package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest05 {
    public static void main(String[] args) {
       // ? Zero ou uma ocorrencia
        // * Zero ou mais ocorrencias
        //+ Uma ou mais ocorrencias
        // {n,m} de n até m
        // () Agrupamento
        // | significar ou, exemplo: o(v/c)o que pode retornar ovo ou oco
        // $ fim da linha
        // . Ex: 1.3 = 123, 133, 1@3, 1A3
        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        String texto = "luffy@hotmail.com, 123jotaro@gmail.com, #@!zoro@mail.br, teste@gmail.com.br , sakura@mail";
        System.out.println("#@!zoro@mail.br".matches(regex)); //Retorna um boolean falando se da match
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        while(matcher.find()){
            System.out.println(matcher.start() + " " + matcher.group() + "\n");
        }
       



    }
}
