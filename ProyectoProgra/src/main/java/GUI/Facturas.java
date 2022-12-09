package GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Facturas extends JFrame {

    public Facturas(String[][] Factura) {

        //Creación de la ventana
        VENTANA.setDefaultCloseOperation(EXIT_ON_CLOSE);
        VENTANA.setResizable(false);
        VENTANA.setLocation(550, 100);
        VENTANA.setTitle("Generar Factura");
        VENTANA.setSize(620, 480);
        VENTANA.setVisible(true);

        IMAGEN_FONDO.setIcon(IMAGEN);
        IMAGEN_FONDO.setSize(700, 700);

        // Texto de los datos
        TXT_CLIENTE.setFont(new Font("Serif", 3, 18));
        TXT_CLIENTE.setText("Nombre de Cliente :");
        TXT_CLIENTE.setBounds(50, 70, 150, 40);
        TXT_CLIENTE.setForeground(new Color(255, 255, 255));

        TXT_ID.setFont(new Font("Serif", 3, 18));
        TXT_ID.setText("Identificación :");
        TXT_ID.setBounds(50, 120, 150, 40);
        TXT_ID.setForeground(new Color(255, 255, 255));

        TXT_TELEFONO.setFont(new Font("Serif", 3, 18));
        TXT_TELEFONO.setText("Número de Teléfono :");
        TXT_TELEFONO.setBounds(50, 170, 170, 40);
        TXT_TELEFONO.setForeground(new Color(255, 255, 255));

        TXT_CORREO.setFont(new Font("Serif", 3, 18));
        TXT_CORREO.setText("Correo Electrónico :");
        TXT_CORREO.setBounds(50, 220, 160, 40);
        TXT_CORREO.setForeground(new Color(255, 255, 255));

        CAMPO_CLIENTE.setFont(new Font("Segoe UI", 0, 14));
        CAMPO_CLIENTE.setBounds(220, 70, 160, 31);
        CAMPO_CLIENTE.setForeground(new Color(187, 187, 187));
        CAMPO_CLIENTE.setBackground(new Color(70, 73, 75));
        CAMPO_CLIENTE.setBorder(null);

        CAMPO_ID.setFont(new Font("Segoe UI", 0, 14));
        CAMPO_ID.setBounds(220, 120, 160, 31);
        CAMPO_ID.setForeground(new Color(187, 187, 187));
        CAMPO_ID.setBackground(new Color(70, 73, 75));
        CAMPO_ID.setBorder(null);

    }

    //Crear factura y de clarar variables.
    private final String RUTA_IMAGEN = "src\\main\\java\\Imagenes\\FondoUno.jpg";

    private final JFrame VENTANA = new JFrame();
    private final ImageIcon IMAGEN = new ImageIcon(RUTA_IMAGEN);
    private final JLabel IMAGEN_FONDO = new JLabel();

    private final JLabel TXT_CLIENTE = new JLabel();
    private final JLabel TXT_ID = new JLabel();
    private final JTextField CAMPO_CLIENTE = new JTextField();
    private final JTextField CAMPO_ID = new JTextField();
    
    private final JLabel TXT_TELEFONO = new JLabel();
    private final JLabel TXT_CORREO = new JLabel();

}
