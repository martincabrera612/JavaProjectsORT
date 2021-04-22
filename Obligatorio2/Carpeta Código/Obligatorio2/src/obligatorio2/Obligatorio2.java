//Martin Cabrera 185091 Michel Kuza 242483
package obligatorio2;

import interfaz.VentanaPrincipal;
import java.io.*;
import java.nio.file.*;
import dominio.*;
import java.io.ObjectInputStream;
import interfaz.*;


public class Obligatorio2 {

    public static void main(String[] args) {
        Sistema unSistema;
        String ruta = "";
        //Serializable 
       
       
        try {
            FileInputStream archivo = new FileInputStream("archivos/datos");
            ObjectInputStream info = new ObjectInputStream(archivo);
            unSistema = (Sistema) info.readObject();
           

        } catch (Exception e) {
            System.out.println("No hay datos guardados");
            unSistema = new Sistema();
        }

        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(unSistema);
        ventanaPrincipal.setVisible(true);

    }

}
