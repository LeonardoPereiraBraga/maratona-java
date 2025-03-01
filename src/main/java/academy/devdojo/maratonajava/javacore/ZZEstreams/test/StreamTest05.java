package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest05 {
    public static void main(String[] args) {
        List<String> words = List.of("Gomu", "Gomu", "No", "Mi");
        String[] letters = words.get(0).split("");

        List<String[]> collect = words.stream().map(w -> w.split("")).collect(Collectors.toList());
        List<String> collect1 = words.stream()
                .map(w -> w.split(""))
                .flatMap(letter -> Arrays.stream(letter))
                .collect(Collectors.toList());
        System.out.println(collect1);


    }
}

