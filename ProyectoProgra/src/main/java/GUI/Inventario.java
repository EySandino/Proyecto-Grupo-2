package GUI;

//Importar paquetes
import GestorCRUD.GestorDatos;

//Importar excepciones
import java.io.IOException;

//Importar clases
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Inventario extends JFrame{
    
    public Inventario() throws IOException{
        //Crea la VENTANA de inicio de sesión y establece sus características
        VENTANA.setDefaultCloseOperation(EXIT_ON_CLOSE);
        VENTANA.setResizable(false);
        VENTANA.setTitle("Inventario");
        VENTANA.setLocation(550, 100);
        VENTANA.setSize(620, 480);
        VENTANA.setVisible(true);

        //Elementos del inventario
        String[][] inventario = GestorDatos.leerDatos(GestorDatos.getRutaInventario());

        //Encabezado del inventario
        String[] encabezado = {"Número de parte", "Descripción", "Cantidad" , "Fabricante", "Precio"};
        
        JTable tabla = new JTable(inventario, encabezado);
        tabla.setBounds(30, 40, 200, 300);
        
        JScrollPane scroll = new JScrollPane(tabla);

        VENTANA.add(scroll);
    }
    private final JFrame VENTANA = new JFrame();
}