/**
 */
package org.splevo.diffing.emfcompare.java2kdmdiff.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.gmt.modisco.java.AbstractMethodDeclaration;
import org.splevo.diffing.emfcompare.java2kdmdiff.Java2KDMDiffPackage;
import org.splevo.diffing.emfcompare.java2kdmdiff.MethodInsert;

/**
 * This is the item provider adapter for a {@link org.splevo.diffing.emfcompare.java2kdmdiff.MethodInsert} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MethodInsertItemProvider
    extends MethodChangeItemProvider
    implements
        IEditingDomainItemProvider,
        IStructuredItemContentProvider,
        ITreeItemContentProvider,
        IItemLabelProvider,
        IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MethodInsertItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addMethodLeftPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Method Left feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMethodLeftPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_MethodInsert_methodLeft_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_MethodInsert_methodLeft_feature", "_UI_MethodInsert_type"),
                 Java2KDMDiffPackage.Literals.METHOD_INSERT__METHOD_LEFT,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This returns MethodInsert.gif.
     * <!-- begin-user-doc -->
     * Customized image provider to provide different icons depending on the 
     * visibility of the inserted method.
     * <!-- end-user-doc -->
     * @generated not
     */
    @Override
    public Object getImage(Object object) {
        MethodInsert methodInsert = (MethodInsert)object;
        AbstractMethodDeclaration method = methodInsert.getMethodLeft();
        if(method != null && method.getModifier() != null){
            switch (method.getModifier().getVisibility()) {
            case PUBLIC:
                return overlayImage(object, getResourceLocator().getImage("full/obj16/MethodInsert_public"));
            case PRIVATE:
                return overlayImage(object, getResourceLocator().getImage("full/obj16/MethodInsert_private"));
            case PROTECTED:
                return overlayImage(object, getResourceLocator().getImage("full/obj16/MethodInsert_protected"));
            case NONE:
            default:
                return overlayImage(object, getResourceLocator().getImage("full/obj16/MethodInsert_package"));
            }
        }
        return overlayImage(object, getResourceLocator().getImage("full/obj16/MethodInsert_package"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * Customized label to provide the name of the inerted method.
     * <!-- end-user-doc -->
     * @generated not
     */
    @Override
    public String getText(Object object) {
        MethodInsert methodInsert = (MethodInsert)object;
        
        String methodName = null;
        if(methodInsert.getMethodLeft() != null){
            methodName = methodInsert.getMethodLeft().getName();
        }
        
        return getString("_UI_MethodInsert_type") + " " + methodName;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

}
