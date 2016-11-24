/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.grammar;

public class MindmapContainment extends mindmap.resource.mindmap.grammar.MindmapTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public MindmapContainment(org.eclipse.emf.ecore.EStructuralFeature feature, mindmap.resource.mindmap.grammar.MindmapCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = mindmap.resource.mindmap.util.MindmapStringUtil.explode(allowedTypes, ", ", new mindmap.resource.mindmap.IMindmapFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
