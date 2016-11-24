/**
 */
package mindmap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mindmap.Relationship#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see mindmap.MindmapPackage#getRelationship()
 * @model
 * @generated
 */
public interface Relationship extends MapElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"DEPENDENCY"</code>.
	 * The literals are from the enumeration {@link mindmap.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see mindmap.Type
	 * @see #setType(Type)
	 * @see mindmap.MindmapPackage#getRelationship_Type()
	 * @model default="DEPENDENCY"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link mindmap.Relationship#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see mindmap.Type
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

} // Relationship
