package academy.devdojo.maratonajava.javacore.ZZJcrud.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Conexao com o Banco de Dados
public class ConnectionFactory {
        public static Connection getConnection() throws SQLException {
            String url = "jdbc:mysql://localhost:3307/anime_store";
            String username = "root";
            String password = "root";
            return DriverManager.getConnection(url, username, password);
        }
}
