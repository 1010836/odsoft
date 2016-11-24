/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IMindmapResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public mindmap.resource.mindmap.IMindmapResourcePostProcessor getResourcePostProcessor();
	
}
