package umg.progra2.ui;

import umg.progra2.model.EquipoChampions;
import umg.progra2.service.EquiposChampionsService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ejercicio3 extends JFrame {
    private EquiposChampionsService equiposService;

    private JPanel mainPanel;
    private JTextField txtPais;
    private JTextField txtCiudad;
    private JTextField txtEstadio;
    private JTextField txtFundacion;
    private JTextField txtID;
    private JButton btnBuscarId;
    private JButton btnAgregar;
    private JButton btnLeer;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JTable tableEquipos;
    private JTextField txtEntrenador;
    private JTextField txtWeb;
    private JTextField txtFacebook;
    private JTextField txtInstagram;
    private JTextField txtPatrocinador;
    private JTextField txtNombre;
    private JTextField txtTwitter;

    public Ejercicio3() {
        equiposService = new EquiposChampionsService();

        // Configurar el JFrame
        this.setTitle("EJERCICIO 3");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar el modelo de la tabla
        String[] columnNames = {"ID", "Nombre", "País", "Ciudad", "Estadio", "Fundación", "Entrenador", "Web", "Facebook", "Twitter", "Instagram", "Patrocinador"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        tableEquipos.setModel(model);

        this.setContentPane(mainPanel);
        this.setVisible(true);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Capturar datos de los JTextField
                    String nombre = txtNombre.getText();
                    String pais = txtPais.getText();
                    String ciudad = txtCiudad.getText();
                    String estadio = txtEstadio.getText();
                    int fundacion = Integer.parseInt(txtFundacion.getText());
                    String entrenador = txtEntrenador.getText();
                    String webOficial = txtWeb.getText();
                    String facebook = txtFacebook.getText();
                    String twitter = txtTwitter.getText();
                    String instagram = txtInstagram.getText();
                    String patrocinador = txtPatrocinador.getText();

                    // Crear objeto EquipoChampions
                    EquipoChampions equipo = new EquipoChampions(0, nombre, pais, ciudad, estadio, fundacion, entrenador, webOficial, facebook, twitter, instagram, patrocinador);

                    // Llamar a la capa de servicio para insertar
                    equiposService.agregarEquipo(equipo);

                    JOptionPane.showMessageDialog(null, "Equipo insertado con éxito");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al insertar el equipo: " + ex.getMessage());
                }
            }
        });
        btnLeer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<EquipoChampions> listaEquipos = equiposService.obtenerEquipos();
                    DefaultTableModel model = (DefaultTableModel) tableEquipos.getModel();
                    model.setRowCount(0); // Limpiar la tabla

                    // Llenar la tabla con los datos
                    for (EquipoChampions equipo : listaEquipos) {
                        model.addRow(new Object[]{equipo.getIdEquipo(), equipo.getNombre(), equipo.getPais(), equipo.getCiudad(), equipo.getEstadio(), equipo.getFundacion(), equipo.getEntrenador(), equipo.getWebOficial(), equipo.getFacebook(), equipo.getTwitter(), equipo.getInstagram(), equipo.getPatrocinadorPrincipal()});
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al leer los equipos: " + ex.getMessage());
                }
            }
        });
        btnBuscarId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtID.getText());

                    // Buscar equipo por ID
                    EquipoChampions equipo = equiposService.obtenerEquipoPorId(id);

                    if (equipo != null) {
                        // Llenar los campos con los datos del equipo encontrado
                        txtNombre.setText(equipo.getNombre());
                        txtPais.setText(equipo.getPais());
                        txtCiudad.setText(equipo.getCiudad());
                        txtEstadio.setText(equipo.getEstadio());
                        txtFundacion.setText(String.valueOf(equipo.getFundacion()));
                        txtEntrenador.setText(equipo.getEntrenador());
                        txtWeb.setText(equipo.getWebOficial());
                        txtFacebook.setText(equipo.getFacebook());
                        txtTwitter.setText(equipo.getTwitter());
                        txtInstagram.setText(equipo.getInstagram());
                        txtPatrocinador.setText(equipo.getPatrocinadorPrincipal());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un equipo con ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al buscar el equipo: " + ex.getMessage());
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idEquipo = Integer.parseInt(txtID.getText());
                    String nombre = txtNombre.getText();
                    String pais = txtPais.getText();
                    String ciudad = txtCiudad.getText();
                    String estadio = txtEstadio.getText();
                    int fundacion = Integer.parseInt(txtFundacion.getText());
                    String entrenador = txtEntrenador.getText();
                    String webOficial = txtWeb.getText();
                    String facebook = txtFacebook.getText();
                    String twitter = txtTwitter.getText();
                    String instagram = txtInstagram.getText();
                    String patrocinadorPrincipal = txtPatrocinador.getText();

                    EquipoChampions equipo = new EquipoChampions(idEquipo, nombre, pais, ciudad, estadio, fundacion, entrenador, webOficial, facebook, twitter, instagram, patrocinadorPrincipal);

                    equiposService.actualizarEquipo(equipo);

                    JOptionPane.showMessageDialog(null, "Equipo actualizado con éxito");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el equipo: " + ex.getMessage());
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idEquipo = Integer.parseInt(txtID.getText());
                    equiposService.eliminarEquipo(idEquipo);
                    JOptionPane.showMessageDialog(null, "Equipo eliminado con éxito");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el equipo: " + ex.getMessage());
                }
            }
        });
    }
}
