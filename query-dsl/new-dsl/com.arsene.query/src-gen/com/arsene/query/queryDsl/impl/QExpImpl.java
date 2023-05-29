/**
 * generated by Xtext 2.25.0
 */
package com.arsene.query.queryDsl.impl;

import com.arsene.query.queryDsl.Comparison;
import com.arsene.query.queryDsl.QExp;
import com.arsene.query.queryDsl.Qattribute;
import com.arsene.query.queryDsl.QueryDslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>QExp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.arsene.query.queryDsl.impl.QExpImpl#getQAttr <em>QAttr</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.impl.QExpImpl#getComp <em>Comp</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.impl.QExpImpl#getN <em>N</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QExpImpl extends MinimalEObjectImpl.Container implements QExp
{
  /**
   * The cached value of the '{@link #getQAttr() <em>QAttr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQAttr()
   * @generated
   * @ordered
   */
  protected Qattribute qAttr;

  /**
   * The cached value of the '{@link #getComp() <em>Comp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComp()
   * @generated
   * @ordered
   */
  protected Comparison comp;

  /**
   * The default value of the '{@link #getN() <em>N</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getN()
   * @generated
   * @ordered
   */
  protected static final int N_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getN() <em>N</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getN()
   * @generated
   * @ordered
   */
  protected int n = N_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QExpImpl()
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
    return QueryDslPackage.Literals.QEXP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Qattribute getQAttr()
  {
    return qAttr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQAttr(Qattribute newQAttr, NotificationChain msgs)
  {
    Qattribute oldQAttr = qAttr;
    qAttr = newQAttr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryDslPackage.QEXP__QATTR, oldQAttr, newQAttr);
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
  public void setQAttr(Qattribute newQAttr)
  {
    if (newQAttr != qAttr)
    {
      NotificationChain msgs = null;
      if (qAttr != null)
        msgs = ((InternalEObject)qAttr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryDslPackage.QEXP__QATTR, null, msgs);
      if (newQAttr != null)
        msgs = ((InternalEObject)newQAttr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QueryDslPackage.QEXP__QATTR, null, msgs);
      msgs = basicSetQAttr(newQAttr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryDslPackage.QEXP__QATTR, newQAttr, newQAttr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Comparison getComp()
  {
    return comp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetComp(Comparison newComp, NotificationChain msgs)
  {
    Comparison oldComp = comp;
    comp = newComp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryDslPackage.QEXP__COMP, oldComp, newComp);
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
  public void setComp(Comparison newComp)
  {
    if (newComp != comp)
    {
      NotificationChain msgs = null;
      if (comp != null)
        msgs = ((InternalEObject)comp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryDslPackage.QEXP__COMP, null, msgs);
      if (newComp != null)
        msgs = ((InternalEObject)newComp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QueryDslPackage.QEXP__COMP, null, msgs);
      msgs = basicSetComp(newComp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryDslPackage.QEXP__COMP, newComp, newComp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getN()
  {
    return n;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setN(int newN)
  {
    int oldN = n;
    n = newN;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryDslPackage.QEXP__N, oldN, n));
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
      case QueryDslPackage.QEXP__QATTR:
        return basicSetQAttr(null, msgs);
      case QueryDslPackage.QEXP__COMP:
        return basicSetComp(null, msgs);
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
      case QueryDslPackage.QEXP__QATTR:
        return getQAttr();
      case QueryDslPackage.QEXP__COMP:
        return getComp();
      case QueryDslPackage.QEXP__N:
        return getN();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case QueryDslPackage.QEXP__QATTR:
        setQAttr((Qattribute)newValue);
        return;
      case QueryDslPackage.QEXP__COMP:
        setComp((Comparison)newValue);
        return;
      case QueryDslPackage.QEXP__N:
        setN((Integer)newValue);
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
      case QueryDslPackage.QEXP__QATTR:
        setQAttr((Qattribute)null);
        return;
      case QueryDslPackage.QEXP__COMP:
        setComp((Comparison)null);
        return;
      case QueryDslPackage.QEXP__N:
        setN(N_EDEFAULT);
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
      case QueryDslPackage.QEXP__QATTR:
        return qAttr != null;
      case QueryDslPackage.QEXP__COMP:
        return comp != null;
      case QueryDslPackage.QEXP__N:
        return n != N_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (n: ");
    result.append(n);
    result.append(')');
    return result.toString();
  }

} //QExpImpl
