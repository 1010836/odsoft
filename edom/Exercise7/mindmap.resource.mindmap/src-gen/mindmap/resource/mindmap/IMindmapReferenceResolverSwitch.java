/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap;

/**
 * A IMindmapReferenceResolverSwitch holds references to multiple other reference
 * resolvers and delegates requests to the appropriate resolver.
 */
public interface IMindmapReferenceResolverSwitch extends mindmap.resource.mindmap.IMindmapConfigurable {
	
	/**
	 * Attempts to resolve a reference string fuzzy (returning objects that do not
	 * match exactly). This is need during code completion.
	 * 
	 * @param identifier The identifier for the reference.
	 * @param container The object that contains the reference.
	 * @param reference The reference that points to the target of the reference.
	 * @param result an object to store the result of the resolve operation.
	 */
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, mindmap.resource.mindmap.IMindmapReferenceResolveResult<org.eclipse.emf.ecore.EObject> result);
}
