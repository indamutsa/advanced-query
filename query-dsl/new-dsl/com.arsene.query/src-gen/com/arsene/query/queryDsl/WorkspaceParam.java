/**
 * generated by Xtext 2.25.0
 */
package com.arsene.query.queryDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workspace Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.arsene.query.queryDsl.WorkspaceParam#getExp <em>Exp</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.WorkspaceParam#getTypeName <em>Type Name</em>}</li>
 * </ul>
 *
 * @see com.arsene.query.queryDsl.QueryDslPackage#getWorkspaceParam()
 * @model
 * @generated
 */
public interface WorkspaceParam extends WorkspaceVar
{
  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference.
   * @see #setExp(Expression)
   * @see com.arsene.query.queryDsl.QueryDslPackage#getWorkspaceParam_Exp()
   * @model containment="true"
   * @generated
   */
  Expression getExp();

  /**
   * Sets the value of the '{@link com.arsene.query.queryDsl.WorkspaceParam#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(Expression value);

  /**
   * Returns the value of the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Name</em>' attribute.
   * @see #setTypeName(String)
   * @see com.arsene.query.queryDsl.QueryDslPackage#getWorkspaceParam_TypeName()
   * @model
   * @generated
   */
  String getTypeName();

  /**
   * Sets the value of the '{@link com.arsene.query.queryDsl.WorkspaceParam#getTypeName <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' attribute.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(String value);

} // WorkspaceParam