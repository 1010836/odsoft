package restcomponent;

import org.apache.ofbiz.entity.GenericDelegator;

public class GenericDelegatorDummy extends GenericDelegator
{

  public GenericDelegatorDummy() 
  {
    super();
  }
  
  @Override
  public String getDelegatorName() 
  {
    return "GenericDelegatorDummy";
  }
  
}