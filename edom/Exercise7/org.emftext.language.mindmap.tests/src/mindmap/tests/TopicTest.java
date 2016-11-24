/**
 */
package mindmap.tests;

import junit.textui.TestRunner;

import mindmap.MindmapFactory;
import mindmap.Topic;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Topic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link mindmap.Topic#allSubTopics() <em>All Sub Topics</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class TopicTest extends MapElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TopicTest.class);
	}

	/**
	 * Constructs a new Topic test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopicTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Topic test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Topic getFixture() {
		return (Topic)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MindmapFactory.eINSTANCE.createTopic());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link mindmap.Topic#allSubTopics() <em>All Sub Topics</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindmap.Topic#allSubTopics()
	 * @generated
	 */
	public void testAllSubTopics() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //TopicTest
