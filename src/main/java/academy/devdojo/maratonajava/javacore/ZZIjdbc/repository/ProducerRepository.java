package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {
    public static void saveTransaction(List<Producer> producers){
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
        ){
            conn.setAutoCommit(false);
            preparedStatementSaveTransaction(conn,producers);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void preparedStatementSaveTransaction(Connection connection,List<Producer> producers) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);";
        for(Producer p : producers){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setString(1, p.getName());
                ps.execute();
            }catch (SQLException e){
                e.printStackTrace();
            }

        }



    }

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

    public static void updatePreparedStatement(Producer producer){
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = preparedStatementUpdate(conn, producer);
        ){
            int rowsAffected = ps.executeUpdate();
            log.info("Database rows affected {}", rowsAffected ); //Log4j2
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static PreparedStatement preparedStatementUpdate(Connection connection,Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, producer.getName());
        ps.setInt(2, producer.getId());
        return ps;
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
    public static List<Producer> findByNameAndUpdateToUpperCase(String name){
        String sql = "SELECT * FROM anime_store.producer where name like '%s';".formatted("%"+name+"%");
        List<Producer> producerList = new ArrayList<>();
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);
        ){

            while (rs.next()){ //Enquanto tiver um proximo elemento
                rs.updateString("name", rs.getString("name").toUpperCase());
                // rs.cancelRowUpdates(); //Cancela o updateString
                rs.updateRow(); //precisa disso pra realmente dar updateString
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
    public static List<Producer> findByNameAndInsertWhenNotFound(String name){
        String sql = "SELECT * FROM anime_store.producer where name like '%s';".formatted("%"+name+"%");
        List<Producer> producerList = new ArrayList<>();
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);
        ){
            if(rs.next()) return producerList;
                rs.moveToInsertRow(); //Vai pra proxima linha que é vazia e temporaria
                rs.updateString("name", name); //Coloca o nome na linha
                rs.insertRow(); //e Inseri
                rs.beforeFirst();
                rs.next();
                int tempId = rs.getInt("id");
                String tempName = rs.getString("name");
                Producer producerBuild = Producer.builder().id(tempId).name(tempName).build();
                producerList.add(producerBuild);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producerList;
    }public static void findByNameAndDelete(String name){
        String sql = "SELECT * FROM anime_store.producer where name like '%s';".formatted("%"+name+"%");
        List<Producer> producerList = new ArrayList<>();
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);
        ){
            while(rs.next()){
                System.out.println("Deletando: " + rs.getString("name"));
                rs.deleteRow();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //PreparedStatement é mais perfomatico e protege de SQL Injection
    public static List<Producer> findByNamePreparedStatement(String name){
        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        List<Producer> producerList = new ArrayList<>();
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = preparedStatementFindByName(conn, name);
            ResultSet rs = ps.executeQuery();
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
    public static List<Producer> findByNameCallableStatement(String name){
        List<Producer> producerList = new ArrayList<>();
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = CallableStatementFindByName(conn, name);
            ResultSet rs = ps.executeQuery();
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

    private static PreparedStatement preparedStatementFindByName(Connection connection,String name) throws SQLException {
        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, name); //Primeiro ? vai ser substituido por name
        return ps;
    }
    //  CallableStatement usado para Stored Procedures
    private static CallableStatement CallableStatementFindByName(Connection connection,String name) throws SQLException {
        String sql = "CALL `anime_store`.`sp_get_producer_by_name`(?);";
        CallableStatement cs = connection.prepareCall(sql);
        cs.setString(1, name);
        return cs;
    }
}
