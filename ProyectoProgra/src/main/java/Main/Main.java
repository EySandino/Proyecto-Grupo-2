package Main;

//Importar paquetes
import GUI.InicioSesion;
import GUI.Tabla;
import GestorCRUD.GestorDatos;

//Importar excepciones
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        InicioSesion inicioSesion = new InicioSesion(GestorDatos.leerDatos(GestorDatos.getRutaUsuarios()));
        
        //Propositos de testeo (se borra despues de comprobar que el codigo este bien)
        Tabla ventanaInventario = new Tabla("inventario");
    }
}