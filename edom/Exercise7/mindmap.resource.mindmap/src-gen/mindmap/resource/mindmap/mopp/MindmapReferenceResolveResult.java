/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

/**
 * A basic implementation of the
 * mindmap.resource.mindmap.IMindmapReferenceResolveResult interface that collects
 * mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class MindmapReferenceResolveResult<ReferenceType> implements mindmap.resource.mindmap.IMindmapReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<mindmap.resource.mindmap.IMindmapReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<mindmap.resource.mindmap.IMindmapQuickFix> quickFixes;
	
	public MindmapReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<mindmap.resource.mindmap.IMindmapQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<mindmap.resource.mindmap.IMindmapQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(mindmap.resource.mindmap.IMindmapQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<mindmap.resource.mindmap.IMindmapQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<mindmap.resource.mindmap.IMindmapReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<mindmap.resource.mindmap.IMindmapReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new mindmap.resource.mindmap.mopp.MindmapElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<mindmap.resource.mindmap.IMindmapReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new mindmap.resource.mindmap.mopp.MindmapURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
