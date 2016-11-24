/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class MindmapRule extends mindmap.resource.mindmap.grammar.MindmapSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public MindmapRule(org.eclipse.emf.ecore.EClass metaclass, mindmap.resource.mindmap.grammar.MindmapChoice choice, mindmap.resource.mindmap.grammar.MindmapCardinality cardinality) {
		super(cardinality, new mindmap.resource.mindmap.grammar.MindmapSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public mindmap.resource.mindmap.grammar.MindmapChoice getDefinition() {
		return (mindmap.resource.mindmap.grammar.MindmapChoice) getChildren()[0];
	}
	
}

