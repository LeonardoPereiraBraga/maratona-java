package academy.devdojo.maratonajava.javacore.ZZJcrud.dominio;

import lombok.Builder;
import lombok.Value;


//Usando Lombok que gera Getters e Setters Hashcode Builder e tudo mais por Anotaçao


@Value
@Builder
public class Producer {
    Integer id;
    String name;

}
