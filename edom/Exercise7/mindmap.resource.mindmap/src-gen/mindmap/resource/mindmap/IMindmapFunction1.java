/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap;

/**
 * A simple interface for generic functions with one argument.
 */
public interface IMindmapFunction1<ReturnType, ArgumentType1> {
	
	public ReturnType execute(ArgumentType1 argument1);
}
