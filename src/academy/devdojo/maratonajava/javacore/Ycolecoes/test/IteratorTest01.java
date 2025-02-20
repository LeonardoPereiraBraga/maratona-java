package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(1L,"Hellsing", 5.0, 0));
        mangas.add(new Manga(2L,"Berserk", 10.0, 5));
        mangas.add(new Manga(3L,"Pokemon", 30.00, 0));
        mangas.add(new Manga(4L,"Attack on titan",19.90, 2));
        mangas.add(new Manga(5L,"Dragon Ball Z Kai",25, 0));
        //Iterator classe que checa antes de fazer algo
//        Iterator<Manga> mangaIterator = mangas.iterator();
//        while(mangaIterator.hasNext()){
//            Manga manga = mangaIterator.next();
//            if(manga.getQuantidade() == 0){
//                mangaIterator.remove();
//            }
//        }

        //Forma que substitui o jeito que usava o Iterator
        mangas.removeIf(manga -> manga.getQuantidade() == 0);
        System.out.println(mangas);


    }
}
