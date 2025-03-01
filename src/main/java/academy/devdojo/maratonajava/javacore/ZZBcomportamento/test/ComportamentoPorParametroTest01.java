package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {
    private static List<Car> cars = List.of(new Car("green", 2011),
            new Car("black", 1998),
            new Car("vermelho", 2019)
    );

    public static void main(String[] args) {
        System.out.println(filterGreenCar(cars));
        System.out.println(filterCarByColor(cars,"black"));
        System.out.println(filterByYear(cars,2015));



    }
    private static List<Car> filterGreenCar(List<Car> cars){
        List<Car> greenCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals("green")){
                greenCars.add(car);
            }
        }
        return greenCars;
    }
    private static List<Car> filterCarByColor(List<Car> cars, String color){
        List<Car> FilteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals(color)){
                FilteredCars.add(car);
            }
        }
        return FilteredCars;
    }
    private static List<Car> filterByYear(List<Car> cars, int year){
        List<Car> FilteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() < year){
                FilteredCars.add(car);
            }
        }
        return FilteredCars;
    }


}
