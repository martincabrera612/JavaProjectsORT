//Martin Cabrera 185091 Michel Kuza 242483
package dominio;

import interfaz.*;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.Serializable;

public class Sistema implements Serializable {

    private ArrayList<Tema> listaTemas;
    private ArrayList<Tema> listaTemasDisponibles;
    private ArrayList<Tema> listaTemasSeleccionados;
    private ArrayList<Pregunta> listaPreguntasJugar;

    public Sistema() {
        listaTemas = new ArrayList<>();
        listaTemasDisponibles = new ArrayList<>();
        listaTemasSeleccionados = new ArrayList<>();
        listaPreguntasJugar = new ArrayList<>();

    }

    public ArrayList<Tema> getListaTemas() {
        return listaTemas;
    }

    public ArrayList<Tema> getListaTemasDisponibles() {
        return listaTemasDisponibles;
    }

    public ArrayList<Tema> getListaTemasSeleccionados() {
        return listaTemasSeleccionados;
    }

    public ArrayList<Pregunta> getListaPreguntasJugar() {
        return listaPreguntasJugar;
    }

    public void agregarTemaSeleccionado(Tema unTema) {
        getListaTemasSeleccionados().add(unTema);
        getListaTemasDisponibles().remove(unTema);
    }

    public void quitarTemaSeleccionado(Tema unTema) {
        getListaTemasSeleccionados().remove(unTema);
        getListaTemasDisponibles().add(unTema);
    }

    public void agregarTema(Sistema sistema, Tema unTema, VentanaGestionarTemas ventana) {

        boolean repetido = false;

        for (int i = 0; i < sistema.listaTemas.size(); i++) {
            if (unTema.getNombre().toUpperCase().equals(sistema.listaTemas.get(i).getNombre().toUpperCase()) && !repetido) {
                repetido = true;
                //(ventana,"Ese tema ya esta registrado");
                JOptionPane.showMessageDialog(ventana, "Ese tema ya esta registrado", "", JOptionPane.INFORMATION_MESSAGE);

            }
        }
        if (!repetido) {
            sistema.listaTemas.add(unTema);
            sistema.getListaTemasDisponibles().add(unTema);

        }

    }

    public void agregarTemaCargarArchivo(Sistema sistema, Tema unTema) {

        boolean repetido = false;

        for (int i = 0; i < sistema.listaTemas.size(); i++) {
            if (unTema.getNombre().toUpperCase().equals(sistema.listaTemas.get(i).getNombre().toUpperCase()) && !repetido) {
                repetido = true;
                //(ventana,"Ese tema ya esta registrado");
                System.out.println("Ese tema ya esta registrado");

            }
        }
        if (!repetido) {
            sistema.listaTemas.add(unTema);
            sistema.getListaTemasDisponibles().add(unTema);

        }

    }

    public void agregarPregunta(Sistema sistema, String unaPregunta, String unaRespuesta, Tema unTema) {
        boolean repetido = false;
        for (int j = 0; j < unTema.getListaPreguntas().size(); j++) {
            Pregunta pregunta = unTema.getListaPreguntas().get(j);
            if ((pregunta.getPregunta().toUpperCase()).equals(unaPregunta.toUpperCase())) {
                repetido = true;

                unTema.getListaPreguntas().get(j).setRespuesta(unaRespuesta);
                if (unaPregunta.length() < 30) {
                    System.out.println("Es facil");
                } else {
                    System.out.println("Es dificil");
                }
            }
        }
        if (!repetido) {
            Pregunta nuevaPregunta = new Pregunta(unaPregunta, unaRespuesta, unTema);
            unTema.getListaPreguntas().add(nuevaPregunta);

        }

    }

    /*
    public void informarDificultad(Pregunta pregunta) {
        if (pregunta.getPregunta().length() < 30) {
            System.out.println("Es facil");
        } else {
            System.out.println("Es dificil");
        }
    }

*/

    public void modificarDescripcion(Sistema unSistema, int indice, String nuevaDescripcion, VentanaGestionarTemas ventanaGestionarTemas) {

        try {
            unSistema.listaTemas.get(indice).setDescripcion(nuevaDescripcion);

        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(ventanaGestionarTemas, "Seleccione un tema", "Info", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void eliminarTema(Sistema sistema, int indice, VentanaGestionarTemas ventanaGestionarTemas) {
        try {
            if (sistema.listaTemas.get(indice).getListaPreguntas().size() == 0) {
                sistema.listaTemas.remove(sistema.listaTemas.get(indice));
            } else {
                JOptionPane.showMessageDialog(ventanaGestionarTemas, "No puede eliminar este tema, contiene preguntas", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(ventanaGestionarTemas, "Seleccione otro tema", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

}
