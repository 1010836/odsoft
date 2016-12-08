package restcomponent;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.http.HttpServletRequest;
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
import org.apache.ofbiz.entity.DelegatorFactory;
import org.apache.ofbiz.entity.GenericDelegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.entity.util.Converters.GenericValueToJSON;
import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;
import javolution.util.FastMap;

@Path("/recipe")
public class RecipeResource {
	
	@Context
	HttpServletRequest httpRequest;
	
	/**
	 * This method creates a new product in the collection
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
		
		Map<String, String> paramMap = UtilMisc.toMap("recipeName", jsonObj.getString("recipeName"), 
				"notes",jsonObj.getString("notes"), 
				"recipeTypeId", jsonObj.getString("recipeTypeId"), 
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
		//String recipe = Util.getRecipe(recipeId);
		String recipe = Util.getRecipe(recipeId);
		if (recipe != null) {
			return Response.ok(recipe).type("application/json").build();
		} else {
			return Response.serverError().entity("Problem reading the new product after created!").build();
		}
	}
	
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
				return Response.serverError().entity("Problem converting the product to json!").build();
			}

			JsonReader jsonReader = Json.createReader(new StringReader(json.toString()));
			object = jsonReader.readObject();
			jsonReader.close();

			return Response.ok(object.toString()).type("application/json").build();
		}

		throw new RuntimeException("Invalid ");
	}
	
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

		throw new RuntimeException("Invalid ");
	}
	
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

		Map<String, String> paramMap = UtilMisc.toMap("recipeName", jsonObj.getString("recipeName"), 
				"notes", jsonObj.getString("notes"), 
				"recipeTypeId", jsonObj.getString("recipeTypeId"),
				"recipeId", recipeId,
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
			String recipe = Util.getRecipe(recipeId);

			if (recipe != null) {

				return Response.ok(recipe).type("application/json").build();
			} else {
				return Response.serverError().entity("Problem reading the new recipeCo after updated!").build();
			}
		} else {
			return Response.serverError().entity(result.get("responseMessage").toString()).build();
		}
	}
}
