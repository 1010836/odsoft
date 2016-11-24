/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IMindmapResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public mindmap.resource.mindmap.IMindmapTextResource getResource();
	
}
