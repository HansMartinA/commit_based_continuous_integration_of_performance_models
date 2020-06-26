package mir.reactions.classifierBody;

import mir.routines.classifierBody.RoutinesFacade;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.types.TypeReference;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionRealization;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.feature.reference.ReplaceSingleValuedEReference;

/**
 * 
 * //Langhammers Level 3 Regel fuer remove Field
 * reaction RemoveFieldEvent {
 * 	after element removed from java::ConcreteClassifier[members]
 * 		with oldValue instanceof java::Field // TODO replace with element filter in trigger
 * 	call removedFieldEvent(oldValue as Field)
 * }
 * 	
 * routine removedFieldEvent(java::Field field) {
 * 	match { 
 * 		val namedElement = retrieve pcm::NamedElement corresponding to field
 * 	}	
 * 	action {
 * 		remove correspondence between field and namedElement
 * 		update field {
 * 			userInteractor.notificationDialogBuilder.message("Removed " + namedElement + " because the corresponding field " + field + " has been removed").
 * 				windowModality(WindowModality.MODAL).startInteraction;
 * 			// TODO This is wrong, isnt't it? Should be "namedElement"!?
 * 			EcoreUtil.^remove(field)
 * 		}
 * 	}
 * }
 * 
 */
@SuppressWarnings("all")
public class JavaReturnTypeChangedReaction extends AbstractReactionRealization {
  private ReplaceSingleValuedEReference<Method, TypeReference> replaceChange;
  
  private int currentlyMatchedChange;
  
  public JavaReturnTypeChangedReaction(final RoutinesFacade routinesFacade) {
    super(routinesFacade);
  }
  
  public void executeReaction(final EChange change) {
    if (!checkPrecondition(change)) {
    	return;
    }
    org.emftext.language.java.members.Method affectedEObject = replaceChange.getAffectedEObject();
    EReference affectedFeature = replaceChange.getAffectedFeature();
    org.emftext.language.java.types.TypeReference oldValue = replaceChange.getOldValue();
    org.emftext.language.java.types.TypeReference newValue = replaceChange.getNewValue();
    				
    getLogger().trace("Passed complete precondition check of Reaction " + this.getClass().getName());
    				
    mir.reactions.classifierBody.JavaReturnTypeChangedReaction.ActionUserExecution userExecution = new mir.reactions.classifierBody.JavaReturnTypeChangedReaction.ActionUserExecution(this.executionState, this);
    userExecution.callRoutine1(replaceChange, affectedEObject, affectedFeature, oldValue, newValue, this.getRoutinesFacade());
    
    resetChanges();
  }
  
  private void resetChanges() {
    replaceChange = null;
    currentlyMatchedChange = 0;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (currentlyMatchedChange == 0) {
    	if (!matchReplaceChange(change)) {
    		resetChanges();
    		return false;
    	} else {
    		currentlyMatchedChange++;
    	}
    }
    
    return true;
  }
  
  private boolean matchReplaceChange(final EChange change) {
    if (change instanceof ReplaceSingleValuedEReference<?, ?>) {
    	ReplaceSingleValuedEReference<org.emftext.language.java.members.Method, org.emftext.language.java.types.TypeReference> _localTypedChange = (ReplaceSingleValuedEReference<org.emftext.language.java.members.Method, org.emftext.language.java.types.TypeReference>) change;
    	if (!(_localTypedChange.getAffectedEObject() instanceof org.emftext.language.java.members.Method)) {
    		return false;
    	}
    	if (!_localTypedChange.getAffectedFeature().getName().equals("typeReference")) {
    		return false;
    	}
    	if (_localTypedChange.isFromNonDefaultValue() && !(_localTypedChange.getOldValue() instanceof org.emftext.language.java.types.TypeReference)) {
    		return false;
    	}
    	if (_localTypedChange.isToNonDefaultValue() && !(_localTypedChange.getNewValue() instanceof org.emftext.language.java.types.TypeReference)) {
    		return false;
    	}
    	this.replaceChange = (ReplaceSingleValuedEReference<org.emftext.language.java.members.Method, org.emftext.language.java.types.TypeReference>) change;
    	return true;
    }
    
    return false;
  }
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public void callRoutine1(final ReplaceSingleValuedEReference replaceChange, final Method affectedEObject, final EReference affectedFeature, final TypeReference oldValue, final TypeReference newValue, @Extension final RoutinesFacade _routinesFacade) {
      _routinesFacade.changeReturnType(affectedEObject, newValue);
    }
  }
}
