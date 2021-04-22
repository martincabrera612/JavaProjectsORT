//Martin Cabrera 185091 Michel Kuza 242483
package interfaz;

import dominio.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VentanaJuegoFlash extends javax.swing.JFrame {

    public VentanaJuegoFlash(Sistema unSistema) {
        initComponents();
        sistema = unSistema;
        indiceTema = 0;
        indicePregunta = 0;

    }

    public void mostrarPregunta(int i, int j) {
        try {
            Tema unTema = sistema.getListaTemasSeleccionados().get(i);        
            Pregunta pregunta = unTema.getListaPreguntas().get(j);
            String texto = pregunta.getPregunta();
            botonMostrarTexto.setText(texto);
        } catch (IndexOutOfBoundsException e) {
            //ignorar
        }
    }

    public void atrasPregunta(int indiceTema, int indicePregunta) {
        if (indicePregunta > 0) {
            indicePregunta--;
        } else {
            indicePregunta = (sistema.getListaTemas().get(indiceTema).getListaPreguntas().size() - 1);
            if (indiceTema > 0) {
                indiceTema--;

            } else {
                JOptionPane.showMessageDialog(this, "No hay preguntas anterior a esta");
            }
        }
    }

    // Metodo para cambiar hacia adelante las preguntas en Flash Cards
    public void siguienteFlash() {
        try {
            if ((indicePregunta == sistema.getListaTemas().get(indiceTema).getListaPreguntas().size() - 1) && (indiceTema == sistema.getListaTemas().size() - 1)) {
                JOptionPane.showMessageDialog(this, "No hay mas preguntas ");
            } else {
                if (indicePregunta < sistema.getListaTemas().get(indiceTema).getListaPreguntas().size() - 1) {
                    indicePregunta++;
                } else {
                    indicePregunta = 0;
                    if (indiceTema < sistema.getListaTemas().size() - 1 && indicePregunta == 0) {
                        indiceTema++;
                        this.setTitle(sistema.getListaTemasSeleccionados().get(indiceTema).getNombre());
                    } else {
                        indicePregunta = 0;
                        indiceTema = 0;
                    }
                }
            }
        }catch (IndexOutOfBoundsException e) {
            indicePregunta = 0;
            indiceTema = 0;
            JOptionPane.showMessageDialog(this, "No hay mas preguntas ");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonAnterior = new javax.swing.JButton();
        botonSiguiente = new javax.swing.JButton();
        botonMostrarTexto = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonAnterior.setText("Anterior ");
        botonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnteriorActionPerformed(evt);
            }
        });

        botonSiguiente.setText("Siguiente");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        botonMostrarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarTextoActionPerformed(evt);
            }
        });

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(botonAnterior)
                .addGap(22, 22, 22)
                .addComponent(botonMostrarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(botonSiguiente)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonVolver)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(botonSiguiente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(botonAnterior))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(botonMostrarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(botonVolver)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonMostrarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarTextoActionPerformed

        Tema unTema = sistema.getListaTemasSeleccionados().get(indiceTema);
        Pregunta pregunta = unTema.getListaPreguntas().get(indicePregunta);
        String texto = pregunta.getRespuesta();
        botonMostrarTexto.setText(texto);
        if ((botonMostrarTexto.getText()).equals(texto) && !alternar) {
            alternar = true;
        } else {
            texto = pregunta.getPregunta();
            alternar = false;
            botonMostrarTexto.setText(texto);

        }
    }//GEN-LAST:event_botonMostrarTextoActionPerformed

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed

        siguienteFlash();
        mostrarPregunta(indiceTema, indicePregunta);

    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void botonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnteriorActionPerformed

        atrasFlash();
        mostrarPregunta(indiceTema, indicePregunta);
    }//GEN-LAST:event_botonAnteriorActionPerformed
    // Metodo para cambiar hacia atras las preguntas en Flash Cards
    public void atrasFlash() {
        try{ 
            if (indicePregunta > 0) {
            indicePregunta--;
        } else {

            if (indiceTema > 0) {
                indiceTema--;
                this.setTitle(sistema.getListaTemasSeleccionados().get(indiceTema).getNombre());
                indicePregunta = (sistema.getListaTemas().get(indiceTema).getListaPreguntas().size() - 1);
            } else {
                JOptionPane.showMessageDialog(this, "No hay preguntas anterior a esta");
            }
        }
        } catch (IndexOutOfBoundsException e) {
            indicePregunta = 0;
            indiceTema = 0;
            JOptionPane.showMessageDialog(this, "No hay preguntas anterior a esta");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnterior;
    private javax.swing.JButton botonMostrarTexto;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JButton botonVolver;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    private Sistema sistema;
    private int indiceTema;
    private int indicePregunta;
    private boolean alternar = false;
}
