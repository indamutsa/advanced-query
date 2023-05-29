/**
 * generated by Xtext 2.25.0
 */
package com.arsene.query.queryDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.arsene.query.queryDsl.Operator#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @see com.arsene.query.queryDsl.QueryDslPackage#getOperator()
 * @model
 * @generated
 */
public interface Operator extends EObject
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see com.arsene.query.queryDsl.QueryDslPackage#getOperator_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link com.arsene.query.queryDsl.Operator#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

} // Operator
