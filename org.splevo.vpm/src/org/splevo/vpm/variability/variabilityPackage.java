/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.splevo.vpm.variability;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.splevo.vpm.variability.variabilityFactory
 * @model kind="package"
 * @generated
 */
public interface variabilityPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "variability";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://splevo.org/vpm/1.0/variability";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "variability";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	variabilityPackage eINSTANCE = org.splevo.vpm.variability.impl.variabilityPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.splevo.vpm.variability.impl.VariationPointImpl <em>Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.splevo.vpm.variability.impl.VariationPointImpl
	 * @see org.splevo.vpm.variability.impl.variabilityPackageImpl#getVariationPoint()
	 * @generated
	 */
	int VARIATION_POINT = 0;

	/**
	 * The feature id for the '<em><b>Variants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__VARIANTS = 0;

	/**
	 * The feature id for the '<em><b>Realization Technique</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__REALIZATION_TECHNIQUE = 1;

	/**
	 * The feature id for the '<em><b>Software Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__SOFTWARE_ENTITIES = 2;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__FEATURE = 3;

	/**
	 * The number of structural features of the '<em>Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.splevo.vpm.variability.impl.VariantImpl <em>Variant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.splevo.vpm.variability.impl.VariantImpl
	 * @see org.splevo.vpm.variability.impl.variabilityPackageImpl#getVariant()
	 * @generated
	 */
	int VARIANT = 1;

	/**
	 * The feature id for the '<em><b>Software Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__SOFTWARE_ENTITIES = 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__FEATURE = 1;

	/**
	 * The number of structural features of the '<em>Variant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.splevo.vpm.variability.VariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variation Point</em>'.
	 * @see org.splevo.vpm.variability.VariationPoint
	 * @generated
	 */
	EClass getVariationPoint();

	/**
	 * Returns the meta object for the containment reference list '{@link org.splevo.vpm.variability.VariationPoint#getVariants <em>Variants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variants</em>'.
	 * @see org.splevo.vpm.variability.VariationPoint#getVariants()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_Variants();

	/**
	 * Returns the meta object for the reference '{@link org.splevo.vpm.variability.VariationPoint#getRealizationTechnique <em>Realization Technique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Realization Technique</em>'.
	 * @see org.splevo.vpm.variability.VariationPoint#getRealizationTechnique()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_RealizationTechnique();

	/**
	 * Returns the meta object for the reference list '{@link org.splevo.vpm.variability.VariationPoint#getSoftwareEntities <em>Software Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Software Entities</em>'.
	 * @see org.splevo.vpm.variability.VariationPoint#getSoftwareEntities()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_SoftwareEntities();

	/**
	 * Returns the meta object for the reference '{@link org.splevo.vpm.variability.VariationPoint#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.splevo.vpm.variability.VariationPoint#getFeature()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_Feature();

	/**
	 * Returns the meta object for class '{@link org.splevo.vpm.variability.Variant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variant</em>'.
	 * @see org.splevo.vpm.variability.Variant
	 * @generated
	 */
	EClass getVariant();

	/**
	 * Returns the meta object for the reference list '{@link org.splevo.vpm.variability.Variant#getSoftwareEntities <em>Software Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Software Entities</em>'.
	 * @see org.splevo.vpm.variability.Variant#getSoftwareEntities()
	 * @see #getVariant()
	 * @generated
	 */
	EReference getVariant_SoftwareEntities();

	/**
	 * Returns the meta object for the reference '{@link org.splevo.vpm.variability.Variant#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.splevo.vpm.variability.Variant#getFeature()
	 * @see #getVariant()
	 * @generated
	 */
	EReference getVariant_Feature();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	variabilityFactory getvariabilityFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.splevo.vpm.variability.impl.VariationPointImpl <em>Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.splevo.vpm.variability.impl.VariationPointImpl
		 * @see org.splevo.vpm.variability.impl.variabilityPackageImpl#getVariationPoint()
		 * @generated
		 */
		EClass VARIATION_POINT = eINSTANCE.getVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Variants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION_POINT__VARIANTS = eINSTANCE.getVariationPoint_Variants();

		/**
		 * The meta object literal for the '<em><b>Realization Technique</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION_POINT__REALIZATION_TECHNIQUE = eINSTANCE.getVariationPoint_RealizationTechnique();

		/**
		 * The meta object literal for the '<em><b>Software Entities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION_POINT__SOFTWARE_ENTITIES = eINSTANCE.getVariationPoint_SoftwareEntities();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION_POINT__FEATURE = eINSTANCE.getVariationPoint_Feature();

		/**
		 * The meta object literal for the '{@link org.splevo.vpm.variability.impl.VariantImpl <em>Variant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.splevo.vpm.variability.impl.VariantImpl
		 * @see org.splevo.vpm.variability.impl.variabilityPackageImpl#getVariant()
		 * @generated
		 */
		EClass VARIANT = eINSTANCE.getVariant();

		/**
		 * The meta object literal for the '<em><b>Software Entities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT__SOFTWARE_ENTITIES = eINSTANCE.getVariant_SoftwareEntities();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT__FEATURE = eINSTANCE.getVariant_Feature();

	}

} //variabilityPackage
