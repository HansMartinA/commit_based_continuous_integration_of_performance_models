package mir.routines.pcm2java;

import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.responses.pcm2java.Pcm2JavaHelper;
import edu.kit.ipd.sdq.vitruvius.dsls.response.runtime.AbstractEffectRealization;
import edu.kit.ipd.sdq.vitruvius.dsls.response.runtime.ResponseExecutionState;
import edu.kit.ipd.sdq.vitruvius.dsls.response.runtime.structure.CallHierarchyHaving;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.containment.CreateNonRootEObjectInList;
import java.io.IOException;
import mir.routines.pcm2java.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.types.TypeReference;
import org.palladiosimulator.pcm.repository.CompositeDataType;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.InnerDeclaration;

@SuppressWarnings("all")
public class CreatedInnerDeclarationEffect extends AbstractEffectRealization {
  public CreatedInnerDeclarationEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final CreateNonRootEObjectInList<InnerDeclaration> change) {
    super(responseExecutionState, calledBy);
    				this.change = change;
  }
  
  private CreateNonRootEObjectInList<InnerDeclaration> change;
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine CreatedInnerDeclarationEffect with input:");
    getLogger().debug("   CreateNonRootEObjectInList: " + this.change);
    
    org.emftext.language.java.classifiers.Class nonPrimitiveInnerDataTypeClass = getCorrespondingElement(
    	getCorrepondenceSourceNonPrimitiveInnerDataTypeClass(change), // correspondence source supplier
    	org.emftext.language.java.classifiers.Class.class,
    	(org.emftext.language.java.classifiers.Class _element) -> true, // correspondence precondition checker
    	null);
    initializeRetrieveElementState(nonPrimitiveInnerDataTypeClass);
    
    preprocessElementStates();
    new mir.routines.pcm2java.CreatedInnerDeclarationEffect.EffectUserExecution(getExecutionState(), this).executeUserOperations(
    	change, nonPrimitiveInnerDataTypeClass);
    postprocessElementStates();
  }
  
  private EObject getCorrepondenceSourceNonPrimitiveInnerDataTypeClass(final CreateNonRootEObjectInList<InnerDeclaration> change) {
    InnerDeclaration _newValue = change.getNewValue();
    DataType _datatype_InnerDeclaration = _newValue.getDatatype_InnerDeclaration();
    return _datatype_InnerDeclaration;
  }
  
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    @Extension
    private RoutinesFacade effectFacade;
    
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
      this.effectFacade = new mir.routines.pcm2java.RoutinesFacade(responseExecutionState, calledBy);
    }
    
    private void executeUserOperations(final CreateNonRootEObjectInList<InnerDeclaration> change, final org.emftext.language.java.classifiers.Class nonPrimitiveInnerDataTypeClass) {
      InnerDeclaration _newValue = change.getNewValue();
      DataType _datatype_InnerDeclaration = _newValue.getDatatype_InnerDeclaration();
      final TypeReference innerDataTypeReference = Pcm2JavaHelper.createTypeReference(_datatype_InnerDeclaration, nonPrimitiveInnerDataTypeClass);
      EObject _newAffectedEObject = change.getNewAffectedEObject();
      final CompositeDataType compositeDataType = ((CompositeDataType) _newAffectedEObject);
      final InnerDeclaration innerDeclaration = change.getNewValue();
      this.effectFacade.callAddInnerDeclarationToCompositeDataType(compositeDataType, innerDeclaration, innerDataTypeReference);
    }
  }
}
