package academy.devdojo.maratonajava.javacore.ZZDoptional.repositorio;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {
    private static List<Manga> mangas = List.of(new Manga(1,"Boku no hero", 50), new Manga(2,"Overlord", 15));

    public static Optional<Manga> findByTitle(String title){
        Manga found = null;
        for (Manga manga : mangas) {
            if(manga.getTitle().equals(title)){
                found = manga;
            }
        }
        return Optional.ofNullable(found);
    }

    public static Optional<Manga> findByTitle2(String title){
        return findBy(manga -> manga.getTitle().equals(title));
    }

    public static Optional<Manga> findById(Integer id){
        return  findBy(manga -> manga.getId().equals(id));
    }

    public static Optional<Manga> findBy(Predicate<Manga> predicate){
        Manga found = null;
        for (Manga manga : mangas) {
            if(predicate.test(manga)){
                found = manga;
            }
        }
        return Optional.ofNullable(found);
    }
}
