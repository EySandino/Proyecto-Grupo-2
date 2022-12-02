package GUI;

//Importar paquetes
import GestorCRUD.GestorDatos;

//Importar elementos de la ventana
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

//Importar caracteristicas de los elementos
import java.awt.Font;
import java.awt.Color;

//Importar acciones de los botones
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioSesion extends JFrame{
    public InicioSesion(String[][] contenedorUsuarios){
        //Configurar la ventana principal
        VENTANA.setDefaultCloseOperation(EXIT_ON_CLOSE);
        VENTANA.setResizable(false);
        VENTANA.setLocation(550, 100);
        VENTANA.setTitle("Repuestos Fidelitas");
        VENTANA.setSize(404, 365);
        VENTANA.setVisible(true);
        
        //Configurar la imagen de fonde de la ventana principal
        IMAGEN_FONDO.setIcon(IMAGEN);
        IMAGEN_FONDO.setSize(700, 700);
        
        //Configurar los aspectos visuales de las etiquetas de texto
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

        //Configurar los campos de entrada de texto
        CAMPO_USUARIO.setFont(new Font("Segoe UI", 0, 14));
        CAMPO_USUARIO.setBounds(180, 120, 139, 31);
        CAMPO_USUARIO.setForeground(new Color(187, 187, 187));
        CAMPO_USUARIO.setBackground(new Color(69, 73, 74));
        CAMPO_USUARIO.setBorder(null);
        
        CAMPO_CONTRASENA.setBounds(180, 190, 139, 31);
        CAMPO_CONTRASENA.setForeground(new Color(187, 187, 187));
        CAMPO_CONTRASENA.setBackground(new Color(69, 73, 74));
        CAMPO_CONTRASENA.setBorder(null);
        
        //Configurar los aspectos visuales del boton
        BTN_INICIO.setFont(new Font("Segoe UI", 0, 14));
        BTN_INICIO.setText("Iniciar Sesión");
        BTN_INICIO.setBounds(140, 260, 130, 34);
        BTN_INICIO.setForeground(new Color(0, 0, 0));
        BTN_INICIO.setBackground(new Color(69, 73, 74));
        BTN_INICIO.setBorder(null);
        BTN_INICIO.setFocusable(false);
        
        //Configurar la acion del boton de inicio de sesion
        BTN_INICIO.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //Obtener los datos ingresados por el usuario
                String entradaNombreUsuario = CAMPO_USUARIO.getText();
                String entradaContrasena = String.valueOf(CAMPO_CONTRASENA.getPassword());  
                
                //Lee los usuarios existentes de uno en uno para verificar las credenciales del usuario
                for (int i = 0; i < contenedorUsuarios.length; i++){
                    if (contenedorUsuarios[i][1].equals(entradaNombreUsuario) && contenedorUsuarios[i][2].equals(entradaContrasena)){
                        Menu ventanaMenu = new Menu(contenedorUsuarios[i]);
                        VENTANA.dispose();
                        break;
                    }
                }
                
                //Si ninguno de los usuarios existentes coincide con las credenciales ingresadas se muestra el mensaje de error
                CAMPO_USUARIO.setText("");
                CAMPO_CONTRASENA.setText("");
                TXT_SESION_FALLIDA.setText("El usuario y/o la contraseña son incorrectos");
            }
        });
        
        //Añadir los elementos a la ventana
        VENTANA.add(TXT_NOMBRE_EMPRESA);
        VENTANA.add(TXT_USUARIO);
        VENTANA.add(CAMPO_USUARIO);
        VENTANA.add(TXT_CONTRASENA);
        VENTANA.add(CAMPO_CONTRASENA);
        VENTANA.add(BTN_INICIO);
        VENTANA.add(TXT_SESION_FALLIDA);
        VENTANA.add(IMAGEN_FONDO);
        
    }
    
    //Ventana principal
    private final JFrame VENTANA = new JFrame();
    
    //Imagen de fondo
    private final JLabel IMAGEN_FONDO = new JLabel();
    private final String RUTA_IMAGEN = GestorDatos.getImagenUno();
    private final ImageIcon IMAGEN = new ImageIcon(RUTA_IMAGEN);
    
    //Etiquetas de texto
    private final JLabel TXT_USUARIO = new JLabel();
    private final JLabel TXT_CONTRASENA = new JLabel();
    private final JLabel TXT_NOMBRE_EMPRESA = new JLabel();
    private final JLabel TXT_SESION_FALLIDA = new JLabel();
    
    //Campos de entrada de texto
    private final JTextField CAMPO_USUARIO = new JTextField();
    private final JPasswordField CAMPO_CONTRASENA = new JPasswordField();
    
    //Boton
    private final JButton BTN_INICIO = new JButton();
}
