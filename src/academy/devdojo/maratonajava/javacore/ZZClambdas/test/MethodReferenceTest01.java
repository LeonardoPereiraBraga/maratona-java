package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Reference to a static method
public class MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Zenkai", 43), new Anime("One Piece", 800), new Anime("Naruto", 400)));

        Collections.sort(animeList, (anime1,anime2) -> anime1.getTitle().compareTo(anime2.getTitle()));
        Collections.sort(animeList, (a1,a2) -> AnimeComparators.compareByTitle(a1,a2));
        Collections.sort(animeList, AnimeComparators::compareByTitle); //Usando MethodReference

        Collections.sort(animeList, AnimeComparators::comapareByEpisodes);
        System.out.println(animeList);

    }
}
