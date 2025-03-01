package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonEager;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonLazy;

public class AircraftSingletonLazyTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
        System.out.println(AircraftSingletonEager.getINSTANCE());

    }
    private static void bookSeat(String seat){
        AircraftSingletonLazy AircraftSingletonLazy = academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonLazy.getINSTANCE();
        System.out.println(AircraftSingletonLazy);
        System.out.println(AircraftSingletonLazy.bookSeat(seat));

    }
}
