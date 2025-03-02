package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerService;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerServiceRowSet;

import java.util.List;

public class ConnectionFactoryTest03 {
    public static void main(String[] args) {
        Producer producer1 = Producer.builder().name("mendes").build();
        Producer producer2 = Producer.builder().name("carlos").build();
        Producer producer3 = Producer.builder().name("dragon").build();
        ProducerService.saveTransaction(List.of(producer1,producer2,producer3));
    }
}
