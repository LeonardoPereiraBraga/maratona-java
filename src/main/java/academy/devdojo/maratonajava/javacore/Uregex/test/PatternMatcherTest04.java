package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest04 {
    public static void main(String[] args) {
       // ? Zero ou uma ocorrencia
        // * Zero ou mais ocorrencias
        //+ Uma ou mais ocorrencias
        // {n,m} de n até m
        // () Agrupamento
        // | significar ou, exemplo: o(v/c)o que pode retornar ovo ou oco
        // $ fim da linha
        String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
        String texto = "12 0x 0X 0xFFABC 0x10G 0x1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        while(matcher.find()){
            System.out.println(matcher.start() + " " + matcher.group() + "\n");
        }
       



    }
}
