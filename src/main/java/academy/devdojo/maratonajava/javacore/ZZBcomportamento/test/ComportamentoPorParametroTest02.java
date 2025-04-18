package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;
import academy.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest02 {
    private static List<Car> cars = List.of(new Car("green", 2011),
            new Car("black", 1998),
            new Car("vermelho", 2019)
    );

    public static void main(String[] args) {
        List<Car> greenCars = filter(cars, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("green");
            }
        });
        System.out.println(greenCars);

    }
    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate){
        List<Car> FilteredCars = new ArrayList<>();
        for (Car car : cars) {
            if(carPredicate.test(car)){
                FilteredCars.add(car);
            }
        }
        return FilteredCars;
    }
}
