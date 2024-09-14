package umg.progra2.dao;

import umg.progra2.model.Usuario;
import umg.progra2.utils.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDao {

    public void insertarUsuario(Usuario usuario) throws SQLException {
        if (!correoDuplicado(usuario.getCorreo())) {
            Connection connection = Conexion.getConnection();
            String sql = "INSERT INTO tb_usuarios (carne, nombre, correo, seccion, telegramid, activo) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getCarne());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getSeccion());
            ps.setLong(5, usuario.getTelegramId());
            ps.setString(6, usuario.getActivo());
            ps.executeUpdate();
            ps.close();
        } else {
            System.out.println("Correo ya registrado");
        }
    }

    private boolean correoDuplicado(String correo) throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "SELECT COUNT(*) FROM tb_usuarios WHERE correo = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, correo);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    public List<Usuario> obtenerTodos() throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "SELECT * FROM tb_usuarios";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Usuario> lista = new ArrayList<>();
        while (rs.next()) {
            Usuario usuario = new Usuario(
                    rs.getInt("idusuario"),
                    rs.getString("carne"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("seccion"),
                    rs.getLong("telegramid"),
                    rs.getString("activo")
            );
            lista.add(usuario);
        }
        rs.close();
        return lista;
    }

    public void actualizarUsuario(Usuario usuario) throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "UPDATE tb_usuarios SET carne=?, nombre=?, correo=?, seccion=?, telegramid=?, activo=? WHERE idusuario=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, usuario.getCarne());
        ps.setString(2, usuario.getNombre());
        ps.setString(3, usuario.getCorreo());
        ps.setString(4, usuario.getSeccion());
        ps.setLong(5, usuario.getTelegramId());
        ps.setString(6, usuario.getActivo());
        ps.setInt(7, usuario.getIdUsuario());
        ps.executeUpdate();
        ps.close();
    }

    public void eliminarUsuario(int idUsuario) throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "DELETE FROM tb_usuarios WHERE idusuario=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ps.executeUpdate();
        ps.close();
    }

    public Usuario obtenerPorId(int idUsuario) throws SQLException {
        Connection connection = Conexion.getConnection();
        String sql = "SELECT * FROM tb_usuarios WHERE idusuario = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery();

        Usuario usuario = null;
        if (rs.next()) {
            usuario = new Usuario(
                    rs.getInt("idusuario"),
                    rs.getString("carne"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("seccion"),
                    rs.getLong("telegramid"),
                    rs.getString("activo")
            );
        }
        rs.close();
        ps.close();
        return usuario;
    }

}
