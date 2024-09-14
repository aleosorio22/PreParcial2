package umg.progra2.dao;

import umg.progra2.model.EquipoChampions;
import umg.progra2.utils.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquiposChampionsDao {

    public void insertarEquipo(EquipoChampions equipo) throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "INSERT INTO equipos_champions (nombre, pais, ciudad, estadio, fundacion, entrenador, web_oficial, facebook, twitter, instagram, patrocinador_principal) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, equipo.getNombre());
        ps.setString(2, equipo.getPais());
        ps.setString(3, equipo.getCiudad());
        ps.setString(4, equipo.getEstadio());
        ps.setInt(5, equipo.getFundacion());
        ps.setString(6, equipo.getEntrenador());
        ps.setString(7, equipo.getWebOficial());
        ps.setString(8, equipo.getFacebook());
        ps.setString(9, equipo.getTwitter());
        ps.setString(10, equipo.getInstagram());
        ps.setString(11, equipo.getPatrocinadorPrincipal());
        ps.executeUpdate();
        ps.close();
    }

    public List<EquipoChampions> obtenerTodos() throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "SELECT * FROM equipos_champions";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<EquipoChampions> lista = new ArrayList<>();
        while (rs.next()) {
            EquipoChampions equipo = new EquipoChampions(
                    rs.getInt("id_equipo"),
                    rs.getString("nombre"),
                    rs.getString("pais"),
                    rs.getString("ciudad"),
                    rs.getString("estadio"),
                    rs.getInt("fundacion"),
                    rs.getString("entrenador"),
                    rs.getString("web_oficial"),
                    rs.getString("facebook"),
                    rs.getString("twitter"),
                    rs.getString("instagram"),
                    rs.getString("patrocinador_principal")
            );
            lista.add(equipo);
        }
        rs.close();
        return lista;
    }

    public void actualizarEquipo(EquipoChampions equipo) throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "UPDATE equipos_champions SET nombre=?, pais=?, ciudad=?, estadio=?, fundacion=?, entrenador=?, web_oficial=?, facebook=?, twitter=?, instagram=?, patrocinador_principal=? WHERE id_equipo=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, equipo.getNombre());
        ps.setString(2, equipo.getPais());
        ps.setString(3, equipo.getCiudad());
        ps.setString(4, equipo.getEstadio());
        ps.setInt(5, equipo.getFundacion());
        ps.setString(6, equipo.getEntrenador());
        ps.setString(7, equipo.getWebOficial());
        ps.setString(8, equipo.getFacebook());
        ps.setString(9, equipo.getTwitter());
        ps.setString(10, equipo.getInstagram());
        ps.setString(11, equipo.getPatrocinadorPrincipal());
        ps.setInt(12, equipo.getIdEquipo());
        ps.executeUpdate();
        ps.close();
    }

    public void eliminarEquipo(int idEquipo) throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "DELETE FROM equipos_champions WHERE id_equipo=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idEquipo);
        ps.executeUpdate();
        ps.close();
    }

    public EquipoChampions obtenerPorId(int idEquipo) throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "SELECT * FROM equipos_champions WHERE id_equipo = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idEquipo);
        ResultSet rs = ps.executeQuery();

        EquipoChampions equipo = null;
        if (rs.next()) {
            equipo = new EquipoChampions(
                    rs.getInt("id_equipo"),
                    rs.getString("nombre"),
                    rs.getString("pais"),
                    rs.getString("ciudad"),
                    rs.getString("estadio"),
                    rs.getInt("fundacion"),
                    rs.getString("entrenador"),
                    rs.getString("web_oficial"),
                    rs.getString("facebook"),
                    rs.getString("twitter"),
                    rs.getString("instagram"),
                    rs.getString("patrocinador_principal")
            );
        }
        rs.close();
        ps.close();
        return equipo;
    }
}
