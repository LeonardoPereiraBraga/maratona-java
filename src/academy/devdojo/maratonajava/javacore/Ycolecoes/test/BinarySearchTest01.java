package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);
        Collections.sort(numeros);

        //A Lista precisa estar ordenada para usar a Busca Binaria
        //Lista Ordenada 0,2,3,4
        System.out.println(Collections.binarySearch(numeros, 2)); // Retorna 1 - que é o index do numero

    }
}
