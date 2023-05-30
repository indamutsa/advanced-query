/**
 * generated by Xtext 2.25.0
 */
package com.arsene.query.queryDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter Keyword</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.arsene.query.queryDsl.FilterKeyword#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see com.arsene.query.queryDsl.QueryDslPackage#getFilterKeyword()
 * @model
 * @generated
 */
public interface FilterKeyword extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see com.arsene.query.queryDsl.QueryDslPackage#getFilterKeyword_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link com.arsene.query.queryDsl.FilterKeyword#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

} // FilterKeyword