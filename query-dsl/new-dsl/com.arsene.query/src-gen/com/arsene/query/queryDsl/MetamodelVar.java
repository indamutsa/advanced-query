/**
 * generated by Xtext 2.25.0
 */
package com.arsene.query.queryDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metamodel Var</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.arsene.query.queryDsl.MetamodelVar#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @see com.arsene.query.queryDsl.QueryDslPackage#getMetamodelVar()
 * @model
 * @generated
 */
public interface MetamodelVar extends EObject
{
  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference.
   * @see #setExp(Expression)
   * @see com.arsene.query.queryDsl.QueryDslPackage#getMetamodelVar_Exp()
   * @model containment="true"
   * @generated
   */
  Expression getExp();

  /**
   * Sets the value of the '{@link com.arsene.query.queryDsl.MetamodelVar#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(Expression value);

} // MetamodelVar
