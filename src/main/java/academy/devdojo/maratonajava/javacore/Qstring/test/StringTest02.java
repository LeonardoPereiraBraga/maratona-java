package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest02 {
    public static void main(String[] args) {
        String nome = "Luffy";
        System.out.println(nome.charAt(0)); //Retorna L
        System.out.println(nome.length()); // Retorna 5
        System.out.println(nome.replace("f","l")); //Retorna Lully
        System.out.println(nome.toLowerCase()); //Retorna luffy
        System.out.println(nome.toUpperCase()); //Retorna LUFFY
        System.out.println(nome.substring(0,2)); //Retorna Lu
        System.out.println(nome.trim()); //Tira todos os espaços
        

    }
}
