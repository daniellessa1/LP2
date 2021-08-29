import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import figuras.*;

class RectEllipsePolyApp {
    public static void main (String[] args) {
        RectEllipsePolyFrame frame = new RectEllipsePolyFrame();
        frame.setVisible(true);
    }
}

class RectEllipsePolyFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    Rect r1, r2, r3;
    Ellipse e1, e2, e3;
    Poly p1, p2, p3;
    int[] xPoint1 = {75, 100 , 75 ,50};
    int[] yPoint1 = {150, 200, 250, 200};
    int[] xPoint2 = {200, 250 , 200 ,150};
    int[] yPoint2 = {200, 250, 300, 250};
    int[] xPoint3 = {350, 425 , 350 ,275};
    int[] yPoint3 = {200, 250, 300, 250};
    int npoints = 4;

    RectEllipsePolyFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect + Ellipse + Poly");
        this.setSize(500, 500);
        this.r1 = new Rect(50,50, 100,30, new Color(255, 255, 0), new Color(255, 0, 0));
        this.r2 = new Rect(200,50, 50,30, new Color(0, 255, 0), new Color(0, 0, 255));
        this.r3 = new Rect(300,50, 60,40, new Color(0, 0, 0), new Color(255, 0, 255));
        this.e1 = new Ellipse(50,100, 100,30, new Color(102, 255, 51), new Color(255, 102, 0));
        this.e2 = new Ellipse(200,100, 30,100, new Color(0, 255, 255), new Color(255, 0, 102));
        this.e3 = new Ellipse(300,100, 100,60, new Color(204, 0, 0), new Color(204, 153, 0));
        this.p1 = new Poly(xPoint1, yPoint1, npoints, new Color(102, 51, 0), new Color(51, 204, 255));
        this.p2 = new Poly(xPoint2, yPoint2, npoints, new Color(255, 51, 0), new Color(255, 153, 255));
        this.p3 = new Poly(xPoint3, yPoint3, npoints, new Color(0, 153, 204), new Color(102, 255, 102));
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
        this.p1.paint(g);
        this.p2.paint(g);
        this.p3.paint(g);
        
    }
}
