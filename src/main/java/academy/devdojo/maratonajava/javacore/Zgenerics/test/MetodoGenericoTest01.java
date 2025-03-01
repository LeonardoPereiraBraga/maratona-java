package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;
import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;

import java.util.ArrayList;
import java.util.List;

public class MetodoGenericoTest01 {
    public static void main(String[] args) {
        List<Barco> barcoList = criarArrayComUmObjeto(new Barco("Canoa furada"));

    }
    //Classe generica que pode aceita qualuqer tipo e retorna Lista desse Tipo
    private static <T> List<T> criarArrayComUmObjeto(T t){
        return List.of(t);
    }

    //So aceita tipos que extends Comparabke
    private static <T extends Comparable> List<T> criarArrayComUmObjeto2(T t){
        return List.of(t);
    }
}

