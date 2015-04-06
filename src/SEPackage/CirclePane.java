package SEPackage;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;

public class CirclePane extends JLabel {

        public CirclePane() {
            setOpaque(false);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected int getRadius() {
            // Determines the radius based on the smaller of the width
            // or height, so we stay symmetrical
            return Math.min(getWidth(), getHeight());
        }

        @Override
        public Insets getInsets() {
            int radius = getRadius();
            int xOffset = (getWidth() - radius) / 2;
            int yOffset = (getHeight() - radius) / 2;
            // These are magic numbers, you might like to calculate
            // your own values based on your needs
            Insets insets = new Insets(
                    radius / 6,
                    radius / 6,
                    radius / 6,
                    radius / 6);
            return insets;
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            int radius = getRadius();
            int xOffset = (getWidth() - radius) / 2;
            int yOffset = (getHeight() - radius) / 2;

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(getBackground());
            g2d.fillOval(xOffset, yOffset, radius, radius);
            g2d.setColor(Color.GRAY);
            g2d.drawOval(xOffset, yOffset, radius, radius);
//            This is test code to test the insets/usable area bounds...
//            Insets insets = getInsets();
//            g2d.drawRect(xOffset + insets.left, 
//                    yOffset + insets.top,
//                    (xOffset + radius) - (insets.right + insets.left), 
//                    (yOffset + radius) - (insets.bottom + insets.top));
            g2d.dispose();

        }
    }