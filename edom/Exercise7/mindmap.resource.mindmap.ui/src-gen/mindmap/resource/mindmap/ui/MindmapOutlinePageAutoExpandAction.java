/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.ui;

public class MindmapOutlinePageAutoExpandAction extends mindmap.resource.mindmap.ui.AbstractMindmapOutlinePageAction {
	
	public MindmapOutlinePageAutoExpandAction(mindmap.resource.mindmap.ui.MindmapOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
