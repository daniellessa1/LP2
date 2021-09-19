package figures;

import java.awt.*;
import java.awt.Polygon;

public class Poly extends Figure {
    int[] xPoint, yPoint;
    int npoints = 4;
    
    public Poly (int x, int y, int w, int h) {
        super(x,y, w,h);
    }

    public void print () {
        for(int i = 0; i < npoints ; i++) {
            System.out.format("Poligono de (%d) lados nos pontos (%d,%d).\n",
            this.npoints, this.xPoint[i], this.yPoint[i]);
          }  
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        this.xPoint = new int[]{x + w/2 , x + w, x + w/2, x};
        this.yPoint = new int[]{y, y + h/2 , y + h, y + h/2 };
        g2d.draw(new Polygon(this.xPoint, this.yPoint, this.npoints));
        
    }
}