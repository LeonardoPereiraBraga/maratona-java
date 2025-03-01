package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public class DatabaseLoader implements DataLoader, DataRemover {
    @Override
    public void load() {
        System.out.println("Carregando dados");
    }

    @Override
    public void checkAnotherPermission() {
        System.out.println("Checking database");
    }

    @Override
    public void remove() {
        System.out.println("Removendo do Banco de dados");
    }
}
