package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {
    public static void main(String[] args) {
        //Primeiro a entrar a primeira a sair
        Queue<String> fila = new PriorityQueue<>();
        fila.add("C");
        fila.add("A");
        fila.add("B");
        //Enquanto nao estiver vazio remove o primeiro elemento
        while (!fila.isEmpty()){
            System.out.println(fila.poll());
        }
        System.out.println(fila);

    }
}
