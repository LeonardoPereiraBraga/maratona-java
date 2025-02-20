package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest01 {
    public static void main(String[] args) {
        //Tipo da chave e tipo do Valor
        Map<String, String> map = new HashMap<>();
        map.put("teklado", "teclado"); //Chave e valor
        map.put("mouze", "mouse");
        for(String key : map.keySet()){
            System.out.println(key + " - " + map.get(key));
        }

    }
}
