package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws IOException {
        File fileDiretorio = new File("pasta");
        boolean isDiretorioCriado = fileDiretorio.mkdir(); //Cria a pasta
        File fileArquivoDiretorio = new File(fileDiretorio, "arquivo.txt"); //Pasta e nome do arquivo
        fileArquivoDiretorio.createNewFile(); //Cria arquivo na pasta
        File fileRenamed = new File(fileDiretorio,"arquivo_renomeado.txt");
        fileArquivoDiretorio.renameTo(fileRenamed); //Renomeando arquivo
        File diretorioRenamed = new File("pasta2");
        fileDiretorio.renameTo(diretorioRenamed); //Renomeando pasta

    }
}
