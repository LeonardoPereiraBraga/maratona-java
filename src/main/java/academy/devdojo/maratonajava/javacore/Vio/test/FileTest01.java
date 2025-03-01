package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class FileTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try {
            boolean IsCreated = file.createNewFile(); //Criar um arquivo
            boolean exists = file.exists(); //Verifica se o arquivo já existe
            System.out.println(file.getPath()); //
            System.out.println(file.getAbsolutePath());
            if(exists){
                file.delete(); //Deleta o arquivo
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
