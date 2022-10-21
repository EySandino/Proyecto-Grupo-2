package Main;

import GUI.InicioSesion;
import GestorDatos.LectorUsuarios;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        InicioSesion inicioSesion = new InicioSesion(LectorUsuarios.leerUsuarios());
    }
}
