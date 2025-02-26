package academy.devdojo.maratonajava.javacore.ZZEstreams.test;


import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest09 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1,50).filter(n -> n % 2 == 0).forEach(System.out::println);
        Stream.of("Eleve", " O", " Cosmo").map(String::toUpperCase).forEach(System.out::print);

        int num[] = {1,2,3,4,5};
        IntStream stream = Arrays.stream(num);
    }



    


    }


