/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package mindmap.resource.mindmap.mopp;

public class MindmapPrinter implements mindmap.resource.mindmap.IMindmapTextPrinter {
	
	protected mindmap.resource.mindmap.IMindmapTokenResolverFactory tokenResolverFactory = new mindmap.resource.mindmap.mopp.MindmapTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private mindmap.resource.mindmap.IMindmapTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public MindmapPrinter(java.io.OutputStream outputStream, mindmap.resource.mindmap.IMindmapTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof mindmap.Map) {
			print_mindmap_Map((mindmap.Map) element, globaltab, out);
			return;
		}
		if (element instanceof mindmap.Topic) {
			print_mindmap_Topic((mindmap.Topic) element, globaltab, out);
			return;
		}
		if (element instanceof mindmap.Relationship) {
			print_mindmap_Relationship((mindmap.Relationship) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected mindmap.resource.mindmap.mopp.MindmapReferenceResolverSwitch getReferenceResolverSwitch() {
		return (mindmap.resource.mindmap.mopp.MindmapReferenceResolverSwitch) new mindmap.resource.mindmap.mopp.MindmapMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		mindmap.resource.mindmap.IMindmapTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new mindmap.resource.mindmap.mopp.MindmapProblem(errorMessage, mindmap.resource.mindmap.MindmapEProblemType.PRINT_PROBLEM, mindmap.resource.mindmap.MindmapEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setEncoding(String encoding) {
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public mindmap.resource.mindmap.IMindmapTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(outputStream), encoding));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_mindmap_Map(mindmap.Map element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.MAP__TITLE));
		printCountingMap.put("title", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.MAP__CREATED));
		printCountingMap.put("created", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.MAP__ELEMENTS));
		printCountingMap.put("elements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Map");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_mindmap_Map_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_mindmap_Map_0(mindmap.Map element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"title"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"created"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"elements"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("created");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("created");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.MAP__CREATED));
					if (o != null) {
						mindmap.resource.mindmap.IMindmapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(mindmap.MindmapPackage.MAP__CREATED), element));
						out.print(" ");
					}
					printCountingMap.put("created", count - 1);
				}
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("elements");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("elements");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.MAP__ELEMENTS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("elements", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("title");
			out.print(" ");
			// DEFINITION PART BEGINS (CsString)
			out.print(":");
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("title");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.MAP__TITLE));
				if (o != null) {
					mindmap.resource.mindmap.IMindmapTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(mindmap.MindmapPackage.MAP__TITLE), element));
					out.print(" ");
				}
				printCountingMap.put("title", count - 1);
			}
		}
	}
	
	
	public void print_mindmap_Topic(mindmap.Topic element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__DESCRIPTION));
		printCountingMap.put("description", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__START));
		printCountingMap.put("start", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__END));
		printCountingMap.put("end", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__PRIORITY));
		printCountingMap.put("priority", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__SUBTOPICS));
		printCountingMap.put("subtopics", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__PARENT));
		printCountingMap.put("parent", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Topic");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_mindmap_Topic_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_mindmap_Topic_0(mindmap.Topic element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"name"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"description"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"start"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"end"		));
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"priority"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"parent"		));
		if (tempMatchCount > matches) {
			alt = 5;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("description");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderInQuotes)
				count = printCountingMap.get("description");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__DESCRIPTION));
					if (o != null) {
						mindmap.resource.mindmap.IMindmapTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__DESCRIPTION), element));
						out.print(" ");
					}
					printCountingMap.put("description", count - 1);
				}
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("start");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("start");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__START));
					if (o != null) {
						mindmap.resource.mindmap.IMindmapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__START), element));
						out.print(" ");
					}
					printCountingMap.put("start", count - 1);
				}
			}
			break;
			case 3:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("end");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("end");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__END));
					if (o != null) {
						mindmap.resource.mindmap.IMindmapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__END), element));
						out.print(" ");
					}
					printCountingMap.put("end", count - 1);
				}
			}
			break;
			case 4:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("priority");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (EnumTerminal)
				count = printCountingMap.get("priority");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__PRIORITY));
					if (o != null) {
					}
					printCountingMap.put("priority", count - 1);
				}
			}
			break;
			case 5:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("parent");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("parent");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__PARENT));
					if (o != null) {
						mindmap.resource.mindmap.IMindmapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTopicParentReferenceResolver().deResolve((mindmap.Topic) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__PARENT)), element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__PARENT), element));
						out.print(" ");
					}
					printCountingMap.put("parent", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("name");
			out.print(" ");
			// DEFINITION PART BEGINS (CsString)
			out.print(":");
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("name");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__NAME));
				if (o != null) {
					mindmap.resource.mindmap.IMindmapTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__NAME), element));
					out.print(" ");
				}
				printCountingMap.put("name", count - 1);
			}
		}
	}
	
	
	public void print_mindmap_Relationship(mindmap.Relationship element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.RELATIONSHIP__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.RELATIONSHIP__TYPE));
		printCountingMap.put("Type", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Relationship");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_mindmap_Relationship_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_mindmap_Relationship_0(mindmap.Relationship element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"name"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"Type"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("Type");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (EnumTerminal)
				count = printCountingMap.get("Type");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.RELATIONSHIP__TYPE));
					if (o != null) {
					}
					printCountingMap.put("Type", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("name");
			out.print(" ");
			// DEFINITION PART BEGINS (CsString)
			out.print(":");
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("name");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.RELATIONSHIP__NAME));
				if (o != null) {
					mindmap.resource.mindmap.IMindmapTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(mindmap.MindmapPackage.RELATIONSHIP__NAME), element));
					out.print(" ");
				}
				printCountingMap.put("name", count - 1);
			}
		}
	}
	
	
}
