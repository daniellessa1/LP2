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

// fonte: https://www.ti-enxame.com/pt/java/qual-e-diferenca-entre-polimorfismo-dinamico-e-estatico-em-java/1044505034/