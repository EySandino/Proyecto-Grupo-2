package GUI;

import GestorCRUD.GestorDatos;
import GestorCRUD.Usuario;
import Main.Helper;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Facturas extends JFrame {

    public Facturas() {

        Helper clsH = new Helper();
        String factura = "";
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
        TXT_CLIENTE.setText("Nombre de Cliente:");
        TXT_CLIENTE.setBounds(50, 70, 150, 40);
        TXT_CLIENTE.setForeground(new Color(255, 255, 255));

        TXT_ID.setFont(new Font("Serif", 3, 18));
        TXT_ID.setText("Identificación:");
        TXT_ID.setBounds(50, 120, 150, 40);
        TXT_ID.setForeground(new Color(255, 255, 255));

        TXT_TELEFONO.setFont(new Font("Serif", 3, 18));
        TXT_TELEFONO.setText("Número de Teléfono:");
        TXT_TELEFONO.setBounds(50, 170, 170, 40);
        TXT_TELEFONO.setForeground(new Color(255, 255, 255));

        TXT_CORREO.setFont(new Font("Serif", 3, 18));
        TXT_CORREO.setText("Correo Electrónico:");
        TXT_CORREO.setBounds(50, 220, 160, 40);
        TXT_CORREO.setForeground(new Color(255, 255, 255));

        TXT_PRODUCTO.setFont(new Font("Serif", 3, 18));
        TXT_PRODUCTO.setText("Producro Requerido:");
        TXT_PRODUCTO.setBounds(50, 270, 160, 40);
        TXT_PRODUCTO.setForeground(new Color(255, 255, 255));

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

        CAMPO_TELEFONO.setFont(new Font("Segoe UI", 0, 14));
        CAMPO_TELEFONO.setBounds(220, 170, 160, 31);
        CAMPO_TELEFONO.setForeground(new Color(187, 187, 187));
        CAMPO_TELEFONO.setBackground(new Color(70, 73, 75));
        CAMPO_TELEFONO.setBorder(null);

        CAMPO_CORREO.setFont(new Font("Segoe UI", 0, 14));
        CAMPO_CORREO.setBounds(220, 220, 160, 31);
        CAMPO_CORREO.setForeground(new Color(187, 187, 187));
        CAMPO_CORREO.setBackground(new Color(70, 73, 75));
        CAMPO_CORREO.setBorder(null);

        CAMPO_PRODUCTO.setFont(new Font("Segoe UI", 0, 14));
        CAMPO_PRODUCTO.setBounds(220, 280, 160, 31);
        CAMPO_PRODUCTO.setForeground(new Color(187, 187, 187));
        CAMPO_PRODUCTO.setBackground(new Color(70, 73, 75));
        CAMPO_PRODUCTO.setBorder(null);

        BTN_ACEPTAR.setFont(new Font("Segoe UI", 0, 18));
        BTN_ACEPTAR.setText("Aceptar");
        BTN_ACEPTAR.setBounds(70, 390, 90, 30);
        BTN_ACEPTAR.setForeground(new Color(187, 187, 187));
        BTN_ACEPTAR.setBackground(new Color(78, 80, 82));
        BTN_ACEPTAR.setBorder(null);
        BTN_ACEPTAR.setFocusable(false);

        BTN_SALIR.setFont(new Font("Segoe UI", 0, 18));
        BTN_SALIR.setText("Salir");
        BTN_SALIR.setBounds(430, 390, 90, 30);
        BTN_SALIR.setForeground(new Color(187, 187, 187));
        BTN_SALIR.setBackground(new Color(78, 80, 82));
        BTN_SALIR.setBorder(null);
        BTN_SALIR.setFocusable(false);

        BTN_AGREGAR.setFont(new Font("Segoe UI", 0, 14));
        BTN_AGREGAR.setText("Agregar a la compra");
        BTN_AGREGAR.setBounds(230, 390, 150, 30);
        BTN_AGREGAR.setForeground(new Color(187, 187, 187));
        BTN_AGREGAR.setBackground(new Color(78, 80, 82));
        BTN_AGREGAR.setBorder(null);
        BTN_AGREGAR.setFocusable(false);

//        BTN_AGREGAR.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    GestorDatos gD = new GestorDatos();
//                    String precioTexto = "";
//                    int precio = 0;
//                    String productos[];
//                    int precios[];
//
//                    String producto = CAMPO_PRODUCTO.getText();
//
//                    String[][] Datos = gD.leerDatos(gD.getRuta(gD.INVENTARIO));
//
//                    for (int i = 0; i < Datos.length; i++) {
//                        if (Datos[i][1].equalsIgnoreCase(producto)) { //dentro de los paréntesis poner el nombre del producto que desea buscar el precio
//                            precioTexto = Datos[i][4];
//                            break;
//                        }
//                    }
//                    producto += productos[0];
//                    precioTexto = precioTexto.substring(3, precioTexto.length());
//                    precio = Integer.parseInt(precioTexto);
//                    precio += precios[0];
//                    
//                } catch (IOException ex) {
//                }
//
//            }
//        });

        BTN_ACEPTAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String factura = "";
                    int numFact = 1;
                    int precio = 0;
                    float IVA = 0.13f,Total = 0.0f;

                    String producto = CAMPO_PRODUCTO.getText();
                    String nombre = CAMPO_CLIENTE.getText();
                    String identificacion = CAMPO_ID.getText();
                    String telefono = CAMPO_TELEFONO.getText();
                    String correo = CAMPO_CORREO.getText();
                    GestorDatos gD = new GestorDatos();
                    String precioTexto = "";
                    

                    String[][] Datos = gD.leerDatos(gD.getRuta(gD.INVENTARIO));

                    for (int i = 0; i < Datos.length; i++) {
                        if (Datos[i][1].equalsIgnoreCase(producto)) { //dentro de los paréntesis poner el nombre del producto que desea buscar el precio
                            precioTexto = Datos[i][4];
                            break;
                        }
                    }
                    
                    precioTexto = precioTexto.substring(3, precioTexto.length());
                    precio = Integer.parseInt(precioTexto);
                    
                    Total = precio * IVA;

                    numFact = (int) (Math.random() * (9999999 - 10000 + 1)) * 10000;
                    factura += "Factura #" + numFact + "\n";
                    factura += "Nombre Cliente: " + nombre + "\n";
                    factura += "Identificación: " + identificacion + "\n";
                    factura += "Numero de Telefono: " + telefono + "\n";
                    factura += "Correo Electrónico: " + correo + "\n";
                    factura += "---------------------------------------------------------------------------\n";
                    factura += "Descripcion\t\tMonto\n";
                    factura += "---------------------------------------------------------------------------\n";
                    factura += producto + "\t\t" + precio+"\n";
                    factura += "---------------------------------------------------------------------------\n";
                    factura += "Iva\t\t\t"+IVA+"\n";
                    factura += "Total\t\t\t"+Total+"\n";

                    clsH.imprimeMensaje(new TextArea(factura));
//                return precio;
                } catch (IOException ex) {
                }

            }
        });

        BTN_SALIR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Menu ventanaMenu = new Menu(Usuario.getNombreUsuario());
                VENTANA.dispose();
            }
        });
        //        Añadir los elementos a la VENTANA    

        VENTANA.add(CAMPO_CLIENTE);
        VENTANA.add(CAMPO_ID);
        VENTANA.add(CAMPO_TELEFONO);
        VENTANA.add(CAMPO_CORREO);
        VENTANA.add(CAMPO_PRODUCTO);

        VENTANA.add(TXT_CLIENTE);
        VENTANA.add(TXT_ID);
        VENTANA.add(TXT_TELEFONO);
        VENTANA.add(TXT_CORREO);
        VENTANA.add(TXT_PRODUCTO);

        VENTANA.add(BTN_SALIR);
        VENTANA.add(BTN_ACEPTAR);
        VENTANA.add(BTN_AGREGAR);
        VENTANA.add(IMAGEN_FONDO);
//      VENTANA.add(PANEL);
    }
    //Crear factura y de clarar variables.
    private final String RUTA_IMAGEN = "src\\main\\java\\Imagenes\\FondoUno.jpg";

    private final JFrame VENTANA = new JFrame();

    private final JPanel PANEL = new JPanel();

    private final ImageIcon IMAGEN = new ImageIcon(RUTA_IMAGEN);
    private final JLabel IMAGEN_FONDO = new JLabel();

    private final JLabel TXT_CLIENTE = new JLabel();
    private final JLabel TXT_ID = new JLabel();
    private final JTextField CAMPO_CLIENTE = new JTextField();
    private final JTextField CAMPO_ID = new JTextField();

    private final JLabel TXT_TELEFONO = new JLabel();
    private final JLabel TXT_CORREO = new JLabel();
    private final JLabel TXT_PRODUCTO = new JLabel();
    private final JTextField CAMPO_TELEFONO = new JTextField();
    private final JTextField CAMPO_CORREO = new JTextField();
    private final JTextField CAMPO_PRODUCTO = new JTextField();
    private final JButton BTN_ACEPTAR = new JButton();
    private final JButton BTN_SALIR = new JButton();
    private final JButton BTN_AGREGAR = new JButton();

}
