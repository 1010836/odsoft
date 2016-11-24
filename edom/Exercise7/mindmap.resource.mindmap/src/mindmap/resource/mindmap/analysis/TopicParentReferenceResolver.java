/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.analysis;

public class TopicParentReferenceResolver implements mindmap.resource.mindmap.IMindmapReferenceResolver<mindmap.Topic, mindmap.Topic> {
	
	private mindmap.resource.mindmap.analysis.MindmapDefaultResolverDelegate<mindmap.Topic, mindmap.Topic> delegate = new mindmap.resource.mindmap.analysis.MindmapDefaultResolverDelegate<mindmap.Topic, mindmap.Topic>();
	
	public void resolve(String identifier, mindmap.Topic container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final mindmap.resource.mindmap.IMindmapReferenceResolveResult<mindmap.Topic> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(mindmap.Topic element, mindmap.Topic container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
