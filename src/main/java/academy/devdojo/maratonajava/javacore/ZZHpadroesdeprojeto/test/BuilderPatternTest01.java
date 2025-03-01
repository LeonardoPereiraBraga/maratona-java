package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Pessoa;

public class BuilderPatternTest01 {
    public static void main(String[] args) {
        Pessoa build = new Pessoa.PessoaBuilder()
                .firstName("William")
                .lastName("Suane")
                .username("ViradoNoJiraya")
                .email("devdojo@gmail.com")
                .build();
        System.out.println(build);

    }
}
