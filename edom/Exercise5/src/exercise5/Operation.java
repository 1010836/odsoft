/**
 */
package exercise5;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link exercise5.Operation#getParameters <em>Parameters</em>}</li>
 *   <li>{@link exercise5.Operation#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see exercise5.Exercise5Package#getOperation()
 * @model
 * @generated
 */
public interface Operation extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link exercise5.Parameter}.
	 * It is bidirectional and its opposite is '{@link exercise5.Parameter#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see exercise5.Exercise5Package#getOperation_Parameters()
	 * @see exercise5.Parameter#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link exercise5.Class#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(exercise5.Class)
	 * @see exercise5.Exercise5Package#getOperation_Owner()
	 * @see exercise5.Class#getOperations
	 * @model opposite="operations" required="true" transient="false"
	 * @generated
	 */
	exercise5.Class getOwner();

	/**
	 * Sets the value of the '{@link exercise5.Operation#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(exercise5.Class value);

} // Operation
