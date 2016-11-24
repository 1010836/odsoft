/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class MindmapFollowSetProvider {
	
	public final static mindmap.resource.mindmap.IMindmapExpectedElement TERMINALS[] = new mindmap.resource.mindmap.IMindmapExpectedElement[41];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[1];
	
	public final static mindmap.resource.mindmap.mopp.MindmapContainedFeature[] LINKS = new mindmap.resource.mindmap.mopp.MindmapContainedFeature[2];
	
	public final static mindmap.resource.mindmap.mopp.MindmapContainedFeature[] EMPTY_LINK_ARRAY = new mindmap.resource.mindmap.mopp.MindmapContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_0);
		TERMINALS[1] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_1);
		TERMINALS[2] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_0_0);
		TERMINALS[3] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_1_0);
		TERMINALS[4] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_2_0);
		TERMINALS[5] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_3);
		TERMINALS[6] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_0_1);
		TERMINALS[7] = new mindmap.resource.mindmap.mopp.MindmapExpectedStructuralFeature(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_0_2);
		TERMINALS[8] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_1_1);
		TERMINALS[9] = new mindmap.resource.mindmap.mopp.MindmapExpectedStructuralFeature(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_1_2);
		TERMINALS[10] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_2_1);
		TERMINALS[11] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_0);
		TERMINALS[12] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_0);
		TERMINALS[13] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_1);
		TERMINALS[14] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_0_0);
		TERMINALS[15] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_1_0);
		TERMINALS[16] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_2_0);
		TERMINALS[17] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_3_0);
		TERMINALS[18] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_4_0);
		TERMINALS[19] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_5_0);
		TERMINALS[20] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_3);
		TERMINALS[21] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_0_1);
		TERMINALS[22] = new mindmap.resource.mindmap.mopp.MindmapExpectedStructuralFeature(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_0_2);
		TERMINALS[23] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_1_1);
		TERMINALS[24] = new mindmap.resource.mindmap.mopp.MindmapExpectedStructuralFeature(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_1_2);
		TERMINALS[25] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_2_1);
		TERMINALS[26] = new mindmap.resource.mindmap.mopp.MindmapExpectedStructuralFeature(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_2_2);
		TERMINALS[27] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_3_1);
		TERMINALS[28] = new mindmap.resource.mindmap.mopp.MindmapExpectedStructuralFeature(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_3_2);
		TERMINALS[29] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_4_1);
		TERMINALS[30] = new mindmap.resource.mindmap.mopp.MindmapExpectedEnumerationTerminal(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_4_2);
		TERMINALS[31] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_5_1);
		TERMINALS[32] = new mindmap.resource.mindmap.mopp.MindmapExpectedStructuralFeature(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_5_2);
		TERMINALS[33] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_1);
		TERMINALS[34] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_0_0);
		TERMINALS[35] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_1_0);
		TERMINALS[36] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_3);
		TERMINALS[37] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_0_1);
		TERMINALS[38] = new mindmap.resource.mindmap.mopp.MindmapExpectedStructuralFeature(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_0_2);
		TERMINALS[39] = new mindmap.resource.mindmap.mopp.MindmapExpectedCsString(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_1_1);
		TERMINALS[40] = new mindmap.resource.mindmap.mopp.MindmapExpectedEnumerationTerminal(mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_1_2);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = mindmap.MindmapPackage.eINSTANCE.getMap().getEStructuralFeature(mindmap.MindmapPackage.MAP__ELEMENTS);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new mindmap.resource.mindmap.mopp.MindmapContainedFeature(mindmap.MindmapPackage.eINSTANCE.getTopic(), FEATURES[0]);
		LINKS[1] = new mindmap.resource.mindmap.mopp.MindmapContainedFeature(mindmap.MindmapPackage.eINSTANCE.getRelationship(), FEATURES[0]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[9].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[9].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[9].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[9].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[10].addFollower(TERMINALS[11], new mindmap.resource.mindmap.mopp.MindmapContainedFeature[] {new mindmap.resource.mindmap.mopp.MindmapContainedFeature(mindmap.MindmapPackage.eINSTANCE.getTopic(), FEATURES[0]), });
		TERMINALS[10].addFollower(TERMINALS[12], new mindmap.resource.mindmap.mopp.MindmapContainedFeature[] {new mindmap.resource.mindmap.mopp.MindmapContainedFeature(mindmap.MindmapPackage.eINSTANCE.getRelationship(), FEATURES[0]), });
		TERMINALS[11].addFollower(TERMINALS[13], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[20], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[21], EMPTY_LINK_ARRAY);
		TERMINALS[21].addFollower(TERMINALS[22], EMPTY_LINK_ARRAY);
		TERMINALS[22].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[22].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[22].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[22].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[22].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[22].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[22].addFollower(TERMINALS[20], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[23], EMPTY_LINK_ARRAY);
		TERMINALS[23].addFollower(TERMINALS[24], EMPTY_LINK_ARRAY);
		TERMINALS[24].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[24].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[24].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[24].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[24].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[24].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[24].addFollower(TERMINALS[20], EMPTY_LINK_ARRAY);
		TERMINALS[16].addFollower(TERMINALS[25], EMPTY_LINK_ARRAY);
		TERMINALS[25].addFollower(TERMINALS[26], EMPTY_LINK_ARRAY);
		TERMINALS[26].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[26].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[26].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[26].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[26].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[26].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[26].addFollower(TERMINALS[20], EMPTY_LINK_ARRAY);
		TERMINALS[17].addFollower(TERMINALS[27], EMPTY_LINK_ARRAY);
		TERMINALS[27].addFollower(TERMINALS[28], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[20], EMPTY_LINK_ARRAY);
		TERMINALS[18].addFollower(TERMINALS[29], EMPTY_LINK_ARRAY);
		TERMINALS[29].addFollower(TERMINALS[30], EMPTY_LINK_ARRAY);
		TERMINALS[19].addFollower(TERMINALS[31], EMPTY_LINK_ARRAY);
		TERMINALS[31].addFollower(TERMINALS[32], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[20], EMPTY_LINK_ARRAY);
		TERMINALS[20].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[20].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[20].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[20].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[33], EMPTY_LINK_ARRAY);
		TERMINALS[33].addFollower(TERMINALS[34], EMPTY_LINK_ARRAY);
		TERMINALS[33].addFollower(TERMINALS[35], EMPTY_LINK_ARRAY);
		TERMINALS[33].addFollower(TERMINALS[36], EMPTY_LINK_ARRAY);
		TERMINALS[34].addFollower(TERMINALS[37], EMPTY_LINK_ARRAY);
		TERMINALS[37].addFollower(TERMINALS[38], EMPTY_LINK_ARRAY);
		TERMINALS[38].addFollower(TERMINALS[34], EMPTY_LINK_ARRAY);
		TERMINALS[38].addFollower(TERMINALS[35], EMPTY_LINK_ARRAY);
		TERMINALS[38].addFollower(TERMINALS[36], EMPTY_LINK_ARRAY);
		TERMINALS[35].addFollower(TERMINALS[39], EMPTY_LINK_ARRAY);
		TERMINALS[39].addFollower(TERMINALS[40], EMPTY_LINK_ARRAY);
		TERMINALS[36].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[36].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[36].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[36].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
	}
	
	public static void wire() {
		wire0();
	}
	
	static {
		// initialize the arrays
		initializeTerminals();
		initializeFeatures();
		initializeLinks();
		// wire the terminals
		wire();
	}
}
