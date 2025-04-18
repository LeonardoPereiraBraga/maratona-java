package academy.devdojo.maratonajava.javacore.ZZIjdbc.conn;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
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
        //Connected RowSet
        public static JdbcRowSet getJdbcRowSet() throws SQLException {
            String url = "jdbc:mysql://localhost:3307/anime_store";
            String username = "root";
            String password = "root";
            JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRowSet.setUrl(url);
            jdbcRowSet.setUsername(username);
            jdbcRowSet.setPassword(password);
            return jdbcRowSet;
        }
        public static CachedRowSet getCachedRowSet() throws SQLException {
            String url = "jdbc:mysql://localhost:3307/anime_store";
            String username = "root";
            String password = "root";
            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.setUrl(url);
            cachedRowSet.setUsername(username);
            cachedRowSet.setPassword(password);
            return cachedRowSet;
        }
}
