//Martin Cabrera 185091 Michel Kuza 242483
package obligatorio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Partida {

    Tablero tablero = new Tablero();
    private int idPartida;

    public Partida() {
        this.setIdPartida(0);
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int numIdPartida) {
        idPartida = numIdPartida;
    }

    //Generar valor de dados aleatorios
    public String[] generarDados() {
        String[] arrayDados = new String[5];
        int aux = 0;
        for (int i = 0; i < arrayDados.length; i++) {
            aux = (int) (Math.random() * 6 + 1);
            arrayDados[i] = Integer.toString(aux);
        }
        return arrayDados;
    }

    public void jugarSumas(Sistema unSistema) {
        restablecerPartida(unSistema);
        asignarLetra(seleccionarJugador(unSistema), unSistema);
        asignarLetra(seleccionarJugador(unSistema), unSistema);
        menuSumas(unSistema);

    }

    public boolean elegirModo(Sistema unSistema) {
        boolean datosMal = true;
        Scanner input = new Scanner(System.in);
        boolean modoReal = true;

        String[] dados = generarDados();

        while (datosMal) {
            System.out.println("Ingrese el modo de juego: (Test o Real)");
            String modoElegido = input.nextLine().toUpperCase();
            if (modoElegido.equals("TEST")) {
                datosMal = false;
                modoReal = false;

            } else {
                if (modoElegido.equals("REAL")) {
                    datosMal = false;

                } else {
                    System.out.println("Modo mal ingresado (Test o Real)");
                }

            }
        }
        return modoReal;
    }

    public void GanadoryPerdedor(boolean perdedorAutomatico,int turno, int puntajeJugador1, int puntajeJugador2, Jugador jugador1, Jugador jugador2) {
        if (perdedorAutomatico) {
            if(turno %2 ==0 ) {
                System.out.println("El ganador es: " + jugador2.getAlias());
            }else {
                System.out.println("El ganador es: " + jugador1.getAlias());
            }
        } else {
            System.out.println("El puntaje de " + jugador1.getAlias() + " es" + puntajeJugador1);
            System.out.println("El puntaje de " + jugador2.getAlias() + " es" + puntajeJugador2);

            if (puntajeJugador1 > puntajeJugador2) {
                System.out.println("El ganador es: " + jugador1.getAlias());
            } else {
                if (puntajeJugador1 == puntajeJugador2) {
                    System.out.println("Hay empate");
                } else {
                    System.out.println("El ganador es: " + jugador2.getAlias());
                }
            }
        }

    }

    //Agregar que no ingreso una opcion valida
    public void menuSumas(Sistema unSistema) {

        Scanner input = new Scanner(System.in);
        boolean terminar = false;
        boolean modoReal = elegirModo(unSistema);
        String opcion = "";
        int turno = 0;
        Jugador jugador1 = unSistema.getListaJugadoresSeleccionados().get(0);
        Jugador jugador2 = unSistema.getListaJugadoresSeleccionados().get(1);
        String letraJ1 = jugador1.getLetra();
        String letraJ2 = jugador2.getLetra();
        String mostrarTurno = "";
        int puntajeJugador1 = 0;
        int puntajeJugador2 = 0;
        boolean perdedorAutomatico = false;

        //va cambiando  los turnos
        while (!terminar) {
            String[] dados = new String[5];
            if (turnoPar(turno)) { // Turno pares son del Jugador1 

                mostrarTurno = ("Turno de " + jugador1.getAlias());
                if (modoReal) {
                    dados = generarDados();
                } else {
                    dados = pedirDadosTest();
                }

            } else { // impar son del jugador 2

                mostrarTurno = ("Turno de " + jugador2.getAlias());
                if (modoReal) {
                    dados = generarDados();
                } else {
                    dados = pedirDadosTest();
                }

            }
            //Menu sumas

            tablero.mostrarTablero(tablero.getTablero(), dados, mostrarTurno);
            System.out.println("X ->Abandona y pierde partida");
            System.out.println("P -> Pasar de turno ");
            System.out.println("0 -> Usar solo el dado Base");
            System.out.println("1 -> Usar dados extra");
            System.out.println("A -> Solicitar Ayuda");
            System.out.println("Escribe el numero de la opcion");
            opcion = input.nextLine().toUpperCase();
            //esta booleana controla que se eligio bien una opcion
            boolean opcionBien = false;
            boolean noEstaOcupado = false;

            while (!noEstaOcupado && !opcionBien) {

                if (opcion.equals("X")) {
                        perdedorAutomatico = true;
                        
                        terminar = true;
                        opcionBien = true;
                        puntajeJugador1 = recorrerHorizontal(tablero.getTablero(), jugador1) + recorrerVertical(tablero.getTablero(), jugador1) + Diagonales(tablero.getTablero(), letraJ1) + DiagonalesInvertidas(tablero.getTablero(), letraJ1);
                        puntajeJugador1 = recorrerHorizontal(tablero.getTablero(), jugador2) + recorrerVertical(tablero.getTablero(), jugador2) + Diagonales(tablero.getTablero(), letraJ2) + DiagonalesInvertidas(tablero.getTablero(), letraJ2);
                        System.out.println(recorrerHorizontal(tablero.getTablero(), jugador1));
                        System.out.println(recorrerVertical(tablero.getTablero(), jugador1));
                        System.out.println(Diagonales(tablero.getTablero(), letraJ2));
                        System.out.println(DiagonalesInvertidas(tablero.getTablero(), letraJ1));
                        System.out.println(recorrerHorizontal(tablero.getTablero(), jugador2));
                        System.out.println(recorrerVertical(tablero.getTablero(), jugador2));
                        System.out.println(Diagonales(tablero.getTablero(), letraJ1));
                        System.out.println(DiagonalesInvertidas(tablero.getTablero(), letraJ2));
                        GanadoryPerdedor( perdedorAutomatico, turno, puntajeJugador1, puntajeJugador2, jugador1, jugador2);
                    }else {
                    if (opcion.equals("P")) {
                        opcionBien = true;
                        turno++;//pasar turno
                        generarDados();
                    } else {
                        if (opcion.equals("0")) {
                            opcionBien = true;
                            //usar solo el dado base
                            String dado = dados[0];
                            if (turnoPar(turno)) {
                                noEstaOcupado = tablero.sustituirEnTablero(dado, letraJ1, letraJ2, tablero.getTablero(), turno);

                            } else {
                                noEstaOcupado = tablero.sustituirEnTablero(dado, letraJ2, letraJ1, tablero.getTablero(), turno);
                            }
                            if (noEstaOcupado) {

                                turno++; //pasar turno
                            } else {
                                System.out.println("Ese lugar esta ocupado, Elija otro por favor");
                                opcionBien = false;
                                System.out.println("Ingrese nuevamente la opcion");
                                opcion = input.nextLine().toUpperCase();
                            }
                        } else {

                            if (opcion.equals("A")) {

                                //solicitar ayuda
                                ayuda(dados, tablero);
                                System.out.println("Escriba el numero de la opcion");
                                opcion = input.nextLine().toUpperCase();
                            } else {

                                // Indica los dados Extra
                                if (opcion.equals("1")) {
                                    opcionBien = true;

                                    int suma = usarDadosExtra(dados);
                                    while (suma > 20) {
                                        suma = usarDadosExtra(dados);
                                    }
                                    String sumaDeDados = String.valueOf(suma);

                                    if (turnoPar(turno)) {
                                        noEstaOcupado = tablero.sustituirEnTablero(sumaDeDados, letraJ1, letraJ2, tablero.getTablero(), turno);

                                    } else {
                                        noEstaOcupado = tablero.sustituirEnTablero(sumaDeDados, letraJ2, letraJ1, tablero.getTablero(), turno);
                                    }
                                    if (noEstaOcupado) {

                                        turno++; //pasar turno
                                    } else {
                                        System.out.println("Ese lugar esta ocupado, Elija otro por favor");
                                        opcionBien = false;
                                        System.out.println("Ingrese nuevamente la opcion");
                                        opcion = input.nextLine().toUpperCase();
                                    }

                                } else {
                                    System.out.println("Ingrese nuevamente la opcion");
                                    opcion = input.nextLine().toUpperCase();
                                }
                            }
                        }
                    }
                }
                }
                if (tablero.estaLleno(tablero)) {
                    puntajeJugador1 = recorrerHorizontal(tablero.getTablero(), jugador1) + recorrerVertical(tablero.getTablero(), jugador1) + Diagonales(tablero.getTablero(), letraJ2) + DiagonalesInvertidas(tablero.getTablero(), letraJ1);
                    puntajeJugador1 = recorrerHorizontal(tablero.getTablero(), jugador2) + recorrerVertical(tablero.getTablero(), jugador2) + Diagonales(tablero.getTablero(), letraJ1) + DiagonalesInvertidas(tablero.getTablero(), letraJ2);
                    GanadoryPerdedor(perdedorAutomatico, turno, puntajeJugador1, puntajeJugador2, jugador1, jugador2);
                    terminar = true;
                }
            }
        }

    

    

    

    

    

    

    public Jugador seleccionarJugador(Sistema sistema) {
        Scanner input = new Scanner(System.in);
        int opcion = 0;
        boolean esCorrecto = false;

        Jugador jugador = new Jugador();
        while (!(esCorrecto)) {
            sistema.mostrarJugadores(sistema.getListaJugadoresDisponibles());
            System.out.println("Ingrese un numero de jugador que se encuentre en la lista");
            boolean estaBien = false;

            //Manejo de Exception
            while (!estaBien) {
                try {
                    opcion = input.nextInt();
                    estaBien = true;

                } catch (InputMismatchException e) {
                    System.out.println("Ingrese nuevamente el numero de opcion");
                    input.nextLine();
                }
            }

            if (opcion < sistema.getListaJugadoresDisponibles().size()) {
                esCorrecto = true;
            }
        }
        for (int j = 0; j < sistema.getListaJugadoresDisponibles().size(); j++) {
            if ((opcion == j)) {
                jugador = sistema.getListaJugadoresDisponibles().get(j);
                sistema.borrarJugadorDisponible(jugador);
            }
        }
        sistema.getListaJugadoresSeleccionados().add(jugador);
        return jugador;
    }

    public String asignarLetra(Jugador jugador, Sistema sistema) {
        Scanner input = new Scanner(System.in);
        String aux = "";
        boolean noEsUnico = true;
        while (noEsUnico) {
            System.out.println("Eliga una letra para representar al jugador que no este repetida: ");
            aux = input.nextLine().toUpperCase();

            if (!(aux.equals(sistema.getListaJugadoresSeleccionados().get(0).getLetra().toUpperCase())) && aux.length() < 2) {
                jugador.setLetra(aux);
                noEsUnico = false;
            }

        }
        return jugador.getLetra();
    }

    public boolean turnoPar(int turno) {
        return ((turno % 2) == 0);
    }

    public String[] pedirDadosTest() {
        Scanner input = new Scanner(System.in);
        String[] dadosTest = new String[5];
        for (int i = 0; i < dadosTest.length; i++) {
            System.out.println("Ingrese el valor del dado (Entre 1 y 6): ");
            dadosTest[i] = input.nextLine();
        }
        System.out.println("Los dados son: " + Arrays.toString(dadosTest));
        return dadosTest;
    }

    public int usarDadosExtra(String[] dados) {
        Scanner input = new Scanner(System.in);
        String[] dadosUsados = dadosExtra(dados);
        int suma = 0;
        for (int i = 0; i < dadosUsados.length; i++) {
            suma += Integer.parseInt(dadosUsados[i]);
            if (suma > 20) {
                System.out.println("La suma de sus dados elegidos se pasa de 20");
            }
        }
        System.out.println(suma);
        return suma;
    }

    public String[] dadosExtra(String[] dados) {
        Scanner input = new Scanner(System.in);
        String[] dadosAux = {dados[0], "0", "0", "0", "0"};
        for (int i = 1; i < dadosAux.length; i++) {
            dadosAux[i] = dados[i];
        }
        String[] arrayElegidos = {dadosAux[0], "0", "0", "0", "0"};
        boolean unaVez = true;
        boolean terminar = false;
        int cont = 0;

        while (!terminar && cont < 4) {
            System.out.println("Ingrese el valor de los dados extra que quiere usar: ");
            String elegido = input.nextLine();

            for (int i = 1; i < dadosAux.length && unaVez; i++) {
                if (elegido.equals(dadosAux[i])) {
                    arrayElegidos[i] = elegido;
                    dadosAux[i] = "0";
                    unaVez = false;
                    cont++;
                }
            }
            System.out.print("Sus dados elegidos son: ");
            System.out.println(Arrays.toString(arrayElegidos));
            System.out.println(Arrays.toString(dadosAux));
            if (cont < 4) {
                System.out.println("¿Quiere ingresar otro valor? s/n");
                String opcion = input.nextLine();
                if (opcion.toUpperCase().equals("S")) {
                    unaVez = true;
                } else {
                    if (opcion.toUpperCase().equals("N")) {
                        terminar = true;
                    }
                }
            }
        }
        return arrayElegidos;
    }

    public void ayuda(String[] dados, Tablero tablero) {
        int[] dadosInt = convertirIntDados(dados);
        int base = dadosInt[0];
        int suma = base;
        boolean terminar = true;
        boolean sinJugada = true;
        if (tablero.estaLibre(tablero, base)) {
            System.out.println("Puede utilizar el dado base: " + base);
            terminar = false;
            sinJugada = false;
        } else {
            for (int i = 1; i < dados.length && terminar; i++) {
                suma += dadosInt[i];
                if (tablero.estaLibre(tablero, suma)) {
                    System.out.println("Los dados extra que puede utilizar son: " + dadosInt[i]);
                    terminar = false;
                    sinJugada = false;
                }

                for (int j = i + 1; j < dados.length && terminar; j++) {
                    suma = base;
                    suma += dadosInt[i] + dadosInt[j];
                    if (tablero.estaLibre(tablero, suma)) {
                        System.out.println("Los dados extra que puede utilizar son: " + dadosInt[i] + " " + dadosInt[j]);
                        terminar = false;
                        sinJugada = false;
                    }
                    for (int k = j + 1; k < dados.length && terminar; k++) {
                        suma = base;
                        suma += dadosInt[i] + dadosInt[j] + dadosInt[k];
                        if (tablero.estaLibre(tablero, suma)) {
                            System.out.println("Los dados extra que puede utilizar son: " + dadosInt[i] + " " + dadosInt[j] + " " + dadosInt[k]);
                            terminar = false;
                            sinJugada = false;
                        } else {
                            suma = base + dadosInt[1] + dadosInt[2] + dadosInt[3] + dadosInt[4];
                            if (tablero.estaLibre(tablero, suma)) {
                                System.out.println("Los dados extra que puede utilizar son: " + dadosInt[1] + " " + dadosInt[2] + " " + dadosInt[3] + " " + dadosInt[4]);
                                terminar = false;
                                sinJugada = false;
                            }
                        }
                    }
                }

            }

        }
        if (sinJugada) {
            System.out.println("No tiene ninguna jugada posible");
            terminar = false;
        }
    }

    public int[] convertirIntDados(String[] dados) {
        int[] dadosInt = new int[5];
        for (int i = 0; i < dados.length; i++) {
            dadosInt[i] = Integer.parseInt(dados[i]);
        }
        return dadosInt;
    }

    public void restablecerPartida(Sistema unSistema) {
        //Restablecer Letras
        restablecerLetras(unSistema);
        //Todos los jugadores previamente registrados quedan como disponibles
        unSistema.reiniciarListaJugadoresDisponibles(unSistema);
        tablero.reiniciarTablero();
        //Borra los jugadores seleccionados de cada partida
        unSistema.getListaJugadoresSeleccionados().clear();

    }

    public void restablecerLetras(Sistema unSistema) {
        //Restablecer Letras
        for (int i = 0; i < unSistema.getListaJugadoresSeleccionados().size(); i++) {
            unSistema.getListaJugadoresSeleccionados().get(i).setLetra("");
        }

    }

    public int recorrerHorizontal(String[][] unTablero, Jugador unJugador) {
        String[][] tablero = unTablero;
        String letra = unJugador.getLetra();
        int[] sumaFila = new int[4];
        int sumaTotal = 0;
        for (int i = 0; i < tablero.length; i++) {
            int cont = 0;
            for (int j = 0; j < tablero[0].length; j++) {
                String pos = tablero[i][j];
                if (pos.contains(letra)) {
                    cont++;

                } else {
                    if (!pos.contains(letra) && cont < 3) {
                        cont = 0;
                    }
                }
                if (cont >= 3 && cont <= 5) {
                    sumaFila[i] = cont;
                }
            }

        }

        for (int i = 0; i < sumaFila.length; i++) {
            sumaTotal += sumaFila[i];
        }
        return sumaTotal;
    }

    public int recorrerVertical(String[][] unTablero, Jugador unJugador) {
        String[][] tablero = unTablero;
        String letra = unJugador.getLetra();
        int[] suma = new int[5];
        int sumaTotalVertical = 0;
        int cont = 0;
        boolean yaSumo = false;

        for (int j = 0; j < tablero[0].length; j++) {
            cont = 0;
            //Si son 4
            for (int i = 1; i < 2; i++) {
                if ((tablero[i - 1][j]).contains(letra) && tablero[i][j].contains(letra) && tablero[i + 1][j].contains(letra) && tablero[i + 2][j].contains(letra)) {
                    cont = 4;
                    suma[j] = 4;
                    yaSumo = true;

                }
            }

            //Si son 3
            for (int i = 1; i <= 2; i++) {
                if ((tablero[i - 1][j]).contains(letra) && tablero[i][j].contains(letra) && tablero[i + 1][j].contains(letra) && !yaSumo) {
                    cont = 3;
                    if (cont == 3) {
                        suma[j] = 3;
                    }

                }
            }

        }

        for (int i = 0; i < suma.length; i++) {
            sumaTotalVertical += suma[i];

        }
        return sumaTotalVertical;
    }

    public int Diagonales(String[][] unTablero, String unaLetra) {
        String[][] tablero = unTablero;
        String letra = unaLetra;
        int[] suma = new int[4];
        int sumaTotal = 0;
        boolean yaSumo = false;
        //primera diagonal de 4
        if (tablero[0][0].contains(letra) && tablero[1][1].contains(letra) && tablero[2][2].contains(letra) && tablero[3][3].contains(letra)) {
            suma[1] = 4;
            yaSumo = true;
        }

        //primera diagonal de 4 (primer caso de 3 ptos)
        if (tablero[0][0].contains(letra) && tablero[1][1].contains(letra) && tablero[2][2].contains(letra) && !yaSumo) {
            suma[1] = 3;
            yaSumo = true;
        }
        //primera diagonal de 4 (segundo caso de 3 ptos)
        if (tablero[1][1].contains(letra) && tablero[2][2].contains(letra) && tablero[3][3].contains(letra) && !yaSumo) {
            suma[1] = 3;
            yaSumo = true;
        }

        //segunda diagonal de 4
        if (tablero[0][1].contains(letra) && tablero[1][2].contains(letra) && tablero[2][3].contains(letra) && tablero[3][4].contains(letra)) {
            suma[2] = 4;
            yaSumo = true;
        }

        //segunda diagonal de 4 (primer caso de 3 ptos)
        if (tablero[0][1].contains(letra) && tablero[1][2].contains(letra) && tablero[2][3].contains(letra) && !yaSumo) {
            suma[2] = 3;
            yaSumo = true;
        }
        //segunda diagonal de 4 (segundo caso de 3 ptos)
        if (tablero[1][2].contains(letra) && tablero[2][3].contains(letra) && tablero[3][4].contains(letra) && !yaSumo) {
            suma[2] = 3;
            yaSumo = true;
        }

        //1era Diagonal de 3 
        if (tablero[1][0].contains(letra) && tablero[2][1].contains(letra) && tablero[3][2].contains(letra)) {
            suma[0] = 3;
        }
        //Segunda Diagonal de 3 
        if (tablero[0][2].contains(letra) && tablero[1][3].contains(letra) && tablero[2][4].contains(letra)) {
            suma[3] = 3;
        }

        //suma final
        for (int i = 0; i < suma.length; i++) {
            sumaTotal += suma[i];
        }

        return sumaTotal;
    }

    public int DiagonalesInvertidas(String[][] unTablero, String unaLetra) {
        int sumaTotal = 0;
        String[][] tablero = unTablero;
        String letra = unaLetra;
        int[] suma = new int[4];
        boolean yaSumo = false;

        //primera diagonal invertida
        if (tablero[0][2].contains(letra) && tablero[1][1].contains(letra) && tablero[2][0].contains(letra)) {
            suma[0] = 3;
        }
        //cuarto diagonal invertida
        if (tablero[1][4].contains(letra) && tablero[2][3].contains(letra) && tablero[3][2].contains(letra)) {
            suma[4] = 3;
        }

        //tercera diagonal invertida de 4
        if (tablero[0][4].contains(letra) && tablero[1][3].contains(letra) && tablero[2][2].contains(letra) && tablero[3][1].contains(letra)) {
            suma[3] = 4;
            yaSumo = true;
        }
        //sean 3 puntos de la tercera diagonal
        if (tablero[0][4].contains(letra) && tablero[1][3].contains(letra) && tablero[2][2].contains(letra) && !yaSumo) {
            suma[3] = 3;
            yaSumo = true;
        }

        if (tablero[1][3].contains(letra) && tablero[2][2].contains(letra) && tablero[3][1].contains(letra) && !yaSumo) {
            suma[3] = 3;
            yaSumo = true;
        }

        //segunda diagonal invertida de 4
        if (tablero[0][3].contains(letra) && tablero[1][2].contains(letra) && tablero[2][1].contains(letra) && tablero[3][0].contains(letra)) {
            suma[2] = 4;
            yaSumo = true;
        }

        if (tablero[0][3].contains(letra) && tablero[1][2].contains(letra) && tablero[2][1].contains(letra) && !yaSumo) {
            suma[2] = 3;
            yaSumo = true;
        }

        if (tablero[1][2].contains(letra) && tablero[2][1].contains(letra) && tablero[3][0].contains(letra) && !yaSumo) {
            suma[2] = 3;
            yaSumo = true;
        }

        for (int i = 0; i < 4; i++) {
            sumaTotal += suma[i];
        }

        return sumaTotal;
    }
}
