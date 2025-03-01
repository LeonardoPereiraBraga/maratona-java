package academy.devdojo.maratonajava.javacore.ZZEstreams.test;


import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
        Stream.iterate(1, n -> n + 2).limit(10).forEach(System.out::println);

        //Gerador de numeros aleatorios
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Stream.generate(() -> random.nextInt(1,500)) //Gerar numeros entre 1 e 500
                .limit(90) //Limite para nao ficar infinitamente
                .forEach(System.out::println);

    }
    }


