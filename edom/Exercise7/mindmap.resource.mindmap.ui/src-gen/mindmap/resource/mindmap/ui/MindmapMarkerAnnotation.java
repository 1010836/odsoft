/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.ui;

public class MindmapMarkerAnnotation extends org.eclipse.ui.texteditor.MarkerAnnotation implements org.eclipse.jface.text.quickassist.IQuickFixableAnnotation {
	
	// private boolean isQuickFixable;
	
	public MindmapMarkerAnnotation(org.eclipse.core.resources.IMarker marker) {
		super(marker);
	}
	
	public void setQuickFixable(boolean state) {
		// this.isQuickFixable = state;
	}
	
	public boolean isQuickFixableStateSet() {
		return true;
	}
	
	public boolean isQuickFixable() {
		try {
			return getMarker().getAttribute(org.eclipse.core.resources.IMarker.SOURCE_ID) != null;
		} catch (org.eclipse.core.runtime.CoreException e) {
			// ignore
		}
		return false;
	}
	
}