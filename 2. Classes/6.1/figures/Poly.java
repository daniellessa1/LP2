package figures;

import java.awt.*;

public class Poly extends Figure {
    int[] xPoint, yPoint;
    int npoints;
    
    

    public Poly (int[] xPoint, int[] yPoint, int npoints) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.npoints = npoints;
    }

    public void print () {
        for(int i = 0; i < npoints ; i++) {
            System.out.format("Poligono de (%d) lados nos pontos (%d,%d).\n",
            this.npoints, this.xPoint[i], this.yPoint[i]);
          }  
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawPolygon(this.xPoint, this.yPoint, this.npoints);
        
    }
}