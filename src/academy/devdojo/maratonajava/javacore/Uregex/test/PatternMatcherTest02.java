package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest02 {
    public static void main(String[] args) {
        // \d = Todos os digitos
        // \D = Tudo o que nao for digito
        // \s = Espaços em branco
        // \S = Todos os caracteres excluindo os brancos
        // \w = a-z A-Z, digitos, _
        // \W = Tudo o que nao for incluso no \w
        String regex = "\\d"; //O que voce quer achar
        String texto = "hhj212gvh21kh2"; //Onde voce quer procurar
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        while(matcher.find()){
            System.out.println(matcher.start() + " " + matcher.group() + "\n");
        }



    }
}
