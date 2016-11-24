/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class MindmapExpectedCsString extends mindmap.resource.mindmap.mopp.MindmapAbstractExpectedElement {
	
	private mindmap.resource.mindmap.grammar.MindmapKeyword keyword;
	
	public MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public mindmap.resource.mindmap.grammar.MindmapSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof MindmapExpectedCsString) {
			return getValue().equals(((MindmapExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
