package restcomponent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import org.apache.ofbiz.entity.GenericValue;
import org.junit.Test;

public class UtilTest 
{
  
  @Test
  public void testConvertProdutSampleListGenericValueToJSON() 
  {
    
    String expectedResult= "[{\"_ENTITY_NAME_\":\"EntityDummy\",\"_DELEGATOR_NAME_\":\"GenericDelegatorDummy\"}]";
    
    GenericValue aGenValue=new GenericValueDummy();
    List<GenericValue> listIn=new ArrayList<GenericValue>();
    listIn.add(aGenValue);
    
    String result=Util.convertListGenericValueToJSON(listIn);
    
    assertEquals("Teste: ", expectedResult, result);
    
  }

  /* 
  @Test
  public void testConvertProdutSampleListGenericValueToJSONFail() 
  {
    
    String expectedResult= "";
    
    GenericValue aGenValue=new GenericValueDummy();
    List<GenericValue> listIn=new ArrayList<GenericValue>();
    listIn.add(aGenValue);
    
    String result=Util.convertListGenericValueToJSON(listIn);
    
    assertEquals("Teste: ", expectedResult, result);
    
  }
  */
}