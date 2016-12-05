/**
 */
package exercise5.impl;

import exercise5.Exercise5Package;
import exercise5.Operation;
import exercise5.StructuralFeature;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link exercise5.impl.ClassImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link exercise5.impl.ClassImpl#isInterface <em>Interface</em>}</li>
 *   <li>{@link exercise5.impl.ClassImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link exercise5.impl.ClassImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link exercise5.impl.ClassImpl#getSubclasses <em>Subclasses</em>}</li>
 *   <li>{@link exercise5.impl.ClassImpl#getSuperclasses <em>Superclasses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl extends ClassifierImpl implements exercise5.Class {
	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #isInterface() <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterface()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INTERFACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInterface() <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterface()
	 * @generated
	 * @ordered
	 */
	protected boolean interface_ = INTERFACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> operations;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<StructuralFeature> features;

	/**
	 * The cached value of the '{@link #getSubclasses() <em>Subclasses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubclasses()
	 * @generated
	 * @ordered
	 */
	protected EList<exercise5.Class> subclasses;

	/**
	 * The cached value of the '{@link #getSuperclasses() <em>Superclasses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperclasses()
	 * @generated
	 * @ordered
	 */
	protected EList<exercise5.Class> superclasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Exercise5Package.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Exercise5Package.CLASS__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInterface() {
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterface(boolean newInterface) {
		boolean oldInterface = interface_;
		interface_ = newInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Exercise5Package.CLASS__INTERFACE, oldInterface, interface_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentWithInverseEList<Operation>(Operation.class, this, Exercise5Package.CLASS__OPERATIONS, Exercise5Package.OPERATION__OWNER);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StructuralFeature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentWithInverseEList<StructuralFeature>(StructuralFeature.class, this, Exercise5Package.CLASS__FEATURES, Exercise5Package.STRUCTURAL_FEATURE__OWNER);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<exercise5.Class> getSubclasses() {
		if (subclasses == null) {
			subclasses = new EObjectWithInverseResolvingEList.ManyInverse<exercise5.Class>(exercise5.Class.class, this, Exercise5Package.CLASS__SUBCLASSES, Exercise5Package.CLASS__SUPERCLASSES);
		}
		return subclasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<exercise5.Class> getSuperclasses() {
		if (superclasses == null) {
			superclasses = new EObjectWithInverseResolvingEList.ManyInverse<exercise5.Class>(exercise5.Class.class, this, Exercise5Package.CLASS__SUPERCLASSES, Exercise5Package.CLASS__SUBCLASSES);
		}
		return superclasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Exercise5Package.CLASS__OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperations()).basicAdd(otherEnd, msgs);
			case Exercise5Package.CLASS__FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeatures()).basicAdd(otherEnd, msgs);
			case Exercise5Package.CLASS__SUBCLASSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubclasses()).basicAdd(otherEnd, msgs);
			case Exercise5Package.CLASS__SUPERCLASSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSuperclasses()).basicAdd(otherEnd, msgs);
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
			case Exercise5Package.CLASS__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case Exercise5Package.CLASS__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case Exercise5Package.CLASS__SUBCLASSES:
				return ((InternalEList<?>)getSubclasses()).basicRemove(otherEnd, msgs);
			case Exercise5Package.CLASS__SUPERCLASSES:
				return ((InternalEList<?>)getSuperclasses()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Exercise5Package.CLASS__ABSTRACT:
				return isAbstract();
			case Exercise5Package.CLASS__INTERFACE:
				return isInterface();
			case Exercise5Package.CLASS__OPERATIONS:
				return getOperations();
			case Exercise5Package.CLASS__FEATURES:
				return getFeatures();
			case Exercise5Package.CLASS__SUBCLASSES:
				return getSubclasses();
			case Exercise5Package.CLASS__SUPERCLASSES:
				return getSuperclasses();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Exercise5Package.CLASS__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case Exercise5Package.CLASS__INTERFACE:
				setInterface((Boolean)newValue);
				return;
			case Exercise5Package.CLASS__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case Exercise5Package.CLASS__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends StructuralFeature>)newValue);
				return;
			case Exercise5Package.CLASS__SUBCLASSES:
				getSubclasses().clear();
				getSubclasses().addAll((Collection<? extends exercise5.Class>)newValue);
				return;
			case Exercise5Package.CLASS__SUPERCLASSES:
				getSuperclasses().clear();
				getSuperclasses().addAll((Collection<? extends exercise5.Class>)newValue);
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
			case Exercise5Package.CLASS__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case Exercise5Package.CLASS__INTERFACE:
				setInterface(INTERFACE_EDEFAULT);
				return;
			case Exercise5Package.CLASS__OPERATIONS:
				getOperations().clear();
				return;
			case Exercise5Package.CLASS__FEATURES:
				getFeatures().clear();
				return;
			case Exercise5Package.CLASS__SUBCLASSES:
				getSubclasses().clear();
				return;
			case Exercise5Package.CLASS__SUPERCLASSES:
				getSuperclasses().clear();
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
			case Exercise5Package.CLASS__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case Exercise5Package.CLASS__INTERFACE:
				return interface_ != INTERFACE_EDEFAULT;
			case Exercise5Package.CLASS__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case Exercise5Package.CLASS__FEATURES:
				return features != null && !features.isEmpty();
			case Exercise5Package.CLASS__SUBCLASSES:
				return subclasses != null && !subclasses.isEmpty();
			case Exercise5Package.CLASS__SUPERCLASSES:
				return superclasses != null && !superclasses.isEmpty();
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
		result.append(" (abstract: ");
		result.append(abstract_);
		result.append(", interface: ");
		result.append(interface_);
		result.append(')');
		return result.toString();
	}

} //ClassImpl
