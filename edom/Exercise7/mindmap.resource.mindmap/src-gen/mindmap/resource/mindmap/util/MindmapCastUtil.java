/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.util;

/**
 * Utility class that provides a method to cast objects to type parameterized
 * classes without a warning.
 */
public class MindmapCastUtil {
	
	@SuppressWarnings("unchecked")	
	public static <T> T cast(Object temp) {
		return (T) temp;
	}
}
