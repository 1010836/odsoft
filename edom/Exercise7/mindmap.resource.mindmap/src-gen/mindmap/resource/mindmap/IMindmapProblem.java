/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap;

public interface IMindmapProblem {
	public String getMessage();
	public mindmap.resource.mindmap.MindmapEProblemSeverity getSeverity();
	public mindmap.resource.mindmap.MindmapEProblemType getType();
	public java.util.Collection<mindmap.resource.mindmap.IMindmapQuickFix> getQuickFixes();
}
