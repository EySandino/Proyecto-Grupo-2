
package GestorDatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Usuarios {
    public static String[][] leerUsuarios() throws FileNotFoundException, IOException{
        //Lee los usuarios de un archivo externo y los guarda en una matriz
        
        String archivo = "src\\main\\java\\ArchivosCSV\\usuarios.csv"; //archivo donde se almacenan los usuarios
        
        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        String usuario = ""; //Almacena una línea del texto, la cual es un usuario con sus atributos
        String txtUsuarios = ""; //Almacena todo el contenido del archivo de usuarios (a excepción del encabezado)
        int contadorDatos = 1; //Cantidad de usuarios
        
        lector.readLine(); //El primer dato es el cabezado. No es necesario añadirlo a la matriz
        txtUsuarios += lector.readLine(); //El primer usuario se almecena fuera del bucle
        
        //El bucle guarda los usuarios en al variable uno a uno. Se detiene cuando no hayan más usuarios por guardar
        while((usuario = lector.readLine()) != null){
            txtUsuarios += "\n" + usuario;
            contadorDatos ++;
        }
        
        /*
        A continuación se crea una matriz en la que se almacenará cada usuario.
        La mátriz dispone de un número de columnas que varía en función a la variable contadorUsuarios
        El número de filas es de 3. cada elemento se organiza de la siguiente forma:
        - ID
        - Nombre de Usuario
        - Contraseña
        - Rol del usuario
        */
        
        String[][] contenedorUsuarios = new String[contadorDatos][4];
        int contador = 0;
        
        for(String i : txtUsuarios.split("\n")){
            contenedorUsuarios[contador] = i.split(",");
            
            contador ++;
        }
        
        return contenedorUsuarios;
    }
}
