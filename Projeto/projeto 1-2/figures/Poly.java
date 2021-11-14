package figures;

import java.awt.*;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;

public class Poly extends Figure {
    int[] xPoint, yPoint;
    int npoints = 4;
    public Poly (int x, int y, int w, int h,int angle, Color contorno, Color fundo) {
        super(x,y,w,h,angle,contorno,fundo);
    }

    public void paint (Graphics g, Boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        this.xPoint = new int[]{x + w/2 , x + w, x + w/2, x};
        this.yPoint = new int[]{y, y + h/2 , y + h, y + h/2 };
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(angle), x + w/2, y + h/2);
        if (focused){
            int[] xfocus = {x + w/2 , (x + w) + 2, x + w/2, x - 2};
            int[] yfocus = {y - 2 , y + h/2 , (y + h) + 2, y + h/2 };
            g2d.setColor(Color.red);
            g2d.draw(new Polygon(xfocus, yfocus, this.npoints));
        }
        g2d.setColor(this.fundo);
        g2d.fill(new Polygon(this.xPoint, this.yPoint, this.npoints));
        g2d.setColor(this.contorno);
        g2d.draw(new Polygon(this.xPoint, this.yPoint, this.npoints));
        g2d.setTransform(old);
    }
}
