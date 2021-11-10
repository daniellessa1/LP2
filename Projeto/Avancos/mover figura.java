public void drag (int dx, int dy) {
	this.x = dx - (this.w/2);
	this.y = dy - (this.h/2);
}

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
        
       