package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;
class Animal{
    public void walk(){
        System.out.println("Animal walking");
    }
}

public class AnonymousClassTest01 {
    public static void main(String[] args) {
            Animal animal = new Animal(){ //Classe anonima usando as chave nas instanciaçao
                @Override
                public void walk() {
                    System.out.println("Walking in the shadows");
                }
                //Nao consegue criar um metodo em classe anonima apenas Override
            };
            animal.walk();
    }
}
