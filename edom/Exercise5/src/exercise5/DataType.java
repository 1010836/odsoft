/**
 */
package exercise5;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link exercise5.DataType#getDefaultLiteral <em>Default Literal</em>}</li>
 * </ul>
 *
 * @see exercise5.Exercise5Package#getDataType()
 * @model
 * @generated
 */
public interface DataType extends Classifier {
	/**
	 * Returns the value of the '<em><b>Default Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Literal</em>' attribute.
	 * @see #setDefaultLiteral(String)
	 * @see exercise5.Exercise5Package#getDataType_DefaultLiteral()
	 * @model
	 * @generated
	 */
	String getDefaultLiteral();

	/**
	 * Sets the value of the '{@link exercise5.DataType#getDefaultLiteral <em>Default Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Literal</em>' attribute.
	 * @see #getDefaultLiteral()
	 * @generated
	 */
	void setDefaultLiteral(String value);

} // DataType
