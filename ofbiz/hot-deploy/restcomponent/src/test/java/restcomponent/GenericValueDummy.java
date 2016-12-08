package restcomponent;

import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericValue;

public class GenericValueDummy extends GenericValue 
{
  
  private GenericDelegatorDummy delegatorDummy=null;
  
  public GenericValueDummy() 
  {
    delegatorDummy=new GenericDelegatorDummy();
  }
  @Override
  public String getEntityName() { return "EntityDummy"; }
  
  @Override
  public String toString() { return "[null-entity]"; }
  
  @Override
  public Delegator getDelegator() { return delegatorDummy; }
  
}
