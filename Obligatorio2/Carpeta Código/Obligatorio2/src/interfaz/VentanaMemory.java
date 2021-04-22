//Martin Cabrera 185091 Michel Kuza 242483
package interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import dominio.Sistema;
import dominio.*;
import java.applet.*;
import java.util.ArrayList;

public class VentanaMemory extends javax.swing.JFrame {

    private JButton[][] botones;

    public VentanaMemory(Sistema unSistema) {
        initComponents();
        sistema = unSistema;
        int cantFilas = 3;
        int cantColumnas = 4;
        botones = new JButton[cantFilas][cantColumnas];
        for (int i = 0; i < cantFilas; i++) {
            for (int j = 0; j < cantColumnas; j++) {
                JButton jButton = new JButton();
                jButton.addActionListener(new ListenerBoton(i, j));
                panelInferior.add(jButton);
                botones[i][j] = jButton;

            }

        }
        titulos();
       

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        botonAtras = new javax.swing.JButton();
        ayudaParcialBoton = new javax.swing.JButton();
        ayudaTotalBoton = new javax.swing.JButton();
        resetBoton = new javax.swing.JButton();
        sonidoBoton = new javax.swing.JButton();
        labelPuntos = new javax.swing.JLabel();
        panelInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        botonAtras.setText("Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });
        panelSuperior.add(botonAtras);

        ayudaParcialBoton.setText("Ayuda Parcial");
        ayudaParcialBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaParcialBotonActionPerformed(evt);
            }
        });
        panelSuperior.add(ayudaParcialBoton);

        ayudaTotalBoton.setText("Ayuda Total");
        ayudaTotalBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaTotalBotonActionPerformed(evt);
            }
        });
        panelSuperior.add(ayudaTotalBoton);

        resetBoton.setText("Reset");
        resetBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBotonActionPerformed(evt);
            }
        });
        panelSuperior.add(resetBoton);

        sonidoBoton.setText("Sonido");
        sonidoBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sonidoBotonMouseClicked(evt);
            }
        });
        panelSuperior.add(sonidoBoton);

        labelPuntos.setText("Puntos: ----");
        panelSuperior.add(labelPuntos);

        getContentPane().add(panelSuperior);

        panelInferior.setLayout(new java.awt.GridLayout(3, 4));
        getContentPane().add(panelInferior);

        setBounds(0, 0, 730, 510);
    }// </editor-fold>//GEN-END:initComponents

    public void titulos() {
        String titulos = "";
        for (int i = 0; i < sistema.getListaTemasSeleccionados().size(); i++) {
            titulos = titulos + " " + sistema.getListaTemasSeleccionados().get(i).getDescripcion();
        }
        this.setTitle(titulos);
    }

    public void noRepetidas(ArrayList<Pregunta> todasLasPreguntas) {
        ArrayList<Pregunta> enJuego = new ArrayList<>();

        int cont = 0;
        while (cont < 6) {
            int random = (int) (Math.random() * (todasLasPreguntas.size() - 1) + 1);
            Pregunta pregunta = todasLasPreguntas.get(random);
            if(! buscar(enJuego, pregunta)) {
                enJuego.add(pregunta);
                cont++;
            }
           
            
        }
        for (int i = 0; i < enJuego.size(); i++) {
            System.out.println(enJuego.get(i));
        }
    }
    
    public boolean buscar(ArrayList<Pregunta> enJuego, Pregunta pregunta) {
        boolean rep = false;
         for (int i = 0; i < enJuego.size(); i++) {
                if (pregunta.getPregunta().equals(enJuego.get(i).getPregunta()))  {
                    rep = true;
                }
            }
         return rep;
    }
    
    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void sonidoBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sonidoBotonMouseClicked

        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("sonido.wav"));
        sonido.play();
        System.out.println("Se reproduce");
    }//GEN-LAST:event_sonidoBotonMouseClicked

    private void ayudaParcialBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaParcialBotonActionPerformed
        ayudaParcial();
    }//GEN-LAST:event_ayudaParcialBotonActionPerformed

    private void resetBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBotonActionPerformed
        reset();
    }//GEN-LAST:event_resetBotonActionPerformed

    private void ayudaTotalBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaTotalBotonActionPerformed
        ayudaTotal();
    }//GEN-LAST:event_ayudaTotalBotonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ayudaParcialBoton;
    private javax.swing.JButton ayudaTotalBoton;
    private javax.swing.JButton botonAtras;
    private javax.swing.JLabel labelPuntos;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JButton resetBoton;
    private javax.swing.JButton sonidoBoton;
    // End of variables declaration//GEN-END:variables
    private Sistema sistema;

    private class ListenerBoton implements ActionListener {

        private int x;
        private int y;

        public ListenerBoton(int i, int j) {
            //en el constructor se almacena la fila y columna que se presiono
            x = i;
            y = j;

        }

        public void actionPerformed(ActionEvent e) {
            // cuando se presiona un botón, se ejecutará este método 
            clickBoton(x, y);
        }

    }

    private void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                botones[i][j].setText("");
            }
        }
    }

    private void asignarBoton(int s, int d) {
        ayudaParcial();
        int rangoPreg = sistema.getListaPreguntasJugar().size() - 1;
        int random = (int) (Math.random() * rangoPreg) + 1;
        ArrayList<Pregunta> pregunta = temasAzar();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (botones[i][j].getText().equals("Pregunta")) {
                    botones[i][j].setText(pregunta.get(random).getPregunta());
                    //sistema.getListaPreguntasJugar().remove(pregunta.get(random));
                } else {
                    botones[i][j].setText(pregunta.get(random).getRespuesta());
                    //sistema.getListaPreguntasJugar().remove(pregunta.get(random));
                }
            }
        }
    }

    private void clickBoton(int fila, int columna) {
        asignarBoton(fila, columna);
    }

    private void ayudaTotal() {
        ayudaParcial();
        asignarBoton(3, 4);
        /*for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                asignarBoton(i, j);
            }
        }*/
    }

    private ArrayList<Pregunta> todasLasPreguntas() {
        ArrayList<Pregunta> lasPreguntas = new ArrayList<>();
        for (int i = 0; i < sistema.getListaTemasSeleccionados().size(); i++) {
            Tema unTema = sistema.getListaTemasSeleccionados().get(i);
            for (int j = 0; j < unTema.getListaPreguntas().size(); j++) {
                Pregunta unaPregunta = unTema.getListaPreguntas().get(j);
                lasPreguntas.add(unaPregunta);
            }
        }

        return lasPreguntas;
    }

    private ArrayList<Pregunta> temasAzar() {
        //ArrayList<Pregunta> array = new ArrayList<>();
        ArrayList<Pregunta> arrayAux = new ArrayList<>();
        for (int i = 0; i < sistema.getListaTemasSeleccionados().size(); i++) {
            Tema unTema = sistema.getListaTemasSeleccionados().get(i);
            for (int j = 0; j < unTema.getListaPreguntas().size(); j++) {
                Pregunta pregunta = unTema.getListaPreguntas().get(j);
                sistema.getListaPreguntasJugar().add(pregunta);
            }

        }

        int cont = 0;
        int rangoTemas = sistema.getListaTemasSeleccionados().size() - 1;
        while (cont < 6) {
            int random = (int) (Math.random() * rangoTemas) + 1;
            Tema unTema = sistema.getListaTemasSeleccionados().get(random);
            int rangoPreguntas = unTema.getListaPreguntas().size() - 1;
            random = (int) (Math.random() * rangoTemas) + 1;
            int randomPreg = (int) (Math.random() * rangoPreguntas) + 1;
            Pregunta pregunta = unTema.getListaPreguntas().get(randomPreg);
            sistema.getListaPreguntasJugar().add(pregunta);
            sistema.getListaPreguntasJugar().remove(pregunta);
            cont++;

        }

        return sistema.getListaPreguntasJugar();
    }

    private void ayudaParcial() {
        String respuesta = "Respuesta";
        String pregunta = "Pregunta";
        botones[0][0].setText(respuesta);
        botones[0][0].setForeground(Color.BLUE);
        botones[0][1].setText(respuesta);  //respuesta
        botones[0][1].setForeground(Color.BLUE);
        botones[0][2].setText(pregunta);
        botones[0][2].setForeground(Color.RED);
        botones[0][3].setText(pregunta);
        botones[0][3].setForeground(Color.RED);
        botones[1][0].setText(respuesta);  //respuesta
        botones[1][0].setForeground(Color.BLUE);
        botones[1][1].setText(pregunta);
        botones[1][1].setForeground(Color.RED);
        botones[1][2].setText(pregunta);
        botones[1][2].setForeground(Color.RED);
        botones[1][3].setText(respuesta);  //respuesta
        botones[1][3].setForeground(Color.BLUE);
        botones[2][0].setText(pregunta);
        botones[2][0].setForeground(Color.RED);
        botones[2][1].setText(respuesta);  //respuesta
        botones[2][1].setForeground(Color.BLUE);
        botones[2][2].setText(pregunta);
        botones[2][2].setForeground(Color.RED);
        botones[2][3].setText(respuesta);  //respuesta
        botones[2][3].setForeground(Color.BLUE);

    }
}
