package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
    public static void main(String[] args) throws IOException {
        Path p1 = Paths.get("C:\\Users\\braga\\OneDrive\\Documentos\\maratona-java\\file.txt");
        Path p2 = Paths.get("C:\\Users\\braga\\OneDrive\\Documentos\\maratona-java\\file.txt");
        System.out.println(p1.getFileName().toFile());
        Path pastaPath = Paths.get("pasta3"); //Colocando nome da pasta a ser criada
        if(Files.notExists(pastaPath)){ //Se a pasta nao existe
            Path pastaDirectory = Files.createDirectory(pastaPath); //Criando Pasta
        }
        Path subPastaPath = Paths.get("pasta/subpasta/subsubpasta");
        Path subPastaDirectory = Files.createDirectories(subPastaPath); //Criando subPastas
    }
}
