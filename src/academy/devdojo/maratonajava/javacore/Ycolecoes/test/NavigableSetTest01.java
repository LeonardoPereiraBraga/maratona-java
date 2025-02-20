package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneMarcaComparator implements Comparator<Smartphone>{
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

class MangaPrecoComparator implements Comparator<Manga>{
    @Override
    public int compare(Manga manga1, Manga manga2) {
        return Double.compare(manga1.getPreco(), manga2.getPreco());
    }
}


public class NavigableSetTest01 {
    public static void main(String[] args) {
        //Usando TreeSet precisa implementar o Comparable
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneMarcaComparator());
        Smartphone smartphone = new Smartphone("123", "Nokia");
        set.add(smartphone);
        //Criando o Set e passando o Comparator pra ordenar
        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator());
        mangas.add(new Manga(4L,"Attack on titan",19.90));
        mangas.add(new Manga(2L,"Berserk", 7.0));
        mangas.add(new Manga(1L,"Hellsing", 50.0));
        mangas.add(new Manga(3L,"Pokemon", 30.00));
        mangas.add(new Manga(5L,"Dragon Ball Z Kai",25));
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println("----------------------------------------------");

        Manga yuyu = new Manga(21L,"Yu yu Hakusho", 10.0);
        // Ele pega o preco de Yuyu e pega o menor valor abaixo do dele
        System.out.println(mangas.lower(yuyu));
        // Retorna o maior preco que seja menor ou igual a yuyu.
        System.out.println(mangas.floor(yuyu));
        // Retorna o menor preco que seja maior que yuyu.
        System.out.println(mangas.higher(yuyu));
        //Retorna o menor preco que seja maior ou igual a yuyu.
        System.out.println(mangas.ceiling(yuyu));

        //pega o primeiro elemento do Set
        System.out.println(mangas.pollFirst());
        //pega o ultimo elemento do Set
        System.out.println(mangas.pollLast());


    }
}
