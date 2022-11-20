
package GestorCRUD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestorDatos {
    //Archivo donde se almacenan los usuarios
    private static final String RUTA_USUARIOS = "src\\main\\java\\ArchivosCSV\\usuarios.csv"; 
    //Archivo donde se almacena el inventario
    private static final String RUTA_INVENTARIO = "src\\main\\java\\ArchivosCSV\\inventario.csv";
    
    public static String getRutaUsuarios(){
        return RUTA_USUARIOS;
    }
    
    public static String getRutaInventario(){
        return RUTA_INVENTARIO;
    }
    
//    public static void crearDatos(String nombre, String contrasena, String rol) throws FileNotFoundException, IOException{
//        BufferedReader lector = new BufferedReader(new FileReader(ARCHIVO));
//        FileWriter escritor = new FileWriter(ARCHIVO);
//        
//        double numero;
//        String id = null;
//        
//        while ((numero = Math.random()) == 1.0){
//            id = String.valueOf(numero * 1000);
//        }
//        
//        escritor.append("\n" + id + "," + nombre + "," + contrasena + "," + rol);
//        escritor.close();
//    }
    
    //Lee los usuarios de un archivo externo y los guarda en una matriz
    public static String[][] leerDatos(String ruta) throws FileNotFoundException, IOException{
        BufferedReader lector = new BufferedReader(new FileReader(ruta));
        
        //Almacena todo el contenido del archivo de usuarios (a excepción del encabezado)
        String txtDatos = "";
        
        //Cantidad de usuarios
        int contadorDatos = 0;
        
        //Almacena una línea del texto, la cual es un usuario con sus atributos
        String usuario;
        
        //El bucle guarda los usuarios en al variable uno a uno. Se detiene cuando no hayan más usuarios por guardar
        while((usuario = lector.readLine()) != null){
            if (txtDatos.equals("")){
                txtDatos += usuario;
            }
            else{
                txtDatos += "\n" + usuario;
            }
            contadorDatos ++;
        }
        
        //Lista de datos
        String[][] contenedorDatos = new String[contadorDatos][];
        
        //Añadir cada dato individual a la lista
        for(int i = 0; i < contadorDatos; i++){
            contenedorDatos[i] = txtDatos.split("\n")[i].split(",");
        }
        
        //Cerrar el lector y enviar el resultado
        lector.close();
        
        return contenedorDatos;
    }
    
//    public static void editarDatos(String id, String nombre, String contrasena, String rol) throws FileNotFoundException, IOException{
//        BufferedReader lector = new BufferedReader(new FileReader(ARCHIVO));
//        FileWriter escritor = new FileWriter(ARCHIVO);
//        String txtDatos = "";
//        String usuario;
//        
//        lector.readLine();
//        txtDatos += lector.readLine();
//        
//        while((usuario = lector.readLine()) != null){
//            txtDatos += "\n" + usuario;
//        }
//        
//        escritor.write(txtDatos + "\n" + id + "," + nombre + "," + contrasena + "," + rol);
//    }
    
//    public static boolean eliminarDatos(String id) throws FileNotFoundException, IOException{
//        BufferedReader lector = new BufferedReader(new FileReader(ARCHIVO));
//        FileWriter escritor = new FileWriter(ARCHIVO);
//        String usuario;
//        String txtDatosSuperior = "";
//        String txtDatosInferior = "";
//        boolean validacion = false;
//        
//        lector.readLine();
//        txtDatosSuperior += lector.readLine();
//        
//        while ((usuario = lector.readLine()) != null){
//                if (id.equals(usuario.split(",")[0])){
//                    validacion = true;
//                    
//                    if ((usuario = lector.readLine()) != null){
//                        txtDatosInferior += usuario;
//                    }
//                    
//                    break;
//                }
//                else{
//                    txtDatosSuperior += "\n" + lector.readLine();
//                }
//        }
//        
//        while ((usuario = lector.readLine()) != null){
//            txtDatosInferior += usuario;
//        }
//        
//        escritor.write(txtDatosSuperior + "\n" + txtDatosInferior);
//        
//        escritor.close();
//        lector.close();
//        
//        return validacion;
//    }
}
