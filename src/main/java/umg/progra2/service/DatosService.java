package umg.progra2.service;


import umg.progra2.dao.DatosDao;
import umg.progra2.model.Datos;

import java.sql.SQLException;
import java.util.List;

public class DatosService {
    private DatosDao datosDao = new DatosDao();

    public void agregarDatos(Datos datos) throws SQLException {
        datosDao.insertarDatos(datos);
    }

    public List<Datos> obtenerDatos() throws SQLException {
        return datosDao.obtenerTodos();
    }

    public void actualizarDatos(Datos datos) throws SQLException {
        datosDao.actualizarDatos(datos);
    }

    public void eliminarDatos(int codigo) throws SQLException {
        datosDao.eliminarDatos(codigo);
    }

    // Método para buscar datos por ID (código)
    public Datos buscarPorId(int id) throws SQLException {
        return datosDao.obtenerPorId(id);
    }
}
