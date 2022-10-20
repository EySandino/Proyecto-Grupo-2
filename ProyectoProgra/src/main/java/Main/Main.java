package Main;

import GUI.InicioSesion;
import GestorDatos.Usuarios;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        InicioSesion inicioSesion = new InicioSesion(Usuarios.leerUsuarios());
    }
}
