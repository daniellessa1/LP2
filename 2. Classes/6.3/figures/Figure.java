package figures;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.geom.Line2D;

public abstract class Figure {
    public int x, y;
    public int w, h;
    
    public Figure (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
     public void drag (int dx, int dy) {
        this.x = dx - (this.w/2);
        this.y = dy - (this.h/2);
    }

    public abstract void paint (Graphics g);
}