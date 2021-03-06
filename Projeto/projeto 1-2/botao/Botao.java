package botao;

import ivisible.IVisible;
import figures.Figure;
import java.awt.*;


public class Botao implements IVisible {
    static int SPC = 10;
    static int DIM = 35;
    static int PAD = 4;
    public int idx;
    private Figure fig;

    public Botao (int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
        this.fig.x = PAD+SPC;
        this.fig.y = PAD+SPC + idx*DIM;
        this.fig.w = DIM-PAD*2;
        this.fig.h = DIM-PAD*2;
    }

    public boolean clicked (int x, int y) {
        return SPC<=x && x<=SPC+DIM && SPC+this.idx*DIM<=y && y<=SPC+this.idx*DIM+DIM;
    }

    public void paint (Graphics g, Boolean focused){
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawString("Menu", SPC + 3, SPC + DIM - 3);

        g2d.setColor(focused ? Color.GRAY : Color.LIGHT_GRAY);
        g2d.fillRect(SPC, SPC+this.idx*DIM, DIM, DIM);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(SPC, SPC+this.idx*DIM, DIM, DIM);

        this.fig.paint(g, false);
    }
}
