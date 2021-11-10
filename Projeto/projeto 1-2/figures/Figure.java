package figures;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.io.Serializable;
import ivisible.IVisible;

public abstract class Figure implements IVisible, Serializable {
    public int x, y;
    public int w, h;
    public Color contorno, fundo;
    
    public Figure (int x, int y, int w, int h, Color contorno, Color fundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.contorno = contorno;
        this.fundo = fundo;
    }
    
     public void drag (int dx, int dy) {
        this.x = dx - (this.w)/2;
        this.y = dy - (this.h)/2;
    }
    
    public boolean clicked (int x, int y) {
        return (this.x <= x && (this.x + this.w) >= x && this.y <= y && (this.y + this.h) >= y );       				
    }
}
