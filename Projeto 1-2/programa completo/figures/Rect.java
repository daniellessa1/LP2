package figures;

import java.awt.*;
import java.awt.Color;

public class Rect extends Figure {
    public Rect (int x, int y, int w, int h, Color contorno, Color fundo) {
        super(x,y, w,h, contorno,fundo);
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g, Boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        if (focused){
            g2d.setColor(Color.red);
            g2d.drawRect(this.x - 2,this.y - 2, this.w + 4,this.h + 4);
        }
        g2d.setColor(this.fundo);
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setColor(this.contorno);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }

}