public boolean clicked (int x, int y) {
    return (this.x <= x && (this.x + this.w) >= x && this.y <= y && (this.y + this.h) >= y );       				
}

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

public void paint (Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    super.paint(g);
    for (Figure fig: this.figs) {
        fig.paint(g, fig == focus);
    }
            
}