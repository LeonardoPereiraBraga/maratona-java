package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest03 {
    private String name = "William";
    //Quando voce usa o static é como se essa Nested estivesse fora da OuterClass
    static class Nested {
        void print(){
               System.out.println(new OuterClassesTest03().name); //Funciona
            // System.out.println(name); Nao Funciona
        }

    }
    public static void main(String[] args) {
        Nested nested = new Nested();
        nested.print();
    }
}
