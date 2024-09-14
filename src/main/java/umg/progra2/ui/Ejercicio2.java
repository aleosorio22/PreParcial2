package umg.progra2.ui;

import umg.progra2.model.Usuario;
import umg.progra2.service.UsuariosService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class Ejercicio2 extends JFrame{
    private UsuariosService usuariosService;

    private JPanel mainPanel;
    private JTextField txtNombre;
    private JTextField txtCorreo;
    private JTextField txtSeccion;
    private JTextField txtTelegramId;
    private JTextField txtCarne;
    private JButton btnBuscarId;
    private JButton btnAgregar;
    private JButton btnLeer;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JTable tableUsuarios;
    private JTextField txtEstado;
    private JTextField txtId;

    public Ejercicio2() {
        usuariosService = new UsuariosService();

        // Configurar el JFrame
        this.setTitle("EJERCICIO 2");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar el modelo de la tabla
        String[] columnNames = {"ID", "Nombre", "Correo", "Sección", "Telegram ID", "Estado"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        tableUsuarios.setModel(model);  // Asignar el modelo a la tabla

        this.setContentPane(mainPanel);
        this.setVisible(true);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String carne = txtCarne.getText();
                    String nombre = txtNombre.getText();
                    String correo = txtCorreo.getText();
                    String seccion = txtSeccion.getText();
                    Long telegramId = Long.parseLong(txtTelegramId.getText());
                    String estado = txtEstado.getText();

                    Usuario usuario = new Usuario(0, carne, nombre, correo, seccion, telegramId, estado);

                    usuariosService.agregarUsuario(usuario);

                    JOptionPane.showMessageDialog(null, "Usuario agregado exitosamente");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al agregar usuario" + ex.getMessage());
                }
            }
        });
        btnLeer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Usuario> listaUsuarios = usuariosService.obtenerUsuarios();
                    DefaultTableModel model = (DefaultTableModel) tableUsuarios.getModel();
                    model.setRowCount(0);

                    for (Usuario usuario : listaUsuarios) {
                        model.addRow(new Object[]{usuario.getIdUsuario(), usuario.getNombre(), usuario.getCorreo(), usuario.getSeccion(), usuario.getTelegramId()});
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al obtener el usuario");
                }
            }
        });
        btnBuscarId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtId.getText());

                    // Buscar usuario por ID
                    Usuario usuario = usuariosService.obtenerUsuarioPorId(id);

                    if (usuario != null) {
                        // Llenar los campos con los datos del usuario encontrado
                        txtCarne.setText(usuario.getCarne());
                        txtNombre.setText(usuario.getNombre());
                        txtCorreo.setText(usuario.getCorreo());
                        txtSeccion.setText(usuario.getSeccion());
                        txtTelegramId.setText(String.valueOf(usuario.getTelegramId()));
                        txtEstado.setText(usuario.getActivo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado para el ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al buscar usuario: " + ex.getMessage());
                }

            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idUsuario = Integer.parseInt(txtId.getText());
                    String carne = txtCarne.getText();
                    String nombre = txtNombre.getText();
                    String correo = txtCorreo.getText();
                    String seccion = txtSeccion.getText();
                    long telegramId = Long.parseLong(txtTelegramId.getText());
                    String activo = txtEstado.getText();

                    Usuario usuario = new Usuario(idUsuario, carne, nombre, correo, seccion, telegramId, activo);

                    usuariosService.actualizarUsuario(usuario);

                    JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el usuario: " + ex.getMessage());
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idUsuario = Integer.parseInt(txtId.getText());
                    usuariosService.eliminarUsuario(idUsuario);
                    JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el usuario: " + ex.getMessage());
                }
            }
        });
    }

}
