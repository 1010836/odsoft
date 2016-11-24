/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.grammar;

public class MindmapChoice extends mindmap.resource.mindmap.grammar.MindmapSyntaxElement {
	
	public MindmapChoice(mindmap.resource.mindmap.grammar.MindmapCardinality cardinality, mindmap.resource.mindmap.grammar.MindmapSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return mindmap.resource.mindmap.util.MindmapStringUtil.explode(getChildren(), "|");
	}
	
}
