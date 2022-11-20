package GUI;

import GestorCRUD.GestorDatos;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Usuarios extends JFrame{
    public Usuarios() throws IOException{
        //Crea la ventana de inicio de sesión y establece sus características
        VENTANA.setDefaultCloseOperation(EXIT_ON_CLOSE);
        VENTANA.setResizable(false);
        VENTANA.setLocation(550, 100);
        VENTANA.setTitle("Lista de Usuarios");
        VENTANA.setSize(620, 480);
        VENTANA.setVisible(true);
        
        //Elementos del inventario
        String[][] inventario = GestorDatos.leerDatos(GestorDatos.getRutaUsuarios());

        //Encabezado del inventario
        String[] encabezado = {"ID", "Nombre", "Contraseña" , "Rol"};
        
        JTable tabla = new JTable(inventario, encabezado);
        tabla.setBounds(30, 40, 200, 300);
        
        JScrollPane scroll = new JScrollPane(tabla);
        
        VENTANA.add(scroll);
    }
    
    private final JFrame VENTANA = new JFrame();
}
