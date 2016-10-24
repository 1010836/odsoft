/**
 */
package requirements.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import requirements.RequirementsFactory;
import requirements.RequirentGroup;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Requirent Group</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequirentGroupTest extends TestCase {

	/**
	 * The fixture for this Requirent Group test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirentGroup fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RequirentGroupTest.class);
	}

	/**
	 * Constructs a new Requirent Group test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirentGroupTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Requirent Group test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(RequirentGroup fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Requirent Group test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirentGroup getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RequirementsFactory.eINSTANCE.createRequirentGroup());
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

} //RequirentGroupTest
