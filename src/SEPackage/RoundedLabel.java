/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author Manav
 */
public class RoundedLabel extends JLabel{    
    public int intX,intY,w,h;
    Image image;
    private Ellipse2D.Double border = new Ellipse2D.Double();
      public RoundedLabel(int x,int y,int width,int height,Image image) {
            intX=x;
            intY=y;
            w=width;
            h=height;
            this.image=image;
      }
      
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        border.setFrame(0, 0, w, h);
        g2d.setClip(border);
        g2d.drawImage((Image) image, 0, 0, w, h, this);
    }//end of the rounded shape JLabel class
}