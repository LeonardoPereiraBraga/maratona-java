package academy.devdojo.maratonajava.javacore.ZZDoptional.test;


import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repositorio.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {
        //Se achar Boku no hero muda o nome pra Boku no hero2
        Optional<Manga> mangaByTitle = MangaRepository.findByTitle2("Boku no hero");
        mangaByTitle.ifPresent(manga -> manga.setTitle("Boku no hero2"));
        //Procura por um manga pelo id e se nao achar da throw em um Erro
        Manga mangaById = MangaRepository.findById(2).orElseThrow(IllegalArgumentException::new);
        //Procura pelo titulo e se nao achar cria um novo Manga
        Manga newManga = MangaRepository.findByTitle2("Overlord").orElse(new Manga(3, "Dr Stone", 30));
        System.out.println(newManga);


    }
}
