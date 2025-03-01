package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("Aha uho o DevDojo");
        Optional<String> o2 = Optional.ofNullable(null);
        Optional<String> o3 = Optional.empty();
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);


        //Se nome nao existir empty vai ser Carlos, se existir vai ser William
        Optional<String> nameOptional = Optional.ofNullable(findName("William"));
        String empty = nameOptional.orElse("Carlos");
        System.out.println(empty);
    }
    //Nao é recomendado usar Optional como parametro e nem atributo
    private static String findName(String name){
        List<String> list = List.of("William", "DevDojo");
        int i = list.indexOf(name);
        if(i != 1){
            return list.get(i);
        }
        return null;
    }
}
