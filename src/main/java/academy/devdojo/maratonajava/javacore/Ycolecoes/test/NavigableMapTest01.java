package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest01 {
    public static void main(String[] args) {
        //TreeMap ordena automatico o map com base na Chave
        NavigableMap<String,String> map = new TreeMap<>();
        map.put("A", "Letra A");
        map.put("D", "Letra D");
        map.put("B", "Letra B");
        map.put("C", "Letra C");
        map.put("E", "Letra E");

        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        //Retorna todos elementos que estao abaixo da letra C
        System.out.println(map.headMap("C"));

    }
}
