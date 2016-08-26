package edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java

import edu.kit.ipd.sdq.vitruvius.casestudies.java.util.JaMoPPNamespace
import edu.kit.ipd.sdq.vitruvius.casestudies.pcm.util.PCMNamespace
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.OperationProvidedRoleMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.OperationRequiredRoleMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.repository.BasicComponentMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.repository.CollectionDataTypeMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.repository.CompositeComponentMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.repository.CompositeDataTypeMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.repository.InnerDeclarationMappingTransforamtion
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.repository.OperationInterfaceMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.repository.OperationSignatureMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.repository.ParameterMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.repository.RepositoryMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.repository.ResourceDemandingInternalBehaviorMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.repository.SEFFMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.system.AssemblyConnectorMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.system.AssemblyContextMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.system.ProvidedDelegationConnectorMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.system.RequiredDelegationConnectorMappingTransformation
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java.pcm2java.system.SystemMappingTransformation
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.TransformationMetamodelPair
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VURI
import edu.kit.ipd.sdq.vitruvius.framework.changes.changeprocessor.AbstractChange2CommandTransforming
import edu.kit.ipd.sdq.vitruvius.framework.run.transformationexecuter.DefaultEObjectMappingTransformation
import edu.kit.ipd.sdq.vitruvius.framework.changes.changeprocessor.ChangeProcessor

class PCM2JavaChange2CommandTransformer extends AbstractChange2CommandTransforming {
	
	new() {
		super(
			new TransformationMetamodelPair(VURI.getInstance(PCMNamespace.PCM_METAMODEL_NAMESPACE),
				VURI.getInstance(JaMoPPNamespace.JAMOPP_METAMODEL_NAMESPACE)))
	}

	private def ChangeProcessor createTransformationExecutorChangeProcessor() {
		val changeProcessor = new TransformationExecutorChangeProcessor(userInteracting);
		// Repository
		changeProcessor.addMapping(new RepositoryMappingTransformation())
		changeProcessor.addMapping(new BasicComponentMappingTransformation())
		changeProcessor.addMapping(new CompositeComponentMappingTransformation())
		changeProcessor.addMapping(new OperationInterfaceMappingTransformation())
		changeProcessor.addMapping(new OperationSignatureMappingTransformation())
		changeProcessor.addMapping(new ParameterMappingTransformation())
		changeProcessor.addMapping(new CollectionDataTypeMappingTransformation())
		changeProcessor.addMapping(new CompositeDataTypeMappingTransformation())
		changeProcessor.addMapping(new InnerDeclarationMappingTransforamtion())
		changeProcessor.addMapping(new SEFFMappingTransformation())
		changeProcessor.addMapping(new ResourceDemandingInternalBehaviorMappingTransformation())
		// System
		changeProcessor.addMapping(new SystemMappingTransformation())
		changeProcessor.addMapping(new AssemblyContextMappingTransformation())
		changeProcessor.addMapping(new AssemblyConnectorMappingTransformation())
		changeProcessor.addMapping(new ProvidedDelegationConnectorMappingTransformation())
		changeProcessor.addMapping(new RequiredDelegationConnectorMappingTransformation())
		// Repository and System
		changeProcessor.addMapping(new OperationProvidedRoleMappingTransformation())
		changeProcessor.addMapping(new OperationRequiredRoleMappingTransformation())
		// Mapping for EObjects in order to avoid runtime exceptions
        changeProcessor.addMapping(new DefaultEObjectMappingTransformation());
        
        return changeProcessor;
	}
	
	override protected setup() {
		addChangeProcessor(createTransformationExecutorChangeProcessor());
	}
	
}
