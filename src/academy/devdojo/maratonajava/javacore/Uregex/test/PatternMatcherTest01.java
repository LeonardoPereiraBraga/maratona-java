package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest01 {
    public static void main(String[] args) {
        String regex = "ab"; //O que voce quer achar
        String texto = "abaaba"; //Onde voce quer procurar
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        while(matcher.find()){
            System.out.println(matcher.start() + " " + matcher.group() + "\n");
        }



    }
}
