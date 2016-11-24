// $ANTLR 3.4

	package mindmap.resource.mindmap.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class MindmapParser extends MindmapANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "FLOAT", "INTEGER", "LINEBREAK", "QUOTED_34_34", "TEXT", "WHITESPACE", "':'", "'DEPENDENCY'", "'EXTEND'", "'HIGH'", "'INCLUDE'", "'LOW'", "'MEDIUM'", "'Map'", "'Relationship'", "'Topic'", "'Type'", "'created'", "'description'", "'elements'", "'end'", "'name'", "'parent'", "'priority'", "'start'", "'title'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int COMMENT=4;
    public static final int FLOAT=5;
    public static final int INTEGER=6;
    public static final int LINEBREAK=7;
    public static final int QUOTED_34_34=8;
    public static final int TEXT=9;
    public static final int WHITESPACE=10;

    // delegates
    public MindmapANTLRParserBase[] getDelegates() {
        return new MindmapANTLRParserBase[] {};
    }

    // delegators


    public MindmapParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public MindmapParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(21 + 1);
         

    }

    public String[] getTokenNames() { return MindmapParser.tokenNames; }
    public String getGrammarFileName() { return "Mindmap.g"; }


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
    	



    // $ANTLR start "start"
    // Mindmap.g:505:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_mindmap_Map ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        mindmap.Map c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Mindmap.g:506:2: ( (c0= parse_mindmap_Map ) EOF )
            // Mindmap.g:507:2: (c0= parse_mindmap_Map ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Mindmap.g:512:2: (c0= parse_mindmap_Map )
            // Mindmap.g:513:3: c0= parse_mindmap_Map
            {
            pushFollow(FOLLOW_parse_mindmap_Map_in_start82);
            c0=parse_mindmap_Map();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; }

            }


            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		retrieveLayoutInformation(element, null, null, false);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "start"



    // $ANTLR start "parse_mindmap_Map"
    // Mindmap.g:521:1: parse_mindmap_Map returns [mindmap.Map element = null] : a0= 'Map' a1= '{' ( (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) |a5= 'created' a6= ':' (a7= TEXT ) |a8= 'elements' a9= ':' (a10_0= parse_mindmap_MapElement ) ) )* a11= '}' ;
    public final mindmap.Map parse_mindmap_Map() throws RecognitionException {
        mindmap.Map element =  null;

        int parse_mindmap_Map_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a11=null;
        mindmap.MapElement a10_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Mindmap.g:524:2: (a0= 'Map' a1= '{' ( (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) |a5= 'created' a6= ':' (a7= TEXT ) |a8= 'elements' a9= ':' (a10_0= parse_mindmap_MapElement ) ) )* a11= '}' )
            // Mindmap.g:525:2: a0= 'Map' a1= '{' ( (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) |a5= 'created' a6= ':' (a7= TEXT ) |a8= 'elements' a9= ':' (a10_0= parse_mindmap_MapElement ) ) )* a11= '}'
            {
            a0=(Token)match(input,18,FOLLOW_18_in_parse_mindmap_Map115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = mindmap.MindmapFactory.eINSTANCE.createMap();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[1]);
            	}

            a1=(Token)match(input,31,FOLLOW_31_in_parse_mindmap_Map129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = mindmap.MindmapFactory.eINSTANCE.createMap();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[2]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[4]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[5]);
            	}

            // Mindmap.g:556:2: ( (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) |a5= 'created' a6= ':' (a7= TEXT ) |a8= 'elements' a9= ':' (a10_0= parse_mindmap_MapElement ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22||LA2_0==24||LA2_0==30) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Mindmap.g:557:3: (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) |a5= 'created' a6= ':' (a7= TEXT ) |a8= 'elements' a9= ':' (a10_0= parse_mindmap_MapElement ) )
            	    {
            	    // Mindmap.g:557:3: (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) |a5= 'created' a6= ':' (a7= TEXT ) |a8= 'elements' a9= ':' (a10_0= parse_mindmap_MapElement ) )
            	    int alt1=3;
            	    switch ( input.LA(1) ) {
            	    case 30:
            	        {
            	        alt1=1;
            	        }
            	        break;
            	    case 22:
            	        {
            	        alt1=2;
            	        }
            	        break;
            	    case 24:
            	        {
            	        alt1=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt1) {
            	        case 1 :
            	            // Mindmap.g:558:4: a2= 'title' a3= ':' (a4= QUOTED_34_34 )
            	            {
            	            a2=(Token)match(input,30,FOLLOW_30_in_parse_mindmap_Map152); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createMap();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_0_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[6]);
            	            			}

            	            a3=(Token)match(input,11,FOLLOW_11_in_parse_mindmap_Map172); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createMap();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_0_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[7]);
            	            			}

            	            // Mindmap.g:586:4: (a4= QUOTED_34_34 )
            	            // Mindmap.g:587:5: a4= QUOTED_34_34
            	            {
            	            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_mindmap_Map198); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[8]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[9]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[10]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[11]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Mindmap.g:626:8: a5= 'created' a6= ':' (a7= TEXT )
            	            {
            	            a5=(Token)match(input,22,FOLLOW_22_in_parse_mindmap_Map239); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createMap();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_1_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[12]);
            	            			}

            	            a6=(Token)match(input,11,FOLLOW_11_in_parse_mindmap_Map259); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createMap();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_1_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[13]);
            	            			}

            	            // Mindmap.g:654:4: (a7= TEXT )
            	            // Mindmap.g:655:5: a7= TEXT
            	            {
            	            a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_mindmap_Map285); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[14]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[15]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[16]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[17]);
            	            			}

            	            }
            	            break;
            	        case 3 :
            	            // Mindmap.g:694:8: a8= 'elements' a9= ':' (a10_0= parse_mindmap_MapElement )
            	            {
            	            a8=(Token)match(input,24,FOLLOW_24_in_parse_mindmap_Map326); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createMap();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_2_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[18]);
            	            			}

            	            a9=(Token)match(input,11,FOLLOW_11_in_parse_mindmap_Map346); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createMap();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_2_0_2_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(mindmap.MindmapPackage.eINSTANCE.getMap(), mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[19]);
            	            				addExpectedElement(mindmap.MindmapPackage.eINSTANCE.getMap(), mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[20]);
            	            			}

            	            // Mindmap.g:723:4: (a10_0= parse_mindmap_MapElement )
            	            // Mindmap.g:724:5: a10_0= parse_mindmap_MapElement
            	            {
            	            pushFollow(FOLLOW_parse_mindmap_MapElement_in_parse_mindmap_Map372);
            	            a10_0=parse_mindmap_MapElement();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[21]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[22]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[23]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[24]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[25]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[28]);
            	}

            a11=(Token)match(input,32,FOLLOW_32_in_parse_mindmap_Map413); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = mindmap.MindmapFactory.eINSTANCE.createMap();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_0_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_mindmap_Map_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_mindmap_Map"



    // $ANTLR start "parse_mindmap_Topic"
    // Mindmap.g:777:1: parse_mindmap_Topic returns [mindmap.Topic element = null] : a0= 'Topic' a1= '{' ( (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) |a5= 'description' a6= ':' (a7= QUOTED_34_34 ) |a8= 'start' a9= ':' (a10= TEXT ) |a11= 'end' a12= ':' (a13= TEXT ) |a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) |a21= 'parent' a22= ':' (a23= TEXT ) ) )* a24= '}' ;
    public final mindmap.Topic parse_mindmap_Topic() throws RecognitionException {
        mindmap.Topic element =  null;

        int parse_mindmap_Topic_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;
        Token a17=null;
        Token a18=null;
        Token a21=null;
        Token a22=null;
        Token a23=null;
        Token a24=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Mindmap.g:780:2: (a0= 'Topic' a1= '{' ( (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) |a5= 'description' a6= ':' (a7= QUOTED_34_34 ) |a8= 'start' a9= ':' (a10= TEXT ) |a11= 'end' a12= ':' (a13= TEXT ) |a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) |a21= 'parent' a22= ':' (a23= TEXT ) ) )* a24= '}' )
            // Mindmap.g:781:2: a0= 'Topic' a1= '{' ( (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) |a5= 'description' a6= ':' (a7= QUOTED_34_34 ) |a8= 'start' a9= ':' (a10= TEXT ) |a11= 'end' a12= ':' (a13= TEXT ) |a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) |a21= 'parent' a22= ':' (a23= TEXT ) ) )* a24= '}'
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_mindmap_Topic442); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[29]);
            	}

            a1=(Token)match(input,31,FOLLOW_31_in_parse_mindmap_Topic456); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[30]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[31]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[32]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[33]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[34]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[35]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[36]);
            	}

            // Mindmap.g:815:2: ( (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) |a5= 'description' a6= ':' (a7= QUOTED_34_34 ) |a8= 'start' a9= ':' (a10= TEXT ) |a11= 'end' a12= ':' (a13= TEXT ) |a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) |a21= 'parent' a22= ':' (a23= TEXT ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==23||(LA5_0 >= 25 && LA5_0 <= 29)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Mindmap.g:816:3: (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) |a5= 'description' a6= ':' (a7= QUOTED_34_34 ) |a8= 'start' a9= ':' (a10= TEXT ) |a11= 'end' a12= ':' (a13= TEXT ) |a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) |a21= 'parent' a22= ':' (a23= TEXT ) )
            	    {
            	    // Mindmap.g:816:3: (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) |a5= 'description' a6= ':' (a7= QUOTED_34_34 ) |a8= 'start' a9= ':' (a10= TEXT ) |a11= 'end' a12= ':' (a13= TEXT ) |a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) |a21= 'parent' a22= ':' (a23= TEXT ) )
            	    int alt4=6;
            	    switch ( input.LA(1) ) {
            	    case 26:
            	        {
            	        alt4=1;
            	        }
            	        break;
            	    case 23:
            	        {
            	        alt4=2;
            	        }
            	        break;
            	    case 29:
            	        {
            	        alt4=3;
            	        }
            	        break;
            	    case 25:
            	        {
            	        alt4=4;
            	        }
            	        break;
            	    case 28:
            	        {
            	        alt4=5;
            	        }
            	        break;
            	    case 27:
            	        {
            	        alt4=6;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt4) {
            	        case 1 :
            	            // Mindmap.g:817:4: a2= 'name' a3= ':' (a4= QUOTED_34_34 )
            	            {
            	            a2=(Token)match(input,26,FOLLOW_26_in_parse_mindmap_Topic479); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_0_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[37]);
            	            			}

            	            a3=(Token)match(input,11,FOLLOW_11_in_parse_mindmap_Topic499); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_0_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[38]);
            	            			}

            	            // Mindmap.g:845:4: (a4= QUOTED_34_34 )
            	            // Mindmap.g:846:5: a4= QUOTED_34_34
            	            {
            	            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_mindmap_Topic525); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[39]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[40]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[41]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[42]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[43]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[44]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[45]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Mindmap.g:888:8: a5= 'description' a6= ':' (a7= QUOTED_34_34 )
            	            {
            	            a5=(Token)match(input,23,FOLLOW_23_in_parse_mindmap_Topic566); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_1_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[46]);
            	            			}

            	            a6=(Token)match(input,11,FOLLOW_11_in_parse_mindmap_Topic586); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_1_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[47]);
            	            			}

            	            // Mindmap.g:916:4: (a7= QUOTED_34_34 )
            	            // Mindmap.g:917:5: a7= QUOTED_34_34
            	            {
            	            a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_mindmap_Topic612); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[48]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[49]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[50]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[51]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[52]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[53]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[54]);
            	            			}

            	            }
            	            break;
            	        case 3 :
            	            // Mindmap.g:959:8: a8= 'start' a9= ':' (a10= TEXT )
            	            {
            	            a8=(Token)match(input,29,FOLLOW_29_in_parse_mindmap_Topic653); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_2_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[55]);
            	            			}

            	            a9=(Token)match(input,11,FOLLOW_11_in_parse_mindmap_Topic673); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_2_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[56]);
            	            			}

            	            // Mindmap.g:987:4: (a10= TEXT )
            	            // Mindmap.g:988:5: a10= TEXT
            	            {
            	            a10=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_mindmap_Topic699); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[57]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[58]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[59]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[60]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[61]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[62]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[63]);
            	            			}

            	            }
            	            break;
            	        case 4 :
            	            // Mindmap.g:1030:8: a11= 'end' a12= ':' (a13= TEXT )
            	            {
            	            a11=(Token)match(input,25,FOLLOW_25_in_parse_mindmap_Topic740); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_3_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[64]);
            	            			}

            	            a12=(Token)match(input,11,FOLLOW_11_in_parse_mindmap_Topic760); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_3_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[65]);
            	            			}

            	            // Mindmap.g:1058:4: (a13= TEXT )
            	            // Mindmap.g:1059:5: a13= TEXT
            	            {
            	            a13=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_mindmap_Topic786); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[66]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[67]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[68]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[69]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[70]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[71]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[72]);
            	            			}

            	            }
            	            break;
            	        case 5 :
            	            // Mindmap.g:1101:8: a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) )
            	            {
            	            a14=(Token)match(input,28,FOLLOW_28_in_parse_mindmap_Topic827); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_4_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[73]);
            	            			}

            	            a15=(Token)match(input,11,FOLLOW_11_in_parse_mindmap_Topic847); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_4_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[74]);
            	            			}

            	            // Mindmap.g:1129:4: ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) )
            	            // Mindmap.g:1130:5: (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' )
            	            {
            	            // Mindmap.g:1130:5: (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' )
            	            int alt3=3;
            	            switch ( input.LA(1) ) {
            	            case 14:
            	                {
            	                alt3=1;
            	                }
            	                break;
            	            case 17:
            	                {
            	                alt3=2;
            	                }
            	                break;
            	            case 16:
            	                {
            	                alt3=3;
            	                }
            	                break;
            	            default:
            	                if (state.backtracking>0) {state.failed=true; return element;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 3, 0, input);

            	                throw nvae;

            	            }

            	            switch (alt3) {
            	                case 1 :
            	                    // Mindmap.g:1131:6: a16= 'HIGH'
            	                    {
            	                    a16=(Token)match(input,14,FOLLOW_14_in_parse_mindmap_Topic880); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
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

            	                    }
            	                    break;
            	                case 2 :
            	                    // Mindmap.g:1144:12: a17= 'MEDIUM'
            	                    {
            	                    a17=(Token)match(input,17,FOLLOW_17_in_parse_mindmap_Topic899); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
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

            	                    }
            	                    break;
            	                case 3 :
            	                    // Mindmap.g:1157:12: a18= 'LOW'
            	                    {
            	                    a18=(Token)match(input,16,FOLLOW_16_in_parse_mindmap_Topic918); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
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

            	                    }
            	                    break;

            	            }


            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[75]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[76]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[77]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[78]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[79]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[80]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[81]);
            	            			}

            	            }
            	            break;
            	        case 6 :
            	            // Mindmap.g:1184:8: a21= 'parent' a22= ':' (a23= TEXT )
            	            {
            	            a21=(Token)match(input,27,FOLLOW_27_in_parse_mindmap_Topic957); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_5_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a21, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[82]);
            	            			}

            	            a22=(Token)match(input,11,FOLLOW_11_in_parse_mindmap_Topic977); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_2_0_5_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a22, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[83]);
            	            			}

            	            // Mindmap.g:1212:4: (a23= TEXT )
            	            // Mindmap.g:1213:5: a23= TEXT
            	            {
            	            a23=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_mindmap_Topic1003); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[84]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[85]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[86]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[87]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[88]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[89]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[90]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[91]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[92]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[93]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[94]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[95]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[96]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[97]);
            	}

            a24=(Token)match(input,32,FOLLOW_32_in_parse_mindmap_Topic1049); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = mindmap.MindmapFactory.eINSTANCE.createTopic();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_1_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a24, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[98]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[99]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[100]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[101]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_mindmap_Topic_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_mindmap_Topic"



    // $ANTLR start "parse_mindmap_Relationship"
    // Mindmap.g:1290:1: parse_mindmap_Relationship returns [mindmap.Relationship element = null] : a0= 'Relationship' a1= '{' ( (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) |a5= 'Type' a6= ':' ( (a7= 'DEPENDENCY' |a8= 'INCLUDE' |a9= 'EXTEND' ) ) ) )* a12= '}' ;
    public final mindmap.Relationship parse_mindmap_Relationship() throws RecognitionException {
        mindmap.Relationship element =  null;

        int parse_mindmap_Relationship_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a12=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Mindmap.g:1293:2: (a0= 'Relationship' a1= '{' ( (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) |a5= 'Type' a6= ':' ( (a7= 'DEPENDENCY' |a8= 'INCLUDE' |a9= 'EXTEND' ) ) ) )* a12= '}' )
            // Mindmap.g:1294:2: a0= 'Relationship' a1= '{' ( (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) |a5= 'Type' a6= ':' ( (a7= 'DEPENDENCY' |a8= 'INCLUDE' |a9= 'EXTEND' ) ) ) )* a12= '}'
            {
            a0=(Token)match(input,19,FOLLOW_19_in_parse_mindmap_Relationship1078); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[102]);
            	}

            a1=(Token)match(input,31,FOLLOW_31_in_parse_mindmap_Relationship1092); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[103]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[104]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[105]);
            	}

            // Mindmap.g:1324:2: ( (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) |a5= 'Type' a6= ':' ( (a7= 'DEPENDENCY' |a8= 'INCLUDE' |a9= 'EXTEND' ) ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==21||LA8_0==26) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Mindmap.g:1325:3: (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) |a5= 'Type' a6= ':' ( (a7= 'DEPENDENCY' |a8= 'INCLUDE' |a9= 'EXTEND' ) ) )
            	    {
            	    // Mindmap.g:1325:3: (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) |a5= 'Type' a6= ':' ( (a7= 'DEPENDENCY' |a8= 'INCLUDE' |a9= 'EXTEND' ) ) )
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==26) ) {
            	        alt7=1;
            	    }
            	    else if ( (LA7_0==21) ) {
            	        alt7=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 7, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // Mindmap.g:1326:4: a2= 'name' a3= ':' (a4= QUOTED_34_34 )
            	            {
            	            a2=(Token)match(input,26,FOLLOW_26_in_parse_mindmap_Relationship1115); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_0_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[106]);
            	            			}

            	            a3=(Token)match(input,11,FOLLOW_11_in_parse_mindmap_Relationship1135); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_0_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[107]);
            	            			}

            	            // Mindmap.g:1354:4: (a4= QUOTED_34_34 )
            	            // Mindmap.g:1355:5: a4= QUOTED_34_34
            	            {
            	            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_mindmap_Relationship1161); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[108]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[109]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[110]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Mindmap.g:1393:8: a5= 'Type' a6= ':' ( (a7= 'DEPENDENCY' |a8= 'INCLUDE' |a9= 'EXTEND' ) )
            	            {
            	            a5=(Token)match(input,21,FOLLOW_21_in_parse_mindmap_Relationship1202); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_1_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[111]);
            	            			}

            	            a6=(Token)match(input,11,FOLLOW_11_in_parse_mindmap_Relationship1222); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_2_0_1_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[112]);
            	            			}

            	            // Mindmap.g:1421:4: ( (a7= 'DEPENDENCY' |a8= 'INCLUDE' |a9= 'EXTEND' ) )
            	            // Mindmap.g:1422:5: (a7= 'DEPENDENCY' |a8= 'INCLUDE' |a9= 'EXTEND' )
            	            {
            	            // Mindmap.g:1422:5: (a7= 'DEPENDENCY' |a8= 'INCLUDE' |a9= 'EXTEND' )
            	            int alt6=3;
            	            switch ( input.LA(1) ) {
            	            case 12:
            	                {
            	                alt6=1;
            	                }
            	                break;
            	            case 15:
            	                {
            	                alt6=2;
            	                }
            	                break;
            	            case 13:
            	                {
            	                alt6=3;
            	                }
            	                break;
            	            default:
            	                if (state.backtracking>0) {state.failed=true; return element;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 6, 0, input);

            	                throw nvae;

            	            }

            	            switch (alt6) {
            	                case 1 :
            	                    // Mindmap.g:1423:6: a7= 'DEPENDENCY'
            	                    {
            	                    a7=(Token)match(input,12,FOLLOW_12_in_parse_mindmap_Relationship1255); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
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

            	                    }
            	                    break;
            	                case 2 :
            	                    // Mindmap.g:1436:12: a8= 'INCLUDE'
            	                    {
            	                    a8=(Token)match(input,15,FOLLOW_15_in_parse_mindmap_Relationship1274); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
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

            	                    }
            	                    break;
            	                case 3 :
            	                    // Mindmap.g:1449:12: a9= 'EXTEND'
            	                    {
            	                    a9=(Token)match(input,13,FOLLOW_13_in_parse_mindmap_Relationship1293); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
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

            	                    }
            	                    break;

            	            }


            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[113]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[114]);
            	            				addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[115]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[116]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[117]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[118]);
            	}

            a12=(Token)match(input,32,FOLLOW_32_in_parse_mindmap_Relationship1337); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = mindmap.MindmapFactory.eINSTANCE.createRelationship();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, mindmap.resource.mindmap.grammar.MindmapGrammarInformationProvider.MINDMAP_2_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[119]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[120]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[121]);
            		addExpectedElement(null, mindmap.resource.mindmap.mopp.MindmapExpectationConstants.EXPECTATIONS[122]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_mindmap_Relationship_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_mindmap_Relationship"



    // $ANTLR start "parse_mindmap_MapElement"
    // Mindmap.g:1499:1: parse_mindmap_MapElement returns [mindmap.MapElement element = null] : (c0= parse_mindmap_Topic |c1= parse_mindmap_Relationship );
    public final mindmap.MapElement parse_mindmap_MapElement() throws RecognitionException {
        mindmap.MapElement element =  null;

        int parse_mindmap_MapElement_StartIndex = input.index();

        mindmap.Topic c0 =null;

        mindmap.Relationship c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Mindmap.g:1500:2: (c0= parse_mindmap_Topic |c1= parse_mindmap_Relationship )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            else if ( (LA9_0==19) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // Mindmap.g:1501:2: c0= parse_mindmap_Topic
                    {
                    pushFollow(FOLLOW_parse_mindmap_Topic_in_parse_mindmap_MapElement1362);
                    c0=parse_mindmap_Topic();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Mindmap.g:1502:4: c1= parse_mindmap_Relationship
                    {
                    pushFollow(FOLLOW_parse_mindmap_Relationship_in_parse_mindmap_MapElement1372);
                    c1=parse_mindmap_Relationship();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_mindmap_MapElement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_mindmap_MapElement"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_mindmap_Map_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_parse_mindmap_Map115 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_parse_mindmap_Map129 = new BitSet(new long[]{0x0000000141400000L});
    public static final BitSet FOLLOW_30_in_parse_mindmap_Map152 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_mindmap_Map172 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_mindmap_Map198 = new BitSet(new long[]{0x0000000141400000L});
    public static final BitSet FOLLOW_22_in_parse_mindmap_Map239 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_mindmap_Map259 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_mindmap_Map285 = new BitSet(new long[]{0x0000000141400000L});
    public static final BitSet FOLLOW_24_in_parse_mindmap_Map326 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_mindmap_Map346 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_parse_mindmap_MapElement_in_parse_mindmap_Map372 = new BitSet(new long[]{0x0000000141400000L});
    public static final BitSet FOLLOW_32_in_parse_mindmap_Map413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_mindmap_Topic442 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_parse_mindmap_Topic456 = new BitSet(new long[]{0x000000013E800000L});
    public static final BitSet FOLLOW_26_in_parse_mindmap_Topic479 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_mindmap_Topic499 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_mindmap_Topic525 = new BitSet(new long[]{0x000000013E800000L});
    public static final BitSet FOLLOW_23_in_parse_mindmap_Topic566 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_mindmap_Topic586 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_mindmap_Topic612 = new BitSet(new long[]{0x000000013E800000L});
    public static final BitSet FOLLOW_29_in_parse_mindmap_Topic653 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_mindmap_Topic673 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_mindmap_Topic699 = new BitSet(new long[]{0x000000013E800000L});
    public static final BitSet FOLLOW_25_in_parse_mindmap_Topic740 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_mindmap_Topic760 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_mindmap_Topic786 = new BitSet(new long[]{0x000000013E800000L});
    public static final BitSet FOLLOW_28_in_parse_mindmap_Topic827 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_mindmap_Topic847 = new BitSet(new long[]{0x0000000000034000L});
    public static final BitSet FOLLOW_14_in_parse_mindmap_Topic880 = new BitSet(new long[]{0x000000013E800000L});
    public static final BitSet FOLLOW_17_in_parse_mindmap_Topic899 = new BitSet(new long[]{0x000000013E800000L});
    public static final BitSet FOLLOW_16_in_parse_mindmap_Topic918 = new BitSet(new long[]{0x000000013E800000L});
    public static final BitSet FOLLOW_27_in_parse_mindmap_Topic957 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_mindmap_Topic977 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_mindmap_Topic1003 = new BitSet(new long[]{0x000000013E800000L});
    public static final BitSet FOLLOW_32_in_parse_mindmap_Topic1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_parse_mindmap_Relationship1078 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_parse_mindmap_Relationship1092 = new BitSet(new long[]{0x0000000104200000L});
    public static final BitSet FOLLOW_26_in_parse_mindmap_Relationship1115 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_mindmap_Relationship1135 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_mindmap_Relationship1161 = new BitSet(new long[]{0x0000000104200000L});
    public static final BitSet FOLLOW_21_in_parse_mindmap_Relationship1202 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_mindmap_Relationship1222 = new BitSet(new long[]{0x000000000000B000L});
    public static final BitSet FOLLOW_12_in_parse_mindmap_Relationship1255 = new BitSet(new long[]{0x0000000104200000L});
    public static final BitSet FOLLOW_15_in_parse_mindmap_Relationship1274 = new BitSet(new long[]{0x0000000104200000L});
    public static final BitSet FOLLOW_13_in_parse_mindmap_Relationship1293 = new BitSet(new long[]{0x0000000104200000L});
    public static final BitSet FOLLOW_32_in_parse_mindmap_Relationship1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_mindmap_Topic_in_parse_mindmap_MapElement1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_mindmap_Relationship_in_parse_mindmap_MapElement1372 = new BitSet(new long[]{0x0000000000000002L});

}