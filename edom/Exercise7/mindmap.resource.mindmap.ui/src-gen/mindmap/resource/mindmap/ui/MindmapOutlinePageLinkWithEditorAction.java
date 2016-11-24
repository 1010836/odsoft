/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.ui;

public class MindmapOutlinePageLinkWithEditorAction extends mindmap.resource.mindmap.ui.AbstractMindmapOutlinePageAction {
	
	public MindmapOutlinePageLinkWithEditorAction(mindmap.resource.mindmap.ui.MindmapOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
