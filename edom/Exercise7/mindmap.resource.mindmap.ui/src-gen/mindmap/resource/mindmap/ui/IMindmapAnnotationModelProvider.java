/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.ui;

/**
 * A provider for annotation models.
 */
public interface IMindmapAnnotationModelProvider {
	
	/**
	 * Returns the annotation model.
	 */
	public org.eclipse.jface.text.source.IAnnotationModel getAnnotationModel();
	
}
