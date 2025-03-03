package academy.devdojo.maratonajava.javacore.ZZJcrud.service;

import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.repository.AnimeRepository;

import java.util.List;
import java.util.Scanner;

public class AnimeService {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void buildMenu(int op){
        switch (op){
            case 1: findByName();break;
            default: throw new IllegalArgumentException("Not a valid option");
            case 2: delete(); break;
            case 3: save(); break;
            case 4: update(); break;
        }
    }
    private static void findByName(){
        System.out.println("Type the name or empty to all");
        String name = SCANNER.nextLine();
        List<Anime> animes = AnimeRepository.findByName(name);
        for (int i = 0; i < animes.size() ; i++) {
            System.out.printf("[%d] - %s%n", i, animes.get(i).getName());
        }
    }

    private static void delete(){
        System.out.println("Type one of the ids to delete");
        findByName();
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? S/N");
        String choice = SCANNER.nextLine();
        if("s".equalsIgnoreCase(choice)){
            AnimeRepository.delete(id);
        }
    }
    private static void save(){
        System.out.println("Type the name of the anime");
        String name = SCANNER.nextLine();
        System.out.println("Type the number of episodes of the anime");
        int episodes = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Type the id of the producer");
        Integer producerId = Integer.parseInt(SCANNER.nextLine());
        Anime anime = Anime.builder().episodes(episodes).name(name).producer(Producer.builder().id(producerId).build()).build();
        AnimeRepository.save(anime);
    }
    private static void update(){
        System.out.println("Type the id of the object");
        Anime animeFromDb = AnimeRepository.findById(Integer.parseInt(SCANNER.nextLine()));
        System.out.println(animeFromDb);
        System.out.println("Type the new name");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? animeFromDb.getName() : name;
        System.out.println("Type the new number of episodes");
        int episodes = Integer.parseInt(SCANNER.nextLine());
        Anime animeToUpdate = Anime.builder().id(animeFromDb.getId()).name(name).episodes(episodes).producer(animeFromDb.getProducer()).build();
        AnimeRepository.update(animeToUpdate);

    }



}
