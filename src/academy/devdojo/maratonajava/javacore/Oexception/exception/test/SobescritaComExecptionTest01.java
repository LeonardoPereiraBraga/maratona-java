package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import academy.devdojo.maratonajava.javacore.Oexception.dominio.Funcionario;
import academy.devdojo.maratonajava.javacore.Oexception.dominio.LoginInvalidoException;
import academy.devdojo.maratonajava.javacore.Oexception.dominio.Pessoa;

import java.io.File;
import java.io.FileNotFoundException;

public class SobescritaComExecptionTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Funcionario funcionario = new Funcionario();

        try {
            funcionario.salvar();
        } catch (LoginInvalidoException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
