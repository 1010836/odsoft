/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

public class MindmapParseResult implements mindmap.resource.mindmap.IMindmapParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<mindmap.resource.mindmap.IMindmapCommand<mindmap.resource.mindmap.IMindmapTextResource>> commands = new java.util.ArrayList<mindmap.resource.mindmap.IMindmapCommand<mindmap.resource.mindmap.IMindmapTextResource>>();
	
	public MindmapParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<mindmap.resource.mindmap.IMindmapCommand<mindmap.resource.mindmap.IMindmapTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
