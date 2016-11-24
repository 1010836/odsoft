/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

public class MindmapProblem implements mindmap.resource.mindmap.IMindmapProblem {
	
	private String message;
	private mindmap.resource.mindmap.MindmapEProblemType type;
	private mindmap.resource.mindmap.MindmapEProblemSeverity severity;
	private java.util.Collection<mindmap.resource.mindmap.IMindmapQuickFix> quickFixes;
	
	public MindmapProblem(String message, mindmap.resource.mindmap.MindmapEProblemType type, mindmap.resource.mindmap.MindmapEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<mindmap.resource.mindmap.IMindmapQuickFix>emptySet());
	}
	
	public MindmapProblem(String message, mindmap.resource.mindmap.MindmapEProblemType type, mindmap.resource.mindmap.MindmapEProblemSeverity severity, mindmap.resource.mindmap.IMindmapQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public MindmapProblem(String message, mindmap.resource.mindmap.MindmapEProblemType type, mindmap.resource.mindmap.MindmapEProblemSeverity severity, java.util.Collection<mindmap.resource.mindmap.IMindmapQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<mindmap.resource.mindmap.IMindmapQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public mindmap.resource.mindmap.MindmapEProblemType getType() {
		return type;
	}
	
	public mindmap.resource.mindmap.MindmapEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<mindmap.resource.mindmap.IMindmapQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
