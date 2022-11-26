package Main;

//Importar paquetes
import GUI.InicioSesion;
import GestorCRUD.GestorDatos;

//Importar excepciones
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
<<<<<<< HEAD
        InicioSesion inicioSesion = new InicioSesion(GestorDatos.leerDatos(GestorDatos.getRutaUsuarios()));
=======
        InicioSesion inicioSesion = new InicioSesion(GestorUsuarios.leerUsuarios());
        //esto es una prueba de git
>>>>>>> 75ff8a1174c5f2fb4f1dc153141dcaa5e0a2fe4d
    }
}