package org.splevo.diffing.emfcompare.diff;

import org.eclipse.emf.compare.diff.engine.IMatchManager;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.compare.match.metamodel.UnmatchElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmt.modisco.java.CompilationUnit;
import org.eclipse.gmt.modisco.java.ImportDeclaration;
import org.eclipse.gmt.modisco.java.emf.util.JavaSwitch;
import org.splevo.diffing.emfcompare.java2kdmdiff.ImportDelete;
import org.splevo.diffing.emfcompare.java2kdmdiff.ImportInsert;
import org.splevo.diffing.emfcompare.java2kdmdiff.Java2KDMDiffFactory;

/**
 * A processor to handle unmatched elements according to their type of element.
 * 
 * The processor uses an internal switch based on the generated emf switch for the modisco java
 * model.
 */
public class UnmatchedElementProcessor {

    /** The match manager to find matching elements. */
    private IMatchManager matchManager = null;

    /**
     * Constructor requiring to set the match manager.
     * 
     * @param matchManager
     *            The match manager to set.
     */
    public UnmatchedElementProcessor(IMatchManager matchManager) {
        this.matchManager = matchManager;
    }

    /**
     * Process an element to check for a model specific diff element.
     * 
     * @param unmatchElement
     *            the unmatch element
     * @return The DiffElement or null if no specific diff type exists.
     */
    public DiffElement process(UnmatchElement unmatchElement) {
        ProcessorSwitch processorSwitch = new ProcessorSwitch(unmatchElement, matchManager);
        return processorSwitch.doSwitch(unmatchElement.getElement());
    }

    /**
     * Internal processor switch to handle the unmatched element according to the type of element
     * the unmatch element is about.
     */
    private class ProcessorSwitch extends JavaSwitch<DiffElement> {

        /** The match manager to find matching elements. */
        private IMatchManager matchManager = null;

        /** The unmatch element currently processed. */
        private UnmatchElement unmatchElement = null;

        /**
         * Constructor requiring the UnmatchElement according to which the switchg should be done.
         * 
         * @param unmatchElement
         *            the unmatch element to process
         * @param matchManager
         *            the match manager
         */
        public ProcessorSwitch(UnmatchElement unmatchElement, IMatchManager matchManager) {
            this.matchManager = matchManager;
            this.unmatchElement = unmatchElement;
        }

        /**
         * Process an unmatched element which is about an import declaration.
         * 
         * Builds one of the alternatives: - For a right match: it builds an ImportInsert - For a
         * left match: it builds an ImportDelete
         * 
         * @param element
         *            The ImportDeclaration to handle the switch case for.
         * @return The DiffElement derived from the import declaration.
         */
        @Override
        public DiffElement caseImportDeclaration(ImportDeclaration element) {

            if (unmatchElement.getSide() == Side.LEFT) {
                // add ImportInsert
                final ImportInsert importInsert = Java2KDMDiffFactory.eINSTANCE.createImportInsert();
                importInsert.setImportLeft(element);
                return importInsert;
            } else {
                // add ImportDelete
                final ImportDelete importDelete = Java2KDMDiffFactory.eINSTANCE.createImportDelete();
                importDelete.setImportRight(element);
                EObject leftContainer = matchManager.getMatchedEObject(element.getOriginalCompilationUnit());
                if (leftContainer != null) {
                    importDelete.setLeftContainer((CompilationUnit) leftContainer);
                }
                return importDelete;
            }
        }

    }
}
