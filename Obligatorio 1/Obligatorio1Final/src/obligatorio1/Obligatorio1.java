//Martin Cabrera 185091 Michel Kuza 242483
package obligatorio1;

import java.util.*;

public class Obligatorio1 {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Partida partida = new Partida();
        menuGeneral(sistema, partida);
        

    }

    //Menu General 
    public static void menuGeneral(Sistema sistema, Partida partida) {
        Scanner input = new Scanner(System.in);
        int opcion = 0;
        boolean terminarGeneral = false;
        
        while (!terminarGeneral) {
            //Menu afuera del juego
            System.out.println("1. Registrar Jugador");
            System.out.println("2. Jugar a Sumas ");
            System.out.println("3. Ver ranking de jugadores");
            System.out.println("4. Termina");
            System.out.println("");
            System.out.println("Escribe el numero de la opcion");
            boolean correcto = false;
            //Manejo de Exception
            while (!correcto) {
                try {
                    opcion = input.nextInt();
                    correcto = true;

                } catch (InputMismatchException e) {
                    System.out.println("Ingrese nuevamente el numero de opcion");
                    input.nextLine();
                }
            }

            if (opcion == 1) {
                registrarJugador(sistema);
            } else {
                if (opcion == 2) {
                    if (sistema.getListaJugadores().size() >= 2) {
                        partida.jugarSumas(sistema);

                    } else {
                        System.out.println("No hay al menos 2 jugadores registrados");
                    }
                } else {
                    if (opcion == 3) {

                        //RANKING
                        
                        
                        
                    } else {
                        if (opcion == 4) {
                            terminarGeneral = true;
                        }
                    }
                }
            }

        }
    }

    //REGISTRAR JUGADOR
    public static void registrarJugador(Sistema sistema) {

        Scanner input = new Scanner(System.in);
        Jugador jugador = new Jugador();
        System.out.println("Ingrese el nombre del jugador: ");
        jugador.setNombre(input.nextLine());
        System.out.println("Ingrese la edad del jugador: ");
        boolean correcto = false;
        int edad = 0;
        while (!correcto) {
            try {
                jugador.setEdad(input.nextInt());
                correcto = true;
            } catch (InputMismatchException e) {
                System.out.println("Error al ingresar edad, Ingrese nuevamente: ");
                input.nextLine();
            }
        }

        //Si listaJugadores esta vacio lo agrega de una 
        if (sistema.getListaJugadores().isEmpty()) {
            System.out.println("Ingrese el alias del jugador: ");
            input.nextLine();
            jugador.setAlias(input.nextLine().toUpperCase());
            sistema.getListaJugadores().add(jugador);
            sistema.getListaJugadoresDisponibles().add(jugador);
        } else {
            //Si el alias no esta repetido en listaJugadores lo agrega
            input.nextLine();
            String aux = "";
            boolean noEsUnico = true;
            while (noEsUnico) {
                System.out.println("Ingrese un alias de jugador que no este repetido: ");
                aux = input.nextLine().toUpperCase();
                for (int i = 0; i < sistema.getListaJugadores().size() && noEsUnico; i++) {
                    if (!(aux.equals(sistema.getListaJugadores().get(i).getAlias().toUpperCase()))) {
                        jugador.setAlias(aux);
                        sistema.getListaJugadores().add(jugador);
                        sistema.getListaJugadoresDisponibles().add(jugador);
                        noEsUnico = false;
                    }
                }
            }
        }

    }

}
