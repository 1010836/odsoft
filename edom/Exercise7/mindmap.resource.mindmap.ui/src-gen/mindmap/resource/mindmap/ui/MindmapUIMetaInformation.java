/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.ui;

public class MindmapUIMetaInformation extends mindmap.resource.mindmap.mopp.MindmapMetaInformation {
	
	public mindmap.resource.mindmap.IMindmapHoverTextProvider getHoverTextProvider() {
		return new mindmap.resource.mindmap.ui.MindmapHoverTextProvider();
	}
	
	public mindmap.resource.mindmap.ui.MindmapImageProvider getImageProvider() {
		return mindmap.resource.mindmap.ui.MindmapImageProvider.INSTANCE;
	}
	
	public mindmap.resource.mindmap.ui.MindmapColorManager createColorManager() {
		return new mindmap.resource.mindmap.ui.MindmapColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(mindmap.resource.mindmap.IMindmapTextResource,
	 * mindmap.resource.mindmap.ui.MindmapColorManager) instead.
	 */
	public mindmap.resource.mindmap.ui.MindmapTokenScanner createTokenScanner(mindmap.resource.mindmap.ui.MindmapColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public mindmap.resource.mindmap.ui.MindmapTokenScanner createTokenScanner(mindmap.resource.mindmap.IMindmapTextResource resource, mindmap.resource.mindmap.ui.MindmapColorManager colorManager) {
		return new mindmap.resource.mindmap.ui.MindmapTokenScanner(resource, colorManager);
	}
	
	public mindmap.resource.mindmap.ui.MindmapCodeCompletionHelper createCodeCompletionHelper() {
		return new mindmap.resource.mindmap.ui.MindmapCodeCompletionHelper();
	}
	
}
