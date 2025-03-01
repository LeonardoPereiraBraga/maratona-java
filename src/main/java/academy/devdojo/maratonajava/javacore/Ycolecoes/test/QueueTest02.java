package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest02 {
    public static void main(String[] args) {

        Queue<Manga> mangas = new PriorityQueue<>(new MangaPrecoComparator());
        mangas.add(new Manga(4L,"Attack on titan",19.90));
        mangas.add(new Manga(2L,"Berserk", 10.0));
        mangas.add(new Manga(1L,"Hellsing", 50.0));
        mangas.add(new Manga(3L,"Pokemon", 30.00));
        mangas.add(new Manga(5L,"Dragon Ball Z Kai",25));
        while (!mangas.isEmpty()){
            System.out.println(mangas.poll());
        }


    }
}
