package umg.progra2.service;

import umg.progra2.dao.UsuariosDao;
import umg.progra2.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class UsuariosService {
    private UsuariosDao usuariosDao = new UsuariosDao();

    public void agregarUsuario(Usuario usuario) throws SQLException, Exception {
        usuariosDao.insertarUsuario(usuario);
    }


    public List<Usuario> obtenerUsuarios() throws SQLException {
        return usuariosDao.obtenerTodos();
    }

    public void actualizarUsuario(Usuario usuario) throws SQLException {
        usuariosDao.actualizarUsuario(usuario);
    }

    public void eliminarUsuario(int idUsuario) throws SQLException {
        usuariosDao.eliminarUsuario(idUsuario);
    }

    public Usuario obtenerUsuarioPorId(int idUsuario) throws SQLException {
        return usuariosDao.obtenerPorId(idUsuario);
    }
}
