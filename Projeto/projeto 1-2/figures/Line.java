package figures;

import java.awt.*;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.AffineTransform;

public class Line extends Figure {
    public Line (int x, int y, int w, int h,int angle, Color contorno, Color fundo) {
        super(x,y,w,h,angle,contorno,fundo);
    }

    public void paint (Graphics g, Boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(angle), x + w/2, y + h/2);
        if (focused){
            g2d.setColor(Color.red);
            g2d.drawRect(this.x - 2, this.y - 2, this.w  + 2, this.h  + 2);
        }
        g2d.setColor(this.contorno);
        g2d.drawLine(this.x, this.y, this.w + this.x, this.h + this.y);
        g2d.setTransform(old);
    }
}
