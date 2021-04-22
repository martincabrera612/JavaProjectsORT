//Martin Cabrera 185091 Michel Kuza 242483
package obligatorio1;

public class Jugador {

    //variables de Instancia
    private String nombre;
    private int edad;
    private String alias;
    private int cantPartidasJugadas;
    private int cantPartidasGanadas;
    private String letra;
    
    //Constructor
    
    public Jugador () {
        this.setNombre ("Sin nombre");
        this.setEdad (0);
        this.setAlias ("Sin alias");
        this.cantPartidasGanadas = 0;
        this.cantPartidasJugadas = 0;
        this.setLetra ("-");
    }
    
    public Jugador (String unNombre, int unaEdad, String unAlias, String unaLetra) {
        this.setNombre(unNombre);
        this.setEdad(unaEdad);
        this.setAlias(unAlias);
        this.setLetra (unaLetra);
    }
    

    // metodos de acceso y modificacion 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }
    
    public int getEdad(){ 
        return edad;
    }
    
    public void setEdad(int unaEdad) {
        edad = unaEdad;
    }
    

    public String getAlias() {
        return alias;
    }

    public void setAlias (String unAlias) {
        alias = unAlias;
    }
    
    public int getCantPartidasJugadas(){ 
        return cantPartidasJugadas;
    }
    
    public int getCantPartidasGanadas(){ 
        return cantPartidasGanadas;
    }
    
    public String getLetra() {
        return letra;
    }
    
    public void setLetra (String unaLetra) {
        letra = unaLetra;
    }
    
    
    
    
    @Override 
    public String toString () {
        return (this.getNombre() + " " +this.getEdad()+ " "+ this.getAlias() );
    }
    
     
}
