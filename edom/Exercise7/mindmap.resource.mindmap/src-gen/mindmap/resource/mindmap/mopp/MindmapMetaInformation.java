/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

public class MindmapMetaInformation implements mindmap.resource.mindmap.IMindmapMetaInformation {
	
	public String getSyntaxName() {
		return "mindmap";
	}
	
	public String getURI() {
		return "http://org/eclipse/dsl/mindmap";
	}
	
	public mindmap.resource.mindmap.IMindmapTextScanner createLexer() {
		return new mindmap.resource.mindmap.mopp.MindmapAntlrScanner(new mindmap.resource.mindmap.mopp.MindmapLexer());
	}
	
	public mindmap.resource.mindmap.IMindmapTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new mindmap.resource.mindmap.mopp.MindmapParser().createInstance(inputStream, encoding);
	}
	
	public mindmap.resource.mindmap.IMindmapTextPrinter createPrinter(java.io.OutputStream outputStream, mindmap.resource.mindmap.IMindmapTextResource resource) {
		return new mindmap.resource.mindmap.mopp.MindmapPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new mindmap.resource.mindmap.mopp.MindmapSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new mindmap.resource.mindmap.mopp.MindmapSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public mindmap.resource.mindmap.IMindmapReferenceResolverSwitch getReferenceResolverSwitch() {
		return new mindmap.resource.mindmap.mopp.MindmapReferenceResolverSwitch();
	}
	
	public mindmap.resource.mindmap.IMindmapTokenResolverFactory getTokenResolverFactory() {
		return new mindmap.resource.mindmap.mopp.MindmapTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.emftext.language.mindmap/metamodel/mindmap.cs";
	}
	
	public String[] getTokenNames() {
		return mindmap.resource.mindmap.mopp.MindmapParser.tokenNames;
	}
	
	public mindmap.resource.mindmap.IMindmapTokenStyle getDefaultTokenStyle(String tokenName) {
		return new mindmap.resource.mindmap.mopp.MindmapTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<mindmap.resource.mindmap.IMindmapBracketPair> getBracketPairs() {
		return new mindmap.resource.mindmap.mopp.MindmapBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new mindmap.resource.mindmap.mopp.MindmapFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new mindmap.resource.mindmap.mopp.MindmapResourceFactory();
	}
	
	public mindmap.resource.mindmap.mopp.MindmapNewFileContentProvider getNewFileContentProvider() {
		return new mindmap.resource.mindmap.mopp.MindmapNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new mindmap.resource.mindmap.mopp.MindmapResourceFactory());
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "mindmap.resource.mindmap.ui.launchConfigurationType";
	}
	
	public mindmap.resource.mindmap.IMindmapNameProvider createNameProvider() {
		return new mindmap.resource.mindmap.analysis.MindmapDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		mindmap.resource.mindmap.mopp.MindmapAntlrTokenHelper tokenHelper = new mindmap.resource.mindmap.mopp.MindmapAntlrTokenHelper();
		java.util.List<String> highlightableTokens = new java.util.ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(mindmap.resource.mindmap.mopp.MindmapTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
