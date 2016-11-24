/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

/**
 * The MindmapTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class MindmapTokenResolverFactory implements mindmap.resource.mindmap.IMindmapTokenResolverFactory {
	
	private java.util.Map<String, mindmap.resource.mindmap.IMindmapTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, mindmap.resource.mindmap.IMindmapTokenResolver> featureName2CollectInTokenResolver;
	private static mindmap.resource.mindmap.IMindmapTokenResolver defaultResolver = new mindmap.resource.mindmap.analysis.MindmapDefaultTokenResolver();
	
	public MindmapTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, mindmap.resource.mindmap.IMindmapTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, mindmap.resource.mindmap.IMindmapTokenResolver>();
		registerTokenResolver("TEXT", new mindmap.resource.mindmap.analysis.MindmapTEXTTokenResolver());
		registerTokenResolver("QUOTED_34_34", new mindmap.resource.mindmap.analysis.MindmapQUOTED_34_34TokenResolver());
	}
	
	public mindmap.resource.mindmap.IMindmapTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public mindmap.resource.mindmap.IMindmapTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, mindmap.resource.mindmap.IMindmapTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, mindmap.resource.mindmap.IMindmapTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected mindmap.resource.mindmap.IMindmapTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private mindmap.resource.mindmap.IMindmapTokenResolver internalCreateResolver(java.util.Map<String, mindmap.resource.mindmap.IMindmapTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, mindmap.resource.mindmap.IMindmapTokenResolver> resolverMap, String key, mindmap.resource.mindmap.IMindmapTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
