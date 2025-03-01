package academy.devdojo.maratonajava.javacore.ZZClambdas.service;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;

public class AnimeComparators {
    public static int compareByTitle(Anime anime1, Anime anime2){
        return anime1.getTitle().compareTo(anime2.getTitle());
    }
    public static int comapareByEpisodes(Anime anime1, Anime anime2){
        return Integer.compare(anime1.getEpisodes(), anime2.getEpisodes());
    }

    public  int comapareByEpisodesNonStatic(Anime anime1, Anime anime2){
        return Integer.compare(anime1.getEpisodes(), anime2.getEpisodes());
    }

}
