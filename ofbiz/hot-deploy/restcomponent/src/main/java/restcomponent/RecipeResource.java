/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * 
 * Author: atb@isep.ipp.pt
 *******************************************************************************/
package restcomponent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.ofbiz.base.conversion.ConversionException;
import org.apache.ofbiz.base.lang.JSON;
import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.DelegatorFactory;
import org.apache.ofbiz.entity.GenericDelegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.entity.condition.EntityCondition;
import org.apache.ofbiz.entity.condition.EntityOperator;
import org.apache.ofbiz.entity.util.Converters.GenericValueToJSON;
import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;
import org.apache.ofbiz.service.ServiceUtil;

import javolution.util.FastMap;

/**
 * 
 * Nota: A criacao de um produto e' algo que e' um pouco complexo pelo que e'
 * executada por um servico Na pagina de criacao de produto quando se confirma a
 * criacao e' feito um POST .../catalog/control/CreateRecipe Esse POST esta'
 * mapeado para o servico de criacao de produtos que e' um script simples:
 * component://product/script/org/ofbiz/product/product/ProductServices.xml
 * 
 * @author alexandrebraganca
 *
 */

@Path("/product")
public class RecipeResource {

	@Context
	HttpServletRequest httpRequest;

	// ../url_resource
	// handling the collection
	//
	// GET return all
	// POST create new entry, returns 201
	// PUT not allowed
	// DELETE not allowed
	//

	/**
	 * This method returns a collection with all the products...
	 * 
	 * @return
	 */
	@GET
	@Produces("application/json")
	public Response getAllRecipes() {
		String username = null;
		String password = null;

		try {
			username = httpRequest.getHeader("login.username");
			password = httpRequest.getHeader("login.password");
		} catch (NullPointerException e) {
			return Response.serverError().entity("Problem reading http header(s): login.username or login.password")
					.build();
		}

		if (username == null || password == null) {
			return Response.serverError().entity("Problem reading http header(s): login.username or login.password")
					.build();
		}

		GenericDelegator delegator = (GenericDelegator) DelegatorFactory.getDelegator("default");
		List<GenericValue> recipes = null;

		try {
			recipes = delegator.findAll("Recipe", false);
		} catch (GenericEntityException e) {
			return Response.serverError().entity(e.toString()).build();
		}

		if (recipes != null) {

			String response = Util.convertListGenericValueToJSON(recipes);

			if (response == null) {
				return Response.serverError().entity("Erro na conversao do JSON!").build();
			}

			return Response.ok(response).type("application/json").build();
		}

		// shouldn't ever get here ... should we?
		throw new RuntimeException("Invalid ");
	}

	/**
	 * This method creates a new recipe in the collection
	 * 
	 * @return
	 */
	@POST
	@Produces("application/json")
	public Response createRecipe() {
		String username = null;
		String password = null;

		try {
			username = httpRequest.getHeader("login.username");
			password = httpRequest.getHeader("login.password");
		} catch (NullPointerException e) {
			return Response.serverError().entity("Problem reading http header(s): login.username or login.password")
					.build();
		}

		if (username == null || password == null) {
			return Response.serverError().entity("Problem reading http header(s): login.username or login.password")
					.build();
		}

		JsonReader jsonReader;
		try {
			jsonReader = Json.createReader(httpRequest.getReader());
		} catch (IOException e) {
			return Response.serverError().entity("Problem reading json body").build();
		}

		JsonObject jsonObj = jsonReader.readObject();

		// Lets now invoke the ofbiz service that creates a recipe
		GenericDelegator delegator = (GenericDelegator) DelegatorFactory.getDelegator("default");
		LocalDispatcher dispatcher = org.apache.ofbiz.service.ServiceDispatcher.getLocalDispatcher("default", delegator);
		
		Map<String, String> paramMap = UtilMisc.toMap("recipeId", jsonObj.getString("recipeId"), 
				"recipeName",jsonObj.getString("recipeName"), 
				"recipeTypeId", jsonObj.getString("recipeTypeId"), 
				"notes", jsonObj.getString("notes"),
				"login.username", username, 
				"login.password", password);

		Map<String, Object> result = FastMap.newInstance();
		try {
			result = dispatcher.runSync("createRecipe", paramMap);
		} catch (GenericServiceException e1) {
			Debug.logError(e1, PingResource.class.getName());
			return Response.serverError().entity(e1.toString()).build();
		}

		String recipeId = result.get("recipeId").toString(); 
		String recipe = Util.getRecipe(recipeId);
		if (recipe != null) {
			return Response.ok(recipe).type("application/json").build();
		} else {
			return Response.serverError().entity("Problem reading the new recipe after created!").build();
		}
	}

	// ../url_resource/{id}
	// handling individual itens in the collection
	//
	// item id must be present in the request object
	//
	// GET return specific item or 404
	// POST update existing entry or 404
	// PUT overwrite existing or create new given the id.
	// DELETE deletes the item
	//

	/**
	 * This method returns a recipe given its id.
	 * 
	 * @param recipteId
	 * @return
	 */
	@GET
	@Produces("application/json")
	@Path("{id}")
	public Response getRecipeById(@PathParam("id") String recipeId) {
		// id example="GC-001-C100"

		String username = null;
		String password = null;

		try {
			username = httpRequest.getHeader("login.username");
			password = httpRequest.getHeader("login.password");
		} catch (NullPointerException e) {
			return Response.serverError().entity("Problem reading http header(s): login.username or login.password")
					.build();
		}

		if (username == null || password == null) {
			return Response.serverError().entity("Problem reading http header(s): login.username or login.password")
					.build();
		}

		GenericDelegator delegator = (GenericDelegator) DelegatorFactory.getDelegator("default");
		GenericValue recipe = null;

		try {
			recipe = delegator.findOne("Recipe", UtilMisc.toMap("recipeId", recipeId), false);
		} catch (GenericEntityException e) {
			return Response.serverError().entity(e.toString()).build();
		}

		if (recipe != null) {

			JsonObject object = null;

			JSON json = null;

			try {
				json = new GenericValueToJSON().convert(recipe);
			} catch (ConversionException e) {
				return Response.serverError().entity("Problem converting the recipe to json!").build();
			}

			JsonReader jsonReader = Json.createReader(new StringReader(json.toString()));
			object = jsonReader.readObject();
			jsonReader.close();

			return Response.ok(object.toString()).type("application/json").build();
		}

		// shouldn't ever get here ... should we?
		throw new RuntimeException("Invalid ");
	}
		
	/**
	 * This method returns a recipe given its id.
	 * 
	 * @param recipeId
	 * @return
	 */
	@DELETE
	@Produces("application/json")
	@Path("{id}")
	public Response deleteRecipeById(@PathParam("id") String RecipeId) {

		// To delete a recipe there is no service in ofbiz...

		return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
	}

	// Put para actualizar...
	// https://localhost:8443/webtools/control/ServiceList?sel_service_name=updateRecipe
	/**
	 * This method updates a recipe (given its id).
	 * 
	 * @param recipeId
	 * @return
	 */
	@PUT
	@Produces("application/json")
	@Path("{id}")
	public Response updateRecipeById(@PathParam("id") String recipeId) {
		String username = null;
		String password = null;

		try {
			username = httpRequest.getHeader("login.username");
			password = httpRequest.getHeader("login.password");
		} catch (NullPointerException e) {
			return Response.serverError().entity("Problem reading http header(s): login.username or login.password")
					.build();
		}

		if (username == null || password == null) {
			return Response.serverError().entity("Problem reading http header(s): login.username or login.password")
					.build();
		}

		JsonReader jsonReader;
		try {
			jsonReader = Json.createReader(httpRequest.getReader());
		} catch (IOException e) {
			return Response.serverError().entity("Problem reading json body").build();
		}

		JsonObject jsonObj = jsonReader.readObject();

		// Lets now invoke the ofbiz service that updates a recipe
		GenericDelegator delegator = (GenericDelegator) DelegatorFactory.getDelegator("default");
		LocalDispatcher dispatcher = org.apache.ofbiz.service.ServiceDispatcher.getLocalDispatcher("default", delegator);

		Map<String, String> paramMap = UtilMisc.toMap("recipeId", recipeId, 
				"recipeName", jsonObj.getString("recipeName"), 
				"recipeTypeId", jsonObj.getString("recipeTypeId"), 
				"notes", jsonObj.getString("description"),
				"login.username", username, 
				"login.password", password);

		Map<String, Object> result = FastMap.newInstance();
		try {
			result = dispatcher.runSync("updateRecipe", paramMap);
		} catch (GenericServiceException e1) {
			Debug.logError(e1, PingResource.class.getName());
			return Response.serverError().entity(e1.toString()).build();
		}

		if (result.get("responseMessage").toString().compareTo("success") == 0) {
			String recipe = Util.getProduct(recipeId);

			if (recipe != null) {

				return Response.ok(recipe).type("application/json").build();
			} else {
				return Response.serverError().entity("Problem reading the new product after updated!").build();
			}
		} else {
			return Response.serverError().entity(result.get("responseMessage").toString()).build();
		}
	}
}
