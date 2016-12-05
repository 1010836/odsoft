/**
 */
package exercise5;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link exercise5.Class#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link exercise5.Class#isInterface <em>Interface</em>}</li>
 *   <li>{@link exercise5.Class#getOperations <em>Operations</em>}</li>
 *   <li>{@link exercise5.Class#getFeatures <em>Features</em>}</li>
 *   <li>{@link exercise5.Class#getSubclasses <em>Subclasses</em>}</li>
 *   <li>{@link exercise5.Class#getSuperclasses <em>Superclasses</em>}</li>
 * </ul>
 *
 * @see exercise5.Exercise5Package#getClass_()
 * @model
 * @generated
 */
public interface Class extends Classifier {
	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see exercise5.Exercise5Package#getClass_Abstract()
	 * @model default="false"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link exercise5.Class#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' attribute.
	 * @see #setInterface(boolean)
	 * @see exercise5.Exercise5Package#getClass_Interface()
	 * @model default="false"
	 * @generated
	 */
	boolean isInterface();

	/**
	 * Sets the value of the '{@link exercise5.Class#isInterface <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' attribute.
	 * @see #isInterface()
	 * @generated
	 */
	void setInterface(boolean value);

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link exercise5.Operation}.
	 * It is bidirectional and its opposite is '{@link exercise5.Operation#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see exercise5.Exercise5Package#getClass_Operations()
	 * @see exercise5.Operation#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Operation> getOperations();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link exercise5.StructuralFeature}.
	 * It is bidirectional and its opposite is '{@link exercise5.StructuralFeature#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see exercise5.Exercise5Package#getClass_Features()
	 * @see exercise5.StructuralFeature#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<StructuralFeature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Subclasses</b></em>' reference list.
	 * The list contents are of type {@link exercise5.Class}.
	 * It is bidirectional and its opposite is '{@link exercise5.Class#getSuperclasses <em>Superclasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subclasses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subclasses</em>' reference list.
	 * @see exercise5.Exercise5Package#getClass_Subclasses()
	 * @see exercise5.Class#getSuperclasses
	 * @model opposite="superclasses"
	 * @generated
	 */
	EList<Class> getSubclasses();

	/**
	 * Returns the value of the '<em><b>Superclasses</b></em>' reference list.
	 * The list contents are of type {@link exercise5.Class}.
	 * It is bidirectional and its opposite is '{@link exercise5.Class#getSubclasses <em>Subclasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Superclasses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Superclasses</em>' reference list.
	 * @see exercise5.Exercise5Package#getClass_Superclasses()
	 * @see exercise5.Class#getSubclasses
	 * @model opposite="subclasses"
	 * @generated
	 */
	EList<Class> getSuperclasses();

} // Class
