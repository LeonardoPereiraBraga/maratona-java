package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringPerformanceTest02 {
    public static void main(String[] args) {
        String nome = "William Suane";
        nome.concat(" DevDojo");
        System.out.println(nome);
        StringBuilder sb = new StringBuilder(16);
        sb.append("Academy");
        System.out.println(sb);



    }

}
