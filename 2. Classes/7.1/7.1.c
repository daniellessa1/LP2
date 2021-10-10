#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

typedef struct {
    int paleta;
} Color;

void color_print(Color cor){
	char *cores[12] = { "preto", "azul", "ciano", "cinza", "verde", "rosa", "laranja","vermelho", "verde", "azul", "roxo", "amarelo"};
	printf("%s", cores[cor.paleta]);
}


////////////////////////////////////////////////////////////////////////////////

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Poly;

void poly_print (Poly* this) {
    Figure* sup = (Figure*) this;
    printf("Losango com vertices em: (%d,%d), (%d,%d), (%d,%d) e (%d,%d), ",
           sup->x, sup->y , sup->x + this->w, sup->y + this->h, sup->x, sup->y + 2 * this->h, sup->x - this->w, sup->y + this->h);
    printf("cor de borda ");color_print(sup->bg);
	printf(" e cor de fundo ");color_print(sup->fg);
	printf("\n");
}

Poly* poly_new (int x, int y, int w, int h,int cc, int cf) {
    Poly*   this  = malloc(sizeof(Poly));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) poly_print;
    sup->x = x;
    sup->y = y;
    sup->bg.paleta = cc;
    sup->fg.paleta = cf;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d), ",this->w, this->h, sup->x, sup->y);
    printf("cor de borda ");color_print(sup->bg);
	printf(" e cor de fundo ");color_print(sup->fg);
	printf("\n");
}

Ellipse* ellipse_new (int x, int y, int w, int h,int cc, int cf) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) ellipse_print;
    sup->x = x;
    sup->y = y;
    sup->bg.paleta = cc;
    sup->fg.paleta = cf;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
	srand(time(NULL));
    Figure* figs[4] = {
        (Figure*) poly_new(10,20,100,200, rand() % 11, rand() % 11),
        (Figure*) ellipse_new(40,10,140,300, rand() % 11, rand() % 11),
        (Figure*) poly_new(30,15,150,150, rand() % 11, rand() % 11),
        (Figure*) ellipse_new(210,110,305,130, rand() % 11, rand() % 11),
    };
    int i;

    ///

    for (i=0; i<4; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (i=0; i<4; i++) {
        free(figs[i]);
    }
}
