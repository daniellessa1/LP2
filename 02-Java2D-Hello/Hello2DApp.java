import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(true);
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350,350);
        this.getContentPane().setBackground(Color.white);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.green);
        int w = 250;
        int h = 200;
        int x = 50;
        int y = 50;
        g2d.fillRect(x, y, w, h);
        int[] xPoint = {x + w/2 , x + w - 20 , x + w/2, x + 20 };
        int[] yPoint = {y + 20, y + h/2, y + h - 20, y + h/2};
        int npoints = 4;
        g2d.setPaint(Color.yellow);
        g2d.fillPolygon(xPoint, yPoint, npoints);
        g2d.setPaint(Color.blue);
        g2d.fillOval((x + w)/2, (y + h)/2, 50, 50);
    }
}
