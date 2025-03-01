package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("William Suane");
        Consumidor consumidor2 = new Consumidor("devDojo");
        Manga manga1 = new Manga(1L, "Hellsing", 5.0);
        Manga manga2 = new Manga(2L,"Berserk", 10.0);
        Manga manga3 = new Manga(3L,"Pokemon", 30.00);
        Manga manga4 = new Manga(4L,"Attack on titan",19.90);
        Manga manga5 = new Manga(5L,"Dragon Ball Z Kai",25);
        Map<Consumidor, Manga> consumidorManga = new HashMap<>();
        consumidorManga.put(consumidor1, manga1);
        consumidorManga.put(consumidor2, manga2);
        for (Map.Entry<Consumidor, Manga> entry : consumidorManga.entrySet()){
            System.out.println(entry.getKey().getNome() + " - " + entry.getValue().getNome());
        }

    }
}
