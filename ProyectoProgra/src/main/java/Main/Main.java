package Main;

//Importar paquetes
import GUI.InicioSesion;
import GestorCRUD.GestorDatos;

//Importar excepciones
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            InicioSesion inicioSesion = new InicioSesion(GestorDatos.leerDatos(GestorDatos.getRuta(GestorDatos.USUARIO)));
        }
        catch (IOException ex){}
    }
}