/**
 */
package exercise5;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link exercise5.StructuralFeature#isRequiered <em>Requiered</em>}</li>
 *   <li>{@link exercise5.StructuralFeature#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see exercise5.Exercise5Package#getStructuralFeature()
 * @model
 * @generated
 */
public interface StructuralFeature extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Requiered</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiered</em>' attribute.
	 * @see #setRequiered(boolean)
	 * @see exercise5.Exercise5Package#getStructuralFeature_Requiered()
	 * @model default="false"
	 * @generated
	 */
	boolean isRequiered();

	/**
	 * Sets the value of the '{@link exercise5.StructuralFeature#isRequiered <em>Requiered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiered</em>' attribute.
	 * @see #isRequiered()
	 * @generated
	 */
	void setRequiered(boolean value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link exercise5.Class#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(exercise5.Class)
	 * @see exercise5.Exercise5Package#getStructuralFeature_Owner()
	 * @see exercise5.Class#getFeatures
	 * @model opposite="features" required="true" transient="false"
	 * @generated
	 */
	exercise5.Class getOwner();

	/**
	 * Sets the value of the '{@link exercise5.StructuralFeature#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(exercise5.Class value);

} // StructuralFeature
