
package GestorCRUD;

//Importar Lectores
import java.io.FileReader;
import java.io.BufferedReader;

//Importar escritor
import java.io.FileWriter;

//Import excepciones
import java.io.IOException;
import java.io.FileNotFoundException;

public class GestorDatos {
    //Archivo donde se almacenan los usuarios
    private static final String RUTA_USUARIOS = "src\\main\\java\\ArchivosCSV\\usuarios.csv"; 
    //Archivo donde se almacenan los elementos del inventario
    private static final String RUTA_INVENTARIO = "src\\main\\java\\ArchivosCSV\\inventario.csv";
    
    //Obtener la ruta de los archivos
    public static String getRutaUsuarios(){
        return RUTA_USUARIOS;
    }

    public static String getRutaInventario(){
        return RUTA_INVENTARIO;
    }
    
    //Rutas de las imagenes de fondo
    private static final String IMAGEN_UNO = "src\\main\\java\\Imagenes\\FondoUno.jpg";
    private static final String IMAGEN_DOS = "src\\main\\java\\Imagenes\\FondoDos.jpg";
    
    //Obtener la ruta de las imagenes
    public static String getImagenUno(){
        return IMAGEN_UNO;
    }

    public static String getImagenDos(){
        return IMAGEN_DOS;
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
    
    //Lee los usuarios de un archivo externo y los almacena en un vector de dos dimensiones
    public static String[][] leerDatos(String ruta) throws FileNotFoundException, IOException{
        BufferedReader lectorDatos = new BufferedReader(new FileReader(ruta));
        
        //Almacena todo el contenido del archivo
        String txtDatos = "";
        
        //Cantidad de datos en el archivo CSV
        int contadorDatos = 0;
        
        //Lee una linea de texto del archivo original a la vez
        String usuario;
        
        //Almacena todas las lineas de texto en la variable txtDatos una a la vez. Se detiene cuando no hayan mas lineas de texto por almacenar
        while((usuario = lectorDatos.readLine()) != null){
            if (txtDatos.equals("")){
                txtDatos += usuario;
            }
            else{
                txtDatos += "\n" + usuario;
            }
            
            contadorDatos ++;
        }
        
        //Vector en el que el contenido de txtDatos sera almacenado 
        String[][] contenedorDatos = new String[contadorDatos][];
        
        //Se agrega una linea de text a la vez al vector en forma de vector unidimensional
        for(int i = 0; i < contadorDatos; i++){
            contenedorDatos[i] = txtDatos.split("\n")[i].split(",");
        }
        
        //Cerrar el lector y retornar el resultado
        lectorDatos.close();
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
