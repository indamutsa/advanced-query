/**
 * generated by Xtext 2.25.0
 */
package com.arsene.query.queryDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.arsene.query.queryDsl.Project#getProjectvar <em>Projectvar</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.Project#getProjectvars <em>Projectvars</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.Project#getField <em>Field</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.Project#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @see com.arsene.query.queryDsl.QueryDslPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends AbstractElement
{
  /**
   * Returns the value of the '<em><b>Projectvar</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Projectvar</em>' containment reference.
   * @see #setProjectvar(ProjectVar)
   * @see com.arsene.query.queryDsl.QueryDslPackage#getProject_Projectvar()
   * @model containment="true"
   * @generated
   */
  ProjectVar getProjectvar();

  /**
   * Sets the value of the '{@link com.arsene.query.queryDsl.Project#getProjectvar <em>Projectvar</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Projectvar</em>' containment reference.
   * @see #getProjectvar()
   * @generated
   */
  void setProjectvar(ProjectVar value);

  /**
   * Returns the value of the '<em><b>Projectvars</b></em>' containment reference list.
   * The list contents are of type {@link com.arsene.query.queryDsl.ProjectVar}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Projectvars</em>' containment reference list.
   * @see com.arsene.query.queryDsl.QueryDslPackage#getProject_Projectvars()
   * @model containment="true"
   * @generated
   */
  EList<ProjectVar> getProjectvars();

  /**
   * Returns the value of the '<em><b>Field</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' containment reference.
   * @see #setField(ProjectField)
   * @see com.arsene.query.queryDsl.QueryDslPackage#getProject_Field()
   * @model containment="true"
   * @generated
   */
  ProjectField getField();

  /**
   * Sets the value of the '{@link com.arsene.query.queryDsl.Project#getField <em>Field</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field</em>' containment reference.
   * @see #getField()
   * @generated
   */
  void setField(ProjectField value);

  /**
   * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
   * The list contents are of type {@link com.arsene.query.queryDsl.ProjectField}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fields</em>' containment reference list.
   * @see com.arsene.query.queryDsl.QueryDslPackage#getProject_Fields()
   * @model containment="true"
   * @generated
   */
  EList<ProjectField> getFields();

} // Project
