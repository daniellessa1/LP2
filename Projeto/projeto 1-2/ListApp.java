import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.Color;
import figures.*;
import ivisible.IVisible;
import botao.Botao;
import org.jfree.svg.*;



class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Botao> buts = new ArrayList<Botao>();
    Random rand = new Random();
    Figure focus = null;
    Botao focus_button = null;
    int angulo = 0;
    Color colors[] = {Color.black, Color.blue, Color.cyan, Color.gray, Color.green, Color.orange, Color.pink, Color.red, Color.white, Color.yellow};




    ListFrame () {

        buts.add(new Botao(1,new Rect(0,0,0,0,angulo,Color.BLACK, Color.BLACK)));
        buts.add(new Botao(2,new Ellipse(0,0,0,0,angulo,Color.BLACK, Color.BLACK)));
        buts.add(new Botao(3,new Poly(0,0,0,0,angulo,Color.BLACK, Color.BLACK)));
        buts.add(new Botao(4, new Triangle(0,0,0,0,angulo,Color.BLACK,Color.BLACK)));
        buts.add(new Botao(5, new Line(0,0,0,0,angulo,Color.BLACK,Color.BLACK)));
        

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
                   if (evt.getKeyCode() == KeyEvent.VK_F1){
                        try {
                            FileOutputStream f = new FileOutputStream("proj.bin");
                            ObjectOutputStream o = new ObjectOutputStream(f);
                            o.writeObject(figs);
                            o.flush();
                            o.close();
                        } catch (Exception x) {
                            System.out.println("Erro!, não foi possivel criar o arquivo" +x);
                        }
                    } else if(evt.getKeyCode() == KeyEvent.VK_F2){
                        try {
                            FileInputStream f = new FileInputStream("proj.bin");
                            ObjectInputStream o = new ObjectInputStream(f);
                            figs = (ArrayList<Figure>) o.readObject();
                            o.close();
                        } catch (Exception x) {
                            System.out.println("Erro!, não foi possivel abrir o arquivo" +x);
                        }
                    } else if(evt.getKeyCode() == KeyEvent.VK_F3){
                        try {
                            SVGGraphics2D gSVG = new SVGGraphics2D(getWidth(), getHeight());
                
                            for (Figure fig: figs) {
                                fig.paint(gSVG, false);
                            }
                
                            File svgFile = new File("proj.svg");
                            svgFile.delete();
                            svgFile.createNewFile();
                            SVGUtils.writeToSVG(svgFile, gSVG.getSVGElement());
                        } catch (Exception error) {
                            System.out.println("Não foi possível salvar o projeto em SVG.\nError: " + error);
                        }
                    }
                    Point ponto = getMousePosition();
                    if (ponto != null){
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        int x = ponto.x - w/2;
                        int y = ponto.y - h/2;
                        if (evt.getKeyChar() == 'r') {
                            figs.add(new Rect(x,y,w,h,angulo,colors[rand.nextInt(10)],colors[rand.nextInt(10)]));

                        } else if (evt.getKeyChar() == 'e') {
                            figs.add(new Ellipse(x,y,w,h,angulo,colors[rand.nextInt(10)],colors[rand.nextInt(10)]));

                        } else if (evt.getKeyChar() == 'l') {
                            figs.add(new Line(x,y,w,h,angulo,colors[rand.nextInt(10)],colors[rand.nextInt(10)]));

                        } else if (evt.getKeyChar() == 'p') {
                            figs.add(new Poly(x,y,w,h,angulo,colors[rand.nextInt(10)],colors[rand.nextInt(10)]));
                        
                        } else if (evt.getKeyChar() == 't') {
                            figs.add(new Triangle(x,y,w,h,angulo,colors[rand.nextInt(10)],colors[rand.nextInt(10)]));

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
                            } else if (evt.getKeyChar() == 's') {
                                focus.angle = focus.angle + 5;

                            } else if (evt.getKeyChar() == 'a') {
                                focus.angle = focus.angle - 5;

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

        this.addMouseWheelListener (
                new MouseWheelListener() {
                    public void mouseWheelMoved(MouseWheelEvent evt) {
                        int scroll = evt.getUnitsToScroll();

                        if (focus != null) {
                            if (focus.w + scroll > 4 && focus.h + scroll > 4) {
                                if ((evt.getModifiersEx() & evt.SHIFT_DOWN_MASK) != 0)
                                    focus.h += scroll;
                                else if ((evt.getModifiersEx() & evt.ALT_DOWN_MASK) != 0)
                                    focus.w += scroll;
                                else {
                                    focus.w += scroll;
                                    focus.h += scroll;
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
        			if (focus_button!= null && !(evt.getX() >= 0 && evt.getX() <= 80 && evt.getY() >= 0 && evt.getY() <= 200)){
                        if(focus_button.idx==1)
			    figs.add(new Rect(evt.getX(),evt.getY(),50,50,angulo,colors[rand.nextInt(10)],colors[rand.nextInt(10)]));      
			else if(focus_button.idx==2)
			    figs.add(new Ellipse(evt.getX(),evt.getY(),50,50,angulo,colors[rand.nextInt(10)],colors[rand.nextInt(10)]));
			else if(focus_button.idx==3)
                            figs.add(new Poly(evt.getX(),evt.getY(),50,50,angulo,colors[rand.nextInt(10)],colors[rand.nextInt(10)]));
                        else if(focus_button.idx==4)
                            figs.add(new Triangle(evt.getX(),evt.getY(),50,50,angulo,colors[rand.nextInt(10)],colors[rand.nextInt(10)]));
                        else if(focus_button.idx==5)
                            figs.add(new Line(evt.getX(),evt.getY(),50,50,angulo,colors[rand.nextInt(10)],colors[rand.nextInt(10)]));
                        repaint();

                    }
                    focus_button = null;
                    for (Botao but: buts) {
                        if (but.clicked(evt.getX(), evt.getY())){
                            focus_button = but;
                        }
                    }
                    if (focus_button!= null) {
                        buts.remove(focus_button);
                        buts.add(focus_button);
                    }
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
        super.paint(g2d);
        for (Figure fig: this.figs) {
            fig.paint(g2d, fig == focus);
        }
        for (Botao but: this.buts) {
            but.paint(g2d, but == focus_button);
        }
    }
}
