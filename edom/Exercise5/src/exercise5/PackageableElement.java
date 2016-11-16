/**
 */
package exercise5;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Packageable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link exercise5.PackageableElement#getPackage <em>Package</em>}</li>
 * </ul>
 *
 * @see exercise5.Exercise5Package#getPackageableElement()
 * @model
 * @generated
 */
public interface PackageableElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link exercise5.Package#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' container reference.
	 * @see #setPackage(exercise5.Package)
	 * @see exercise5.Exercise5Package#getPackageableElement_Package()
	 * @see exercise5.Package#getContents
	 * @model opposite="contents" transient="false"
	 * @generated
	 */
	exercise5.Package getPackage();

	/**
	 * Sets the value of the '{@link exercise5.PackageableElement#getPackage <em>Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' container reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(exercise5.Package value);

} // PackageableElement
