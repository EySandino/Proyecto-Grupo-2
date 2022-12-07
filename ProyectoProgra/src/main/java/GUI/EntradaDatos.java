package GUI;

//Importar paquetes
import GestorCRUD.GestorDatos;

//Importar clases
import java.awt.Font;
import java.awt.Color;

//Importar eventos de los botones
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Importar excepciones
import java.io.IOException;

//Importar elementos de la ventana
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class EntradaDatos extends JFrame{
    
    public EntradaDatos(String tipoDato){
        //Configurar la ventana principal
        VENTANA.setDefaultCloseOperation(EXIT_ON_CLOSE);
        VENTANA.setResizable(false);
        VENTANA.setLocation(750, 150);
        VENTANA.setSize(350, 350);
        VENTANA.setVisible(true);
        VENTANA.setLayout(null);
        
        if (tipoDato.equals("inventario")){
            VENTANA.setTitle("Agregar componente");
        }
        else if (tipoDato.equals("usuario")){
            VENTANA.setTitle("Agregar usuario");
        }
        
        //Configurar la imagen de fonde del panel
        IMAGEN_FONDO.setIcon(IMAGEN);
        IMAGEN_FONDO.setBounds(0, -250, 700, 700);
        
        //Configurar los aspectos visuales de las etiquetas de texto para los usuarios
        TXT_NOMBRE.setFont(new Font("Serif", 3, 18));
        TXT_NOMBRE.setText("Nombre");
        TXT_NOMBRE.setBounds(30, 60, 100, 20);
        TXT_NOMBRE.setForeground(new Color(0, 0, 0));
        
        TXT_CONTRASENA.setFont(new Font("Serif", 3, 18));
        TXT_CONTRASENA.setText("Contraseña");
        TXT_CONTRASENA.setBounds(30, 100, 100, 20);
        TXT_CONTRASENA.setForeground(new Color(0, 0, 0));
        
        TXT_COMPROBAR_CONTRASENA.setFont(new Font("Serif", 3, 18));
        TXT_COMPROBAR_CONTRASENA.setText("Comprobar");
        TXT_COMPROBAR_CONTRASENA.setBounds(30, 140, 100, 20);
        TXT_COMPROBAR_CONTRASENA.setForeground(new Color(0, 0, 0));
        
        TXT_ROL.setFont(new Font("Serif", 3, 18));
        TXT_ROL.setText("Rol");
        TXT_ROL.setBounds(30, 180, 100, 20);
        TXT_ROL.setForeground(new Color(0, 0, 0));
        
        //Configurar los aspectos visuales de las etiquetas de texto para los componentes
        TXT_DESCRIPCION.setFont(new Font("Serif", 3, 18));
        TXT_DESCRIPCION.setText("Descripción");
        TXT_DESCRIPCION.setBounds(30, 60, 100, 20);
        TXT_DESCRIPCION.setForeground(new Color(0, 0, 0));
        
        TXT_CANTIDAD.setFont(new Font("Serif", 3, 18));
        TXT_CANTIDAD.setText("Cantidad");
        TXT_CANTIDAD.setBounds(30, 100, 100, 20);
        TXT_CANTIDAD.setForeground(new Color(0, 0, 0));
        
        TXT_FRABRICANTE.setFont(new Font("Serif", 3, 18));
        TXT_FRABRICANTE.setText("Fabricante");
        TXT_FRABRICANTE.setBounds(30, 140, 100, 20);
        TXT_FRABRICANTE.setForeground(new Color(0, 0, 0));
        
        TXT_PRECIO.setFont(new Font("Serif", 3, 18));
        TXT_PRECIO.setText("Precio");
        TXT_PRECIO.setBounds(30, 180, 100, 20);
        TXT_PRECIO.setForeground(new Color(0, 0, 0));
        
        //Configurar los campos de entrada de texto para los usuarios
        CAMPO_NOMBRE.setFont(new Font("Segoe UI", 0, 14));
        CAMPO_NOMBRE.setBounds(150, 60, 140, 30);
        CAMPO_NOMBRE.setForeground(new Color(187, 187, 187));
        CAMPO_NOMBRE.setBackground(new Color(69, 73, 74));
        CAMPO_NOMBRE.setBorder(null);
        
        CAMPO_CONTRASENA.setBounds(150, 100, 139, 31);
        CAMPO_CONTRASENA.setForeground(new Color(187, 187, 187));
        CAMPO_CONTRASENA.setBackground(new Color(69, 73, 74));
        CAMPO_CONTRASENA.setBorder(null);
        
        CAMPO_COMPROBAR_CONTRASENA.setBounds(150, 140, 140, 30);
        CAMPO_COMPROBAR_CONTRASENA.setForeground(new Color(187, 187, 187));
        CAMPO_COMPROBAR_CONTRASENA.setBackground(new Color(69, 73, 74));
        CAMPO_COMPROBAR_CONTRASENA.setBorder(null);
        
        //Configurar el menu desplegable
        MENU_DESPLEGUABLE.setBounds(150, 180, 140, 30);
        MENU_DESPLEGUABLE.setForeground(new Color(187, 187, 187));
        MENU_DESPLEGUABLE.setBackground(new Color(69, 73, 74));
        MENU_DESPLEGUABLE.setBorder(null);
        
        //Configurar los campos de entrada de texto para los componentes
        CAMPO_DESCRIPCION.setFont(new Font("Segoe UI", 0, 14));
        CAMPO_DESCRIPCION.setBounds(150, 60, 140, 30);
        CAMPO_DESCRIPCION.setForeground(new Color(187, 187, 187));
        CAMPO_DESCRIPCION.setBackground(new Color(69, 73, 74));
        CAMPO_DESCRIPCION.setBorder(null);
        
        CAMPO_CANTIDAD.setFont(new Font("Segoe UI", 0, 14));
        CAMPO_CANTIDAD.setBounds(150, 100, 140, 30);
        CAMPO_CANTIDAD.setForeground(new Color(187, 187, 187));
        CAMPO_CANTIDAD.setBackground(new Color(69, 73, 74));
        CAMPO_CANTIDAD.setBorder(null);
        
        CAMPO_FABRICANTE.setFont(new Font("Segoe UI", 0, 14));
        CAMPO_FABRICANTE.setBounds(150, 140, 140, 30);
        CAMPO_FABRICANTE.setForeground(new Color(187, 187, 187));
        CAMPO_FABRICANTE.setBackground(new Color(69, 73, 74));
        CAMPO_FABRICANTE.setBorder(null);
        
        CAMPO_PRECIO.setFont(new Font("Segoe UI", 0, 14));
        CAMPO_PRECIO.setBounds(150, 180, 140, 30);
        CAMPO_PRECIO.setForeground(new Color(187, 187, 187));
        CAMPO_PRECIO.setBackground(new Color(69, 73, 74));
        CAMPO_PRECIO.setBorder(null);
        
        //Configurar los aspectos visuales de los botones
        BTN_ACEPTAR.setFont(new Font("Segoe UI", 0, 14));
        BTN_ACEPTAR.setText("Aceptar");
        BTN_ACEPTAR.setBounds(100, 260, 60, 30);
        BTN_ACEPTAR.setForeground(new Color(255, 255,255));
        BTN_ACEPTAR.setBackground(new Color(69, 73, 74));
        BTN_ACEPTAR.setBorder(null);
        BTN_ACEPTAR.setFocusable(false);
        
        BTN_SALIR.setFont(new Font("Segoe UI", 0, 14));
        BTN_SALIR.setText("Salir");
        BTN_SALIR.setBounds(170, 260, 60, 30);
        BTN_SALIR.setForeground(new Color(255, 255,255));
        BTN_SALIR.setBackground(new Color(69, 73, 74));
        BTN_SALIR.setBorder(null);
        BTN_SALIR.setFocusable(false);
        
        //Configurar las acciones de los botones
        BTN_ACEPTAR.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    if (tipoDato.equals("inventario")){
                        String fabricante = CAMPO_FABRICANTE.getText();
                        String descripcion = CAMPO_DESCRIPCION.getText();
                        int precio = Integer.parseInt(CAMPO_PRECIO.getText());
                        int cantidad = Integer.parseInt(CAMPO_CANTIDAD.getText());

                        String contenedor = "," + descripcion
                                + "," + String.valueOf(cantidad)
                                + "," + fabricante
                                + ",CRC" + String.valueOf(precio);

                        GestorDatos.crearDato("inventario", contenedor);
                        JOptionPane.showMessageDialog(null, "Datos agregados exitosamente!", "Datos agregados", JOptionPane.INFORMATION_MESSAGE);
                        
                        VENTANA.dispose();
                        Tabla ventanaInventario = new Tabla(GestorDatos.INVENTARIO);
                    }
                    else if (tipoDato.equals("usuario")){
                        String nombre = CAMPO_NOMBRE.getText();
                        String rol = String.valueOf(MENU_DESPLEGUABLE.getSelectedItem());
                        String contrasena = String.valueOf(CAMPO_CONTRASENA.getPassword());
                        String comprobarContrasena = String.valueOf(CAMPO_COMPROBAR_CONTRASENA.getPassword());
                        
                        if (contrasena.equals(comprobarContrasena)){
                            String contenedor = "," + nombre
                                    + "," + contrasena
                                    + "," + rol;
                            
                            GestorDatos.crearDato("usuario", contenedor);
                            JOptionPane.showMessageDialog(null, "Datos agregados exitosamente!", "Datos agregados", JOptionPane.INFORMATION_MESSAGE);
                            
                            VENTANA.dispose();
                            Tabla ventanaInventario = new Tabla(GestorDatos.USUARIO);
                        }
                        else{
                            CAMPO_NOMBRE.setText("");
                            CAMPO_CONTRASENA.setText("");
                            CAMPO_COMPROBAR_CONTRASENA.setText("");
                            JOptionPane.showMessageDialog(null, "Por favor, verifique la contrasena e intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                catch (NumberFormatException | IOException ex){
                    CAMPO_PRECIO.setText("");
                    CAMPO_CANTIDAD.setText("");
                    CAMPO_FABRICANTE.setText("");
                    CAMPO_DESCRIPCION.setText("");

                    JOptionPane.showMessageDialog(null, "Por favor, digite valores válidos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        BTN_SALIR.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tipoDato.equals("inventario")){
                        VENTANA.dispose();
                        Tabla ventanaInventario = new Tabla(GestorDatos.INVENTARIO);
                    }
                    else if (tipoDato.equals("usuario")){
                        VENTANA.dispose();
                        Tabla ventanaInventario = new Tabla(GestorDatos.USUARIO);
                    }
                }
                catch (IOException ex){}
            }
        });

        //Agregar los elementos a la ventana principal
        if (tipoDato.equals("usuario")){
            VENTANA.add(TXT_NOMBRE);
            VENTANA.add(CAMPO_NOMBRE);
            VENTANA.add(TXT_CONTRASENA);
            VENTANA.add(CAMPO_CONTRASENA);
            VENTANA.add(TXT_COMPROBAR_CONTRASENA);
            VENTANA.add(CAMPO_COMPROBAR_CONTRASENA);
            VENTANA.add(TXT_ROL);
            VENTANA.add(MENU_DESPLEGUABLE);
            VENTANA.add(BTN_ACEPTAR);
            VENTANA.add(BTN_SALIR);
            VENTANA.add(IMAGEN_FONDO);
        }
        else if (tipoDato.equals("inventario")){
            VENTANA.add(TXT_DESCRIPCION);
            VENTANA.add(CAMPO_DESCRIPCION);
            VENTANA.add(TXT_CANTIDAD);
            VENTANA.add(CAMPO_CANTIDAD);
            VENTANA.add(TXT_FRABRICANTE);
            VENTANA.add(CAMPO_FABRICANTE);
            VENTANA.add(TXT_PRECIO);
            VENTANA.add(CAMPO_PRECIO);
            VENTANA.add(BTN_ACEPTAR);
            VENTANA.add(BTN_SALIR);
            VENTANA.add(IMAGEN_FONDO);
        }
    }
    
    //Ventana principal
    private final JFrame VENTANA = new JFrame();
    
    //Imagen de fondo
    private final JLabel IMAGEN_FONDO = new JLabel();
    private final String RUTA_IMAGEN = GestorDatos.getImagenTres();
    private final ImageIcon IMAGEN = new ImageIcon(RUTA_IMAGEN);
    
    //Etiquetas de texto para el usuario
    private final JLabel TXT_ROL = new JLabel();
    private final JLabel TXT_NOMBRE = new JLabel();
    private final JLabel TXT_CONTRASENA = new JLabel();
    private final JLabel TXT_COMPROBAR_CONTRASENA = new JLabel();
    
    //Etiquetas de texto para el elemento del inventario
    private final JLabel TXT_PRECIO = new JLabel();
    private final JLabel TXT_CANTIDAD = new JLabel();
    private final JLabel TXT_FRABRICANTE = new JLabel();
    private final JLabel TXT_DESCRIPCION = new JLabel();
    
    //Campos de entrada para el usuario
    private final JTextField CAMPO_NOMBRE = new JTextField();
    private final JPasswordField CAMPO_CONTRASENA = new JPasswordField();
    private final JPasswordField CAMPO_COMPROBAR_CONTRASENA = new JPasswordField();
    
    //Elementos para la seleccion del rol del usuario
    private final String[] OPCIONES = {"Administrador", "Vendedor"};
    private final JComboBox MENU_DESPLEGUABLE = new JComboBox(OPCIONES);
    
    //Campos de entrada para el elemento del inventario
    private final JTextField CAMPO_PRECIO = new JTextField(); 
    private final JTextField CAMPO_CANTIDAD = new JTextField();
    private final JTextField CAMPO_FABRICANTE = new JTextField();
    private final JTextField CAMPO_DESCRIPCION = new JTextField();
    
    //Botones
    private final JButton BTN_ACEPTAR = new JButton();
    private final JButton BTN_SALIR = new JButton();
}