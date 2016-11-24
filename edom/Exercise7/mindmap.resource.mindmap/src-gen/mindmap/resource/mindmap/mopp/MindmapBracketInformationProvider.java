/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

public class MindmapBracketInformationProvider {
	
	public class BracketPair implements mindmap.resource.mindmap.IMindmapBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<mindmap.resource.mindmap.IMindmapBracketPair> getBracketPairs() {
		java.util.Collection<mindmap.resource.mindmap.IMindmapBracketPair> result = new java.util.ArrayList<mindmap.resource.mindmap.IMindmapBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("\"", "\"", false));
		return result;
	}
	
}
