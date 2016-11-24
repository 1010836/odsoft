/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

public class MindmapAntlrScanner implements mindmap.resource.mindmap.IMindmapTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public MindmapAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public mindmap.resource.mindmap.IMindmapTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		mindmap.resource.mindmap.IMindmapTextToken result = new mindmap.resource.mindmap.mopp.MindmapANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
