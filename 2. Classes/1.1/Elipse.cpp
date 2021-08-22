#include <stdio.h>
#include <math.h>

typedef struct {
  int r1x, r1y, r2x, r2y;
  int size;
  float rot;
} Elipse;

void print_elipse (Elipse* e) {
	if(e->r1x==e->r2x && e->r1y==e->r2y){
		printf("Circulo de tamanho %d, de raio na posicao (%d,%d) e rotacao %.1f graus.\n",
		e->size, e->r1x,e->r1y, e->rot);
	}else{
		printf("Elipse de tamanho %d, de raios nas posicoes (%d,%d) e (%d,%d) e rotacao %.1f graus.\n",
    	e->size, e->r1x,e->r1y,e->r2x,e->r2y, e->rot);
	}
}

int main (void) {
    Elipse e1 = {1,1,1,2,5,90};
    print_elipse(&e1);
}
