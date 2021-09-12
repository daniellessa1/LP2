public void keyPressed (KeyEvent evt) {
    int x = rand.nextInt(350);                
    int y = rand.nextInt(350);
    int w = rand.nextInt(50);
    int h = rand.nextInt(50);
    if (evt.getKeyChar() == 'r') {
        figs.add(new Rect(x,y, w,h,colors[rand.nextInt(13)],colors[rand.nextInt(13)]));

    } else if (evt.getKeyChar() == 'e') {
        figs.add(new Ellipse(x,y, w,h,colors[rand.nextInt(13)],colors[rand.nextInt(13)]));

    } else if (evt.getKeyChar() == 'l') {
        figs.add(new Line(x,y, w,h,colors[rand.nextInt(13)],colors[rand.nextInt(13)]));

    } else if (evt.getKeyChar() == 'p') {
        figs.add(new Poly(x,y, w,h,colors[rand.nextInt(13)],colors[rand.nextInt(13)]));

    }  else if(evt.getKeyCode() == KeyEvent.VK_DELETE){
        figs.remove(focus);
        focus = null;
    }  
}