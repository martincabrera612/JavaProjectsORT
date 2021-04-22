//Martin Cabrera 185091 Michel Kuza 242483
package dominio;
import java.io.Serializable;

public class Pregunta implements Serializable {

    private String pregunta;
    private String respuesta;
    private Tema tema;

    
    public Pregunta () {
        this.setPregunta("");
        this.setRespuesta("");
        this.setTema(tema);
    }
    
     public Pregunta (String pregunta, String respuesta, Tema tema) {
        this.setPregunta(pregunta);
        this.setRespuesta(respuesta);
        this.setTema(tema);
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Tema getTema() {
        return tema;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setPregunta(String unaPregunta) {
        this.pregunta = unaPregunta;
    }

    public void setRespuesta(String unaRespuesta) {
        this.respuesta = unaRespuesta;
    }
    
   @Override 
   public String toString() {
       return (this.getPregunta() + " | " + this.getRespuesta());
   }
    
    
}
