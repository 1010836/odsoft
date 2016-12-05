/**
 */
package exercise5.impl;

import exercise5.Exercise5Package;
import exercise5.StructuralFeature;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structural Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link exercise5.impl.StructuralFeatureImpl#isRequiered <em>Requiered</em>}</li>
 *   <li>{@link exercise5.impl.StructuralFeatureImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructuralFeatureImpl extends TypedElementImpl implements StructuralFeature {
	/**
	 * The default value of the '{@link #isRequiered() <em>Requiered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequiered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRequiered() <em>Requiered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequiered()
	 * @generated
	 * @ordered
	 */
	protected boolean requiered = REQUIERED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructuralFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Exercise5Package.Literals.STRUCTURAL_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequiered() {
		return requiered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiered(boolean newRequiered) {
		boolean oldRequiered = requiered;
		requiered = newRequiered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Exercise5Package.STRUCTURAL_FEATURE__REQUIERED, oldRequiered, requiered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public exercise5.Class getOwner() {
		if (eContainerFeatureID() != Exercise5Package.STRUCTURAL_FEATURE__OWNER) return null;
		return (exercise5.Class)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(exercise5.Class newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, Exercise5Package.STRUCTURAL_FEATURE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(exercise5.Class newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != Exercise5Package.STRUCTURAL_FEATURE__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, Exercise5Package.CLASS__FEATURES, exercise5.Class.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Exercise5Package.STRUCTURAL_FEATURE__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Exercise5Package.STRUCTURAL_FEATURE__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((exercise5.Class)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Exercise5Package.STRUCTURAL_FEATURE__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case Exercise5Package.STRUCTURAL_FEATURE__OWNER:
				return eInternalContainer().eInverseRemove(this, Exercise5Package.CLASS__FEATURES, exercise5.Class.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Exercise5Package.STRUCTURAL_FEATURE__REQUIERED:
				return isRequiered();
			case Exercise5Package.STRUCTURAL_FEATURE__OWNER:
				return getOwner();
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
			case Exercise5Package.STRUCTURAL_FEATURE__REQUIERED:
				setRequiered((Boolean)newValue);
				return;
			case Exercise5Package.STRUCTURAL_FEATURE__OWNER:
				setOwner((exercise5.Class)newValue);
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
			case Exercise5Package.STRUCTURAL_FEATURE__REQUIERED:
				setRequiered(REQUIERED_EDEFAULT);
				return;
			case Exercise5Package.STRUCTURAL_FEATURE__OWNER:
				setOwner((exercise5.Class)null);
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
			case Exercise5Package.STRUCTURAL_FEATURE__REQUIERED:
				return requiered != REQUIERED_EDEFAULT;
			case Exercise5Package.STRUCTURAL_FEATURE__OWNER:
				return getOwner() != null;
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
		result.append(" (requiered: ");
		result.append(requiered);
		result.append(')');
		return result.toString();
	}

} //StructuralFeatureImpl
