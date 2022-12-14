package Main;

//Importar paquetes
import GUI.Facturas;
import GestorCRUD.GestorDatos;
import java.awt.TextArea;
import java.io.IOException;

//Importar clases
import java.util.Random;
import javax.swing.JOptionPane;

public class Helper {
    //Crea un ID para cuando el usuario crea un usuario o un elemento para el inventario
    public static String crearID(String tipoDato){
        if (tipoDato.equals("inventario")){
            Random generador = new Random();
            String contenedor = "";
            
            for (int i = 0; i < 5; i++){
                boolean usarLetra;
                
                if (usarLetra = generador.nextBoolean()){
                    contenedor += (char) (generador.nextInt(26) + 65);
                }
                else {
                    contenedor += (char) (generador.nextInt(10) + 48);
                }
            }
            
            return contenedor;
        }
        else if (tipoDato.equals("usuario")){
            return String.valueOf((int) (Math.random() * 1000));
        }
        else {
            return null;
        }
    }
    
    //Retorna el valor de indice del id ingresado. Retorna -1 si no encuentra ningun valor
    public static int getIndice(String id, String ruta) throws IOException{
        int indice = -1;
        
        String[][] listaDatos = GestorDatos.leerDatos(ruta);

        for (int i = 0; i < listaDatos.length; i++){
            if (id.equals(listaDatos[i][0])){
                indice = i;
                break;
            }
        }
        
        return indice;
    }
    
    public static void imprimeMensaje(TextArea mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public static void limpiarProductos(){
        Facturas.productos = "";
    }
    
    public static void limpiarPrecios(){
        Facturas.precios = "";
    }
}