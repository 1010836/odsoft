/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class MindmapAbstractExpectedElement implements mindmap.resource.mindmap.IMindmapExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<mindmap.resource.mindmap.util.MindmapPair<mindmap.resource.mindmap.IMindmapExpectedElement, mindmap.resource.mindmap.mopp.MindmapContainedFeature[]>> followers = new java.util.LinkedHashSet<mindmap.resource.mindmap.util.MindmapPair<mindmap.resource.mindmap.IMindmapExpectedElement, mindmap.resource.mindmap.mopp.MindmapContainedFeature[]>>();
	
	public MindmapAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(mindmap.resource.mindmap.IMindmapExpectedElement follower, mindmap.resource.mindmap.mopp.MindmapContainedFeature[] path) {
		followers.add(new mindmap.resource.mindmap.util.MindmapPair<mindmap.resource.mindmap.IMindmapExpectedElement, mindmap.resource.mindmap.mopp.MindmapContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<mindmap.resource.mindmap.util.MindmapPair<mindmap.resource.mindmap.IMindmapExpectedElement, mindmap.resource.mindmap.mopp.MindmapContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
