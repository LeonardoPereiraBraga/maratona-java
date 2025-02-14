package academy.devdojo.maratonajava.javacore.Oexception.dominio;

import java.io.File;
import java.io.FileNotFoundException;

public class Funcionario extends Pessoa {
    @Override
    public void salvar() throws LoginInvalidoException, FileNotFoundException {
        System.out.println("Salvando Funcionario");
    }
}
