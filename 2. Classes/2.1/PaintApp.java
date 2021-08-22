import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1,r2,r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30, new Color(255, 255, 0), new Color(255, 0, 0));
        this.r2 = new Rect(50,80, 30,100, new Color(0, 255, 0), new Color(0, 0, 255));
        this.r3 = new Rect(100,100, 100,50, new Color(0, 0, 0), new Color(255, 0, 255));
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    Color cordecontorno;
    Color cordefundo;
    

    Rect (int x, int y, int w, int h, Color cordecontorno, Color cordefundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.cordecontorno = cordecontorno;
        this.cordefundo = cordefundo;
        }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    
    int area(){
		return this.w * this.h;
	}
	void drag (int dx, int dy){
		System.out.format("Movendo (%d,%d) no retangulo.\n",dx,dy);
		this.x = this.x + dx;
		this.y = this.y + dy;
	}

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.cordefundo);
        g2d.fillRect(this.x,this.y, this.w,this.h);
        g2d.setColor(this.cordecontorno);
        g2d.drawRect(this.x,this.y, this.w,this.h);
        
    }

}