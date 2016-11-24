/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

public class MindmapSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			mindmap.MindmapPackage.eINSTANCE.getMap(),
			mindmap.MindmapPackage.eINSTANCE.getTopic(),
			mindmap.MindmapPackage.eINSTANCE.getRelationship(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			mindmap.MindmapPackage.eINSTANCE.getMap(),
		};
	}
	
}
