/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IMindmapCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
