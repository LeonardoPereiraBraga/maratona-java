package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListArrayConversaoTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        //Convertendo uma lista pra Array
        Integer[] listToArray = numeros.toArray(new Integer[0]);
        //Printando Array
        System.out.println(Arrays.toString(listToArray));
        System.out.println("-----------------------------------------");

        Integer[] numerosArray = new Integer[3];
        numerosArray[0] = 1;
        numerosArray[1] = 2;
        numerosArray[2] = 3;
        //Convertendo um Array pra List
        List<Integer> arrayToList = Arrays.asList(numerosArray);
        arrayToList.set(0,12);
        System.out.println(Arrays.toString(numerosArray));
        System.out.println(arrayToList);
        //Convertendo do jeito certo( pq do outro jeito vc nao consegue usar .add)
        List<Integer> numerosList = new ArrayList<>(Arrays.asList(numerosArray));

    }
}
