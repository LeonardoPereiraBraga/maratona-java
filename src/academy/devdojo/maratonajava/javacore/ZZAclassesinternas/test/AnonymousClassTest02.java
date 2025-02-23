package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class BarcoNameComparator implements Comparator<Barco>{
    @Override
    public int compare(Barco o1, Barco o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}

public class AnonymousClassTest02 {
    public static void main(String[] args) {
        List<Barco> barcoList = new ArrayList<>(List.of(new Barco("Zanoa Furada"), new Barco("Lancha"))) ;
        //Usando classe anonima
        barcoList.sort(new Comparator<Barco>() {
            @Override
            public int compare(Barco o1, Barco o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        //Mesma coisa do que usando Lambda
        barcoList.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
        System.out.println(barcoList);

    }
}
