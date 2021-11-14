package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.Color;
import java.awt.geom.AffineTransform;

public class Ellipse extends Figure {
    public Ellipse (int x, int y, int w, int h,int angle, Color contorno, Color fundo) {
        super(x,y,w,h,angle,contorno,fundo);
    }

    public void paint (Graphics g, Boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(angle), x + w/2, y + h/2);
        if (focused){
            g2d.setColor(Color.red);
            g2d.draw(new Ellipse2D.Double(this.x - 2, this.y - 2, this.w + 4, this.h + 4));
        }
        g2d.setColor(this.fundo);
        g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h ));
        g2d.setColor(this.contorno);
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
        g2d.setTransform(old);
    }
}


