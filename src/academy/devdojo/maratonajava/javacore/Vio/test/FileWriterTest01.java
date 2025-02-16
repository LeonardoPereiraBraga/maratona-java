package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try(FileWriter fw = new FileWriter(file, true);) { //true nao deleta o que ja tem no file
            fw.write("O devdojo é foda caralho2\n");
            fw.flush(); //força a gravaçao do counteudo
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
