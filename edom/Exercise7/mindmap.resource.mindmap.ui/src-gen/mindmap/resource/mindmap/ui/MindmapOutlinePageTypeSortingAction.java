/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.ui;

public class MindmapOutlinePageTypeSortingAction extends mindmap.resource.mindmap.ui.AbstractMindmapOutlinePageAction {
	
	public MindmapOutlinePageTypeSortingAction(mindmap.resource.mindmap.ui.MindmapOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
