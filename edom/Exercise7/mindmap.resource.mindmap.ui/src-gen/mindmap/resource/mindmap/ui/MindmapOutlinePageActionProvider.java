/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.ui;

public class MindmapOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(mindmap.resource.mindmap.ui.MindmapOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new mindmap.resource.mindmap.ui.MindmapOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new mindmap.resource.mindmap.ui.MindmapOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new mindmap.resource.mindmap.ui.MindmapOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new mindmap.resource.mindmap.ui.MindmapOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new mindmap.resource.mindmap.ui.MindmapOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new mindmap.resource.mindmap.ui.MindmapOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
