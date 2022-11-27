package GUI;

import javax.swing.JFrame;

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
}