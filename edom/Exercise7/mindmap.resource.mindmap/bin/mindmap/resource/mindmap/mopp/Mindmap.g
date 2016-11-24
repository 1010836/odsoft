grammar Mindmap;

options {
	superClass = MindmapANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package mindmap.resource.mindmap.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package mindmap.resource.mindmap.mopp;
}

@members{
	private mindmap.resource.mindmap.IMindmapTokenResolverFactory tokenResolverFactory = new mindmap.resource.mindmap.mopp.MindmapTokenResolverFactory();
	
	/**
	 * the index of the last token that was handled by collectHiddenTokens()
	 */
	private int lastPosition;
	
	/**
	 * A flag that indicates whether the parser should remember all expected elements.
	 * This flag is set to true when using the parse for code completion. Otherwise it
	 * is set to false.
	 */
	private boolean rememberExpectedElements = false;
	
	private Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	
	/**
	 * A list of expected elements the were collected while parsing the input stream.
	 * This list is only filled if <code>rememberExpectedElements</code> is set to
	 * true.
	 */
	private java.util.List<mindmap.resource.mindmap.mopp.MindmapExpectedTerminal> expectedElements = new java.util.ArrayList<mindmap.resource.mindmap.mopp.MindmapExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
	
	/**
	 * Another helper list to allow a lexer to pass positions of errors to its parser
	 */
	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
	
	/**
	 * A stack for incomplete objects. This stack is used filled when the parser is
	 * used for code completion. Whenever the parser starts to read an object it is
	 * pushed on the stack. Once the element was parser completely it is popped from
	 * the stack.
	 */
	java.util.List<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
	
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	private int tokenIndexOfLastCompleteElement;
	
	private int expectedElementsIndexOfLastCompleteElement;
	
	/**
	 * The offset indicating the cursor position when the parser is used for code
	 * completion by calling parseToExpectedElements().
	 */
	private int cursorOffset;
	
	/**
	 * The offset of the first hidden token of the last expected element. This offset
	 * is used to discard expected elements, which are not needed for code completion.
	 */
	private int lastStartIncludingHidden;
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new mindmap.resource.mindmap.IMindmapCommand<mindmap.resource.mindmap.IMindmapTextResource>() {
			public boolean execute(mindmap.resource.mindmap.IMindmapTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new mindmap.resource.mindmap.IMindmapProblem() {
					public mindmap.resource.mindmap.MindmapEProblemSeverity getSeverity() {
						return mindmap.resource.mindmap.MindmapEProblemSeverity.ERROR;
					}
					public mindmap.resource.mindmap.MindmapEProblemType getType() {
						return mindmap.resource.mindmap.MindmapEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<mindmap.resource.mindmap.IMindmapQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
		if (!this.rememberExpectedElements) {
			return;
		}
		int terminalID = ids[0];
		int followSetID = ids[1];
		mindmap.resource.mindmap.IMindmapExpectedElement terminal = mindmap.resource.mindmap.grammar.MindmapFollowSetProvider.TERMINALS[terminalID];
		mindmap.resource.mindmap.mopp.MindmapContainedFeature[] containmentFeatures = new mindmap.resource.mindmap.mopp.MindmapContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = mindmap.resource.mindmap.grammar.MindmapFollowSetProvider.LINKS[ids[i]];
		}
		mindmap.resource.mindmap.grammar.MindmapContainmentTrace containmentTrace = new mindmap.resource.mindmap.grammar.MindmapContainmentTrace(eClass, containmentFeatures);
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		mindmap.resource.mindmap.mopp.MindmapExpectedTerminal expectedElement = new mindmap.resource.mindmap.mopp.MindmapExpectedTerminal(container, terminal, followSetID, containmentTrace);
		setPosition(expectedElement, input.index());
		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
			// clear list of expected elements
			this.expectedElements.clear();
			this.expectedElementsIndexOfLastCompleteElement = 0;
		}
		lastStartIncludingHidden = startIncludingHiddenTokens;
		this.expectedElements.add(expectedElement);
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new mindmap.resource.mindmap.IMindmapCommand<mindmap.resource.mindmap.IMindmapTextResource>() {
			public boolean execute(mindmap.resource.mindmap.IMindmapTextResource resource) {
				mindmap.resource.mindmap.IMindmapLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				locationMap.setCharStart(target, locationMap.getCharStart(source));
				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
				locationMap.setColumn(target, locationMap.getColumn(source));
				locationMap.setLine(target, locationMap.getLine(source));
				return true;
			}
		});
	}
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new mindmap.resource.mindmap.IMindmapCommand<mindmap.resource.mindmap.IMindmapTextResource>() {
			public boolean execute(mindmap.resource.mindmap.IMindmapTextResource resource) {
				mindmap.resource.mindmap.IMindmapLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				if (source == null) {
					return true;
				}
				locationMap.setCharStart(target, source.getStartIndex());
				locationMap.setCharEnd(target, source.getStopIndex());
				locationMap.setColumn(target, source.getCharPositionInLine());
				locationMap.setLine(target, source.getLine());
				return true;
			}
		});
	}
	
	/**
	 * Sets the end character index and the last line for the given object in the
	 * location map.
	 */
	protected void setLocalizationEnd(java.util.Collection<mindmap.resource.mindmap.IMindmapCommand<mindmap.resource.mindmap.IMindmapTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new mindmap.resource.mindmap.IMindmapCommand<mindmap.resource.mindmap.IMindmapTextResource>() {
			public boolean execute(mindmap.resource.mindmap.IMindmapTextResource resource) {
				mindmap.resource.mindmap.IMindmapLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public mindmap.resource.mindmap.IMindmapTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new MindmapParser(new org.antlr.runtime3_4_0.CommonTokenStream(new MindmapLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new MindmapParser(new org.antlr.runtime3_4_0.CommonTokenStream(new MindmapLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new mindmap.resource.mindmap.util.MindmapRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public MindmapParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((MindmapLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((MindmapLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == mindmap.Map.class) {
				return parse_mindmap_Map();
			}
			if (type.getInstanceClass() == mindmap.Topic.class) {
				return parse_mindmap_Topic();
			}
			if (type.getInstanceClass() == mindmap.Relationship.class) {
				return parse_mindmap_Relationship();
			}
		}
		throw new mindmap.resource.mindmap.mopp.MindmapUnexpectedContentTypeException(typeObject);
	}
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public Object getMissingSymbol(org.antlr.runtime3_4_0.IntStream arg0, org.antlr.runtime3_4_0.RecognitionException arg1, int arg2, org.antlr.runtime3_4_0.BitSet arg3) {
		mismatchedTokenRecoveryTries++;
		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
	}
	
	public Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected Object getTypeObject() {
		Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(mindmap.resource.mindmap.IMindmapOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public mindmap.resource.mindmap.IMindmapParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<mindmap.resource.mindmap.IMindmapCommand<mindmap.resource.mindmap.IMindmapTextResource>>();
		mindmap.resource.mindmap.mopp.MindmapParseResult parseResult = new mindmap.resource.mindmap.mopp.MindmapParseResult();
		try {
			org.eclipse.emf.ecore.EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
			}
		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
			reportLexicalError(re);
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public java.util.List<mindmap.resource.mindmap.mopp.MindmapExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, mindmap.resource.mindmap.IMindmapTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		mindmap.resource.mindmap.IMindmapParseResult result = parse();
		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
			org.antlr.runtime3_4_0.Lexer lexer = (org.antlr.runtime3_4_0.Lexer) tokenStream.getTokenSource();
			int endChar = lexer.getCharIndex();
			int endLine = lexer.getLine();
			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
		}
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContentsInternal().add(root);
			}
			for (mindmap.resource.mindmap.IMindmapCommand<mindmap.resource.mindmap.IMindmapTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<mindmap.resource.mindmap.mopp.MindmapExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<mindmap.resource.mindmap.mopp.MindmapExpectedTerminal>();
		java.util.List<mindmap.resource.mindmap.mopp.MindmapExpectedTerminal> newFollowSet = new java.util.ArrayList<mindmap.resource.mindmap.mopp.MindmapExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			mindmap.resource.mindmap.mopp.MindmapExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 46;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_4_0.CommonToken nextToken = (org.antlr.runtime3_4_0.CommonToken) tokenStream.get(i);
			if (nextToken.getType() < 0) {
				break;
			}
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected
				// terminals can be set
				for (mindmap.resource.mindmap.mopp.MindmapExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (mindmap.resource.mindmap.mopp.MindmapExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<mindmap.resource.mindmap.util.MindmapPair<mindmap.resource.mindmap.IMindmapExpectedElement, mindmap.resource.mindmap.mopp.MindmapContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (mindmap.resource.mindmap.util.MindmapPair<mindmap.resource.mindmap.IMindmapExpectedElement, mindmap.resource.mindmap.mopp.MindmapContainedFeature[]> newFollowerPair : newFollowers) {
							mindmap.resource.mindmap.IMindmapExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							mindmap.resource.mindmap.grammar.MindmapContainmentTrace containmentTrace = new mindmap.resource.mindmap.grammar.MindmapContainmentTrace(null, newFollowerPair.getRight());
							mindmap.resource.mindmap.mopp.MindmapExpectedTerminal newFollowTerminal = new mindmap.resource.mindmap.mopp.MindmapExpectedTerminal(container, newFollower, followSetID, containmentTrace);
							newFollowSet.add(newFollowTerminal);
							expectedElements.add(newFollowTerminal);
						}
					}
				}
				currentFollowSet.clear();
				currentFollowSet.addAll(newFollowSet);
			}
			followSetID++;
		}
		// after the last token in the stream we must set the position for the elements
		// that were added during the last iteration of the loop
		for (mindmap.resource.mindmap.mopp.MindmapExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(mindmap.resource.mindmap.mopp.MindmapExpectedTerminal expectedElement, int tokenIndex) {
		int currentIndex = Math.max(0, tokenIndex);
		for (int index = lastTokenIndex; index < currentIndex; index++) {
			if (index >= input.size()) {
				break;
			}
			org.antlr.runtime3_4_0.CommonToken tokenAtIndex = (org.antlr.runtime3_4_0.CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public Object recoverFromMismatchedToken(org.antlr.runtime3_4_0.IntStream input, int ttype, org.antlr.runtime3_4_0.BitSet follow) throws org.antlr.runtime3_4_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			String expectedTokenName = formatTokenName(mte.expecting);
			String actualTokenName = formatTokenName(e.token.getType());
			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
			String expectedTokenName = formatTokenName(mtne.expecting);
			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
		}
		// the resource may be null if the parser is used for code completion
		final String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = "";
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
	}
	
	private void startIncompleteElement(Object object) {
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.incompleteObjects.add((org.eclipse.emf.ecore.EObject) object);
		}
	}
	
	private void completedElement(Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			boolean exists = this.incompleteObjects.remove(object);
			if (!exists) {
			}
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	private org.eclipse.emf.ecore.EObject getLastIncompleteElement() {
		if (incompleteObjects.isEmpty()) {
			return null;
		}
		return incompleteObjects.get(incompleteObjects.size() - 1);
	}
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_mindmap_Map{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_mindmap_Map returns [mindmap.Map element = null]
@init{
}
:
	a0 = 'Map' {
		if (element == null) {
			element = mindmap.MindmapFactory.eINSTANCE.createMap();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[1]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = mindmap.MindmapFactory.eINSTANCE.createMap();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[2]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[3]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[4]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[5]);
	}
	
	(
		(
			a2 = 'title' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createMap();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[6]);
			}
			
			a3 = ':' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createMap();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[7]);
			}
			
			(
				a4 = QUOTED_34_34				
				{
					if (terminateParsing) {
						throw new mindmap.resource.mindmap.mopp.MindmapTerminateParsingException();
					}
					if (element == null) {
						element = mindmap.MindmapFactory.eINSTANCE.createMap();
						startIncompleteElement(element);
					}
					if (a4 != null) {
						mindmap.resource.mindmap.IMindmapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						tokenResolver.setOptions(getOptions());
						mindmap.resource.mindmap.IMindmapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(mindmap.MindmapPackage.MAP__TITLE), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.MAP__TITLE), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_0_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[8]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[9]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[10]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[11]);
			}
			
			
			|			a5 = 'created' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createMap();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_1_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[12]);
			}
			
			a6 = ':' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createMap();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_1_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[13]);
			}
			
			(
				a7 = TEXT				
				{
					if (terminateParsing) {
						throw new mindmap.resource.mindmap.mopp.MindmapTerminateParsingException();
					}
					if (element == null) {
						element = mindmap.MindmapFactory.eINSTANCE.createMap();
						startIncompleteElement(element);
					}
					if (a7 != null) {
						mindmap.resource.mindmap.IMindmapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						mindmap.resource.mindmap.IMindmapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(mindmap.MindmapPackage.MAP__CREATED), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
						}
						java.util.Date resolved = (java.util.Date) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.MAP__CREATED), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_1_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[14]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[15]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[16]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[17]);
			}
			
			
			|			a8 = 'elements' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createMap();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_2_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[18]);
			}
			
			a9 = ':' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createMap();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_2_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(mindmap.MindmapPackage.eINSTANCE.getMap(), mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[19]);
				addExpectedElement(mindmap.MindmapPackage.eINSTANCE.getMap(), mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[20]);
			}
			
			(
				a10_0 = parse_mindmap_MapElement				{
					if (terminateParsing) {
						throw new mindmap.resource.mindmap.mopp.MindmapTerminateParsingException();
					}
					if (element == null) {
						element = mindmap.MindmapFactory.eINSTANCE.createMap();
						startIncompleteElement(element);
					}
					if (a10_0 != null) {
						if (a10_0 != null) {
							Object value = a10_0;
							addObjectToList(element, mindmap.MindmapPackage.MAP__ELEMENTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_2_2, a10_0, true);
						copyLocalizationInfos(a10_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[21]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[22]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[23]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[24]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[25]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[26]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[28]);
	}
	
	a11 = '}' {
		if (element == null) {
			element = mindmap.MindmapFactory.eINSTANCE.createMap();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
	}
	
;

parse_mindmap_Topic returns [mindmap.Topic element = null]
@init{
}
:
	a0 = 'Topic' {
		if (element == null) {
			element = mindmap.MindmapFactory.eINSTANCE.createTopic();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[29]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = mindmap.MindmapFactory.eINSTANCE.createTopic();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[30]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[31]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[32]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[33]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[34]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[35]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[36]);
	}
	
	(
		(
			a2 = 'name' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[37]);
			}
			
			a3 = ':' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[38]);
			}
			
			(
				a4 = QUOTED_34_34				
				{
					if (terminateParsing) {
						throw new mindmap.resource.mindmap.mopp.MindmapTerminateParsingException();
					}
					if (element == null) {
						element = mindmap.MindmapFactory.eINSTANCE.createTopic();
						startIncompleteElement(element);
					}
					if (a4 != null) {
						mindmap.resource.mindmap.IMindmapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						tokenResolver.setOptions(getOptions());
						mindmap.resource.mindmap.IMindmapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__NAME), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__NAME), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_0_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[39]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[40]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[41]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[42]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[43]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[44]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[45]);
			}
			
			
			|			a5 = 'description' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_1_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[46]);
			}
			
			a6 = ':' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_1_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[47]);
			}
			
			(
				a7 = QUOTED_34_34				
				{
					if (terminateParsing) {
						throw new mindmap.resource.mindmap.mopp.MindmapTerminateParsingException();
					}
					if (element == null) {
						element = mindmap.MindmapFactory.eINSTANCE.createTopic();
						startIncompleteElement(element);
					}
					if (a7 != null) {
						mindmap.resource.mindmap.IMindmapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						tokenResolver.setOptions(getOptions());
						mindmap.resource.mindmap.IMindmapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__DESCRIPTION), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__DESCRIPTION), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_1_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[48]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[49]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[50]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[51]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[52]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[53]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[54]);
			}
			
			
			|			a8 = 'start' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_2_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[55]);
			}
			
			a9 = ':' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_2_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[56]);
			}
			
			(
				a10 = TEXT				
				{
					if (terminateParsing) {
						throw new mindmap.resource.mindmap.mopp.MindmapTerminateParsingException();
					}
					if (element == null) {
						element = mindmap.MindmapFactory.eINSTANCE.createTopic();
						startIncompleteElement(element);
					}
					if (a10 != null) {
						mindmap.resource.mindmap.IMindmapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						mindmap.resource.mindmap.IMindmapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__START), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
						}
						java.util.Date resolved = (java.util.Date) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__START), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_2_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[57]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[58]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[59]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[60]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[61]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[62]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[63]);
			}
			
			
			|			a11 = 'end' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_3_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[64]);
			}
			
			a12 = ':' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_3_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[65]);
			}
			
			(
				a13 = TEXT				
				{
					if (terminateParsing) {
						throw new mindmap.resource.mindmap.mopp.MindmapTerminateParsingException();
					}
					if (element == null) {
						element = mindmap.MindmapFactory.eINSTANCE.createTopic();
						startIncompleteElement(element);
					}
					if (a13 != null) {
						mindmap.resource.mindmap.IMindmapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						mindmap.resource.mindmap.IMindmapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__END), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a13).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStopIndex());
						}
						java.util.Date resolved = (java.util.Date) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__END), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_3_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a13, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[66]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[67]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[68]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[69]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[70]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[71]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[72]);
			}
			
			
			|			a14 = 'priority' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_4_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[73]);
			}
			
			a15 = ':' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_4_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[74]);
			}
			
			(
				(
					a16 = 'HIGH' {
						if (element == null) {
							element = mindmap.MindmapFactory.eINSTANCE.createTopic();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_4_2, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
						// set value of enumeration attribute
						Object value = mindmap.MindmapPackage.eINSTANCE.getPriority().getEEnumLiteral(mindmap.Priority.HIGH_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__PRIORITY), value);
						completedElement(value, false);
					}
					|					a17 = 'MEDIUM' {
						if (element == null) {
							element = mindmap.MindmapFactory.eINSTANCE.createTopic();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_4_2, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
						// set value of enumeration attribute
						Object value = mindmap.MindmapPackage.eINSTANCE.getPriority().getEEnumLiteral(mindmap.Priority.MEDIUM_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__PRIORITY), value);
						completedElement(value, false);
					}
					|					a18 = 'LOW' {
						if (element == null) {
							element = mindmap.MindmapFactory.eINSTANCE.createTopic();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_4_2, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
						// set value of enumeration attribute
						Object value = mindmap.MindmapPackage.eINSTANCE.getPriority().getEEnumLiteral(mindmap.Priority.LOW_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__PRIORITY), value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[75]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[76]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[77]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[78]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[79]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[80]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[81]);
			}
			
			
			|			a21 = 'parent' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_5_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a21, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[82]);
			}
			
			a22 = ':' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_5_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a22, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[83]);
			}
			
			(
				a23 = TEXT				
				{
					if (terminateParsing) {
						throw new mindmap.resource.mindmap.mopp.MindmapTerminateParsingException();
					}
					if (element == null) {
						element = mindmap.MindmapFactory.eINSTANCE.createTopic();
						startIncompleteElement(element);
					}
					if (a23 != null) {
						mindmap.resource.mindmap.IMindmapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						mindmap.resource.mindmap.IMindmapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a23.getText(), element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__PARENT), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a23).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a23).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a23).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a23).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						mindmap.Topic proxy = mindmap.MindmapFactory.eINSTANCE.createTopic();
						collectHiddenTokens(element);
						registerContextDependentProxy(new mindmap.resource.mindmap.mopp.MindmapContextDependentURIFragmentFactory<mindmap.Topic, mindmap.Topic>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTopicParentReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__PARENT), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							element.eSet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.TOPIC__PARENT), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_5_2, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a23, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a23, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[84]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[85]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[86]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[87]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[88]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[89]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[90]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[91]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[92]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[93]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[94]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[95]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[96]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[97]);
	}
	
	a24 = '}' {
		if (element == null) {
			element = mindmap.MindmapFactory.eINSTANCE.createTopic();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a24, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[98]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[99]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[100]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[101]);
	}
	
;

parse_mindmap_Relationship returns [mindmap.Relationship element = null]
@init{
}
:
	a0 = 'Relationship' {
		if (element == null) {
			element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[102]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[103]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[104]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[105]);
	}
	
	(
		(
			a2 = 'name' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[106]);
			}
			
			a3 = ':' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[107]);
			}
			
			(
				a4 = QUOTED_34_34				
				{
					if (terminateParsing) {
						throw new mindmap.resource.mindmap.mopp.MindmapTerminateParsingException();
					}
					if (element == null) {
						element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
						startIncompleteElement(element);
					}
					if (a4 != null) {
						mindmap.resource.mindmap.IMindmapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						tokenResolver.setOptions(getOptions());
						mindmap.resource.mindmap.IMindmapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(mindmap.MindmapPackage.RELATIONSHIP__NAME), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.RELATIONSHIP__NAME), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_0_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[108]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[109]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[110]);
			}
			
			
			|			a5 = 'Type' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_1_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[111]);
			}
			
			a6 = ':' {
				if (element == null) {
					element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_1_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[112]);
			}
			
			(
				(
					a7 = 'DEPENDENCY' {
						if (element == null) {
							element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_1_2, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
						// set value of enumeration attribute
						Object value = mindmap.MindmapPackage.eINSTANCE.getType().getEEnumLiteral(mindmap.Type.DEPENDENCY_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.RELATIONSHIP__TYPE), value);
						completedElement(value, false);
					}
					|					a8 = 'INCLUDE' {
						if (element == null) {
							element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_1_2, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
						// set value of enumeration attribute
						Object value = mindmap.MindmapPackage.eINSTANCE.getType().getEEnumLiteral(mindmap.Type.INCLUDE_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.RELATIONSHIP__TYPE), value);
						completedElement(value, false);
					}
					|					a9 = 'EXTEND' {
						if (element == null) {
							element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_1_2, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
						// set value of enumeration attribute
						Object value = mindmap.MindmapPackage.eINSTANCE.getType().getEEnumLiteral(mindmap.Type.EXTEND_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(mindmap.MindmapPackage.RELATIONSHIP__TYPE), value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[113]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[114]);
				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[115]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[116]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[117]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[118]);
	}
	
	a12 = '}' {
		if (element == null) {
			element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[119]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[120]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[122]);
	}
	
;

parse_mindmap_MapElement returns [mindmap.MapElement element = null]
:
	c0 = parse_mindmap_Topic{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_mindmap_Relationship{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
INTEGER:
	(('-')?('1'..'9')('0'..'9')*|'0')
	{ _channel = 99; }
;
FLOAT:
	(('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ )
	{ _channel = 99; }
;
TEXT:
	(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+)
;
WHITESPACE:
	((' ' | '\t' | '\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

