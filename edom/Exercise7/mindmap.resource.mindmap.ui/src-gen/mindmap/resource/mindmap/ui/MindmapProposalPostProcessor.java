/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class MindmapProposalPostProcessor {
	
	public java.util.List<mindmap.resource.mindmap.ui.MindmapCompletionProposal> process(java.util.List<mindmap.resource.mindmap.ui.MindmapCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
