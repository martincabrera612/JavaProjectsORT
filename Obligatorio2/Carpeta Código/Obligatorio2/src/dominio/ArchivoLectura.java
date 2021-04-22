//Martin Cabrera 185091 Michel Kuza 242483
package dominio;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Date;
import java.time.*;
import interfaz.*;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class ArchivoLectura {

    private Date date = new Date();
    private Scanner in;
    private VentanaCargarArchivos ventanaCargarArchivos;
    private int preguntasAgregadas = 0;
    private int preguntasIgnoradas = 0;
    private int preguntasActualizadas = 0;
    

    public ArchivoLectura(Sistema unSistema, VentanaCargarArchivos unaVentanaCargarArchivos) {
        ventanaCargarArchivos = unaVentanaCargarArchivos;

    }

    public void mostrarInfoPreguntas() {
        ventanaCargarArchivos.labelPregAgregadas.setText("Preguntas Agregadas: " + preguntasAgregadas);
        ventanaCargarArchivos.labelPregIgnoradas.setText("Preguntas Ignoradas: " + preguntasIgnoradas);
    }

    public String[] arrayBitacora() {
        String lineas = "";
        try {
            in = new Scanner(Paths.get("BITACORA.txt"));
            while (in.hasNextLine()) {
                lineas = lineas + "#" + (in.nextLine());
            }
            in.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
        String[] datos = lineas.split("#");

        return datos;
    }

    public void bitacora() {

        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MMM-yy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora = LocalTime.now();
        
        String[] anterior = arrayBitacora();
        try {
            Formatter arch = new Formatter("BITACORA.txt");
            
            String texto = ("Preguntas Agregadas: " + preguntasAgregadas
                    + " " + "Preguntas Actualizadas: " + preguntasActualizadas + " "
                    + "Preguntas Ignoradas: " + preguntasIgnoradas + " Hora: " + hora.format(formatoHora) + " Fecha: " + fecha.format(formatoFecha));
            for (int i = 0; i < anterior.length; i++) {
                if (!(anterior[i].equals(""))) {
                    arch.format("%s%n", anterior[i]);
                }
            }
            arch.format("%s%n", texto);
            arch.close();
        } catch (FileNotFoundException e) {
            System.out.println("LOL");
        }

    }

    public void leer(Sistema unSistema, String unNombre, VentanaCargarArchivos unaVentanaCargarArchivos) {
        String tema = "";
        String pregunta = "";
        String respuesta = "";
        int indiceTema = 0;
        int indicePregunta = 0;
        boolean yaExisteTema = false;
        boolean existePregunta = false;
        int cantidadLineas = 0;
        String total = "";
        //Intento obtener el archivo y la cantidad de lineas en el
        try {
            in = new Scanner(Paths.get(unNombre));
            while (in.hasNextLine()) {
                if (total.equals("")) {
                    total = (in.nextLine());
                } else {
                    total = total + "#" + (in.nextLine());
                }

            }
            in.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
        String[] datos = total.split("#");
        for (int k = 0; k < datos.length - 2; k = k + 3) {
            tema = datos[k];
            pregunta = datos[k + 1];
            respuesta = datos[k + 2];

            //Compruebo si la pregunta es valida 
            if (esValida(tema, pregunta, respuesta)) {

                // Me fijo si el tema indicado ya existe
                for (int i = 0; i < unSistema.getListaTemas().size(); i++) {
                    if (tema.toUpperCase().equals(unSistema.getListaTemas().get(i).getNombre().toUpperCase())) {
                        indiceTema = i;
                        yaExisteTema = true;
                        Tema unTema = unSistema.getListaTemas().get(indiceTema);
                        // Si existe el tema, chequeo si existe en su lista de preguntas
                        for (int j = 0; j < unTema.getListaPreguntas().size(); j++) {
                            if (pregunta.toUpperCase().equals(unTema.getListaPreguntas().get(j).getPregunta().toUpperCase())) {
                                indicePregunta = j;
                                existePregunta = true;
                            }

                        }
                    }
                }
                //Si ya existe el tema 
                if (yaExisteTema) {
                    //Si ya existe la pregunta actualizo la respuesta
                    if (existePregunta) {
                        Tema unTema = unSistema.getListaTemas().get(indiceTema);
                        unTema.getListaPreguntas().get(indicePregunta).setRespuesta(respuesta);
                        preguntasActualizadas++;
                        bitacora();
                        System.out.println("se actualizo la respuesta");

                    } else {
                        //Si ya existe el tema le agrego la pregunta
                        Tema unTema = unSistema.getListaTemas().get(indiceTema);
                        unSistema.agregarPregunta(unSistema, pregunta, respuesta, unTema);
                        preguntasAgregadas++;
                        bitacora();
                        System.out.println("Se agrego bien");
                    }
                } else {
                    //Creo el tema y le agrego la pregunta
                    Tema unTema = new Tema(tema);
                    unSistema.agregarTemaCargarArchivo(unSistema, unTema);
                    unSistema.agregarPregunta(unSistema, pregunta, respuesta, unTema);
                    preguntasAgregadas++;
                    bitacora();
                    System.out.println("El tema nuevo se agrego bien");
                }
            } else {
                preguntasIgnoradas++;
                bitacora();
                System.out.println("Se ignoro una pregunta");
            }
        }
        //}

        //}
        ventanaCargarArchivos.labelPregAgregadas.setText("Preguntas Agregadas: " + preguntasAgregadas);
        ventanaCargarArchivos.labelPregIgnoradas.setText("Preguntas Ignoradas: " + preguntasIgnoradas);
        ventanaCargarArchivos.labelPregActualizadas.setText("Preguntas Actualizadas: " + preguntasActualizadas);
    }

    public boolean esValida(String tema, String pregunta, String respuesta) {
        boolean valido = false;
        if ((!pregunta.equals("") && !respuesta.equals("") && !tema.equals(""))) {
            valido = true;
        }

        return valido;

    }
}
