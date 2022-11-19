package Main;

import GUI.InicioSesion;
import GestorDatos.GestorUsuarios;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        InicioSesion inicioSesion = new InicioSesion(GestorUsuarios.leerUsuarios());
        //esto es una prueba de git
    }
}
