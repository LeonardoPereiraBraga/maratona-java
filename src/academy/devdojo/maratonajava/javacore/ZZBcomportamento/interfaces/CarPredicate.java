package academy.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

//Predicate é uma função que recebe um argumento do tipo T e retorna um boolean
public interface CarPredicate {
    boolean test(Car car);
}
