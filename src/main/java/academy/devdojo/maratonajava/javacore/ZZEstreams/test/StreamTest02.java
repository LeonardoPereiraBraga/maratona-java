package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Jeito moderno usando Streams
public class StreamTest02 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shitarra", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Fumo", 1.99),
            new LightNovel("Monogatari", 4.00)
            ));

    //Operaçoes intermedias sao acoes que sao feitas em um stream que retorna outro stream
    public static void main(String[] args) {
        List<String> titles = lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle)) //Ordenando pelo nome
                .filter(lightNovel -> lightNovel.getPrice() <= 4) //Filtrando pelo preço
                .limit(3) //Limitando o tamanho
                .map(lightNovel -> lightNovel.getTitle()) //Extraindo apenas os titulos
                .collect(Collectors.toList()); //Transformando em Lista - Operaçao Final
        System.out.println(titles);

    }

}
