package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashSet;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
        //Set nao permite eleentos duplicados
        Set<Manga> mangas = new HashSet<>();
        mangas.add(new Manga(4L,"Attack on titan",19.90));
        mangas.add(new Manga(2L,"Berserk", 10.0));
        mangas.add(new Manga(1L,"Hellsing", 5.0));
        mangas.add(new Manga(3L,"Pokemon", 30.00));
        mangas.add(new Manga(5L,"Dragon Ball Z Kai",25));

        //Set nao tem index entao usa for each
        for (Manga manga : mangas) {
            System.out.println(manga);
        }



    }
}
