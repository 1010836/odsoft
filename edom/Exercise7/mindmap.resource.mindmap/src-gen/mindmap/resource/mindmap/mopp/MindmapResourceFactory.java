/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

public class MindmapResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public MindmapResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new mindmap.resource.mindmap.mopp.MindmapResource(uri);
	}
	
}
