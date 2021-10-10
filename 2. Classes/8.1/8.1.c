#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
#include<math.h>

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
typedef int  (* Figure_Area)  (struct Figure*);
typedef int  (* Figure_Perimetro)  (struct Figure*);


typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
    int  (* perimetro)  (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Poly;

void poly_print (Poly* this) {
    Figure* sup = (Figure*) this;
     printf("Losango com vertices em: (%d,%d), (%d,%d), (%d,%d) e (%d,%d), area %d, perimetro %d,",
           sup->x, sup->y , sup->x + this->w, sup->y + this->h, sup->x, sup->y + 2 * this->h, sup->x - this->w, sup->y + this->h,sup->vtable->area(sup), sup->vtable->perimetro(sup));
    printf("cor de borda ");color_print(sup->bg);
	printf(" e cor de fundo ");color_print(sup->fg);
	printf("\n");
}

int poly_area (Poly* this) {
    Figure* sup = (Figure*) this;
    return 2*(this->w * this->h);
}

int poly_perimetro (Poly* this) {
    Figure* sup = (Figure*) this;
    int l =  sqrt(pow(this->w,2) + pow(this->h,2));
    return 4*l;
}

Figure_vtable poly_vtable = {
    (Figure_Print) poly_print,
    (Figure_Area)  poly_area,
    (Figure_Perimetro)  poly_perimetro
};

Poly* poly_new (int x, int y, int w, int h,int cc, int cf) {
    Poly*   this  = malloc(sizeof(Poly));
    Figure* sup = (Figure*) this;
    sup->vtable = &poly_vtable;
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
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d), area %d e perimetro %d,",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perimetro(sup));
    printf("cor de borda ");color_print(sup->bg);
	printf(" e cor de fundo ");color_print(sup->fg);
	printf("\n");
}

int ellipse_area (Ellipse* this) {
    Figure* sup = (Figure*) this;
    return (this->w )/2 * (this->h)/2 * 3;
}

int ellipse_perimetro (Ellipse* this) {
    Figure* sup = (Figure*) this;
    int a = (this->w)/2;
	int b = (this->h)/2;
	if (a > b){
		int c = sqrt(pow(a,2) - pow(b,2));
		int e = c/a;
		return 3 * a * (2 - pow(e,2)/2 - (3* pow(e,4))/16 );
	} else if (a < b){
		int c = sqrt(pow(b,2) - pow(a,2));
		int e = c/b;
		return 3 * b * (2 - pow(e,2)/2 - (3* pow(e,4))/16);
	} else{
		return 2 * 3.14 * a;
	}
	
}

Figure_vtable ellipse_vtable = {
    (Figure_Print) ellipse_print,
    (Figure_Area)  ellipse_area,
    (Figure_Perimetro)  ellipse_perimetro
};

Ellipse* ellipse_new (int x, int y, int w, int h,int cc, int cf) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;
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
        figs[i]->vtable->print(figs[i]);
    }

    ///

    for (i=0; i<4; i++) {
        free(figs[i]);
    }
}
