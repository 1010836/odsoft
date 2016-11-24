/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.grammar;

public class MindmapGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static MindmapGrammarInformationProvider INSTANCE = new MindmapGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_0_0_0_0 = new mindmap.resource.mindmap.grammar.MindmapKeyword("Map", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_0_0_0_1 = new mindmap.resource.mindmap.grammar.MindmapKeyword("{", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_0_0_0_2_0_0_0 = new mindmap.resource.mindmap.grammar.MindmapKeyword("title", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_0_0_0_2_0_0_1 = new mindmap.resource.mindmap.grammar.MindmapKeyword(":", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapPlaceholder MINDMAP_0_0_0_2_0_0_2 = new mindmap.resource.mindmap.grammar.MindmapPlaceholder(mindmap.MindmapPackage.eINSTANCE.getMap().getEStructuralFeature(mindmap.MindmapPackage.MAP__TITLE), "QUOTED_34_34", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, 0);
	public final static mindmap.resource.mindmap.grammar.MindmapSequence MINDMAP_0_0_0_2_0_0 = new mindmap.resource.mindmap.grammar.MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_0_0_0_2_0_0_0, MINDMAP_0_0_0_2_0_0_1, MINDMAP_0_0_0_2_0_0_2);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_0_0_0_2_0_1_0 = new mindmap.resource.mindmap.grammar.MindmapKeyword("created", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_0_0_0_2_0_1_1 = new mindmap.resource.mindmap.grammar.MindmapKeyword(":", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapPlaceholder MINDMAP_0_0_0_2_0_1_2 = new mindmap.resource.mindmap.grammar.MindmapPlaceholder(mindmap.MindmapPackage.eINSTANCE.getMap().getEStructuralFeature(mindmap.MindmapPackage.MAP__CREATED), "TEXT", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, 0);
	public final static mindmap.resource.mindmap.grammar.MindmapSequence MINDMAP_0_0_0_2_0_1 = new mindmap.resource.mindmap.grammar.MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_0_0_0_2_0_1_0, MINDMAP_0_0_0_2_0_1_1, MINDMAP_0_0_0_2_0_1_2);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_0_0_0_2_0_2_0 = new mindmap.resource.mindmap.grammar.MindmapKeyword("elements", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_0_0_0_2_0_2_1 = new mindmap.resource.mindmap.grammar.MindmapKeyword(":", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapContainment MINDMAP_0_0_0_2_0_2_2 = new mindmap.resource.mindmap.grammar.MindmapContainment(mindmap.MindmapPackage.eINSTANCE.getMap().getEStructuralFeature(mindmap.MindmapPackage.MAP__ELEMENTS), mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {mindmap.MindmapPackage.eINSTANCE.getMapElement(), }, 0);
	public final static mindmap.resource.mindmap.grammar.MindmapSequence MINDMAP_0_0_0_2_0_2 = new mindmap.resource.mindmap.grammar.MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_0_0_0_2_0_2_0, MINDMAP_0_0_0_2_0_2_1, MINDMAP_0_0_0_2_0_2_2);
	public final static mindmap.resource.mindmap.grammar.MindmapChoice MINDMAP_0_0_0_2_0 = new mindmap.resource.mindmap.grammar.MindmapChoice(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_0_0_0_2_0_0, MINDMAP_0_0_0_2_0_1, MINDMAP_0_0_0_2_0_2);
	public final static mindmap.resource.mindmap.grammar.MindmapCompound MINDMAP_0_0_0_2 = new mindmap.resource.mindmap.grammar.MindmapCompound(MINDMAP_0_0_0_2_0, mindmap.resource.mindmap.grammar.MindmapCardinality.STAR);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_0_0_0_3 = new mindmap.resource.mindmap.grammar.MindmapKeyword("}", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapSequence MINDMAP_0_0_0 = new mindmap.resource.mindmap.grammar.MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_0_0_0_0, MINDMAP_0_0_0_1, MINDMAP_0_0_0_2, MINDMAP_0_0_0_3);
	public final static mindmap.resource.mindmap.grammar.MindmapChoice MINDMAP_0_0 = new mindmap.resource.mindmap.grammar.MindmapChoice(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_0_0_0);
	public final static mindmap.resource.mindmap.grammar.MindmapRule MINDMAP_0 = new mindmap.resource.mindmap.grammar.MindmapRule(mindmap.MindmapPackage.eINSTANCE.getMap(), MINDMAP_0_0, mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_0 = new mindmap.resource.mindmap.grammar.MindmapKeyword("Topic", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_1 = new mindmap.resource.mindmap.grammar.MindmapKeyword("{", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_2_0_0_0 = new mindmap.resource.mindmap.grammar.MindmapKeyword("name", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_2_0_0_1 = new mindmap.resource.mindmap.grammar.MindmapKeyword(":", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapPlaceholder MINDMAP_1_0_0_2_0_0_2 = new mindmap.resource.mindmap.grammar.MindmapPlaceholder(mindmap.MindmapPackage.eINSTANCE.getTopic().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__NAME), "QUOTED_34_34", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, 0);
	public final static mindmap.resource.mindmap.grammar.MindmapSequence MINDMAP_1_0_0_2_0_0 = new mindmap.resource.mindmap.grammar.MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_1_0_0_2_0_0_0, MINDMAP_1_0_0_2_0_0_1, MINDMAP_1_0_0_2_0_0_2);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_2_0_1_0 = new mindmap.resource.mindmap.grammar.MindmapKeyword("description", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_2_0_1_1 = new mindmap.resource.mindmap.grammar.MindmapKeyword(":", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapPlaceholder MINDMAP_1_0_0_2_0_1_2 = new mindmap.resource.mindmap.grammar.MindmapPlaceholder(mindmap.MindmapPackage.eINSTANCE.getTopic().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__DESCRIPTION), "QUOTED_34_34", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, 0);
	public final static mindmap.resource.mindmap.grammar.MindmapSequence MINDMAP_1_0_0_2_0_1 = new mindmap.resource.mindmap.grammar.MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_1_0_0_2_0_1_0, MINDMAP_1_0_0_2_0_1_1, MINDMAP_1_0_0_2_0_1_2);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_2_0_2_0 = new mindmap.resource.mindmap.grammar.MindmapKeyword("start", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_2_0_2_1 = new mindmap.resource.mindmap.grammar.MindmapKeyword(":", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapPlaceholder MINDMAP_1_0_0_2_0_2_2 = new mindmap.resource.mindmap.grammar.MindmapPlaceholder(mindmap.MindmapPackage.eINSTANCE.getTopic().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__START), "TEXT", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, 0);
	public final static mindmap.resource.mindmap.grammar.MindmapSequence MINDMAP_1_0_0_2_0_2 = new mindmap.resource.mindmap.grammar.MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_1_0_0_2_0_2_0, MINDMAP_1_0_0_2_0_2_1, MINDMAP_1_0_0_2_0_2_2);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_2_0_3_0 = new mindmap.resource.mindmap.grammar.MindmapKeyword("end", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_2_0_3_1 = new mindmap.resource.mindmap.grammar.MindmapKeyword(":", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapPlaceholder MINDMAP_1_0_0_2_0_3_2 = new mindmap.resource.mindmap.grammar.MindmapPlaceholder(mindmap.MindmapPackage.eINSTANCE.getTopic().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__END), "TEXT", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, 0);
	public final static mindmap.resource.mindmap.grammar.MindmapSequence MINDMAP_1_0_0_2_0_3 = new mindmap.resource.mindmap.grammar.MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_1_0_0_2_0_3_0, MINDMAP_1_0_0_2_0_3_1, MINDMAP_1_0_0_2_0_3_2);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_2_0_4_0 = new mindmap.resource.mindmap.grammar.MindmapKeyword("priority", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_2_0_4_1 = new mindmap.resource.mindmap.grammar.MindmapKeyword(":", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapEnumerationTerminal MINDMAP_1_0_0_2_0_4_2 = new mindmap.resource.mindmap.grammar.MindmapEnumerationTerminal(mindmap.MindmapPackage.eINSTANCE.getTopic().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__PRIORITY), new String[] {"HIGH", "HIGH", "MEDIUM", "MEDIUM", "LOW", "LOW", }, mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, 0);
	public final static mindmap.resource.mindmap.grammar.MindmapSequence MINDMAP_1_0_0_2_0_4 = new mindmap.resource.mindmap.grammar.MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_1_0_0_2_0_4_0, MINDMAP_1_0_0_2_0_4_1, MINDMAP_1_0_0_2_0_4_2);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_2_0_5_0 = new mindmap.resource.mindmap.grammar.MindmapKeyword("parent", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_2_0_5_1 = new mindmap.resource.mindmap.grammar.MindmapKeyword(":", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapPlaceholder MINDMAP_1_0_0_2_0_5_2 = new mindmap.resource.mindmap.grammar.MindmapPlaceholder(mindmap.MindmapPackage.eINSTANCE.getTopic().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__PARENT), "TEXT", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, 0);
	public final static mindmap.resource.mindmap.grammar.MindmapSequence MINDMAP_1_0_0_2_0_5 = new mindmap.resource.mindmap.grammar.MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_1_0_0_2_0_5_0, MINDMAP_1_0_0_2_0_5_1, MINDMAP_1_0_0_2_0_5_2);
	public final static mindmap.resource.mindmap.grammar.MindmapChoice MINDMAP_1_0_0_2_0 = new mindmap.resource.mindmap.grammar.MindmapChoice(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_1_0_0_2_0_0, MINDMAP_1_0_0_2_0_1, MINDMAP_1_0_0_2_0_2, MINDMAP_1_0_0_2_0_3, MINDMAP_1_0_0_2_0_4, MINDMAP_1_0_0_2_0_5);
	public final static mindmap.resource.mindmap.grammar.MindmapCompound MINDMAP_1_0_0_2 = new mindmap.resource.mindmap.grammar.MindmapCompound(MINDMAP_1_0_0_2_0, mindmap.resource.mindmap.grammar.MindmapCardinality.STAR);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_1_0_0_3 = new mindmap.resource.mindmap.grammar.MindmapKeyword("}", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapSequence MINDMAP_1_0_0 = new mindmap.resource.mindmap.grammar.MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_1_0_0_0, MINDMAP_1_0_0_1, MINDMAP_1_0_0_2, MINDMAP_1_0_0_3);
	public final static mindmap.resource.mindmap.grammar.MindmapChoice MINDMAP_1_0 = new mindmap.resource.mindmap.grammar.MindmapChoice(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_1_0_0);
	public final static mindmap.resource.mindmap.grammar.MindmapRule MINDMAP_1 = new mindmap.resource.mindmap.grammar.MindmapRule(mindmap.MindmapPackage.eINSTANCE.getTopic(), MINDMAP_1_0, mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_2_0_0_0 = new mindmap.resource.mindmap.grammar.MindmapKeyword("Relationship", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_2_0_0_1 = new mindmap.resource.mindmap.grammar.MindmapKeyword("{", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_2_0_0_2_0_0_0 = new mindmap.resource.mindmap.grammar.MindmapKeyword("name", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_2_0_0_2_0_0_1 = new mindmap.resource.mindmap.grammar.MindmapKeyword(":", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapPlaceholder MINDMAP_2_0_0_2_0_0_2 = new mindmap.resource.mindmap.grammar.MindmapPlaceholder(mindmap.MindmapPackage.eINSTANCE.getRelationship().getEStructuralFeature(mindmap.MindmapPackage.RELATIONSHIP__NAME), "QUOTED_34_34", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, 0);
	public final static mindmap.resource.mindmap.grammar.MindmapSequence MINDMAP_2_0_0_2_0_0 = new mindmap.resource.mindmap.grammar.MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_2_0_0_2_0_0_0, MINDMAP_2_0_0_2_0_0_1, MINDMAP_2_0_0_2_0_0_2);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_2_0_0_2_0_1_0 = new mindmap.resource.mindmap.grammar.MindmapKeyword("Type", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_2_0_0_2_0_1_1 = new mindmap.resource.mindmap.grammar.MindmapKeyword(":", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapEnumerationTerminal MINDMAP_2_0_0_2_0_1_2 = new mindmap.resource.mindmap.grammar.MindmapEnumerationTerminal(mindmap.MindmapPackage.eINSTANCE.getRelationship().getEStructuralFeature(mindmap.MindmapPackage.RELATIONSHIP__TYPE), new String[] {"DEPENDENCY", "DEPENDENCY", "INCLUDE", "INCLUDE", "EXTEND", "EXTEND", }, mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, 0);
	public final static mindmap.resource.mindmap.grammar.MindmapSequence MINDMAP_2_0_0_2_0_1 = new mindmap.resource.mindmap.grammar.MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_2_0_0_2_0_1_0, MINDMAP_2_0_0_2_0_1_1, MINDMAP_2_0_0_2_0_1_2);
	public final static mindmap.resource.mindmap.grammar.MindmapChoice MINDMAP_2_0_0_2_0 = new mindmap.resource.mindmap.grammar.MindmapChoice(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_2_0_0_2_0_0, MINDMAP_2_0_0_2_0_1);
	public final static mindmap.resource.mindmap.grammar.MindmapCompound MINDMAP_2_0_0_2 = new mindmap.resource.mindmap.grammar.MindmapCompound(MINDMAP_2_0_0_2_0, mindmap.resource.mindmap.grammar.MindmapCardinality.STAR);
	public final static mindmap.resource.mindmap.grammar.MindmapKeyword MINDMAP_2_0_0_3 = new mindmap.resource.mindmap.grammar.MindmapKeyword("}", mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	public final static mindmap.resource.mindmap.grammar.MindmapSequence MINDMAP_2_0_0 = new mindmap.resource.mindmap.grammar.MindmapSequence(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_2_0_0_0, MINDMAP_2_0_0_1, MINDMAP_2_0_0_2, MINDMAP_2_0_0_3);
	public final static mindmap.resource.mindmap.grammar.MindmapChoice MINDMAP_2_0 = new mindmap.resource.mindmap.grammar.MindmapChoice(mindmap.resource.mindmap.grammar.MindmapCardinality.ONE, MINDMAP_2_0_0);
	public final static mindmap.resource.mindmap.grammar.MindmapRule MINDMAP_2 = new mindmap.resource.mindmap.grammar.MindmapRule(mindmap.MindmapPackage.eINSTANCE.getRelationship(), MINDMAP_2_0, mindmap.resource.mindmap.grammar.MindmapCardinality.ONE);
	
	public static String getSyntaxElementID(mindmap.resource.mindmap.grammar.MindmapSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.class.getFields()) {
			Object fieldValue;
			try {
				fieldValue = field.get(null);
				if (fieldValue == syntaxElement) {
					String id = field.getName();
					return id;
				}
			} catch (Exception e) { }
		}
		return null;
	}
	
	public static mindmap.resource.mindmap.grammar.MindmapSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (mindmap.resource.mindmap.grammar.MindmapSyntaxElement) mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static mindmap.resource.mindmap.grammar.MindmapRule[] RULES = new mindmap.resource.mindmap.grammar.MindmapRule[] {
		MINDMAP_0,
		MINDMAP_1,
		MINDMAP_2,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (mindmap.resource.mindmap.grammar.MindmapRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(mindmap.resource.mindmap.grammar.MindmapSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof mindmap.resource.mindmap.grammar.MindmapKeyword) {
			keywords.add(((mindmap.resource.mindmap.grammar.MindmapKeyword) element).getValue());
		} else if (element instanceof mindmap.resource.mindmap.grammar.MindmapBooleanTerminal) {
			keywords.add(((mindmap.resource.mindmap.grammar.MindmapBooleanTerminal) element).getTrueLiteral());
			keywords.add(((mindmap.resource.mindmap.grammar.MindmapBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof mindmap.resource.mindmap.grammar.MindmapEnumerationTerminal) {
			mindmap.resource.mindmap.grammar.MindmapEnumerationTerminal terminal = (mindmap.resource.mindmap.grammar.MindmapEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (mindmap.resource.mindmap.grammar.MindmapSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
