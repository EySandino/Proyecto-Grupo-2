package GestorCRUD;

public class Usuario {
    private static String rolUsuario;
    private static String nombreUsuario;
    
    public static void setNombreUsuario(String nombre){
        nombreUsuario = nombre;
    }
    
    public static void setRolUsuario(String rol){
        rolUsuario = rol;
    }
    
    public static String getNombreUsuario(){
        return nombreUsuario;
    }
    
    public static String getRolUsuario(){
        return rolUsuario;
    }
}
