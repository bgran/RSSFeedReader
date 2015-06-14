package rssfr.GUI;

import javax.swing.JList;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author bgran
 */
public abstract class ColorJList extends JList {

    private Color rowColors[] = new Color[2];
    private boolean drawMarker = false;

    
	
    

    public ColorJList() {
    }

    public ColorJList(javax.swing.ListModel dataModel) {
        super(dataModel);
    }

    public ColorJList(Object[] listData) {
        super(listData);
    }

    public ColorJList(java.util.Vector<?> listData) {
        super(listData);
    }

    public void paintComponent(Graphics g) {

	    UICruft.info_box("super metodi", "fofofo");
        // Paint color background stripes
	rowColors[0] = java.awt.Color.black;
	rowColors[1] = java.awt.Color.GREEN;

        final java.awt.Insets insets = getInsets();
        final int w = getWidth() - insets.left - insets.right;
        final int h = getHeight() - insets.top - insets.bottom;
        final int x = insets.left;
        int y = insets.top;
        int nRows = 0;
        int startRow = 0;
        int rowHeight = getFixedCellHeight();
        if (rowHeight > 0) {
            nRows = h / rowHeight;
        } else {
            // Paint non-uniform height rows first
            final int nItems = getModel().getSize();
            rowHeight = 17; // A default for empty lists
            for (int i = 0; i < nItems; i++, y += rowHeight) {
                rowHeight = getCellBounds(i, i).height;
                g.setColor(rowColors[i & 1]);
                g.fillRect(x, y, w, rowHeight);
            }
            // Use last row height for remainder of list area
            nRows = nItems + (insets.top + h - y) / rowHeight;
            startRow = nItems;
        }
        for (int i = startRow; i < nRows; i++, y += rowHeight) {
            g.setColor(rowColors[i & 1]);
            g.fillRect(x, y, w, rowHeight);
        }
        final int remainder = insets.top + h - y;
        if (remainder > 0) {
            g.setColor(rowColors[nRows & 1]);
            g.fillRect(x, y, w, remainder);
        }

        // Paint component
        setOpaque(false);
        super.paintComponent(g);
        setOpaque(true);
    }

    /**
     * Wrap a cell renderer to add color stripes behind list cells.
     */
    public class RendererWrapper
            implements javax.swing.ListCellRenderer {

        public javax.swing.ListCellRenderer ren = null;

        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            final java.awt.Component c = ren.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            if (!isSelected && drawMarker) {
                c.setBackground(rowColors[index & 1]);
            }
            return c;
        }
    }
    private RendererWrapper wrapper = null;

    /**
     * Return the wrapped cell renderer.
     */
    public javax.swing.ListCellRenderer getCellRenderer() {
        final javax.swing.ListCellRenderer ren = super.getCellRenderer();
        if (ren == null) {
            return null;
        }
        if (wrapper == null) {
            wrapper = new RendererWrapper();
        }
        wrapper.ren = ren;
        return wrapper;
    }

    /**
     * Compute color background stripe colors.
     */
/*
    private void updateColors() {
        if ((rowColors[0] = getBackground()) == null) {
            rowColors[0] = rowColors[1] = java.awt.Color.white;
            return;
        }
        final java.awt.Color sel = getSelectionBackground();
        if (sel == null) {
            rowColors[1] = rowColors[0];
            return;
        }
        final float[] bgHSB = java.awt.Color.RGBtoHSB(
                rowColors[0].getRed(), rowColors[0].getGreen(),
                rowColors[0].getBlue(), null);
        final float[] selHSB = java.awt.Color.RGBtoHSB(
                sel.getRed(), sel.getGreen(), sel.getBlue(), null);
        rowColors[1] = java.awt.Color.getHSBColor(
                (selHSB[1] == 0.0 || selHSB[2] == 0.0) ? bgHSB[0] : selHSB[0],
                0.1f * selHSB[1] + 0.9f * bgHSB[1],
                bgHSB[2] + ((bgHSB[2] < 0.5f) ? 0.05f : -0.05f));
    }
*/
	//abstract public void updateColors ();
 /* {
		//rowColors[0] = java.awt.Color.white;
		//rowColors[1] = java.awt.Color.LIGHT_GRAY;
		rowColors[0] = java.awt.Color.black;
		rowColors[1] = java.awt.Color.red;
		}*/
}
