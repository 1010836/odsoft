/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.util;

/**
 * Class MindmapTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * mindmap.resource.mindmap.util.MindmapResourceUtil.
 */
public class MindmapTextResourceUtil {
	
	/**
	 * Use mindmap.resource.mindmap.util.MindmapResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static mindmap.resource.mindmap.mopp.MindmapResource getResource(org.eclipse.core.resources.IFile file) {
		return new mindmap.resource.mindmap.util.MindmapEclipseProxy().getResource(file);
	}
	
	/**
	 * Use mindmap.resource.mindmap.util.MindmapResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static mindmap.resource.mindmap.mopp.MindmapResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return mindmap.resource.mindmap.util.MindmapResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use mindmap.resource.mindmap.util.MindmapResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static mindmap.resource.mindmap.mopp.MindmapResource getResource(org.eclipse.emf.common.util.URI uri) {
		return mindmap.resource.mindmap.util.MindmapResourceUtil.getResource(uri);
	}
	
	/**
	 * Use mindmap.resource.mindmap.util.MindmapResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static mindmap.resource.mindmap.mopp.MindmapResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return mindmap.resource.mindmap.util.MindmapResourceUtil.getResource(uri, options);
	}
	
}
