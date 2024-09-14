package umg.progra2.service;

import umg.progra2.dao.EquiposChampionsDao;
import umg.progra2.model.EquipoChampions;

import java.sql.SQLException;
import java.util.List;

public class EquiposChampionsService {
    private EquiposChampionsDao equiposDao = new EquiposChampionsDao();

    public void agregarEquipo(EquipoChampions equipo) throws SQLException {
        equiposDao.insertarEquipo(equipo);
    }

    public List<EquipoChampions> obtenerEquipos() throws SQLException {
        return equiposDao.obtenerTodos();
    }

    public void actualizarEquipo(EquipoChampions equipo) throws SQLException {
        equiposDao.actualizarEquipo(equipo);
    }

    public void eliminarEquipo(int idEquipo) throws SQLException {
        equiposDao.eliminarEquipo(idEquipo);
    }

    public EquipoChampions obtenerEquipoPorId(int idEquipo) throws SQLException {
        return equiposDao.obtenerPorId(idEquipo);
    }
}
