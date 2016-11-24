/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IMindmapExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public java.util.Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public mindmap.resource.mindmap.grammar.MindmapSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(mindmap.resource.mindmap.IMindmapExpectedElement follower, mindmap.resource.mindmap.mopp.MindmapContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<mindmap.resource.mindmap.util.MindmapPair<mindmap.resource.mindmap.IMindmapExpectedElement, mindmap.resource.mindmap.mopp.MindmapContainedFeature[]>> getFollowers();
	
}
