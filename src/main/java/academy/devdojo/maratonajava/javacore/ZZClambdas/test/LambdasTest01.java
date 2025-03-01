package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

//Lambdas sao anonimas e sao funcoes
//Podemos usar lambdas em qualquer interface que seja InterfaceFuncional

public class LambdasTest01 {
    public static void main(String[] args) {
        List<String> strings = List.of("William", "Suane", "Luffy", "Zoro");
        printList(strings, (String s) -> System.out.println(s));

    }

    private static <T> void printList(List<T> lista, Consumer<T> consumer){
        for(T item : lista){
            consumer.accept(item);
        }
    }

}
