package figuras;

import java.awt.*;

public class Rect {
    int x, y;
    int w, h;
    Color cordecontorno;
    Color cordefundo;
    

    public Rect (int x, int y, int w, int h, Color cordecontorno, Color cordefundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.cordecontorno = cordecontorno;
        this.cordefundo = cordefundo;
        }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.cordefundo);
        g2d.fillRect(this.x,this.y, this.w,this.h);
        g2d.setColor(this.cordecontorno);
        g2d.drawRect(this.x,this.y, this.w,this.h);
        
    }

}