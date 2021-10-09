import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;


import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    Figure focus = null;
    Color colors[] = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow};




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
                    Point ponto = getMousePosition();
                    if (ponto != null){
                        int x = ponto.x;
                        int y = ponto.y;
                        int w = rand.nextInt(200);
                        int h = rand.nextInt(200);
                        if (evt.getKeyChar() == 'r') {
                            figs.add(new Rect(x,y, w,h,colors[rand.nextInt(13)],colors[rand.nextInt(13)]));

                        } else if (evt.getKeyChar() == 'e') {
                            figs.add(new Ellipse(x,y, w,h,colors[rand.nextInt(13)],colors[rand.nextInt(13)]));

                        } else if (evt.getKeyChar() == 'l') {
                            figs.add(new Line(x,y, w,h,colors[rand.nextInt(13)],colors[rand.nextInt(13)]));

                        } else if (evt.getKeyChar() == 'p') {
                            figs.add(new Poly(x,y, w,h,colors[rand.nextInt(13)],colors[rand.nextInt(13)]));

                        } else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
                            figs.clear();
                            repaint();
                    
                        } else if(focus!=null){
                            if(evt.getKeyChar() == 'c') {    
                                focus.contorno = JColorChooser.showDialog(null, "Escolha uma cor de contorno para a figura ", colors[0]);
                                repaint();
                            
                            } else if(evt.getKeyChar() == 'f') {    
                                focus.fundo = JColorChooser.showDialog(null, "Escolha uma cor de fundo para a figura ", colors[0]);
                                repaint();

                            }else if(evt.getKeyChar() == '+'){
                                if(focus.w < 490 && focus.h < 490){
                                    focus.h = focus.h + 1;
                                    focus.w = focus.w + 1;
                            }
                            } else if(evt.getKeyChar() == '-'){
                                if(focus.w > 5 && focus.h > 5 ){
                                    focus.h = focus.h - 1;
                                    focus.w = focus.w - 1;
                            }
                        
                            } else if(evt.getKeyCode() == KeyEvent.VK_UP){
                                focus.y = focus.y - 10;
    
                            } else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
                                focus.y = focus.y + 10;
    
                            } else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
                                focus.x = focus.x - 10;
    
                            } else if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
                                focus.x = focus.x + 10;
    
                            } else if(evt.getKeyCode() == KeyEvent.VK_DELETE){
                                figs.remove(focus);
                                focus = null;
                            } 
                        }
                        repaint();
                    }
                }
            }
        );

        this.addMouseMotionListener(
        	new MouseMotionAdapter() {
        		public void mouseDragged(MouseEvent evt) {
                    if (focus != null) {
                        focus.drag(evt.getX(),evt.getY());
        	            repaint();
                    }
                }
            }
        );
        
        this.addMouseListener(
        	new MouseAdapter() {
        		public void mousePressed(MouseEvent evt) {
        			focus = null;
        			for(Figure fig: figs) {
                        if (fig.clicked(evt.getX(), evt.getY())){
                            focus = fig;
                            setCursor(new Cursor(Cursor.HAND_CURSOR));
                            
                        } else {
                            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        }
                    }
                    if (focus!= null) {
                        figs.remove(focus);
                        figs.add(focus);
                    }
                    repaint();
        		}
        	}
        );

        this.setTitle("Lista de Figuras");
        this.setSize(500, 500);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g, fig == focus);
        }
        
    }
}

