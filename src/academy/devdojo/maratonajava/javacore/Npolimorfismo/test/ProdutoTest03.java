package academy.devdojo.maratonajava.javacore.Npolimorfismo.test;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Computador;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Produto;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Tomate;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.servico.CalculadoraImposto;

public class ProdutoTest03 {
    public static void main(String[] args) {
        Produto produto1 = new Computador("Acer Nitro V", 3000);
        Tomate tomate = new Tomate("TomateNormal", 10);
        tomate.setDataValidade("11/12/2021");
        CalculadoraImposto.calcularImposto(tomate);
        System.out.println(produto1);
    }
}
