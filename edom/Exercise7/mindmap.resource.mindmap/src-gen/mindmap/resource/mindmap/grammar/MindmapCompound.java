/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.grammar;

public class MindmapCompound extends mindmap.resource.mindmap.grammar.MindmapSyntaxElement {
	
	public MindmapCompound(mindmap.resource.mindmap.grammar.MindmapChoice choice, mindmap.resource.mindmap.grammar.MindmapCardinality cardinality) {
		super(cardinality, new mindmap.resource.mindmap.grammar.MindmapSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
