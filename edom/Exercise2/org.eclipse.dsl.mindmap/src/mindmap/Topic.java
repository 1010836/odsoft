/**
 */
package mindmap;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Topic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mindmap.Topic#getDescription <em>Description</em>}</li>
 *   <li>{@link mindmap.Topic#getPriority <em>Priority</em>}</li>
 *   <li>{@link mindmap.Topic#getSubtopics <em>Subtopics</em>}</li>
 *   <li>{@link mindmap.Topic#getParent <em>Parent</em>}</li>
 * </ul>
 *
 * @see mindmap.MindmapPackage#getTopic()
 * @model
 * @generated
 */
public interface Topic extends MapElement {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see mindmap.MindmapPackage#getTopic_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link mindmap.Topic#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"LOW"</code>.
	 * The literals are from the enumeration {@link mindmap.Priority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see mindmap.Priority
	 * @see #setPriority(Priority)
	 * @see mindmap.MindmapPackage#getTopic_Priority()
	 * @model default="LOW"
	 * @generated
	 */
	Priority getPriority();

	/**
	 * Sets the value of the '{@link mindmap.Topic#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see mindmap.Priority
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(Priority value);

	/**
	 * Returns the value of the '<em><b>Subtopics</b></em>' reference list.
	 * The list contents are of type {@link mindmap.Topic}.
	 * It is bidirectional and its opposite is '{@link mindmap.Topic#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subtopics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtopics</em>' reference list.
	 * @see mindmap.MindmapPackage#getTopic_Subtopics()
	 * @see mindmap.Topic#getParent
	 * @model opposite="parent"
	 * @generated
	 */
	EList<Topic> getSubtopics();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link mindmap.Topic#getSubtopics <em>Subtopics</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Topic)
	 * @see mindmap.MindmapPackage#getTopic_Parent()
	 * @see mindmap.Topic#getSubtopics
	 * @model opposite="subtopics"
	 * @generated
	 */
	Topic getParent();

	/**
	 * Sets the value of the '{@link mindmap.Topic#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Topic value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<Topic> allSubTopics();

} // Topic
