package academy.devdojo.maratonajava.javacore.ZZClambdas.test;


import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

//Reference to a constructor
public class MethodReferenceTest04 {
    public static void main(String[] args) {
        //Essas duas linhas é equivalente a AnimeComparators animeComparators = new AnimeComparators();
        Supplier<AnimeComparators> newaAnimeComparators = AnimeComparators::new;
        AnimeComparators animeComparators = newaAnimeComparators.get();

        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Zenkai", 43), new Anime("One Piece", 800), new Anime("Naruto", 400)));
        animeList.sort(animeComparators::comapareByEpisodesNonStatic);

        BiFunction<String, Integer , Anime> animeBiFunction = (title,episodes )-> new Anime(title,episodes);
        BiFunction<String, Integer , Anime> animeBiFunction2 = Anime::new;
        //Criando objeto do tipo Anime
        System.out.println(animeBiFunction2.apply("Super campeoes", 36));
    }
}
