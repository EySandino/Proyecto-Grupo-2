package GUI;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Facturas extends JFrame{
    public Facturas(){
        VENTANA.setDefaultCloseOperation(EXIT_ON_CLOSE);
        VENTANA.setResizable(false);
        VENTANA.setLocation(550, 100);
        VENTANA.setTitle("Generar Factura");
        VENTANA.setSize(620, 480);
        VENTANA.setVisible(true);
    }
    //Crear factura y de clarar variables.
    //Prueba.
    private final JFrame VENTANA = new JFrame();
    
    public static void main(String[] args) {
    Scanner Prod =  new Scanner(System.in); 
    String nombre = " "; 
    double Precio; 
    int Cantidad;
    double SubTotal; 
    double Total; 
    double IGV = 0.18; 
    double descuento; 

    JOptionPane.showInputDialog(" "); 
    nombre=Prod.next();
    }
}