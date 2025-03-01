package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class StreamTest08 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shitarra", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo", 1.99),
            new LightNovel("Kumo", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));
    public static void main(String[] args) {
        lightNovels.stream().map(lightNovel -> lightNovel.getPrice()).filter(price -> price > 3).reduce(Double::sum).ifPresent(System.out::println);
        //Mais perfomatico
        double sum = lightNovels.stream().mapToDouble(lightNovels -> lightNovels.getPrice()).filter(price -> price > 3).sum();
        System.out.println(sum);

    }
    


    }


