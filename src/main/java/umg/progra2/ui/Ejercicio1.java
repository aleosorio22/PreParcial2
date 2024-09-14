package umg.progra2.ui;

import umg.progra2.model.Datos;
import umg.progra2.service.DatosService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

public class Ejercicio1 extends JFrame {
    //mvc componentes
    private DatosService datosService;

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDepartamento;
    private JTextField txtFecha;
    private JButton btnAgregar;
    private JButton btnLeer;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JPanel mainPanel;
    private JTable tableDatos;
    private JTextField txtID;
    private JButton btnBuscarId;

    public Ejercicio1() {
        datosService = new DatosService();

        // Configurar el JFrame
        this.setTitle("EJERCICIO 1");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);  // Agrega el panel principal al JFrame
        // Configurar la tabla
        String[] columnNames = {"Código", "Nombre", "Apellido", "Departamento", "Fecha Nacimiento"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);  // Asignar las columnas
        tableDatos.setModel(model);  // Asignar el modelo a la tabla

        this.setVisible(true);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    String apellido = txtApellido.getText();
                    String departamento = txtDepartamento.getText();
                    Date fechaNacimiento = Date.valueOf(txtFecha.getText());
                    if (fechaNacimiento == null) {
                        JOptionPane.showMessageDialog(mainPanel, "Formato de fecha incorrecto. Use YYYY-MM-DD.");
                        return; // Salir si la fecha es incorrecta
                    }

                    //Crear objeto de datos
                    Datos datos = new Datos(0, nombre, apellido, departamento, fechaNacimiento);

                    datosService.agregarDatos(datos);

                    JOptionPane.showMessageDialog(mainPanel, "Datos agregado exitosa");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(mainPanel, "error al agregar datos" + ex.getMessage());
                }
            }
        });

        btnLeer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Datos> listaDatos = datosService.obtenerDatos();
                    DefaultTableModel model = (DefaultTableModel) tableDatos.getModel();
                    model.setRowCount(0); // Limpiar la tabla

                    // Llenar la tabla con los datos
                    for (Datos datos : listaDatos) {
                        model.addRow(new Object[]{datos.getCodigo(), datos.getNombre(), datos.getApellido(), datos.getDepartamento(), datos.getFechaNacimiento()});
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al leer los datos: " + ex.getMessage());
                }
            }
        });
        btnBuscarId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(txtID.getText());
                    Datos datos = datosService.buscarPorId(id);
                    if (datos != null) {
                        txtNombre.setText(datos.getNombre());
                        txtApellido.setText(datos.getApellido());
                        txtDepartamento.setText(datos.getDepartamento());
                        txtFecha.setText(datos.getFechaNacimiento().toString());
                    }else {
                        JOptionPane.showMessageDialog(mainPanel, "Datos no encontrado");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(mainPanel, "error al buscar datos" + ex.getMessage());
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(txtID.getText());
                    datosService.eliminarDatos(id);
                    JOptionPane.showMessageDialog(mainPanel, "Datos eliminado exitosa");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(mainPanel, "error al eliminar datos" + ex.getMessage());
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(txtID.getText());

                    String nombre = txtNombre.getText();
                    String apellido = txtApellido.getText();
                    String departamento = txtDepartamento.getText();
                    Date fechaNacimiento = Date.valueOf(txtFecha.getText());

                    Datos datos = new Datos(id, nombre, apellido, departamento, fechaNacimiento);

                    datosService.actualizarDatos(datos);

                    JOptionPane.showMessageDialog(mainPanel, "Datos actualizado exitosa");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(mainPanel, "error al actualizar datos" + ex.getMessage());
                }
            }
        });
    }
}
