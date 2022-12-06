
package GestorCRUD;

//Importar paquetes
import Main.Helper;

//Importar Lectores
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

//Importar escritor
import java.io.FileWriter;

//Import excepciones
import java.io.IOException;
import java.lang.RuntimeException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
    private static final String IMAGEN_TRES = "src\\main\\java\\Imagenes\\FondoTres.jpg";
    
    //Obtener la ruta de las imagenes
    public static String getImagenUno(){
        return IMAGEN_UNO;
    }

    public static String getImagenDos(){
        return IMAGEN_DOS;
    }
    
    public static String getImagenTres(){
        return IMAGEN_TRES;
    }
    
    //Crea un nuevo elemenento para ser almacenado en un archivo especifico
    public static void crearDato(String tipoDato, String atributos) throws FileNotFoundException, IOException{
        //Especificar a que tabla se desea acceder
        String ruta = "";
        if (tipoDato.equals("inventario")){
            ruta = getRutaInventario();

        }
        else if (tipoDato.equals("usuario")){
            ruta = getRutaUsuarios();
        }
        
        //Crear el escritor y la tabla de archivos existentes
        String[][] listaDatos = leerDatos(ruta);
        FileWriter escritor = new FileWriter(ruta);
        
        //Generar un identificador para el nuevo elemento de la tabla (el cual no se puede repetir)
        String id = "";
        boolean seguirCorriendo;
        do{
            seguirCorriendo = false;
            id = Helper.crearID(tipoDato);
            
            for (int i = 0; i < listaDatos.length; i++){
                if (id.equals(listaDatos[i][0])){
                    seguirCorriendo = true;
                    break;
                }
            }
        }
        while(seguirCorriendo);
        
        //Almacenar todos los datos en un contenedor
        String contenedor = "";
        for (int i = 0; i < listaDatos.length; i++){
            for (int j = 0; j < listaDatos[0].length; j++){
                if (j == 0){
                    contenedor += listaDatos[i][j];
                }
                else {
                    contenedor += "," + listaDatos[i][j];
                }
            }
            
            contenedor += "\n";
        }
        
        contenedor += id + atributos;
        
        //Agregar el nuevo elemento a la tabla y cerrar el escritor
        escritor.append(contenedor);
        escritor.close();
    }
    
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

    //Elimina un elemento existente de un archivo especifico
    public static boolean eliminarDatos(String id, String tipoDato) throws FileNotFoundException, IOException{
        //Especificar a que tabla se desea acceder
        String ruta = "";
        if (tipoDato.equals("inventario")){
            ruta = getRutaInventario();

        }
        else if (tipoDato.equals("usuario")){
            ruta = getRutaUsuarios();
        }
        
        FileWriter escritor = new FileWriter(ruta);
        String[][] listaDatos = leerDatos(ruta);

        int indiceDatoEliminado;
        for (int i = 0; i < listaDatos.length; i++){
            if (id.equals(listaDatos[i][0])){
                indiceDatoEliminado = i;
            }
        }
        
        try {
            String contenedor = "";
            for (int i = 0; i < listaDatos.length; i++){
                if (indiceDatoEliminado == i){
                    continue;
                }
                else{
                    for (int j = 0; j < listaDatos[0].length; j++){
                        if (j == 0){
                            contenedor += "," + listaDatos[i][j];
                        }
                        else {
                            contenedor += listaDatos[i][j];
                        }
                    }
                    
                    contenedor += "\n";
                }
            }
            
            escritor.write(contenedor);
            
            escritor.close();
            return true;
        }
        catch (RuntimeException e){
            escritor.close();
            return false;
        }
    }
}
