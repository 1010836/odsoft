/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.analysis;

public class MindmapQUOTED_34_34TokenResolver implements mindmap.resource.mindmap.IMindmapTokenResolver {
	
	private mindmap.resource.mindmap.analysis.MindmapDefaultTokenResolver defaultTokenResolver = new mindmap.resource.mindmap.analysis.MindmapDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "\"", "\"", null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, mindmap.resource.mindmap.IMindmapTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "\"", "\"", null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
