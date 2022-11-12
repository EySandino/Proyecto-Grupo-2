package GUI;

import javax.swing.JFrame;

public class Usuarios extends JFrame{
    public Usuarios(){
        VENTANA.setDefaultCloseOperation(EXIT_ON_CLOSE);
        VENTANA.setResizable(false);
        VENTANA.setLocation(550, 100);
        VENTANA.setSize(620, 480);
        VENTANA.setVisible(true);
    }
    
    private final JFrame VENTANA = new JFrame();
}
