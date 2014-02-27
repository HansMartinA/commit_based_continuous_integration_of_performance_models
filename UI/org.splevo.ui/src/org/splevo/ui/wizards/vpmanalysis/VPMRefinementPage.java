package org.splevo.ui.wizards.vpmanalysis;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.ui.text.IColorManager;
import org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.VerticalRuler;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.splevo.ui.refinementbrowser.CompleteRefinementTreeContentProvider;
import org.splevo.ui.refinementbrowser.CompleteRefinementTreeLabelProvider;
import org.splevo.ui.refinementbrowser.VPMRefinementBrowserInput;

import com.google.common.io.CharStreams;

/**
 * Wizard page to modify the results of the vpm analysis.
 */
public class VPMRefinementPage extends WizardPage {

    private VPMRefinementBrowserInput refinementBrowserInput;
    private CheckboxTreeViewer treeViewer;

    /**
     * Create the wizard page to let the user modify the found VPM.
     */
    public VPMRefinementPage() {
        super("VPMRefinementWizardPage");
        this.setTitle("VPM Refinement");
        this.setDescription("Inspect and modify the VPM.");
    }

    @Override
    public void createControl(final Composite parent) {
        final Composite container = new Composite(parent, SWT.NULL);
        this.setControl(container);
        container.setLayout(new FillLayout());
        final SashForm outerSash = new SashForm(container, SWT.VERTICAL);
        this.treeViewer = new CheckboxTreeViewer(outerSash);
        this.treeViewer.setContentProvider(new CompleteRefinementTreeContentProvider());
        this.treeViewer.setLabelProvider(new CompleteRefinementTreeLabelProvider());
        final SashForm sourceViewersSash = new SashForm(outerSash, SWT.HORIZONTAL);
        final IVerticalRuler leadingRuler = new VerticalRuler(20);
        final IVerticalRuler followingRuler = new VerticalRuler(20);
        final SourceViewer leadingSourceViewer = new SourceViewer(sourceViewersSash, leadingRuler, SWT.V_SCROLL);
        final SourceViewer followingSourceViewer = new SourceViewer(sourceViewersSash, followingRuler, SWT.V_SCROLL);

        Document leadingDocument = null;
        Document followingDocument = null;

        // Test code. Un-comment for testing. Requires Calculator example in the workspace of the run instance.
        
//        IPath leadingPath = new Path("/Calculator-native/src/org/splevo/examples/calculator/CalculatorGCD.java");
//        IPath followingPath = new Path("/Calculator-JScience/src/org/splevo/examples/calculator/CalculatorGCD.java");
//
//        leadingDocument = createDocumentFromPath(leadingPath);
//        followingDocument = createDocumentFromPath(followingPath);
//
//        displayDocument(leadingSourceViewer, leadingDocument);
//        displayDocument(followingSourceViewer, followingDocument);

    }

    /**
     * Displays the Document in the SourceViewer. To achieve this, the SourceViewer will also be set
     * up according to the Document.
     * 
     * @param sourceViewer
     *            The Source viewer to display the Document in.
     * @param document
     *            The Document to display.
     */
    private void displayDocument(final SourceViewer sourceViewer, Document document) {
        // TODO: This needs to be modified to also handle other file types correctly.
        // Left warnings intentionally so it's obvious that this is a hack.
        // FIXME: Don't use any members of JavaPlugin even though this could result in code duplication.
        final IColorManager colorManager = JavaPlugin.getDefault().getJavaTextTools().getColorManager();
        final IPreferenceStore preferenceStore = JavaPlugin.getDefault().getCombinedPreferenceStore();

        sourceViewer.unconfigure();
        // TODO: This needs to be replaced for non-java files.
        sourceViewer.configure(new JavaSourceViewerConfiguration(colorManager, preferenceStore, null, null));
        sourceViewer.setEditable(false);
        sourceViewer.setDocument(document);
    }

    /**
     * Given a path will return a Document with the contents of the file at this path and the
     * DocumentPartitioner set up accordingly.
     * 
     * @param path
     *            Path of the File to generate a Document from.
     * @return a Document containing the content of the file at the path.
     */
    private Document createDocumentFromPath(IPath path) {
        Document document;
        IFile leadingFile = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
        String content = null;

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(leadingFile.getContents(),
                    leadingFile.getCharset());
            content = CharStreams.toString(inputStreamReader);
            inputStreamReader.close();
        } catch (UnsupportedEncodingException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        } catch (CoreException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        document = new Document(content);
        // TODO: This needs to be modified to also handle other file types correctly.
        // FIXME: Don't use any members of JavaPlugin even though this could result in code duplication.
        JavaPlugin.getDefault().getJavaTextTools().setupJavaDocumentPartitioner(document);
        return document;
    }

    /**
     * Setter for the refinements.
     * 
     * @param refinement
     *            refinements to be suggested in the VPMRefinementPage
     */
    public void setRefinementBrowserInput(final VPMRefinementBrowserInput refinement) {
        this.refinementBrowserInput = refinement;
        this.treeViewer.setInput(this.refinementBrowserInput.getRefinements());
        this.treeViewer.refresh();
    }

}
