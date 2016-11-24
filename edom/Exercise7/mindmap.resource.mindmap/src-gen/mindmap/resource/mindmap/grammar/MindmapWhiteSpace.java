/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.grammar;

public class MindmapWhiteSpace extends mindmap.resource.mindmap.grammar.MindmapFormattingElement {
	
	private final int amount;
	
	public MindmapWhiteSpace(int amount, mindmap.resource.mindmap.grammar.MindmapCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
