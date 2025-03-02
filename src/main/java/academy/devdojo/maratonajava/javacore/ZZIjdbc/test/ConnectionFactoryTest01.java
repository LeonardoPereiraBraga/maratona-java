package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepository;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerService;

public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("mendes").build();
        Producer producerToUpdate = Producer.builder().name("MENDES").id(16).build();
        //ProducerService.save(producer);
        //ProducerService.delete(14);
        //ProducerService.update(producerToUpdate);
//        System.out.println(ProducerService.findAll());
//        System.out.println(ProducerService.findByName("MadHouse"));
//        ProducerService.showProducerMetaData();
//        ProducerService.showDriverMetaData();
//        ProducerService.showTypeScrollWorking();
        ProducerService.findByNameAndUpdateToUpperCase("José");
        System.out.println(ProducerService.findByNameAndInsertWhenNotFound("mendess"));
        ProducerService.findByNameAndDelete("José");
        System.out.println(ProducerService.findByNamePreparedStatement("mendes"));
        ProducerService.updatePreparedStatement(producerToUpdate);
        System.out.println(ProducerService.findByNameCallableStatement("mendes"));

    }
}

