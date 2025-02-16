package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest03 {
    public static void main(String[] args) {
        // [] = Exemplo [abc] vai procurar a posicao de qualquer a ou qualquer b ou qualquer c, separamente
        //String regex = "[a-zA-C]"; procura de a-z minusculo e depois de A a C maiusculo
        String regex = "0[xX][0-9a-fA-F]";
        String texto = "12 0x 0X 0xFFABC 0x109 0x1"; //Onde voce quer procurar
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        while(matcher.find()){
            System.out.println(matcher.start() + " " + matcher.group() + "\n");
        }




    }
}
