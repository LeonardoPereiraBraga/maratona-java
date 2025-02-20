package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest02 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(1L,"Hellsing", 5.0));
        mangas.add(new Manga(2L,"Berserk", 10.0));
        mangas.add(new Manga(3L,"Pokemon", 30.00));
        mangas.add(new Manga(4L,"Attack on titan",19.90));
        mangas.add(new Manga(5L,"Dragon Ball Z Kai",25));

        Collections.sort(mangas);
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        //Procurando o index do manga DragonBall dentro da lista de Mangas
        Manga mangaToSearch = new Manga(5L,"Dragon Ball Z Kai",25);
        System.out.println(Collections.binarySearch(mangas,mangaToSearch));


    }
}
