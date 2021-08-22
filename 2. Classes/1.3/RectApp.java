public class RectApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(1,1, 10,10);
        r1.print();
		System.out.format("Area do retangulo = %d.\n",r1.area());
		r1.drag(2,2);
		r1.print();
    }
}
class Rect {
    int x, y;
    int w, h;
    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
	int area(){
		return this.w * this.h;
	}
	void drag (int dx, int dy){
		System.out.format("Movendo (%d,%d) no retangulo.\n",dx,dy);
		this.x = this.x + dx;
		this.y = this.y + dy;
	}
}