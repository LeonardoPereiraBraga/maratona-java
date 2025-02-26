package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest06 {
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
        //Existe alguem que o preco é maior que 8?
        System.out.println(lightNovels.stream().anyMatch(ln -> ln.getPrice() > 8));
        //Todos os elementos tem o preco maior que 0?
        System.out.println(lightNovels.stream().allMatch(ln -> ln.getPrice() > 0));
        //Ninguem é maior que 0?
        System.out.println(lightNovels.stream().noneMatch(ln -> ln.getPrice() > 0));
        //findAny retorna um Optional
        lightNovels.stream().filter(ln -> ln.getPrice() > 3).findAny().ifPresent(System.out::println);


    }
}

