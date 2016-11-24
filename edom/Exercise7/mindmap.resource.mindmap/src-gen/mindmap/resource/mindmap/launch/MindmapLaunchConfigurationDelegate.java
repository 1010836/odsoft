/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.launch;

/**
 * A class that handles launch configurations.
 */
public class MindmapLaunchConfigurationDelegate extends org.eclipse.debug.core.model.LaunchConfigurationDelegate {
	
	/**
	 * The URI of the resource that shall be launched.
	 */
	public final static String ATTR_RESOURCE_URI = "uri";
	
	public void launch(org.eclipse.debug.core.ILaunchConfiguration configuration, String mode, org.eclipse.debug.core.ILaunch launch, org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		// Set the overrideLaunchConfigurationDelegate option to <code>false</code> to
		// implement this method or disable launching support by setting
		// disableLaunchSupport to <code>true</code>.
		
		new mindmap.resource.mindmap.launch.MindmapLaunchConfigurationHelper().launch(configuration, mode, launch, monitor);
	}
	
}
