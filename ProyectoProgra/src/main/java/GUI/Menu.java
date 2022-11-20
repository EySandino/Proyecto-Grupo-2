package GUI;

//Importar paquetes
import GestorCRUD.GestorDatos;

//Importar Clases
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

//Importar excepciones
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu extends JFrame{
    public Menu(String[] usuario){
        //Crea la ventana de inicio de sesión y establece sus características
        VENTANA.setDefaultCloseOperation(EXIT_ON_CLOSE);
        VENTANA.setResizable(false);
        VENTANA.setLocation(550, 100);
        VENTANA.setTitle("Menu");
        VENTANA.setSize(620, 480);
        VENTANA.setVisible(true);
        
        //Establecer las características de los elementos de la VENTANA
        IMAGEN_FONDO.setIcon(IMAGEN);
        IMAGEN_FONDO.setSize(620, 420);
        
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
        
        //Establecer las acctiones de los botones
        BTN_USUARIOS.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    Usuarios listaUsuarios = new Usuarios();
                } catch (IOException ex) {}
            }
        });
        
        BTN_FACTURA.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Facturas generarVenta = new Facturas();
            }
        });
        
        BTN_INVENTARIO.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    Inventario inventario = new Inventario();
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
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                VENTANA.dispose();
            }
        });
        
        //Añadir los elementos a la VENTANA
        VENTANA.add(BTN_USUARIOS);
        VENTANA.add(BTN_FACTURA);
        VENTANA.add(BTN_INVENTARIO);
        VENTANA.add(BTN_SALIR);
        VENTANA.add(IMAGEN_FONDO);
    }
    
    //Crea los elementos de la ventana de menú
    private final String RUTA_IMAGEN = "src\\main\\java\\Imagenes\\Azul.jpg";
    
    private final JFrame VENTANA = new JFrame();
    private final ImageIcon IMAGEN = new ImageIcon(RUTA_IMAGEN);
    private final JLabel IMAGEN_FONDO = new JLabel();
    private final JButton BTN_USUARIOS = new JButton();
    private final JButton BTN_FACTURA = new JButton();
    private final JButton BTN_INVENTARIO = new JButton();
    private final JButton BTN_SALIR = new JButton();
}
