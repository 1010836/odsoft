/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class MindmapKeyword extends mindmap.resource.mindmap.grammar.MindmapSyntaxElement {
	
	private final String value;
	
	public MindmapKeyword(String value, mindmap.resource.mindmap.grammar.MindmapCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
