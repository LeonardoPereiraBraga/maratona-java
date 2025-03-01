package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;


public class LambdasTest02 {
    public static void main(String[] args) {
        List<String> strings = List.of("Natsu", "Allucard");
        List<Integer> integers = map(strings, (String s) -> s.length());

        //Mesma coisa so que Sintaxes diferentes
        List<String> map = map(strings, (s) -> s.toUpperCase()); //Lambda
        List<String> map2 = map(strings, String::toUpperCase); //MethodReference
        System.out.println(integers);
        System.out.println(map);

    }
    //T - Tipo, R - Tipo Retorno - Funcao que pega o tamanho de cada palavra da List
    private static <T,R> List<R> map(List<T> list, Function<T,R> function){
        List<R> result = new ArrayList<>();
        for(T e: list){
            R r = function.apply(e);
            result.add(r);
        }
        return result;
    }

}
