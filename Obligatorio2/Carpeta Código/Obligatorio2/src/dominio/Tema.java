//Martin Cabrera 185091 Michel Kuza 242483
package dominio;

import java.util.ArrayList;
import java.io.Serializable;


public class Tema implements Serializable {

    private String nombre;
    private String descripcion;
    public int index; 
    private ArrayList<Pregunta> listaPreguntas;

    public Tema() {
       this.setNombre(nombre);
       this.setDescripcion("");
       this.listaPreguntas = new ArrayList<Pregunta>();
              
    }
      public Tema(String unNombre) {
       this.setNombre(unNombre);
       this.setDescripcion("A completar");
       this.listaPreguntas = new ArrayList<Pregunta>();
              
    }
      public Tema(String unNombre, String descripcion) {
       this.setNombre(unNombre);
       this.setDescripcion(descripcion);
       this.listaPreguntas = new ArrayList<Pregunta>();
              
    }

    public void agregarPreguntaRespuesta(String textoPregunta,String textoRespuesta, Tema unTema) {
       
        Pregunta pregunta = new Pregunta(textoPregunta,textoRespuesta,unTema);
        unTema.listaPreguntas.add(pregunta);
    }
    
 
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String unaDescripcion) {
        this.descripcion = unaDescripcion;
    }

    public ArrayList<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

   
    
    public String mostrarCantidadPreguntas() {
        return (this.getNombre() + " Cantidad de Preguntas: " + this.getListaPreguntas().size());
    }
    
    @Override 
    public String toString(){
        return (this.getNombre() + " descripcion: " +this.getDescripcion());
    }
    
}
