package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Quando voce fecha um stream voce precisa abrir ele de novo com .stream()
//Precisa implementar equals e hashCode pro distinct() funcionar
public class StreamTest03 {
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
        Stream<LightNovel> stream = lightNovels.stream();
        //Contando a quantidade de preços que sao menores que 4
        long count = stream.filter(lightNovel -> lightNovel.getPrice() <= 4).count();
        //Contando a quantidade so que sem elementos duplicados agora
        long count2 = lightNovels.stream().distinct().filter(lightNovel -> lightNovel.getPrice() <= 4).count();
        System.out.println(count);
        System.out.println(count2);



    }


    }

