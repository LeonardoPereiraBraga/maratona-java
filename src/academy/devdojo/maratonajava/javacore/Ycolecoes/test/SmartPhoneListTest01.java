package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class SmartPhoneListTest01 {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABC1", "Iphone");
        Smartphone s2 = new Smartphone("BBBBB", "Phone");
        Smartphone s3 = new Smartphone("CCCCC", "Samsumg");
        List<Smartphone> smartphones = new ArrayList<>();
        smartphones.add(s1);
        smartphones.add(s2);
        smartphones.add(0,s3); //Adiciona no index 0 e nao no final da lista
//        smartphones.clear(); //Deleta tudo
        for (Smartphone smartphone : smartphones) {
            System.out.println(smartphone.toString());
        }
        Smartphone s4 = new Smartphone("BBBBB", "Phone");
        System.out.println(smartphones.contains(s4)); //Retorna true, se baseia no equals
        System.out.println(smartphones.indexOf(s4)); //Retorna o index que procuramos

    }
}
