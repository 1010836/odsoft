/**
 */
package exercise5.tests;

import exercise5.Exercise5Factory;
import exercise5.StructuralFeature;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Structural Feature</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StructuralFeatureTest extends TypedElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StructuralFeatureTest.class);
	}

	/**
	 * Constructs a new Structural Feature test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuralFeatureTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Structural Feature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StructuralFeature getFixture() {
		return (StructuralFeature)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(Exercise5Factory.eINSTANCE.createStructuralFeature());
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

} //StructuralFeatureTest
