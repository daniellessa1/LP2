import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.Color;

class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    Rect r1, r2, r3;
    Ellipse e1, e2, e3;

    RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect + Ellipse");
        this.setSize(500, 500);
        this.r1 = new Rect(50,50, 100,30, new Color(255, 255, 0), new Color(255, 0, 0));
        this.r2 = new Rect(200,50, 50,30, new Color(0, 255, 0), new Color(0, 0, 255));
        this.r3 = new Rect(300,50, 60,40, new Color(0, 0, 0), new Color(255, 0, 255));
        this.e1 = new Ellipse(50,100, 100,30, new Color(102, 255, 51), new Color(255, 102, 0));
        this.e2 = new Ellipse(200,100, 30,100, new Color(0, 255, 255), new Color(255, 0, 102));
        this.e3 = new Ellipse(300,100, 100,60, new Color(204, 0, 0), new Color(204, 153, 0));
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
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

    void paint (Graphics g) {
        g.setColor(this.cordefundo);
        g.fillRect(this.x,this.y, this.w,this.h);
        g.setColor(this.cordecontorno);
        g.drawRect(this.x,this.y, this.w,this.h);
    }
}

class Ellipse {
    int x, y;
    int w, h;
    Color cordecontorno;
    Color cordefundo;

    Ellipse (int x, int y, int w, int h, Color cordecontorno, Color cordefundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.cordecontorno = cordecontorno;
        this.cordefundo = cordefundo;
        }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.cordefundo);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setColor(this.cordecontorno);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}