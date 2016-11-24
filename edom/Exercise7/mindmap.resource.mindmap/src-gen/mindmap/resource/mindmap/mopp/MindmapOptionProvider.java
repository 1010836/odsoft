/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'mindmap.resource.mindmap.default_load_options' with the difference that the
 * options defined in this class are used even if no Eclipse platform is running.
 */
package mindmap.resource.mindmap.mopp;

public class MindmapOptionProvider implements mindmap.resource.mindmap.IMindmapOptionProvider {
	
	public java.util.Map<?,?> getOptions() {
		// create a map with static option providers here
		return java.util.Collections.emptyMap();
	}
	
}
