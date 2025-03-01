package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest02 {
    private String name = "Midorya";
    //Classe Local é uma classe dentro de um Metodo
    void print(final String param){ //parametro tem que ser final tbm
        final String lastName = "Izuku"; //esse atributo tem que final
        class LocalClass{
            public void printLocal(){
                System.out.println(name + " " + lastName);
            }
        }
        LocalClass localClass = new LocalClass(); //Instanciando classe dentro do metodo
        localClass.printLocal();
    }

    public static void main(String[] args) {
        OuterClassesTest02 outer = new OuterClassesTest02();
        outer.print("param");

    }
}
