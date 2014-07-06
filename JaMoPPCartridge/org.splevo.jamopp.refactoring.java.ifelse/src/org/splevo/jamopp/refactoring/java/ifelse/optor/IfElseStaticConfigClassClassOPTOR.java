package org.splevo.jamopp.refactoring.java.ifelse.optor;

import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;
import org.splevo.jamopp.refactoring.util.RefactoringUtil;
import org.splevo.jamopp.vpm.software.JaMoPPSoftwareElement;
import org.splevo.refactoring.VariabilityRefactoring;
import org.splevo.vpm.realization.RealizationFactory;
import org.splevo.vpm.realization.VariabilityMechanism;
import org.splevo.vpm.software.SoftwareElement;
import org.splevo.vpm.variability.BindingTime;
import org.splevo.vpm.variability.Extensible;
import org.splevo.vpm.variability.VariabilityType;
import org.splevo.vpm.variability.Variant;
import org.splevo.vpm.variability.VariationPoint;

/**
 * The code base container must contain all classes from the variants. Therefore,
 * this refactoring merges the classes from all variants into the base, if there are no
 * interferences.
 */
public class IfElseStaticConfigClassClassOPTOR implements VariabilityRefactoring {

    private static final String REFACTORING_NAME = "IF-Else with Static Configuration Class (OPTOR): Class";
    private static final String REFACTORING_ID = 
            "org.splevo.jamopp.refactoring.java.ifelse.xor.IfElseStaticConfigClassClassOPTOR";

    @Override
    public VariabilityMechanism getVariabilityMechanism() {
        VariabilityMechanism variabilityMechanism = RealizationFactory.eINSTANCE.createVariabilityMechanism();
        variabilityMechanism.setName(REFACTORING_NAME);
        variabilityMechanism.setRefactoringID(REFACTORING_ID);
        return variabilityMechanism;
    }

    @Override
    public void refactor(VariationPoint vp) {
        MemberContainer vpLocation = (MemberContainer) ((JaMoPPSoftwareElement) vp.getLocation()).getJamoppElement();

        for (Variant variant : vp.getVariants()) {
            if (variant.getLeading()) {
                continue;
            }
            for (SoftwareElement se : variant.getImplementingElements()) {
                Member member = (Member) ((JaMoPPSoftwareElement) se).getJamoppElement();
                vpLocation.getMembers().add(member);
            }
        }
    }

    @Override
    public boolean canBeAppliedTo(VariationPoint variationPoint) {
        boolean correctBindingTime = variationPoint.getBindingTime() == BindingTime.COMPILE_TIME;
        boolean correctVariabilityType = variationPoint.getVariabilityType() == VariabilityType.OPTOR;
        boolean correctExtensibility = variationPoint.getExtensibility() == Extensible.NO;
        boolean correctCharacteristics = correctBindingTime && correctVariabilityType && correctExtensibility;

        if (!correctCharacteristics) {
            return false;
        }

        boolean hasEnoughVariants = variationPoint.getVariants().size() > 0;
        Commentable jamoppElement = ((JaMoPPSoftwareElement) variationPoint.getLocation()).getJamoppElement();
        boolean correctLocation = jamoppElement instanceof MemberContainer;
        boolean allImplementingElementsAreClasses = RefactoringUtil.allImplementingElementsOfType(variationPoint,
                Class.class);
        boolean correctInput = hasEnoughVariants && correctLocation && allImplementingElementsAreClasses;

        if (!correctInput) {
            return false;
        }

        return !RefactoringUtil.hasConflictingClasses(variationPoint);
    }

    @Override
    public String getId() {
        return REFACTORING_ID;
    }

}
