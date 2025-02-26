package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.List;

public class StreamTest04 {
    public static void main(String[] args) {
        List<List<String>> devdojo = new ArrayList<>();
        List<String> grapichDesigners = List.of("Wildnei Suane", "Catarina Santos", "Sandy");
        List<String> developers = List.of("William", "David");
        List<String> students = List.of("Édipo", "Gustavo");
        devdojo.add(grapichDesigners);
        devdojo.add(developers);
        devdojo.add(students);
        for (List<String> people : devdojo) {
            for (String person : people) {
                System.out.println(person);
            }
        }
        devdojo.stream().flatMap(l -> l.stream()).forEach(elemento -> System.out.println(elemento));



    }
}

