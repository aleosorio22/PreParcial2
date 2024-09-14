package umg.progra2.dao;

import umg.progra2.model.Datos;
import umg.progra2.utils.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatosDao {

    public void insertarDatos(Datos datos) throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "INSERT INTO tb_datos (nombre, apellido, departamento, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, datos.getNombre());
        ps.setString(2, datos.getApellido());
        ps.setString(3, datos.getDepartamento());
        ps.setDate(4, datos.getFechaNacimiento());
        ps.executeUpdate();
        ps.close();
    }

    public List<Datos> obtenerTodos() throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "SELECT * FROM tb_datos";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Datos> lista = new ArrayList<>();
        while (rs.next()) {
            Datos datos = new Datos(
                    rs.getInt("codigo"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("departamento"),
                    rs.getDate("fecha_nacimiento")
            );
            lista.add(datos);
        }
        rs.close();
        return lista;
    }

    public void actualizarDatos(Datos datos) throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "UPDATE tb_datos SET nombre=?, apellido=?, departamento=?, fecha_nacimiento=? WHERE codigo=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, datos.getNombre());
        ps.setString(2, datos.getApellido());
        ps.setString(3, datos.getDepartamento());
        ps.setDate(4, datos.getFechaNacimiento());
        ps.setInt(5, datos.getCodigo());
        ps.executeUpdate();
        ps.close();
    }

    public void eliminarDatos(int codigo) throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "DELETE FROM tb_datos WHERE codigo=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.executeUpdate();
        ps.close();
    }

    public Datos obtenerPorId(int id) throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "SELECT * FROM tb_datos WHERE codigo = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Datos datos = null;
        if (rs.next()) {
            datos = new Datos(
                    rs.getInt("codigo"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("departamento"),
                    rs.getDate("fecha_nacimiento")
            );
        }
        rs.close();
        ps.close();
        return datos;
    }
}
