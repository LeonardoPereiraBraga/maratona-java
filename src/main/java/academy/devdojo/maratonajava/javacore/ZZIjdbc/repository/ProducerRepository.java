package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {
    public static void save(Producer producer){
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()
        ){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Database rows affected {}", rowsAffected ); //Log4j2
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void delete(int id){
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()
        ){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Database rows affected {}", rowsAffected ); //Log4j2
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update(Producer producer){
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s' WHERE (`id` = '%d');"
                .formatted(producer.getName(),producer.getId());
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()
        ){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Database rows affected {}", rowsAffected ); //Log4j2
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Producer> findAll(){
        String sql = "SELECT id,name FROM anime_store.producer;";
        List<Producer> producerList = new ArrayList<>();
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){

            while (rs.next()){ //Enquanto tiver um proximo elemento
                int id = rs.getInt("id"); //Pega pelo nome do campo
                String name = rs.getString("name"); //Pega pelo nome do campo
                Producer producer = Producer.builder().id(id).name(name).build();
                producerList.add(producer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producerList;
    }
    public static List<Producer> findByName(String name){
        String sql = "SELECT * FROM anime_store.producer where name like '%s';".formatted("%"+name+"%");
        List<Producer> producerList = new ArrayList<>();
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){

            while (rs.next()){ //Enquanto tiver um proximo elemento
                System.out.println(rs.getString("name"));
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
    public static void showProducerMetaData(){
        String sql = "SELECT * FROM anime_store.producer";
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println(columnCount);
            for (int i = 1; i <= columnCount ; i++) {
                System.out.println("Table name: " + metaData.getTableName(i));
                System.out.println("Column name: " + metaData.getColumnName(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void showDriverMetaData(){
        try(Connection conn = ConnectionFactory.getConnection();
        ){
            DatabaseMetaData dbMetaData = conn.getMetaData();
            if(dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)){
                System.out.println("Supports FORWARD ONLY");
                if(dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
                    System.out.println("And supports CONCUR_UPDATABLE");
                }
            }
            if(dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)){
                System.out.println("Supports TYPE_SCROLL_INSENSITIVE");
                if(dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
                    System.out.println("And supports CONCUR_UPDATABLE");
                }
            }if(dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)){
                System.out.println("Supports TYPE_SCROLL_SENSITIVE");
                if(dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
                    System.out.println("And supports CONCUR_UPDATABLE");
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showTypeScrollWorking(){
        String sql = "SELECT * FROM anime_store.producer;";
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);
        ){
            System.out.println(rs.last()); //Ultima linha
            Producer producer = Producer.builder().id(rs.getInt("id")).name("name").build();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
