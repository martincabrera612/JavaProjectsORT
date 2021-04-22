//Martin Cabrera 185091 Michel Kuza 242483
package obligatorio1;

import java.util.Arrays;

public class Tablero {

    private String[][] tablero;
    public String[][] unTablero = {
        {"1", "2", "3", "4", "5"},
        {"6", "7", "8", "9", "10"},
        {"11", "12", "13", "14", "15"},
        {"16", "17", "18", "19", "20"}
    };

    public Tablero() {
        this.setTablero(unTablero);

    }

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] unTablero) {
        tablero = unTablero;
    }

    //Muestratablero  y los dados para cada turno de cada jugador
    public void mostrarTablero(String[][] tablero, String[] losDados, String texto) {
        String[][] xtablero = tablero;
        boolean listo = false;

        for (int i = 0; i < (xtablero.length / 2); i++) {
            for (int j = 0; j < (xtablero[0].length); j++) {
                System.out.print("\033[32m" + xtablero[i][j] + "        ");
            }
            System.out.println("");
        }

        for (int j = 2; j < xtablero.length; j++) {
            for (int k = 0; k < xtablero[0].length; k++) {
                System.out.print("\033[32m" + xtablero[j][k] + "       ");
            }
            System.out.println("");
        }
        System.out.println(texto);
        System.out.println("Los dados son: " + Arrays.toString(losDados));
        System.out.println("");
    }
    
    //Cambia el numero por la Letra en el tablero
    public boolean sustituirEnTablero(String unDado, String unaLetra, String otraLetra, String[][] elTablero, int unTurno) {

        boolean todoOk = false;
        for (int i = 0; i < elTablero.length; i++) {
            for (int j = 0; j < elTablero[0].length; j++) {
                String aux = elTablero[i][j];
                if (unDado.equals(aux) && estaLibreCasillero(aux, otraLetra)) {
                    // Si esta libre el lugar entonces avisa que salio bien 
                    todoOk = true;
                    if (unTurno % 2 == 0) {
                        //System.out.println(elTablero[i][j]);
                        if (Integer.parseInt(unDado) > 10) {
                            elTablero[i][j] = "\033[31m" + unaLetra + " ";
                        } else {
                            elTablero[i][j] = "\033[31m" + unaLetra + "";
                        }
                    } else {
                        //System.out.println(elTablero[i][j]);
                        if (Integer.parseInt(unDado) > 10) {
                            elTablero[i][j] = "\033[34m" + unaLetra + " ";
                        } else {
                            elTablero[i][j] = "\033[34m" + unaLetra;
                        }
                    }
                }
            }
        }
        // Si returna False (es porq no esta libre el lugar)
        return todoOk;
    }

    public boolean estaLibreCasillero(String elementoTablero, String letra) {
        boolean libre = true;
        if (libre) {
            if (elementoTablero.equals(letra)) {
                libre = false;
            }
        }
        return libre;
    }
    
    
    public void reiniciarTablero() {
        String[][] newTablero = {
            {"1", "2", "3", "4", "5"},
            {"6", "7", "8", "9", "10"},
            {"11", "12", "13", "14", "15"},
            {"16", "17", "18", "19", "20"}
        };
        this.setTablero(newTablero);
    }
    
    
    //Controla si en algun lugar del tablero hay una posicion disponible y devuelve True o False
    public boolean estaLleno(Tablero unTablero) {
        boolean sinLugarVacio = false;
        int cont = 0;
        for (int k = 1; k < 20; k++) {
            if(estaLibre(unTablero, k)) {
                cont++;
            }

        }
        if (cont == 0){
            sinLugarVacio= true;
        }
        return sinLugarVacio;
    }
    
    //Dice que hay un lugar libre en el tablero
    public boolean estaLibre (Tablero unTablero, int suma) {
        String[][] tab = unTablero.getTablero();
        boolean estaLibre = false;
        String sum = String.valueOf(suma);
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (sum.equals(tab[i][j])){
                    estaLibre = true;
                }
            }
        }
        
        return estaLibre;
    }
    
    //Muestra solo un tablero 
    public void showTablero (String[][] tab) {
          for (int i = 0; i < (tab.length / 2); i++) {
            for (int j = 0; j < (tab[0].length); j++) {
                System.out.print("\033[32m" + tab[i][j] + "        ");
            }
            System.out.println("");
        }

        for (int j = 2; j < tab.length; j++) {
            for (int k = 0; k < tab[0].length; k++) {
                System.out.print("\033[32m" + tab[j][k] + "       ");
            }
            System.out.println("");
        }
    }
    
    
}
