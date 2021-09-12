import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    ArrayList<Rect> rs = new ArrayList<Rect>();
    ArrayList<Ellipse> es = new ArrayList<Ellipse>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'r') {
                        int x1 = rand.nextInt(350);
                        int y1 = rand.nextInt(350);
                        int w1 = rand.nextInt(50);
                        int h1 = rand.nextInt(50);
                        rs.add(new Rect(x1,y1, w1,h1));
                        repaint();  
                    }
                    if (evt.getKeyChar() == 'e') {
                        int x2 = rand.nextInt(350);
                        int y2 = rand.nextInt(350);
                        int w2 = rand.nextInt(50);
                        int h2 = rand.nextInt(50);
                        es.add(new Ellipse(x2,y2, w2,h2));
                        repaint();  
                    }
                }
            }
        );

        this.setTitle("Lista de Retangulos + Ellipses");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Rect r: this.rs) {
            r.paint(g);
        }
        for (Ellipse e: this.es) {
            e.paint(g);
        }
    }
}

