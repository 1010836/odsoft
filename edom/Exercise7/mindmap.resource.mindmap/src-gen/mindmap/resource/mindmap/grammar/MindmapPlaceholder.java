/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class MindmapPlaceholder extends mindmap.resource.mindmap.grammar.MindmapTerminal {
	
	private final String tokenName;
	
	public MindmapPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, mindmap.resource.mindmap.grammar.MindmapCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
