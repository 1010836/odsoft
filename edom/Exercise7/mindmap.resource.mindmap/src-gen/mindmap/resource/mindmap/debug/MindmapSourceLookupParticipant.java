/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.debug;

public class MindmapSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof mindmap.resource.mindmap.debug.MindmapStackFrame) {
			mindmap.resource.mindmap.debug.MindmapStackFrame frame = (mindmap.resource.mindmap.debug.MindmapStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
