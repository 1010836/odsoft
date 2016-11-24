/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

public class MindmapReferenceResolverSwitch implements mindmap.resource.mindmap.IMindmapReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected mindmap.resource.mindmap.analysis.TopicParentReferenceResolver topicParentReferenceResolver = new mindmap.resource.mindmap.analysis.TopicParentReferenceResolver();
	
	public mindmap.resource.mindmap.IMindmapReferenceResolver<mindmap.Topic, mindmap.Topic> getTopicParentReferenceResolver() {
		return getResolverChain(mindmap.MindmapPackage.eINSTANCE.getTopic_Parent(), topicParentReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		topicParentReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, mindmap.resource.mindmap.IMindmapReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (mindmap.MindmapPackage.eINSTANCE.getTopic().isInstance(container)) {
			MindmapFuzzyResolveResult<mindmap.Topic> frr = new MindmapFuzzyResolveResult<mindmap.Topic>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("parent")) {
				topicParentReferenceResolver.resolve(identifier, (mindmap.Topic) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public mindmap.resource.mindmap.IMindmapReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == mindmap.MindmapPackage.eINSTANCE.getTopic_Parent()) {
			return getResolverChain(reference, topicParentReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> mindmap.resource.mindmap.IMindmapReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, mindmap.resource.mindmap.IMindmapReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(mindmap.resource.mindmap.IMindmapOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new mindmap.resource.mindmap.util.MindmapRuntimeUtil().logWarning("Found value with invalid type for option " + mindmap.resource.mindmap.IMindmapOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof mindmap.resource.mindmap.IMindmapReferenceResolver) {
			mindmap.resource.mindmap.IMindmapReferenceResolver replacingResolver = (mindmap.resource.mindmap.IMindmapReferenceResolver) resolverValue;
			if (replacingResolver instanceof mindmap.resource.mindmap.IMindmapDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((mindmap.resource.mindmap.IMindmapDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			mindmap.resource.mindmap.IMindmapReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof mindmap.resource.mindmap.IMindmapReferenceCache) {
					mindmap.resource.mindmap.IMindmapReferenceResolver nextResolver = (mindmap.resource.mindmap.IMindmapReferenceResolver) next;
					if (nextResolver instanceof mindmap.resource.mindmap.IMindmapDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((mindmap.resource.mindmap.IMindmapDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new mindmap.resource.mindmap.util.MindmapRuntimeUtil().logWarning("Found value with invalid type in value map for option " + mindmap.resource.mindmap.IMindmapOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + mindmap.resource.mindmap.IMindmapDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new mindmap.resource.mindmap.util.MindmapRuntimeUtil().logWarning("Found value with invalid type in value map for option " + mindmap.resource.mindmap.IMindmapOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + mindmap.resource.mindmap.IMindmapDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
