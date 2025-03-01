package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;
import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.CarroRentavelService;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.RentalService;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest03 {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Fusca")));
        List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));
        //Esse Carro em RentalService<Carro> substitui todos os <T> por <Carro>
        RentalService<Carro> rentalService = new RentalService<>(carrosDisponiveis);
        RentalService<Barco> rentalService2 = new RentalService<>(barcosDisponiveis);
        rentalService.buscarObjetoDisponivel();
        rentalService2.buscarObjetoDisponivel();
    }
}
