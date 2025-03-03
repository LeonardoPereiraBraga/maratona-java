package academy.devdojo.maratonajava.javacore.ZZJcrud.repository;


import academy.devdojo.maratonajava.javacore.ZZJcrud.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class AnimeRepository {

    public static List<Anime> findByName(String name){
        log.info("Finding Anime by name");
        String sql = "SELECT * FROM anime_store.anime where name like ?;";
        List<Anime> animes = new ArrayList<>();
        //Sempre que abre conexao precisa fechar entao usamos try with resources
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = createPrepareStatmenteFindByName(conn, name);
            ResultSet rs = ps.executeQuery();
        ){
            while (rs.next()){ //Enquanto tiver um proximo elemento
                Producer producer = Producer.builder().name("producer_name").id(rs.getInt("producer_id")).build();
                int tempid = rs.getInt("id"); //Pega pelo nome do campo
                String tempname = rs.getString("name"); //Pega pelo nome do campo
                int tempEpisodes = rs.getInt("episodes");
                Anime anime = Anime.builder()
                        .id(tempid)
                        .name(tempname)
                        .episodes(tempEpisodes)
                        .producer(producer)
                        .build();
                animes.add(anime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animes;
    }
    public static Anime findById(Integer id) {
        log.info("Finding Anime by id");
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatmenteFindById(conn, id);
             ResultSet rs = ps.executeQuery()) {
            if (!rs.next()) throw new IllegalArgumentException("ID does not exist");
            Producer producer = Producer.builder().name("producer_name").id(rs.getInt("producer_id")).build();
            int tempid = rs.getInt("id"); //Pega pelo nome do campo
            String tempname = rs.getString("name"); //Pega pelo nome do campo
            int tempEpisodes = rs.getInt("episodes");
            Anime anime = Anime.builder()
                    .id(tempid)
                    .name(tempname)
                    .episodes(tempEpisodes)
                    .producer(producer)
                    .build();
            return anime;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


        private static PreparedStatement createPrepareStatmenteFindById (Connection connection, Integer id) throws
        SQLException {
            String sql = """
                    SELECT a.id, a.name, a.episodes, a.producer_id,p.name as 'producer_name' FROM anime_store.anime a inner join
                    anime_store.producer p on a.producer_id = p.id
                    where a.id like ?;
                    """;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id); //Primeiro ? vai ser substituido por name
            return ps;
        }
        private static PreparedStatement createPrepareStatmenteFindByName (Connection connection, String name) throws
        SQLException {
            String sql = """
                    SELECT a.id, a.name, a.episodes, a.producer_id,p.name as 'producer_name' FROM anime_store.anime a inner join
                    anime_store.producer p on a.producer_id = p.id
                    where a.name like ?;
                    """;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, String.format("%%%s%%", name)); //? vai ser substituido por name
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
            String sql = "DELETE FROM `anime_store`.`anime` WHERE (`id` = ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id); //Primeiro ? vai ser substituido por name
            return ps;
        }
        public static void save (Anime anime){
            log.info("Insert Anime");
            //Sempre que abre conexao precisa fechar entao usamos try with resources
            try (Connection conn = ConnectionFactory.getConnection();
                 PreparedStatement ps = createPrepareStatementSave(conn, anime);
            ) {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private static PreparedStatement createPrepareStatementSave (Connection connection, Anime anime) throws
        SQLException {
            String sql = "INSERT INTO `anime_store`.`anime` (`name`, `episodes`, `producer_id`) VALUES (?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, anime.getName());
            ps.setInt(2, anime.getEpisodes());
            ps.setInt(3, anime.getProducer().getId());
            return ps;
        }
    public static void update(Anime anime){
        log.info("Updating anime");
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = createPreparedStatementUpdate(conn, anime);
        ){
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static PreparedStatement createPreparedStatementUpdate(Connection connection, Anime anime) throws SQLException {
        String sql = "UPDATE `anime_store`.`anime` SET `name` = ?, `episodes` = ? WHERE (`id` = ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, anime.getName());
        ps.setInt(2, anime.getEpisodes());
        ps.setInt(2, anime.getId());
        return ps;
    }

}
