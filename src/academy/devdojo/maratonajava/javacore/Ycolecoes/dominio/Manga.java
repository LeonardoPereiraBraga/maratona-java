package academy.devdojo.maratonajava.javacore.Ycolecoes.dominio;

import java.util.Objects;
//Implementando Comparable pra poder usar sort em objetos
public class Manga implements Comparable<Manga> {
    private Long id;
    private String nome;
    private double preco;

    public Manga(Long id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Double.compare(preco, manga.preco) == 0 && Objects.equals(id, manga.id) && Objects.equals(nome, manga.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    //Fazendo o sort funcionar pelo ID
    @Override
    public int compareTo(Manga outroManga) {
        //negativo se o this < outromanga
        //se this.id == outroManga, return 0
        //positivo se this > outroManga
        if(this.id < outroManga.getId()){
            return -1;
        }
        else if(this.id.equals(outroManga.getId())){
            return 0;
        } else {
            return 1;
        }
        //Alternativa pro codigo acima
        //Funciona assim so pra Wrappers e tipos nao primitivos(Nosso id é Long que é Wrapper)
        //return this.id.compareTo(outroManga.getId());

    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }



}
