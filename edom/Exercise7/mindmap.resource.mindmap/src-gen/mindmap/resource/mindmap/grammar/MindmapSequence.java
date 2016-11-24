/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.grammar;

public class MindmapSequence extends mindmap.resource.mindmap.grammar.MindmapSyntaxElement {
	
	public MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality cardinality, mindmap.resource.mindmap.grammar.MindmapSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return mindmap.resource.mindmap.util.MindmapStringUtil.explode(getChildren(), " ");
	}
	
}
