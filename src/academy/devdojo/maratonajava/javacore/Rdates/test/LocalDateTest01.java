package academy.devdojo.maratonajava.javacore.Rdates.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class LocalDateTest01 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2022, Month.JANUARY, 27); //Ano,Mes,dia
        LocalDate agora = LocalDate.now();
        System.out.println(date); //Retorna:2022-01-27
        System.out.println(agora); //Retorna 2025-02-15 (Data atual)
        System.out.println(date.getYear()); //Retorna 2022
        System.out.println(date.getMonth()); //Retorna JANUARY
        System.out.println(date.getMonthValue()); //Retorna 1
        System.out.println(date.getDayOfWeek()); //Retorna THURSDAY
        System.out.println(date.getDayOfMonth()); // Retorna 27
        System.out.println(date.lengthOfMonth()); // Retorna 31
        System.out.println(date.isLeapYear()); // Retorna false (usa pra saber se o ano é bissexto)

    }
}
