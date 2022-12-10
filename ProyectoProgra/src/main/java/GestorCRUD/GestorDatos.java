
package GestorCRUD;

//Importar paquetes
import Main.Helper;

//Importar Lectores
import java.io.FileReader;
import java.io.BufferedReader;

//Importar escritor
import java.io.FileWriter;

//Import excepciones
import java.io.IOException;
import java.io.FileNotFoundException;

public class GestorDatos {
    //Constantes publicas
    public static final String INVENTARIO = "inventario";
    public static final String USUARIO = "usuario";
    
    //Archivo donde se almacenan los usuarios
    private static final String RUTA_USUARIOS = "src\\main\\java\\ArchivosCSV\\usuarios.csv";
    //Archivo donde se almacenan los elementos del inventario
    private static final String RUTA_INVENTARIO = "src\\main\\java\\ArchivosCSV\\inventario.csv";
    
    //Obtener la ruta de los archivos
    public static String getRuta(String tipoDato){
        if (tipoDato.equals(INVENTARIO)){
            return RUTA_INVENTARIO;
        }
        else if (tipoDato.equals(USUARIO)){
            return RUTA_USUARIOS;
        }
        else {
            return null;
        }
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
        String ruta = getRuta(tipoDato);
        
        //Crear el escritor y la tabla de archivos existentes. El escritor elimina todos los elementos del archivo existente
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
        String txtDatos = "";

        //Almacena todas las lineas de texto en la variable txtDatos una a la vez. Se detiene cuando no hayan mas lineas de texto por almacenar
        String usuario;
        int contadorDatos = 0; //Cantidad de datos en el archivo CSV
        while((usuario = lectorDatos.readLine()) != null){
            if (txtDatos.equals("")){
                txtDatos += usuario;
            }
            else{
                txtDatos += "\n" + usuario;
            }
            
            contadorDatos ++;
        }
        
        //Se agrega una linea de text a la vez al vector
        String[][] contenedorDatos = new String[contadorDatos][]; //Vector en el que el contenido de txtDatos sera almacenado
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
        String ruta = getRuta(tipoDato);
        
        //Se determina cual es el elemento que se debe eliminar
        int indiceDatoEliminado = Helper.getIndice(id, ruta);
        
        //Escrito y la lista de elementos existentes
        String[][] listaDatos = leerDatos(ruta);
        FileWriter escritor = new FileWriter(ruta);
        
        //Se elimina el elemento seleccionado. En caso de que el id no coincida con ningun dato, la funciona retorna el valor false
        String contenedor = "";
        if (indiceDatoEliminado != -1){
            for (int i = 0; i < listaDatos.length; i++){
                if (indiceDatoEliminado == i){
                    continue;
                }
                else{
                    for (int j = 0; j < listaDatos[0].length; j++){
                        if (j != 0){
                            contenedor += "," + listaDatos[i][j];
                        }
                        else {
                            contenedor += listaDatos[i][j];
                        }
                    }
                    
                    if (i != listaDatos.length - 1){
                        contenedor += "\n";
                    }
                }
            }
            
            escritor.write(contenedor);
            
            escritor.close();
            return true;
        }
        else{
            for (int i = 0; i < listaDatos.length; i++){
                for (int j = 0; j < listaDatos[0].length; j++){
                    if (j != 0){
                        contenedor += "," + listaDatos[i][j];
                    }
                    else {
                        contenedor += listaDatos[i][j];
                    }
                }
                
                if (i != listaDatos.length - 1){
                    contenedor += "\n";
                }
            }
            
            escritor.write(contenedor);
            
            escritor.close();
            return false;
        }
    }

    public static void modificarDato(String id, String atributos, String tipoDato) throws FileNotFoundException, IOException{
        //Especificar a que tabla se desea acceder
        String ruta = getRuta(tipoDato);
        String[] listaAtributos = atributos.replaceFirst(",", "").split(",");
        
        //Escrito y la lista de elementos existentes
        String[][] listaDatos = leerDatos(ruta);
        FileWriter escritor = new FileWriter(ruta);
        
        for (int i = 0; i < listaDatos.length; i++){
            if (id.equals(listaDatos[i][0])){
                for (int j = 0; j < listaAtributos.length; j++){
                    listaDatos[i][j + 1] = listaAtributos[j];
                }
            }
        }
        
        String contenedor = "";
        for (int i = 0; i < listaDatos.length; i++){
            for (int j = 0; j < listaDatos[0].length; j++){
                if (j != 0){
                    contenedor += "," + listaDatos[i][j];
                }
                else {
                    contenedor += listaDatos[i][j];
                }
            }

            if (i != listaDatos.length - 1){
                contenedor += "\n";
            }
        }
        
        escritor.write(contenedor);

        escritor.close();
    }
}
