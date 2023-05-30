/**
 * generated by Xtext 2.25.0
 */
package com.arsene.query.queryDsl.impl;

import com.arsene.query.queryDsl.Expression;
import com.arsene.query.queryDsl.FullTextSearch;
import com.arsene.query.queryDsl.Operator;
import com.arsene.query.queryDsl.QueryDslPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Full Text Search</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.arsene.query.queryDsl.impl.FullTextSearchImpl#getExp <em>Exp</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.impl.FullTextSearchImpl#getExps <em>Exps</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.impl.FullTextSearchImpl#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FullTextSearchImpl extends MinimalEObjectImpl.Container implements FullTextSearch
{
  /**
   * The cached value of the '{@link #getExp() <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExp()
   * @generated
   * @ordered
   */
  protected Expression exp;

  /**
   * The cached value of the '{@link #getExps() <em>Exps</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExps()
   * @generated
   * @ordered
   */
  protected EList<Expression> exps;

  /**
   * The cached value of the '{@link #getOp() <em>Op</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected Operator op;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FullTextSearchImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return QueryDslPackage.Literals.FULL_TEXT_SEARCH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getExp()
  {
    return exp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExp(Expression newExp, NotificationChain msgs)
  {
    Expression oldExp = exp;
    exp = newExp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryDslPackage.FULL_TEXT_SEARCH__EXP, oldExp, newExp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExp(Expression newExp)
  {
    if (newExp != exp)
    {
      NotificationChain msgs = null;
      if (exp != null)
        msgs = ((InternalEObject)exp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryDslPackage.FULL_TEXT_SEARCH__EXP, null, msgs);
      if (newExp != null)
        msgs = ((InternalEObject)newExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QueryDslPackage.FULL_TEXT_SEARCH__EXP, null, msgs);
      msgs = basicSetExp(newExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryDslPackage.FULL_TEXT_SEARCH__EXP, newExp, newExp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Expression> getExps()
  {
    if (exps == null)
    {
      exps = new EObjectContainmentEList<Expression>(Expression.class, this, QueryDslPackage.FULL_TEXT_SEARCH__EXPS);
    }
    return exps;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Operator getOp()
  {
    return op;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOp(Operator newOp, NotificationChain msgs)
  {
    Operator oldOp = op;
    op = newOp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryDslPackage.FULL_TEXT_SEARCH__OP, oldOp, newOp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOp(Operator newOp)
  {
    if (newOp != op)
    {
      NotificationChain msgs = null;
      if (op != null)
        msgs = ((InternalEObject)op).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryDslPackage.FULL_TEXT_SEARCH__OP, null, msgs);
      if (newOp != null)
        msgs = ((InternalEObject)newOp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QueryDslPackage.FULL_TEXT_SEARCH__OP, null, msgs);
      msgs = basicSetOp(newOp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryDslPackage.FULL_TEXT_SEARCH__OP, newOp, newOp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case QueryDslPackage.FULL_TEXT_SEARCH__EXP:
        return basicSetExp(null, msgs);
      case QueryDslPackage.FULL_TEXT_SEARCH__EXPS:
        return ((InternalEList<?>)getExps()).basicRemove(otherEnd, msgs);
      case QueryDslPackage.FULL_TEXT_SEARCH__OP:
        return basicSetOp(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case QueryDslPackage.FULL_TEXT_SEARCH__EXP:
        return getExp();
      case QueryDslPackage.FULL_TEXT_SEARCH__EXPS:
        return getExps();
      case QueryDslPackage.FULL_TEXT_SEARCH__OP:
        return getOp();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case QueryDslPackage.FULL_TEXT_SEARCH__EXP:
        setExp((Expression)newValue);
        return;
      case QueryDslPackage.FULL_TEXT_SEARCH__EXPS:
        getExps().clear();
        getExps().addAll((Collection<? extends Expression>)newValue);
        return;
      case QueryDslPackage.FULL_TEXT_SEARCH__OP:
        setOp((Operator)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case QueryDslPackage.FULL_TEXT_SEARCH__EXP:
        setExp((Expression)null);
        return;
      case QueryDslPackage.FULL_TEXT_SEARCH__EXPS:
        getExps().clear();
        return;
      case QueryDslPackage.FULL_TEXT_SEARCH__OP:
        setOp((Operator)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case QueryDslPackage.FULL_TEXT_SEARCH__EXP:
        return exp != null;
      case QueryDslPackage.FULL_TEXT_SEARCH__EXPS:
        return exps != null && !exps.isEmpty();
      case QueryDslPackage.FULL_TEXT_SEARCH__OP:
        return op != null;
    }
    return super.eIsSet(featureID);
  }

} //FullTextSearchImpl