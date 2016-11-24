/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class MindmapSyntaxElement {
	
	private MindmapSyntaxElement[] children;
	private MindmapSyntaxElement parent;
	private mindmap.resource.mindmap.grammar.MindmapCardinality cardinality;
	
	public MindmapSyntaxElement(mindmap.resource.mindmap.grammar.MindmapCardinality cardinality, MindmapSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (MindmapSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(MindmapSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public MindmapSyntaxElement getParent() {
		return parent;
	}
	
	public MindmapSyntaxElement[] getChildren() {
		if (children == null) {
			return new MindmapSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public mindmap.resource.mindmap.grammar.MindmapCardinality getCardinality() {
		return cardinality;
	}
	
}
