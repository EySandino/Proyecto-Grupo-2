package GUI;

//Importar paquetes
import GestorCRUD.GestorDatos;

//Importar elementos de la ventana
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

//Importar caracteristicas de los elementos
import java.awt.Font;
import java.awt.Color;

//Importar acciones de los botones
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Importar excepciones
import java.io.IOException;

public class Menu extends JFrame{
    public Menu(String nombre){
        //Configurar la ventana principal
        VENTANA.setDefaultCloseOperation(EXIT_ON_CLOSE);
        VENTANA.setResizable(false);
        VENTANA.setLocation(550, 100);
        VENTANA.setTitle("Menu");
        VENTANA.setSize(620, 480);
        VENTANA.setVisible(true);
        
        //Configurar la imagen de fonde de la ventana principal
        IMAGEN_FONDO.setIcon(IMAGEN);
        IMAGEN_FONDO.setSize(620, 420);
        
        //Configurar los aspectos visuales de las etiquetas de texto
        TXT_BIENVENIDA.setFont(new Font("Segoe UI Emoji", 3, 18));
        TXT_BIENVENIDA.setText("Bienvenido(a) " + nombre + "!");
        TXT_BIENVENIDA.setBounds(0, 0, 300, 20);
        TXT_BIENVENIDA.setForeground(new Color(255, 0, 0));
        
        //Configurar los aspectos visuales de los botones
        BTN_USUARIOS.setFont(new Font("Segoe UI", 0, 14));
        BTN_USUARIOS.setText("Lista de Usuarios");
        BTN_USUARIOS.setBounds(420, 60, 160, 40);
        BTN_USUARIOS.setForeground(new Color(255, 255, 255));
        BTN_USUARIOS.setBackground(new Color(51, 51, 51));
        BTN_USUARIOS.setBorder(null);
        BTN_USUARIOS.setFocusable(false);
        
        BTN_FACTURA.setFont(new Font("Segoe UI", 0, 14));
        BTN_FACTURA.setText("Generar Factura");
        BTN_FACTURA.setBounds(290, 150, 160, 40);
        BTN_FACTURA.setForeground(new Color(255, 255, 255));
        BTN_FACTURA.setBackground(new Color(51, 51, 51));
        BTN_FACTURA.setBorder(null);
        BTN_FACTURA.setFocusable(false);
     
        BTN_INVENTARIO.setFont(new Font("Segoe UI", 0, 14));
        BTN_INVENTARIO.setText("Consultar Inventario");
        BTN_INVENTARIO.setBounds(420, 240, 160, 40);
        BTN_INVENTARIO.setForeground(new Color(255, 255, 255));
        BTN_INVENTARIO.setBackground(new Color(51, 51, 51));
        BTN_INVENTARIO.setBorder(null);
        BTN_INVENTARIO.setFocusable(false);
  
        BTN_SALIR.setFont(new Font("Segoe UI", 0, 14));
        BTN_SALIR.setText("Cerrar Sesión");
        BTN_SALIR.setBounds(500, 380, 100, 22);
        BTN_SALIR.setForeground(new Color(255, 255, 255));
        BTN_SALIR.setBackground(new Color(51, 51, 51));
        BTN_SALIR.setBorder(null);
        BTN_SALIR.setFocusable(false);
        
        //Configurar las acctiones de los botones
        BTN_USUARIOS.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    Tabla ventanaUsuarios = new Tabla(GestorDatos.USUARIO);
                    VENTANA.dispose();
                } catch (IOException ex) {}
            }
        });
        
//        BTN_FACTURA.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                Facturas ventanaFactura = new Facturas();
//            }
//        });
        
        BTN_INVENTARIO.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    Tabla ventanaInventario = new Tabla(GestorDatos.INVENTARIO);
                    VENTANA.dispose();
                }
                catch(IOException ex){}
            }
        });
        
        BTN_SALIR.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    InicioSesion inicioSesion = new InicioSesion(GestorDatos.leerDatos(GestorDatos.getRutaUsuarios()));
                } catch (IOException ex) {}
                VENTANA.dispose();
            }
        });
        
        //Agregar elementos a la ventana
        VENTANA.add(TXT_BIENVENIDA);
        VENTANA.add(BTN_USUARIOS);
        VENTANA.add(BTN_FACTURA);
        VENTANA.add(BTN_INVENTARIO);
        VENTANA.add(BTN_SALIR);
        VENTANA.add(IMAGEN_FONDO);
    }
    
    //Ventana principal
    private final JFrame VENTANA = new JFrame();
    
    //Imagen de fondo
    private final JLabel IMAGEN_FONDO = new JLabel();
    private final String RUTA_IMAGEN = GestorDatos.getImagenDos();
    private final ImageIcon IMAGEN = new ImageIcon(RUTA_IMAGEN);
    
    //Etiquetas de texto
    private final JLabel TXT_BIENVENIDA = new JLabel();
    
    //Botones
    private final JButton BTN_SALIR = new JButton();
    private final JButton BTN_FACTURA = new JButton();
    private final JButton BTN_USUARIOS = new JButton();
    private final JButton BTN_INVENTARIO = new JButton();
    
}
