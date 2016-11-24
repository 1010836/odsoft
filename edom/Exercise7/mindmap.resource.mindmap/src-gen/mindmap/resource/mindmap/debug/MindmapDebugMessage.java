/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class MindmapDebugMessage {
	
	private static final char DELIMITER = ':';
	private mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes messageType;
	private String[] arguments;
	
	public MindmapDebugMessage(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public MindmapDebugMessage(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes getMessageType() {
		return messageType;
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public String serialize() {
		java.util.List<String> parts = new java.util.ArrayList<String>();
		parts.add(messageType.name());
		for (String argument : arguments) {
			parts.add(argument);
		}
		return mindmap.resource.mindmap.util.MindmapStringUtil.encode(DELIMITER, parts);
	}
	
	public static MindmapDebugMessage deserialize(String response) {
		java.util.List<String> parts = mindmap.resource.mindmap.util.MindmapStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes type = mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes.valueOf(messageType);
		MindmapDebugMessage message = new MindmapDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + mindmap.resource.mindmap.util.MindmapStringUtil.explode(arguments, ", ") + "]";
	}
	
}
