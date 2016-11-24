/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.ui;

public class MindmapAnnotationModelFactory implements org.eclipse.core.filebuffers.IAnnotationModelFactory {
	
	public org.eclipse.jface.text.source.IAnnotationModel createAnnotationModel(org.eclipse.core.runtime.IPath location) {
		org.eclipse.core.resources.IWorkspace workspace = org.eclipse.core.resources.ResourcesPlugin.getWorkspace();
		org.eclipse.core.resources.IWorkspaceRoot root = workspace.getRoot();
		org.eclipse.core.resources.IResource resource = root.findMember(location);
		return new mindmap.resource.mindmap.ui.MindmapAnnotationModel(resource);
	}
	
}
