package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerServiceRowSet;

public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().id(1).name("MadHouseUPADO2").build();
        System.out.println(ProducerServiceRowSet.findByNameJdbcRowSet("mendes"));
        ProducerServiceRowSet.updateCachedRowSet(producer   );
    }
}
