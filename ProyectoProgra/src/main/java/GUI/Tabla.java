package GUI;

//Importar paquetes
import GestorCRUD.GestorDatos;
import GestorCRUD.Usuario;

//Importar excepciones
import java.io.IOException;

//Importar clases
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Tabla extends JFrame{
    
    public Tabla(String datosTabla) throws IOException{
        
        //Configurar la ventana principal
        VENTANA.setDefaultCloseOperation(EXIT_ON_CLOSE);
        VENTANA.setResizable(false);
        VENTANA.setLocation(550, 100);
        VENTANA.setSize(620, 480);
        VENTANA.setVisible(true);
        VENTANA.setLayout(new GridLayout(2, 1));
        
        if (datosTabla.equals(GestorDatos.INVENTARIO)){
            VENTANA.setTitle("Inventario");
        }
        else if (datosTabla.equals(GestorDatos.USUARIO)){
            VENTANA.setTitle("Usuarios");
        }
        
        //Configurar la distribucion del panel
        PANEL.setLayout(null);
        
        //Configurar la imagen de fonde del panel
        IMAGEN_FONDO.setIcon(IMAGEN);
        IMAGEN_FONDO.setBounds(0, -500, 1000, 1000);
        
        //Configurar los vectores para almacenar los datos y el encabezado
        String[] encabezado = getEncabezado(datosTabla);
        String[][] elementosTabla = GestorDatos.leerDatos(GestorDatos.getRuta(datosTabla));
        
        //Configurar la tabla y la barra de scroll
        JTable tabla = new JTable(elementosTabla, encabezado);
        JScrollPane scroll = new JScrollPane(tabla);
        
        //Configurar los aspectos visuales de los botones
        BTN_AGREGAR.setFont(new Font("Segoe UI", 0, 15));
        BTN_AGREGAR.setText("Agregar");
        BTN_AGREGAR.setBounds(15, 35, 60, 30);
        BTN_AGREGAR.setForeground(new Color(255, 255, 255));
        BTN_AGREGAR.setBackground(new Color(51, 51, 51));
        BTN_AGREGAR.setBorder(null);
        BTN_AGREGAR.setFocusable(false);
        
        BTN_MODIFICAR.setFont(new Font("Segoe UI", 0, 13));
        BTN_MODIFICAR.setText("Modificar");
        BTN_MODIFICAR.setBounds(15, 85, 60, 30);
        BTN_MODIFICAR.setForeground(new Color(255, 255, 255));
        BTN_MODIFICAR.setBackground(new Color(51, 51, 51));
        BTN_MODIFICAR.setBorder(null);
        BTN_MODIFICAR.setFocusable(false);
        
        BTN_ELIMINIAR.setFont(new Font("Segoe UI", 0, 15));
        BTN_ELIMINIAR.setText("Eliminar");
        BTN_ELIMINIAR.setBounds(15, 135, 60, 30);
        BTN_ELIMINIAR.setForeground(new Color(255, 255, 255));
        BTN_ELIMINIAR.setBackground(new Color(51, 51, 51));
        BTN_ELIMINIAR.setBorder(null);
        BTN_ELIMINIAR.setFocusable(false);
        
        BTN_SALIR.setFont(new Font("Segoe UI", 0, 15));
        BTN_SALIR.setText("Salir");
        BTN_SALIR.setBounds(530, 185, 60, 30);
        BTN_SALIR.setForeground(new Color(255, 255, 255));
        BTN_SALIR.setBackground(new Color(51, 51, 51));
        BTN_SALIR.setBorder(null);
        BTN_SALIR.setFocusable(false);
        
        //Configurar las acctiones de los botones
        BTN_AGREGAR.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                EntradaDatos ventanaEntrada = new EntradaDatos(datosTabla, false);
                VENTANA.dispose();
            }
        });
        
        BTN_MODIFICAR.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                EntradaDatos ventanaEntrada = new EntradaDatos(datosTabla, true);
                VENTANA.dispose();
            }
        });
        
        BTN_ELIMINIAR.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String id = JOptionPane.showInputDialog(null, "Ingrese el id del dato que desea eliminar");
                
                try {
                    boolean datoEliminado;
                    
                    if (datoEliminado = GestorDatos.eliminarDatos(id, datosTabla)){
                        JOptionPane.showMessageDialog(null, "Elemento eliminado exitosamente");
                        VENTANA.dispose();
                        Tabla ventanaInventario = new Tabla(GestorDatos.USUARIO);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "ID no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (IOException ex){}
            }
        });
        
        BTN_SALIR.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Menu ventanaMenu = new Menu(Usuario.getNombreUsuario());
                VENTANA.dispose();
            }
        });
        
        //Agregar elementos al panel
        PANEL.add(BTN_AGREGAR);
        PANEL.add(BTN_MODIFICAR);
        PANEL.add(BTN_ELIMINIAR);
        PANEL.add(BTN_SALIR);
        PANEL.add(IMAGEN_FONDO);
        
        //Agregar elementos a la ventana
        VENTANA.add(PANEL);
        VENTANA.add(scroll);
    }
    
    //Ventana principal
    private final JFrame VENTANA = new JFrame();
    
    //Panel de los botones
    private final JPanel PANEL = new JPanel();
    
    //Imagen de fondo
    private final JLabel IMAGEN_FONDO = new JLabel();
    private final String RUTA_IMAGEN = GestorDatos.getImagenUno();
    private final ImageIcon IMAGEN = new ImageIcon(RUTA_IMAGEN);
    
    //Botones
    private final JButton BTN_SALIR = new JButton();
    private final JButton BTN_AGREGAR = new JButton();
    private final JButton BTN_MODIFICAR = new JButton();
    private final JButton BTN_ELIMINIAR = new JButton();
    
    //Encabezado de la tabla
    public static String[] getEncabezado(String tipoDato){
        if (tipoDato.equals(GestorDatos.INVENTARIO)){
            String[] encabezado = {"ID", "Descripción", "Cantidad", "Fabricante","Precio"};
            return encabezado;
        }
        else if (tipoDato.equals(GestorDatos.USUARIO)){
            String[] encabezado = {"ID", "Nombre", "Clave", "Rol"};
            return encabezado;
        }
        else{
            String[] encabezado = {""};
            return encabezado;
        }
    }
}