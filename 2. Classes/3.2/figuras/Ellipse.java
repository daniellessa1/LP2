package figuras;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.Color;

public class Ellipse {
    int x, y;
    int w, h;
    Color cordecontorno;
    Color cordefundo;

    public Ellipse (int x, int y, int w, int h, Color cordecontorno, Color cordefundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.cordecontorno = cordecontorno;
        this.cordefundo = cordefundo;
        }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.cordefundo);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setColor(this.cordecontorno);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}