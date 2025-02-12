package academy.devdojo.maratonajava.javacore.Npolimorfismo.test;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Computador;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Produto;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Tomate;

public class ProdutoTest02 {
    public static void main(String[] args) {
        Produto produto =  new Computador("Nitro V", 4000);
        Produto produto2 = new Tomate("TomateNormal", 10);
        System.out.println(produto.calcularImposto());
        System.out.println(produto2.calcularImposto());
    }
}
