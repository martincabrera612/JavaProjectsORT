//Martin Cabrera 185091 Michel Kuza 242483
package obligatorio1;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Jugador> listaJugadores;
    private ArrayList<Jugador> listaJugadoresDisponibles;
    private ArrayList<Jugador> listaJugadoresSeleccionados;
    private ArrayList<Partida> listaPartidas;

    public Sistema() {
        listaJugadores = new ArrayList<Jugador>();
        listaJugadoresDisponibles = new ArrayList<Jugador>();
        listaJugadoresSeleccionados = new ArrayList<Jugador>();
    }

    public ArrayList<Partida> getListaPartida() {
        return listaPartidas;
    }

    public void AgregarListaPartidas(Partida unaPartida) {
        this.listaPartidas.add(unaPartida);
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public ArrayList<Jugador> getListaJugadoresSeleccionados() {
        return listaJugadoresSeleccionados;
    }

    public ArrayList<Jugador> getListaJugadoresDisponibles() {
        return listaJugadoresDisponibles;
    }

    public void borrarJugadorDisponible(Jugador jugador) {
        this.getListaJugadoresDisponibles().remove(jugador);
    }

    public void reiniciarListaJugadoresDisponibles(Sistema unSistema) {
        ArrayList jugadoresDisp = unSistema.getListaJugadoresDisponibles();
        ArrayList jugadoresRegistrados = unSistema.getListaJugadores();
        //Borra todos los jugadores Disponibles
        jugadoresDisp.clear();
        //Los agrera de nuevo a la lista
        for (int i = 0; i < jugadoresRegistrados.size(); i++) {
            Jugador jugador = unSistema.getListaJugadores().get(i);
            jugadoresDisp.add(jugador);
        }
    }

    public static void mostrarJugadores(ArrayList lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ". " + lista.get(i));

        }
    }

}
