package rssfr.GUI;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import rssfr.GUI.ColorJList;
import rssfr.GUI.UICruft;

/**
 *
 * @author bgran
 */
public class LowerJList extends ColorJList {

    private Color rowColors[] = new Color[2];

	public LowerJList () {
		setOpaque(false);
	}

    @Override
    public void paintComponent(Graphics g) {
            //super.paintComponent(g);
            
           Graphics2D g2 = (Graphics2D) g;
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.0f));
            g2.fillRect(75, 75, 50, 50);
	    //// if (!isOpaque()) {
	    //	    super.paintComponent(g);
//		    return;
//	    }
	    //setOpaque(true);
        // Paint color background stripes
        
        rowColors[0] = java.awt.Color.white;
        rowColors[1] = java.awt.Color.LIGHT_GRAY;
        Color hdrColor = java.awt.Color.RED;

        final java.awt.Insets insets = getInsets();
        final int w = getWidth() - insets.left - insets.right;
        final int h = getHeight() - insets.top - insets.bottom;
        final int x = insets.left;
        int y = insets.top;
        int nRows = 0;
        int startRow = 0;
        int rowHeight = getFixedCellHeight();

        int line_counter = 0;
        int first_row = 1;
        /*int my_y = 0 + rowHeight;
         g.setColor(hdrColor);
         g.fillRect(x, my_y ,w , rowHeight);
         System.out.println("x: " + x);
         System.out.println("my_y:" + my_y);
         System.out.println("w: " + w);
         System.out.println("rowHeight: " + rowHeight);
         */
        if (rowHeight > 0) {
            nRows = h / rowHeight;
            System.out.println("nRows: " + nRows);
        } else {
                        // XXX bgran: this is useless code
            // Paint non-uniform height rows first
            final int nItems = getModel().getSize();
            rowHeight = 17; // A default for empty lists
            for (int i = 0; i < nItems; i++, y += rowHeight) {
                System.out.println("Eka vaihtoehto!");
                rowHeight = getCellBounds(i, i).height;
                if (first_row == 1) {
                    first_row = 0;
                    g.setColor(hdrColor);
		    
                    g.fillRect(x, y, w, rowHeight);
                } else {
                    g.setColor(rowColors[i & 1]);
                    g.fillRect(x, y, w, rowHeight);
                }
                line_counter ++;
                // Use last row height for remainder of list area
                nRows = nItems + (insets.top + h - y) / rowHeight;
                startRow = nItems;
                System.out.println("2 nRows: " + nRows);
            }
		//int my_y = 0 + rowHeight;
            //g.setColor(hdrColor);
            //g.fillRect(x, my_y ,w , rowHeight);
            for (int i = startRow + 1; i < nRows; i++, y += rowHeight) {
                if (first_row == 1) {
                    g.setColor(hdrColor);
                    first_row = 0;
                } else {
                    g.setColor(rowColors[(i+line_counter % 2) & 1]);
                }
                g.fillRect(x, y, w, rowHeight);
                System.out.println("Toka vaihtoehto");
            }
            final int remainder = insets.top + h - y;
            if (remainder > 0) {
                System.out.println("kolman vaihtoehto");
                g.setColor(rowColors[nRows & 1]);
                g.fillRect(x, y, w, remainder);
            }

            //g.setComposite(AlphaComposite.SrcOver);
		// Paint component
            setOpaque(false);
            super.paintComponent(g);
            setOpaque(true);
        }

    }
}
