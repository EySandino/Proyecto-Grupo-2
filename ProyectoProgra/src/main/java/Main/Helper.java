package Main;

//Importar clases
import java.util.Random;

public class Helper {
    public static String crearID(String tipoDato){
        if (tipoDato.equals("inventario")){
            Random generador = new Random();
            String contenedor = "";
            
            for (int i = 0; i < 5; i++){
                boolean usarLetra;
                
                if ((usarLetra = generador.nextBoolean()) == true){
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
            return "";
        }
    }
}