/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class MindmapContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements mindmap.resource.mindmap.IMindmapContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final mindmap.resource.mindmap.IMindmapReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public MindmapContextDependentURIFragmentFactory(mindmap.resource.mindmap.IMindmapReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public mindmap.resource.mindmap.IMindmapContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new mindmap.resource.mindmap.mopp.MindmapContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public mindmap.resource.mindmap.IMindmapReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
