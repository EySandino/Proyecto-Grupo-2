package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//Para establecer posición los paramentros son x, y
//Para establecer dimenciones los paremetros son anchura, altura

public class InicioSesion extends JFrame{
    
    public InicioSesion(String[][] contenedorUsuarios){
        //Crea la VENTANA de inicio de sesión y establece sus características
        VENTANA.setDefaultCloseOperation(EXIT_ON_CLOSE);
        VENTANA.setResizable(false);
        VENTANA.setLocation(550, 100);
        VENTANA.setSize(404, 365);
        VENTANA.setVisible(true);
        
        //Establecer las características de los elementos de la VENTANA
        IMAGEN_FONDO.setIcon(IMAGEN);
        IMAGEN_FONDO.setSize(700, 700);
        
        TXT_NOMBRE_EMPRESA.setFont(new Font("Serif", 3, 36));
        TXT_NOMBRE_EMPRESA.setText("Repuestos Fidélitas");
        TXT_NOMBRE_EMPRESA.setBounds(50, 20, 300, 50);
        TXT_NOMBRE_EMPRESA.setForeground(new Color(0, 0, 0));
        
        TXT_USUARIO.setFont(new Font("Segoe UI Emoji", 3, 18));
        TXT_USUARIO.setText("Usuario");
        TXT_USUARIO.setBounds(60, 130, 100, 20);
        TXT_USUARIO.setForeground(new Color(255, 255, 255));
        
        TXT_SESION_FALLIDA.setFont(new Font("Segoe UI Emoji", 3, 18));
        TXT_SESION_FALLIDA.setBounds(5, 80, 400, 20);
        TXT_SESION_FALLIDA.setForeground(new Color(255, 0, 0));
        
        TXT_CONTRASENA.setFont(new Font("Segoe UI Emoji", 3, 18));
        TXT_CONTRASENA.setText("Contraseña");
        TXT_CONTRASENA.setBounds(30, 200, 100, 20);
        TXT_CONTRASENA.setForeground(new Color(255, 255, 255));
        
        BTN_INICIO.setFont(new Font("Segoe UI", 0, 14));
        BTN_INICIO.setText("Iniciar Sesión");
        BTN_INICIO.setBounds(140, 260, 130, 34);
        BTN_INICIO.setForeground(new Color(0, 0, 0));
        BTN_INICIO.setBackground(new Color(69, 73, 74));
        BTN_INICIO.setBorder(null);
        BTN_INICIO.setFocusable(false);

        CAMPO_USUARIO.setFont(new Font("Segoe UI", 0, 14));
        CAMPO_USUARIO.setBounds(180, 120, 139, 31);
        CAMPO_USUARIO.setForeground(new Color(187, 187, 187));
        CAMPO_USUARIO.setBackground(new Color(69, 73, 74));
        CAMPO_USUARIO.setBorder(null);
        
        CAMPO_CONTRASENA.setBounds(180, 190, 139, 31);
        CAMPO_CONTRASENA.setForeground(new Color(187, 187, 187));
        CAMPO_CONTRASENA.setBackground(new Color(69, 73, 74));
        CAMPO_CONTRASENA.setBorder(null);
        
        BTN_INICIO.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String entradaNombreUsuario = CAMPO_USUARIO.getText();
                String entradaContrasena = String.valueOf(CAMPO_CONTRASENA.getPassword());
                boolean validacion = false;
                
                for (int i = 0; i <= contenedorUsuarios.length - 1; i++){
                    if (contenedorUsuarios[i][1].equals(entradaNombreUsuario) && contenedorUsuarios[i][2].equals(entradaContrasena)){
                        validacion = true;
                        break;
                    }
                }

                if (validacion){
                    VENTANA.dispose();
                }
                else{
                    CAMPO_USUARIO.setText("");
                    CAMPO_CONTRASENA.setText("");
                    TXT_SESION_FALLIDA.setText("El usuario y/o la contraseña son incorrectos");
                }
            }
        });
        
        //Añadir los elementos a la VENTANA
        VENTANA.add(CAMPO_USUARIO);
        VENTANA.add(BTN_INICIO);
        VENTANA.add(TXT_SESION_FALLIDA);
        VENTANA.add(CAMPO_CONTRASENA);
        VENTANA.add(TXT_CONTRASENA);
        VENTANA.add(TXT_USUARIO);
        VENTANA.add(TXT_NOMBRE_EMPRESA);
        VENTANA.add(IMAGEN_FONDO);
        
    }
    
    //Crea los elementos de la VENTANA de inicio de sesión
    private final String RUTA_IMAGEN = "src\\main\\java\\Imagenes\\FondoUno.jpg";
    
    private final JFrame VENTANA = new JFrame();
    private final ImageIcon IMAGEN = new ImageIcon(RUTA_IMAGEN);
    private final JLabel TXT_USUARIO = new JLabel();
    private final JButton BTN_INICIO = new JButton();
    private final JLabel TXT_CONTRASENA = new JLabel();
    private final JLabel IMAGEN_FONDO = new JLabel();
    private final JLabel TXT_NOMBRE_EMPRESA = new JLabel();
    private final JTextField CAMPO_USUARIO = new JTextField();
    private final JPasswordField CAMPO_CONTRASENA = new JPasswordField();
    private final JLabel TXT_SESION_FALLIDA = new JLabel();
}
