package org.ofbiz.helloworld.services;

import java.util.Map;
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
  
  public static Map<String, Object> createRecipe (DispatchContext dctx, Map<String, Object> context)
  {                                 
    
    // Use the following to access entities or other services of ofbiz
    // Delegator delegator = dctx.getDelegator () ;
    // LocalDispatcher dispatcher = dctx.getDispatcher () ;
    
    // Get the input parameters
    String recipeName = (String)context.get("recipeName");
    String notes = (String)context.get("notes");
    String recipeTypeId = (String)context.get("recipeTypeId");
    
    String recipe = "r005;" + recipeName + ";" + notes + ";" + recipeTypeId + ";";
            
    Map<String, Object> result = ServiceUtil.returnSuccess();
    result.put("recipe", recipe);
    
    return result;
    
  }
  
}