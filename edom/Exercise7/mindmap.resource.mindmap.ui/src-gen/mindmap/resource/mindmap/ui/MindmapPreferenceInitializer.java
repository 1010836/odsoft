/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.ui;

/**
 * A class used to initialize default preference values.
 */
public class MindmapPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = mindmap.resource.mindmap.ui.MindmapUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(mindmap.resource.mindmap.ui.MindmapPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(mindmap.resource.mindmap.ui.MindmapPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = mindmap.resource.mindmap.ui.MindmapUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new mindmap.resource.mindmap.mopp.MindmapMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = mindmap.resource.mindmap.ui.MindmapUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new mindmap.resource.mindmap.mopp.MindmapMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, mindmap.resource.mindmap.IMindmapMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		mindmap.resource.mindmap.ui.MindmapBracketSet bracketSet = new mindmap.resource.mindmap.ui.MindmapBracketSet(null, null);
		final java.util.Collection<mindmap.resource.mindmap.IMindmapBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (mindmap.resource.mindmap.IMindmapBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + mindmap.resource.mindmap.ui.MindmapPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, mindmap.resource.mindmap.mopp.MindmapMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			mindmap.resource.mindmap.IMindmapTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(mindmap.resource.mindmap.ui.MindmapSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, mindmap.resource.mindmap.ui.MindmapSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(mindmap.resource.mindmap.ui.MindmapSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, mindmap.resource.mindmap.ui.MindmapSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(mindmap.resource.mindmap.ui.MindmapSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, mindmap.resource.mindmap.ui.MindmapSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(mindmap.resource.mindmap.ui.MindmapSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, mindmap.resource.mindmap.ui.MindmapSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(mindmap.resource.mindmap.ui.MindmapSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, mindmap.resource.mindmap.ui.MindmapSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(mindmap.resource.mindmap.ui.MindmapSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, mindmap.resource.mindmap.ui.MindmapSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	private String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
}
