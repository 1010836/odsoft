/**
 */
package exercise5;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link exercise5.Package#getContents <em>Contents</em>}</li>
 * </ul>
 *
 * @see exercise5.Exercise5Package#getPackage()
 * @model
 * @generated
 */
public interface Package extends PackageableElement {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link exercise5.PackageableElement}.
	 * It is bidirectional and its opposite is '{@link exercise5.PackageableElement#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see exercise5.Exercise5Package#getPackage_Contents()
	 * @see exercise5.PackageableElement#getPackage
	 * @model opposite="package" containment="true"
	 * @generated
	 */
	EList<PackageableElement> getContents();

} // Package
