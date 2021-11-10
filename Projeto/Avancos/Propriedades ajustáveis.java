public void keyPressed (KeyEvent evt) {
    if(focus!=null){
        if(evt.getKeyChar() == '+'){
            if(focus.w <= 350 && focus.h <= 350) {
                focus.h = focus.h + 10;
                focus.w = focus.w + 10;
            }
        } else if(evt.getKeyChar() == '-'){
            if(focus.w >= 0 && focus.h >= 0){
                focus.h = focus.h - 10;
                focus.w = focus.w - 10;
            }
        
        } else if(evt.getKeyCode() == KeyEvent.VK_UP){
            focus.y = focus.y - 10;

        } else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
            focus.y = focus.y + 10;

        } else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
            focus.x = focus.x - 10;

        } else if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
            focus.x = focus.x + 10;

            } 
            repaint();
        }
    }
);