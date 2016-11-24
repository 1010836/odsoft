/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.ui;

public class MindmapOutlinePageLexicalSortingAction extends mindmap.resource.mindmap.ui.AbstractMindmapOutlinePageAction {
	
	public MindmapOutlinePageLexicalSortingAction(mindmap.resource.mindmap.ui.MindmapOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
