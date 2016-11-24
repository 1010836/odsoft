/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.grammar;

public class MindmapTerminal extends mindmap.resource.mindmap.grammar.MindmapSyntaxElement {
	
	private final org.eclipse.emf.ecore.EStructuralFeature feature;
	private final int mandatoryOccurencesAfter;
	
	public MindmapTerminal(org.eclipse.emf.ecore.EStructuralFeature feature, mindmap.resource.mindmap.grammar.MindmapCardinality cardinality, int mandatoryOccurencesAfter) {
		super(cardinality, null);
		this.feature = feature;
		this.mandatoryOccurencesAfter = mandatoryOccurencesAfter;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return feature;
	}
	
	public int getMandatoryOccurencesAfter() {
		return mandatoryOccurencesAfter;
	}
	
	public String toString() {
		return feature.getName() + "[]";
	}
	
}
