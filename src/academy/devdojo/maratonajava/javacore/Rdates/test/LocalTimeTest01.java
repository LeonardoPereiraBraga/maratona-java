package academy.devdojo.maratonajava.javacore.Rdates.test;

import java.time.LocalTime;

public class LocalTimeTest01 {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(23,32,12);
        LocalTime timeNow = LocalTime.now();
        System.out.println(time); // Retorna 23:32:12
        System.out.println(time.getHour()); //Retorna 23
        System.out.println(time.getMinute()); //Retorna 32
        System.out.println(time.getSecond()); //Retorna 12
        System.out.println(timeNow); //Retorna 13:35:40.791258600 (Horario atual e segundos quebrados)

    }
}
