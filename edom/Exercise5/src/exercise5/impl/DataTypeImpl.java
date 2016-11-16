/**
 */
package exercise5.impl;

import exercise5.DataType;
import exercise5.Exercise5Package;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link exercise5.impl.DataTypeImpl#getDefaultLiteral <em>Default Literal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataTypeImpl extends ClassifierImpl implements DataType {
	/**
	 * The default value of the '{@link #getDefaultLiteral() <em>Default Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultLiteral() <em>Default Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultLiteral()
	 * @generated
	 * @ordered
	 */
	protected String defaultLiteral = DEFAULT_LITERAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Exercise5Package.Literals.DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultLiteral() {
		return defaultLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultLiteral(String newDefaultLiteral) {
		String oldDefaultLiteral = defaultLiteral;
		defaultLiteral = newDefaultLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Exercise5Package.DATA_TYPE__DEFAULT_LITERAL, oldDefaultLiteral, defaultLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Exercise5Package.DATA_TYPE__DEFAULT_LITERAL:
				return getDefaultLiteral();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Exercise5Package.DATA_TYPE__DEFAULT_LITERAL:
				setDefaultLiteral((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Exercise5Package.DATA_TYPE__DEFAULT_LITERAL:
				setDefaultLiteral(DEFAULT_LITERAL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Exercise5Package.DATA_TYPE__DEFAULT_LITERAL:
				return DEFAULT_LITERAL_EDEFAULT == null ? defaultLiteral != null : !DEFAULT_LITERAL_EDEFAULT.equals(defaultLiteral);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (defaultLiteral: ");
		result.append(defaultLiteral);
		result.append(')');
		return result.toString();
	}

} //DataTypeImpl
