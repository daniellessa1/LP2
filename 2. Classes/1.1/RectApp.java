import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectApp {
	
    public static void main (String[] args) {
        Rect r1 = new Rect(5,5,7,10);
        r1.print();
    }
}
class Rect{
    int x,y;
	int w,h;
	double area;
    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.area = this.w * this.h;
	}
    void print () {
		if (this.area==0){
			System.out.format("Ponto na posicao (%d,%d).\n",
			this.x, this.y);
		}else{
		System.out.format("Retangulo de area %.2f, que comeca na posicao (%d,%d), termina na posicao (%d,%d).\n",
            this.area, this.x, this.y, this.w, this.h);
		}
    }
}