public class RectApp {
    public static void main (String[] args) { // Determina o ponto de início de execução do programa.
        Rect r1 = new Rect(1,1, 10,10); //Cria um novo retângulo na posição (1,1) com 10 de largura e 10 de altura.
        r1.print(); // Chamada para o método print imprime o retângulo na tela.
     }
} 

class Rect {
     int x, y; //Declaração das posições x e y do retângulo.
     int w, h; //Declaração das propriedades largura (w) e altura (h) do retângulo, como nesse caso w tem o mesmo valor do h, esse retângulo é um quadrado e w é equivalente ao lado do quadrado.     
     Rect (int x, int y, int w, int h) { //Constrói o retângulo com os dados passados acima.
         this.x = x; //Altera a propriedade posição x do retângulo com o valor passado acima.
         this.y = y; //Altera a propriedade posição y do retângulo com o valor passado acima.
         this.w = w; //Altera a propriedade largura w do retângulo com o valor passado acima.
         this.h = h; //Altera a propriedade altura h do retângulo com o valor passado acima.
     }

     void print () { //imprime o retângulo na tela 
       System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n", 
           this.w, this.h, this.x, this.y); //desenha na tela as informações do retângulo indicando o tamanho dele, com base na largura w e altura h, e a posição inicial indicado pelas posições x e y.
       }
}
