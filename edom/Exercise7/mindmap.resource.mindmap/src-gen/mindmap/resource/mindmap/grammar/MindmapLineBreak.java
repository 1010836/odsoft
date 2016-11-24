/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.grammar;

public class MindmapLineBreak extends mindmap.resource.mindmap.grammar.MindmapFormattingElement {
	
	private final int tabs;
	
	public MindmapLineBreak(mindmap.resource.mindmap.grammar.MindmapCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
