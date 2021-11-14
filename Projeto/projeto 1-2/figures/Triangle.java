package figures;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Triangle extends Figure {
    int[] xPoint, yPoint;

    public Triangle (int x, int y, int w, int h, int angle, Color contorno, Color fundo) {
        super(x,y,w,h,angle,contorno,fundo);
    }

    public void paint (Graphics g, Boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        this.xPoint = new int[]{x, x + w/2, x + w};
        this.yPoint = new int[]{y + h, y, y + h};

        AffineTransform old = g2d.getTransform();

        g2d.rotate(Math.toRadians(angle), x + w/2, y + h/2);
        
        if (focused){
            int[] xfocus = {x - 4, (x + w/2) , (x + w) + 4}; 
            int[] yfocus = {(y + h) + 4, y - 4, (y + h) + 4}; 
            g2d.setColor(Color.red);
            g2d.draw(new Polygon(xfocus, yfocus,3));
        }
        g2d.setColor(this.fundo);
        g2d.fill(new Polygon(this.xPoint, this.yPoint, 3));
        g2d.setColor(this.contorno);
        g2d.draw(new Polygon(this.xPoint, this.yPoint, 3));
        g2d.setTransform(old);
    }
}