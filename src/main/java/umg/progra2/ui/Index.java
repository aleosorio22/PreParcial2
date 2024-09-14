package umg.progra2.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Index extends JFrame {
    private JPanel mainPanel;
    private JButton btnEjercicio2;
    private JButton btnEjercicio3;
    private JButton btnEjercicio1;

    public Index() {
        // Configurar el JFrame
        this.setTitle("Formulario Principal");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);  // Establecer el panel principal como contenido del JFrame
        this.pack();  // Ajusta el tamaño de la ventana al contenido
        this.setVisible(true);

        // Evento del botón ejercicio 1
        btnEjercicio1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Ejercicio1();
            }
        });
        btnEjercicio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Ejercicio2();
            }
        });
        btnEjercicio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Ejercicio3();
            }
        });
    }

    public static void main(String[] args) {
        // Solo creamos una instancia de Index (ya es un JFrame)
        new Index();
    }
}
