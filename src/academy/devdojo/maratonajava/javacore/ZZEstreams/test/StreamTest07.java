package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class StreamTest07 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        //O valor 0 é o valor inicial, se nao tiver valor inicial pode retornar Optional
        Integer reduce = integers.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        //Pega o maior numero da List
        integers.stream().reduce((x,y) -> x > y ? x : y).ifPresent(System.out::println);

    }
    


    }


