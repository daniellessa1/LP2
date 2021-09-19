class Animal {    
   public void move(){
      System.out.println("Animals can move");
   }
}

class Dog extends Animal {

   public void move() { //sobrescreveu metodo
      System.out.println("Dogs can walk and run");
   }
}

public class TestDog {

   public static void main(String args[]) {
      Animal a = new Animal(); // referencia e objeto de Animal
      Animal b = new Dog(); // referencia de Animal mas objeto de Dog

      a.move();//saida: Animals can move

      b.move();//saida:Dogs can walk and run
   }
}

// Ao executar a.move(), b.move() a saída irá imprimir coisas diferentes, porém a assinatura do método é a mesma. 
// Assim o compilador Java não entende qual método é chamado no momento da compilação.Apenas a JVM decide qual método é chamado em tempo de execução, assim que se dá o polimorfismo com despacho dinâmico.


// fonte: https://www.ti-enxame.com/pt/java/qual-e-diferenca-entre-polimorfismo-dinamico-e-estatico-em-java/1044505034/
