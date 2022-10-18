package Usuarios;

import javax.swing.JOptionPane;

public class Autenticacion {
    private static void autUsuario(int tipoUsuario){
        //Solicitar al usuario su ID
        while (true) {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID"));
            
            if (id > Usuario.id){
                System.out.println("Ingrese un ID válido.");
            }
            else{
                break;
            }
        }
        //Solicitar al usuario su contraseña
        while (true) {
            String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña");
            
            if (contrasena != Usuario.contrasena){
                System.out.println("Contraseña incorrecta.");
            }
            else{
                break;
            }
        }
        
        System.out.println("Se ha registrado como: " + Usuario.nombre + ".");
    }
}
