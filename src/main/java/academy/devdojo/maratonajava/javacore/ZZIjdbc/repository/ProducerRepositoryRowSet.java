package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.listener.CustomRowSetListener;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepositoryRowSet {
    public static List<Producer> findByNameJdbcRowSet(String name){
        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        List<Producer> producers = new ArrayList<>();
        try(JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setString(1, name);
            jrs.execute(); //Usar apenas para buscar dados
            while(jrs.next()){
                Producer producer = Producer.builder().id(jrs.getInt("id")).name(jrs.getString("name")).build();
                producers.add(producer);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return producers;
    }
    public static void updateJdbcRowSet(Producer producer){
        String sql = "SELECT * FROM anime_store.producer WHERE (`id` = ?);";
        try(JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setInt(1, producer.getId());
            jrs.execute(); //Usar apenas para buscar dados
            if(!jrs.next()) return;
            jrs.updateString("name", producer.getName()); //Muda o nome
            jrs.updateRow(); //Comitta a mudança
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void updateCachedRowSet(Producer producer){
        String sql = "SELECT * FROM producer WHERE (`id` = ?);";
        try(CachedRowSet crs = ConnectionFactory.getCachedRowSet();
            Connection connection = ConnectionFactory.getConnection();
        ){
            connection.setAutoCommit(false);
//            crs.addRowSetListener(new CustomRowSetListener());
            crs.setCommand(sql);
            crs.setInt(1, producer.getId());
            crs.execute(connection); //Usar apenas para buscar dados
            if(!crs.next()) return;
            crs.updateString("name", producer.getName()); //Muda o nome
            crs.updateRow(); //Comitta a mudança
            crs.acceptChanges();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


}
