package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class RuntimeExceptionTest03 {
    public static void main(String[] args) {
        try{
            System.out.println("Abrindo arquivo");
            System.out.println("Escrevendo dados no arquivo");
            throw  new RuntimeException();
        }catch(Exception exception){
            exception.printStackTrace();
        } finally {
            System.out.println("Fechando o arquivo");
        }

    }




    }


