package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>(6);
        mangas.add("Attack on titan");
        mangas.add("Berserk");
        mangas.add("Hellsing");
        mangas.add("Pokemon");
        mangas.add("Dragon Ball Z Kai");

        //opa
        Collections.sort(mangas); //Organizadno em ordem alfabetica, e ordem crescente em numeros
        for(String manga : mangas){
            System.out.println(manga);
        }
    }
}
