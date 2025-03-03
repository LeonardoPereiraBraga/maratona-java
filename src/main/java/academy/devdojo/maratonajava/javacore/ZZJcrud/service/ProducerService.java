package academy.devdojo.maratonajava.javacore.ZZJcrud.service;

import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.repository.ProducerRepository;

import java.util.List;
import java.util.Scanner;

public class ProducerService {
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
        List<Producer> producers = ProducerRepository.findByName(name);
        for (int i = 0; i < producers.size() ; i++) {
            System.out.printf("[%d] - %s%n", i, producers.get(i).getName());
        }
    }

    private static void delete(){
        System.out.println("Type one of the ids to delete");
        findByName();
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? S/N");
        String choice = SCANNER.nextLine();
        if("s".equalsIgnoreCase(choice)){
            ProducerRepository.delete(id);
        }
    }
    private static void save(){
        System.out.println("Type the name of the producer");
        String name = SCANNER.nextLine();
        Producer producer = Producer.builder().name(name).build();
        ProducerRepository.save(producer);
    }
    private static void update(){
        System.out.println("Type the id of the object");
        Producer producerFromDb = ProducerRepository.findById(Integer.parseInt(SCANNER.nextLine()));
        System.out.println(producerFromDb);
        System.out.println("Type the new name");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? producerFromDb.getName() : name;
        Producer producerToUpdate = Producer.builder().id(producerFromDb.getId()).name(name).build();
        ProducerRepository.update(producerToUpdate);

    }



}
