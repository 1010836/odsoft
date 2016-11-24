/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.debug;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class MindmapDebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private java.io.PrintStream output;
	
	private java.io.BufferedReader reader;
	
	private mindmap.resource.mindmap.debug.MindmapDebugTarget debugTarget;
	
	private mindmap.resource.mindmap.debug.MindmapDebugCommunicationHelper communicationHelper = new mindmap.resource.mindmap.debug.MindmapDebugCommunicationHelper();
	
	public MindmapDebugProxy(mindmap.resource.mindmap.debug.MindmapDebugTarget debugTarget, int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		this.debugTarget = debugTarget;
		// give interpreter a chance to start
		try {
			Thread.sleep(STARTUP_DELAY);
		} catch (InterruptedException e) {
		}
		startSocket(requestPort);
	}
	
	private void startSocket(int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		// creating client proxy socket (trying to connect)...
		java.net.Socket client = new java.net.Socket("localhost", requestPort);
		// creating client proxy socket - done. (connected)
		try {
			java.io.BufferedInputStream input = new java.io.BufferedInputStream(client.getInputStream());
			reader = new java.io.BufferedReader(new java.io.InputStreamReader(input));
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
		try {
			output = new java.io.PrintStream(client.getOutputStream());
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
	}
	
	public void resume() {
		sendCommand(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes.EXIT);
	}
	
	public mindmap.resource.mindmap.debug.MindmapDebugMessage getStack() {
		return sendCommandAndRead(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		mindmap.resource.mindmap.debug.MindmapDebugMessage message = new mindmap.resource.mindmap.debug.MindmapDebugMessage(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		mindmap.resource.mindmap.debug.MindmapDebugMessage message = new mindmap.resource.mindmap.debug.MindmapDebugMessage(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public org.eclipse.debug.core.model.IVariable[] getStackVariables(String stackFrame) {
		mindmap.resource.mindmap.debug.MindmapDebugMessage response = sendCommandAndRead(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		org.eclipse.debug.core.model.IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public org.eclipse.debug.core.model.IVariable[] getVariables(String... requestedIDs) {
		mindmap.resource.mindmap.debug.MindmapDebugMessage response = sendCommandAndRead(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		mindmap.resource.mindmap.debug.MindmapDebugVariable[] variables  = new mindmap.resource.mindmap.debug.MindmapDebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			java.util.Map<String, String> properties = mindmap.resource.mindmap.util.MindmapStringUtil.convertFromString(varString);
			
			// convert varString to variables and values
			String valueString = properties.get("!valueString");
			String valueRefType = "valueRefType";
			java.util.Map<String, Long> childVariables = new java.util.TreeMap<String, Long>(new java.util.Comparator<String>() {
				public int compare(String s1, String s2) {
					return s1.compareToIgnoreCase(s2);
				}
			});
			for (String property : properties.keySet()) {
				// ignore special properties - they are not children
				if (property.startsWith("!")) {
					continue;
				}
				childVariables.put(property, Long.parseLong(properties.get(property)));
			}
			String id = properties.get("!id");
			org.eclipse.debug.core.model.IValue value = new mindmap.resource.mindmap.debug.MindmapDebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			mindmap.resource.mindmap.debug.MindmapDebugVariable variable = new mindmap.resource.mindmap.debug.MindmapDebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes command, String... parameters) {
		mindmap.resource.mindmap.debug.MindmapDebugMessage message = new mindmap.resource.mindmap.debug.MindmapDebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private mindmap.resource.mindmap.debug.MindmapDebugMessage sendCommandAndRead(mindmap.resource.mindmap.debug.EMindmapDebugMessageTypes command, String... parameters) {
		mindmap.resource.mindmap.debug.MindmapDebugMessage message = new mindmap.resource.mindmap.debug.MindmapDebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}
