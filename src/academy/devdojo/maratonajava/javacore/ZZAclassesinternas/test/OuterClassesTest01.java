package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest01 {
    private String name = "Monkey D. Luffy";

    //Classe interna
    class Inner{
        public void printOuterClassAtrtribute(){
            System.out.println(name);
            System.out.println(OuterClassesTest01.this.name);
        }
    }
    public static void main(String[] args) {
            OuterClassesTest01 outerClass = new OuterClassesTest01();
            //Instanciando a classe interna e usando seu metodo
            Inner inner = outerClass.new Inner();
            inner.printOuterClassAtrtribute();

    }
}
