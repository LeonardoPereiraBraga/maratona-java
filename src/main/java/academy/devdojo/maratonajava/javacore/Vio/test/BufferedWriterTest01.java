package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try(FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw)
        ) { //true nao deleta o que ja tem no file
            bw.write("O devdojo é foda caralho");
            bw.newLine(); //Quebra linha(melhor que \n porque nem todo sistema suporta)
            bw.flush(); //força a gravaçao do counteudo
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
