package academy.devdojo.maratonajava.javacore.ZZJcrud.repository;



import academy.devdojo.maratonajava.javacore.ZZJcrud.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {

    public static List<Producer> findByName(String name){
        log.info("Finding Producer by name");
        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        List<Producer> producerList = new ArrayList<>();
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = createPrepareStatmenteFindByName(conn, name);
            ResultSet rs = ps.executeQuery();
        ){
            while (rs.next()){ //Enquanto tiver um proximo elemento
                int id = rs.getInt("id"); //Pega pelo nome do campo
                String tempname = rs.getString("name"); //Pega pelo nome do campo
                Producer producer = Producer.builder().id(id).name(tempname).build();
                producerList.add(producer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producerList;
    }
    public static Producer findById(Integer id) {
        log.info("Finding Producer by id");
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatmenteFindById(conn, id);
             ResultSet rs = ps.executeQuery()) {
            if (!rs.next()) throw new IllegalArgumentException("ID does not exist");
            return Producer.
                    builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


        private static PreparedStatement createPrepareStatmenteFindById (Connection connection, Integer id) throws
        SQLException {
            String sql = "SELECT * FROM anime_store.producer where id like ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id); //Primeiro ? vai ser substituido por name
            return ps;
        }
        private static PreparedStatement createPrepareStatmenteFindByName (Connection connection, String name) throws
        SQLException {
            String sql = "SELECT * FROM anime_store.producer where name like ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name); //Primeiro ? vai ser substituido por name
            return ps;
        }

        public static void delete ( int id){

            //Sempre que abre conexao precisa fechar entao usamos try with resources
            try (Connection conn = ConnectionFactory.getConnection();
                 PreparedStatement ps = createPrepareStatmenteDelete(conn, id);
            ) {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private static PreparedStatement createPrepareStatmenteDelete (Connection connection, Integer id) throws
        SQLException {
            String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id); //Primeiro ? vai ser substituido por name
            return ps;
        }
        public static void save (Producer producer){
            log.info("Insert Producer");
            //Sempre que abre conexao precisa fechar entao usamos try with resources
            try (Connection conn = ConnectionFactory.getConnection();
                 PreparedStatement ps = createPrepareStatementSave(conn, producer);
            ) {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private static PreparedStatement createPrepareStatementSave (Connection connection, Producer producer) throws
        SQLException {
            String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, producer.getName());
            return ps;
        }
    public static void update(Producer producer){
        log.info("Updating producer");
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = createPreparedStatementUpdate(conn, producer);
        ){
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static PreparedStatement createPreparedStatementUpdate(Connection connection, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, producer.getName());
        ps.setInt(2, producer.getId());
        return ps;
    }

}
