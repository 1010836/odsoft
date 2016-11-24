/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

public class MindmapTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public mindmap.resource.mindmap.IMindmapTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("Map".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("title".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("created".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("elements".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("rootTopics".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Topic".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("name".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("description".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("start".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("end".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("priority".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("subtopics".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("parent".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Relationship".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Type".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("HIGH".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("MEDIUM".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("LOW".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("DEPENDENCY".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("INCLUDE".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("EXTEND".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new mindmap.resource.mindmap.mopp.MindmapTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
