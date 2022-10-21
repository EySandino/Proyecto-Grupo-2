package GestorDatos;

public class Usuario {
    public Usuario(String nombre, String rol, String id){
        this.NOMBRE_USUARIO = nombre;
        this.ROL_USUARIO = rol;
        this.ID_USUARIO = id;
    }
    
    private final String NOMBRE_USUARIO;
    private final String ROL_USUARIO;
    private final String ID_USUARIO;
}
