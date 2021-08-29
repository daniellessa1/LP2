package figuras;

import java.awt.*;

public class Poly {
    int[] xPoint, yPoint;
    int npoints;
    Color cordecontorno;
    Color cordefundo;
    

    public Poly (int[] xPoint, int[] yPoint, int npoints, Color cordecontorno, Color cordefundo) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.npoints = npoints;
        this.cordecontorno = cordecontorno;
        this.cordefundo = cordefundo;
    }

    public void print () {
        for(int i = 0; i < npoints ; i++) {
            System.out.format("Poligono de (%d) lados nos pontos (%d,%d).\n",
            this.npoints, this.xPoint[i], this.yPoint[i]);
          }  
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.cordefundo);
        g2d.fillPolygon(this.xPoint, this.yPoint, this.npoints);
        g2d.setColor(this.cordecontorno);
        g2d.drawPolygon(this.xPoint, this.yPoint, this.npoints);
        
    }
}