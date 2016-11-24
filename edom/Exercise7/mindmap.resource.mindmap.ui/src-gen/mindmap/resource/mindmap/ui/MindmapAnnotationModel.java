/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.ui;

public class MindmapAnnotationModel extends org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel {
	
	public MindmapAnnotationModel(org.eclipse.core.resources.IResource resource) {
		super(resource);
	}
	
	protected org.eclipse.ui.texteditor.MarkerAnnotation createMarkerAnnotation(org.eclipse.core.resources.IMarker marker) {
		return new mindmap.resource.mindmap.ui.MindmapMarkerAnnotation(marker);
	}
	
}
