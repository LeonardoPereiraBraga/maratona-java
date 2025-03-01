package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public interface DataLoader {
    void load();
    default void checkAnotherPermission(){
        System.out.println("Fazendo a checkagem de permissao");
    }

}
