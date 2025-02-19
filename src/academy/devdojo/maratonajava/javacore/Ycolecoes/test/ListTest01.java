package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        List<String> nomes2 = new ArrayList<>();
        nomes.add("Alice");
        nomes.add("Barbara");
        nomes.add("Caroline");
        nomes2.add("David");
        nomes2.add("Ed");
        nomes2.add("Fernando");
        nomes.addAll(nomes2); //Adiciona todos os nomes2 em nomes

        nomes.remove(0); //Remove pelo index
        nomes.remove("Barbara"); //Remove pelo conteudo
        for (String nome : nomes) {
            System.out.println(nome);
        }

        for(int i = 0; i < nomes.size(); i++){
            System.out.println(nomes.get(0)); //Equivalente nomes[0]
        }


    }
}
