package org.ofbiz.helloworld.services;

import java.util.Map;

import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;

public class MyServices 
{
  
  public static Map<String, Object> toUppercase (DispatchContext dctx, Map<String, Object> context)
  {                                 
    
  	// Use the following to access entities or other services of ofbiz
  	// Delegator delegator = dctx.getDelegator () ;
  	// LocalDispatcher dispatcher = dctx.getDispatcher () ;
  	// Get the msg input parameter
  	String msg = (String)context.get("msg");
  	
  	String msgUpper=msg.toUpperCase();
  	
  	Map<String, Object> result = ServiceUtil.returnSuccess();
  	
  	result.put("msgUpper", msgUpper);
  	
  	return result ;
  	
  }
  
  public static Map<String, Object> createRecipe(DispatchContext dctx, Map<String, Object> context) 
  {     
    
    Delegator delegator = dctx.getDelegator();
    String recipeId = delegator.getNextSeqId("Recipe");
    GenericValue recipe = delegator.makeValue("Recipe", UtilMisc.toMap("recipeId", recipeId));
    
    recipe.set("recipeName", context.get("recipeName"));
    recipe.set("notes", context.get("notes"));
    recipe.set("recipeTypeId", context.get("recipeTypeId"));
    
    Map<String, Object> result = null;
    try 
    {
      delegator.create(recipe);
      result = ServiceUtil.returnSuccess();
    } 
    catch (GenericEntityException e) 
    {
      result = ServiceUtil.returnError(e.getMessage());
    } 
    
    result.put("recipeId", recipeId);
    return result;
    
  }
  
  public static Map<String, Object> updateRecipe(DispatchContext dctx, Map<String, Object> context) 
  {     
  
    Delegator delegator = dctx.getDelegator();
    GenericValue recipe = delegator.makeValue("Recipe");
    
    recipe.set("recipeName", context.get("recipeName"));
    recipe.set("notes", context.get("notes"));
    recipe.set("recipeTypeId", context.get("recipeTypeId"));
    recipe.set("recipeId", context.get("recipeId"));
    
    Map<String, Object> result = null;
    try 
    {
      delegator.store(recipe);
      result = ServiceUtil.returnSuccess();
    } 
    catch (GenericEntityException e) 
    {
      result = ServiceUtil.returnError(e.getMessage());
    } 
    
    return result;
    
  } 
  
}