/**
 * generated by Xtext 2.25.0
 */
package com.arsene.query.queryDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metamodel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.arsene.query.queryDsl.Metamodel#getMetamodelVar <em>Metamodel Var</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.Metamodel#getMetamodelVars <em>Metamodel Vars</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.Metamodel#getSyntax <em>Syntax</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.Metamodel#getTextSearch <em>Text Search</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.Metamodel#getFilter <em>Filter</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.Metamodel#getQm <em>Qm</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.Metamodel#getTransfo <em>Transfo</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.Metamodel#getField <em>Field</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.Metamodel#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @see com.arsene.query.queryDsl.QueryDslPackage#getMetamodel()
 * @model
 * @generated
 */
public interface Metamodel extends AbstractElement
{
  /**
   * Returns the value of the '<em><b>Metamodel Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel Var</em>' containment reference.
   * @see #setMetamodelVar(MetamodelVar)
   * @see com.arsene.query.queryDsl.QueryDslPackage#getMetamodel_MetamodelVar()
   * @model containment="true"
   * @generated
   */
  MetamodelVar getMetamodelVar();

  /**
   * Sets the value of the '{@link com.arsene.query.queryDsl.Metamodel#getMetamodelVar <em>Metamodel Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metamodel Var</em>' containment reference.
   * @see #getMetamodelVar()
   * @generated
   */
  void setMetamodelVar(MetamodelVar value);

  /**
   * Returns the value of the '<em><b>Metamodel Vars</b></em>' containment reference list.
   * The list contents are of type {@link com.arsene.query.queryDsl.MetamodelVar}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel Vars</em>' containment reference list.
   * @see com.arsene.query.queryDsl.QueryDslPackage#getMetamodel_MetamodelVars()
   * @model containment="true"
   * @generated
   */
  EList<MetamodelVar> getMetamodelVars();

  /**
   * Returns the value of the '<em><b>Syntax</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Syntax</em>' containment reference.
   * @see #setSyntax(MicroSyntax)
   * @see com.arsene.query.queryDsl.QueryDslPackage#getMetamodel_Syntax()
   * @model containment="true"
   * @generated
   */
  MicroSyntax getSyntax();

  /**
   * Sets the value of the '{@link com.arsene.query.queryDsl.Metamodel#getSyntax <em>Syntax</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Syntax</em>' containment reference.
   * @see #getSyntax()
   * @generated
   */
  void setSyntax(MicroSyntax value);

  /**
   * Returns the value of the '<em><b>Text Search</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text Search</em>' containment reference.
   * @see #setTextSearch(FullTextSearch)
   * @see com.arsene.query.queryDsl.QueryDslPackage#getMetamodel_TextSearch()
   * @model containment="true"
   * @generated
   */
  FullTextSearch getTextSearch();

  /**
   * Sets the value of the '{@link com.arsene.query.queryDsl.Metamodel#getTextSearch <em>Text Search</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text Search</em>' containment reference.
   * @see #getTextSearch()
   * @generated
   */
  void setTextSearch(FullTextSearch value);

  /**
   * Returns the value of the '<em><b>Filter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Filter</em>' containment reference.
   * @see #setFilter(Filter)
   * @see com.arsene.query.queryDsl.QueryDslPackage#getMetamodel_Filter()
   * @model containment="true"
   * @generated
   */
  Filter getFilter();

  /**
   * Sets the value of the '{@link com.arsene.query.queryDsl.Metamodel#getFilter <em>Filter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Filter</em>' containment reference.
   * @see #getFilter()
   * @generated
   */
  void setFilter(Filter value);

  /**
   * Returns the value of the '<em><b>Qm</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qm</em>' containment reference.
   * @see #setQm(QualityMetric)
   * @see com.arsene.query.queryDsl.QueryDslPackage#getMetamodel_Qm()
   * @model containment="true"
   * @generated
   */
  QualityMetric getQm();

  /**
   * Sets the value of the '{@link com.arsene.query.queryDsl.Metamodel#getQm <em>Qm</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qm</em>' containment reference.
   * @see #getQm()
   * @generated
   */
  void setQm(QualityMetric value);

  /**
   * Returns the value of the '<em><b>Transfo</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transfo</em>' containment reference.
   * @see #setTransfo(Transformable)
   * @see com.arsene.query.queryDsl.QueryDslPackage#getMetamodel_Transfo()
   * @model containment="true"
   * @generated
   */
  Transformable getTransfo();

  /**
   * Sets the value of the '{@link com.arsene.query.queryDsl.Metamodel#getTransfo <em>Transfo</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transfo</em>' containment reference.
   * @see #getTransfo()
   * @generated
   */
  void setTransfo(Transformable value);

  /**
   * Returns the value of the '<em><b>Field</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' containment reference.
   * @see #setField(MetamodelField)
   * @see com.arsene.query.queryDsl.QueryDslPackage#getMetamodel_Field()
   * @model containment="true"
   * @generated
   */
  MetamodelField getField();

  /**
   * Sets the value of the '{@link com.arsene.query.queryDsl.Metamodel#getField <em>Field</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field</em>' containment reference.
   * @see #getField()
   * @generated
   */
  void setField(MetamodelField value);

  /**
   * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
   * The list contents are of type {@link com.arsene.query.queryDsl.MetamodelField}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fields</em>' containment reference list.
   * @see com.arsene.query.queryDsl.QueryDslPackage#getMetamodel_Fields()
   * @model containment="true"
   * @generated
   */
  EList<MetamodelField> getFields();

} // Metamodel
