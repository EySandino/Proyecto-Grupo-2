
package Usuarios;

public class Usuario {
    protected static int id; //Auto incremento de 1
    protected static int tipoUsuario; //tipoUsuario == 1: es un administrador | tipoUsuario == 2: es un vendedor
    protected static String nombre;
    protected static String contrasena;
    
    Usuario(int id, int tipoUsuario, String nombre, String contrasena){
        this.id = id;
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
}
