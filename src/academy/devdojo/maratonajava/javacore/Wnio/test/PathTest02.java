package academy.devdojo.maratonajava.javacore.Wnio.test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest02 {
    public static void main(String[] args) throws IOException {
        Path pastaPath = Paths.get("pasta3"); //Colocando nome da pasta a ser criada
        if(Files.notExists(pastaPath)){ //Se a pasta nao existe
            Path pastaDirectory = Files.createDirectory(pastaPath); //Criando Pasta
        }
        Path subPastaPath = Paths.get("pasta/subpasta/subsubpasta");
        Path subPastaDirectory = Files.createDirectories(subPastaPath); //Criando subPastas
        Path filePath = Paths.get(subPastaPath.toString(), "file.txt"); //Nome do arquivo e diretorio
        if(Files.notExists(filePath)){
            Path filePathCreated = Files.createFile(filePath); //Criando arquivo
        }
        Path source = filePath;
        Path target = Paths.get(filePath.getParent().toString(), "file_renamed.txt");
        Files.copy(source,target, StandardCopyOption.REPLACE_EXISTING);



    }
}
