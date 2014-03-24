/*******************************************************************************
 * Copyright (c) 2014
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Benjamin Klatt
 *******************************************************************************/
package org.splevo.ui.refinementbrowser;

import java.net.URL;
import java.util.HashMap;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.splevo.vpm.refinement.Refinement;
import org.splevo.vpm.refinement.RefinementType;
import org.splevo.vpm.refinement.provider.RefinementItemProvider;
import org.splevo.vpm.refinement.provider.RefinementItemProviderAdapterFactory;

/**
 * A label provider for the nodes presented in the refinement tree.
 */
public class RefinementTreeLabelProvider extends LabelProvider {

    /** Mapping to cache images loaded. */
    private HashMap<Object, Image> imageMapping = new HashMap<Object, Image>();

    @Override
    public String getText(Object element) {
        if (element instanceof Refinement) {
            // TODO optimize with EMF generated itemprovider
            // MergeItemProvider itemProvider = new MergeItemProvider(new
            // RefinementItemProviderAdapterFactory());
            // return itemProvider.getText((Merge) element);
            Refinement refinement = (Refinement) element;
            StringBuilder labelBuilder = new StringBuilder();
            if (refinement.getType() == RefinementType.GROUPING) {
                labelBuilder.append("Grouping (");
            } else {
                labelBuilder.append("Merge (");
            }
            labelBuilder.append(((Refinement) element).getVariationPoints().size());
            labelBuilder.append(" VPs)");
            return labelBuilder.toString();
        } else {
            throw new RuntimeException("Unknown Refinement Type: " + element.getClass());
        }
    }

    @Override
    public Image getImage(Object element) {
        if (element instanceof Refinement) {
            Refinement refinement = (Refinement) element;
            if (!imageMapping.containsKey(refinement.getType())) {
                RefinementItemProvider itemProvider = new RefinementItemProvider(
                        new RefinementItemProviderAdapterFactory());
                ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL((URL) itemProvider.getImage(element));
                imageMapping.put(refinement.getType(), imageDescriptor.createImage());
            }
            return imageMapping.get(refinement.getType());
        }
        // TODO optimize with EMF generated itemprovider
        return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
    }

}
