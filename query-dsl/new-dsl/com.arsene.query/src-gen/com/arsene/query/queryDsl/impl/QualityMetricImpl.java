/**
 * generated by Xtext 2.25.0
 */
package com.arsene.query.queryDsl.impl;

import com.arsene.query.queryDsl.Operator;
import com.arsene.query.queryDsl.QExp;
import com.arsene.query.queryDsl.QualityMetric;
import com.arsene.query.queryDsl.QueryDslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quality Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.arsene.query.queryDsl.impl.QualityMetricImpl#getQExp <em>QExp</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.impl.QualityMetricImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link com.arsene.query.queryDsl.impl.QualityMetricImpl#getQExps <em>QExps</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QualityMetricImpl extends MinimalEObjectImpl.Container implements QualityMetric
{
  /**
   * The cached value of the '{@link #getQExp() <em>QExp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQExp()
   * @generated
   * @ordered
   */
  protected QExp qExp;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected Operator operator;

  /**
   * The cached value of the '{@link #getQExps() <em>QExps</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQExps()
   * @generated
   * @ordered
   */
  protected QExp qExps;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualityMetricImpl()
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
    return QueryDslPackage.Literals.QUALITY_METRIC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public QExp getQExp()
  {
    return qExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQExp(QExp newQExp, NotificationChain msgs)
  {
    QExp oldQExp = qExp;
    qExp = newQExp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryDslPackage.QUALITY_METRIC__QEXP, oldQExp, newQExp);
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
  public void setQExp(QExp newQExp)
  {
    if (newQExp != qExp)
    {
      NotificationChain msgs = null;
      if (qExp != null)
        msgs = ((InternalEObject)qExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryDslPackage.QUALITY_METRIC__QEXP, null, msgs);
      if (newQExp != null)
        msgs = ((InternalEObject)newQExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QueryDslPackage.QUALITY_METRIC__QEXP, null, msgs);
      msgs = basicSetQExp(newQExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryDslPackage.QUALITY_METRIC__QEXP, newQExp, newQExp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Operator getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperator(Operator newOperator, NotificationChain msgs)
  {
    Operator oldOperator = operator;
    operator = newOperator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryDslPackage.QUALITY_METRIC__OPERATOR, oldOperator, newOperator);
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
  public void setOperator(Operator newOperator)
  {
    if (newOperator != operator)
    {
      NotificationChain msgs = null;
      if (operator != null)
        msgs = ((InternalEObject)operator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryDslPackage.QUALITY_METRIC__OPERATOR, null, msgs);
      if (newOperator != null)
        msgs = ((InternalEObject)newOperator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QueryDslPackage.QUALITY_METRIC__OPERATOR, null, msgs);
      msgs = basicSetOperator(newOperator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryDslPackage.QUALITY_METRIC__OPERATOR, newOperator, newOperator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public QExp getQExps()
  {
    return qExps;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQExps(QExp newQExps, NotificationChain msgs)
  {
    QExp oldQExps = qExps;
    qExps = newQExps;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryDslPackage.QUALITY_METRIC__QEXPS, oldQExps, newQExps);
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
  public void setQExps(QExp newQExps)
  {
    if (newQExps != qExps)
    {
      NotificationChain msgs = null;
      if (qExps != null)
        msgs = ((InternalEObject)qExps).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryDslPackage.QUALITY_METRIC__QEXPS, null, msgs);
      if (newQExps != null)
        msgs = ((InternalEObject)newQExps).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QueryDslPackage.QUALITY_METRIC__QEXPS, null, msgs);
      msgs = basicSetQExps(newQExps, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryDslPackage.QUALITY_METRIC__QEXPS, newQExps, newQExps));
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
      case QueryDslPackage.QUALITY_METRIC__QEXP:
        return basicSetQExp(null, msgs);
      case QueryDslPackage.QUALITY_METRIC__OPERATOR:
        return basicSetOperator(null, msgs);
      case QueryDslPackage.QUALITY_METRIC__QEXPS:
        return basicSetQExps(null, msgs);
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
      case QueryDslPackage.QUALITY_METRIC__QEXP:
        return getQExp();
      case QueryDslPackage.QUALITY_METRIC__OPERATOR:
        return getOperator();
      case QueryDslPackage.QUALITY_METRIC__QEXPS:
        return getQExps();
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
      case QueryDslPackage.QUALITY_METRIC__QEXP:
        setQExp((QExp)newValue);
        return;
      case QueryDslPackage.QUALITY_METRIC__OPERATOR:
        setOperator((Operator)newValue);
        return;
      case QueryDslPackage.QUALITY_METRIC__QEXPS:
        setQExps((QExp)newValue);
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
      case QueryDslPackage.QUALITY_METRIC__QEXP:
        setQExp((QExp)null);
        return;
      case QueryDslPackage.QUALITY_METRIC__OPERATOR:
        setOperator((Operator)null);
        return;
      case QueryDslPackage.QUALITY_METRIC__QEXPS:
        setQExps((QExp)null);
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
      case QueryDslPackage.QUALITY_METRIC__QEXP:
        return qExp != null;
      case QueryDslPackage.QUALITY_METRIC__OPERATOR:
        return operator != null;
      case QueryDslPackage.QUALITY_METRIC__QEXPS:
        return qExps != null;
    }
    return super.eIsSet(featureID);
  }

} //QualityMetricImpl
