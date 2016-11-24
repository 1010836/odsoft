/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IMindmapParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<mindmap.resource.mindmap.IMindmapCommand<mindmap.resource.mindmap.IMindmapTextResource>> getPostParseCommands();
	
}
