//Martin Cabrera 185091 Michel Kuza 242483
package interfaz;

import dominio.Pregunta;
import dominio.Sistema;
import dominio.Tema;
import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.lang.NullPointerException;
import java.lang.IndexOutOfBoundsException;

public class VentanaGestionarPreguntas extends javax.swing.JFrame {

    public VentanaGestionarPreguntas(Sistema unSistema) {
        initComponents();
        sistema = unSistema;
        listaTemasPreguntas.setListData(sistema.getListaTemas().toArray());
        listaTemasPreguntasTab2.setListData(sistema.getListaTemas().toArray());

    }

    public void modificarPregunta(Sistema sistema) {
        String nuevaPregunta = textoModificarPregunta.getText();
        int indiceTema = listaTemasPreguntasTab2.getSelectedIndex();
        int indicePregunta = listaPreguntasTab2.getSelectedIndex();

        try {
            Tema unTema = sistema.getListaTemas().get(indiceTema);
            Pregunta pregunta = unTema.getListaPreguntas().get(indicePregunta);
            pregunta.setPregunta(nuevaPregunta);
            mostrarListaPreguntas(sistema, unTema);

        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Seleccione un tema y una pregunta", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void modificarRespuesta(Sistema sistema) {
        String nuevaPregunta = textoModificarRespuesta.getText();
        int indiceTema = listaTemasPreguntasTab2.getSelectedIndex();
        int indicePregunta = listaPreguntasTab2.getSelectedIndex();

        try {
            Tema unTema = sistema.getListaTemas().get(indiceTema);
            Pregunta pregunta = unTema.getListaPreguntas().get(indicePregunta);
            pregunta.setRespuesta(nuevaPregunta);
            mostrarListaPreguntas(sistema, unTema);

        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Seleccione un tema y una pregunta", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void agregarPreguntayRespuesta(Sistema sistema) {
        String pregunta = textoPregunta.getText();
        String respuesta = textoRespuesta.getText();
        int indice = listaTemasPreguntas.getSelectedIndex();

        try {
            Tema tema = sistema.getListaTemas().get(indice);
            sistema.agregarPregunta(sistema, pregunta, respuesta, tema);
            if(pregunta.length() < 30) {
               JOptionPane.showMessageDialog(this, "Es facil", "Info", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this, "Es dificil", "Info", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Seleccione un tema", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void eliminarPregunta(Sistema sistema) {
        int indiceTema = listaTemasPreguntasTab2.getSelectedIndex();
        int indicePregunta = listaPreguntasTab2.getSelectedIndex();

        try {
            Tema unTema = sistema.getListaTemas().get(indiceTema);
            Pregunta pregunta = unTema.getListaPreguntas().get(indicePregunta);
            unTema.getListaPreguntas().remove(pregunta);
            mostrarListaPreguntas(sistema, unTema);

        } catch (IndexOutOfBoundsException e) {

            JOptionPane.showMessageDialog(this, "Seleccione un tema y una pregunta", "Info", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void mostrarListaPreguntas(Sistema unSistema, Tema unTema) {
        int indice = listaTemasPreguntasTab2.getSelectedIndex();
        Tema tema = unTema;

        try {
            if (tema.getListaPreguntas().size() > 0) {
                listaPreguntasTab2.setListData(tema.getListaPreguntas().toArray());

            }
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Este tema no tiene preguntas", "Info", JOptionPane.ERROR_MESSAGE);
        }
        // Si se borra la ultima pregunta limpia la lista
        if (tema.getListaPreguntas().isEmpty()) {
            listaPreguntasTab2.setListData(new Object[0]);

        }

    }

    public void actualizarListas() {
        //Actualiza lista Temas
        listaTemasPreguntas.setListData(sistema.getListaTemas().toArray());
        listaTemasPreguntasTab2.setListData(sistema.getListaTemas().toArray());

    }

    public JList getListaTemasPreguntas() {
        return listaTemasPreguntas;
    }

    public void setListaTemasPreguntas(JList listaTemasPreguntas) {
        this.listaTemasPreguntas = listaTemasPreguntas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTemasPreguntas = new javax.swing.JList();
        botonVolverPreguntas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoPregunta = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoRespuesta = new javax.swing.JTextArea();
        botonAgregarPregunta = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();
        botonActualizarListas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaTemasPreguntasTab2 = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaPreguntasTab2 = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        textoModificarPregunta = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        textoModificarRespuesta = new javax.swing.JTextArea();
        botonVolverPreguntas1 = new javax.swing.JButton();
        botonCambiarPregunta = new javax.swing.JButton();
        botonCambiarRespuesta = new javax.swing.JButton();
        botonEliminarPregunta = new javax.swing.JButton();
        botonVolverTab2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccione Tema: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 25, 154, 25));

        jScrollPane1.setViewportView(listaTemasPreguntas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 107, 282, 268));

        botonVolverPreguntas.setText("Volver");
        botonVolverPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverPreguntasActionPerformed(evt);
            }
        });
        jPanel1.add(botonVolverPreguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1253, 724, -1, -1));

        jLabel2.setText("Ingrese la pregunta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 25, 179, 70));

        textoPregunta.setColumns(20);
        textoPregunta.setRows(5);
        textoPregunta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textoPreguntaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(textoPregunta);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 107, 294, 114));

        jLabel3.setText("Respuesta a la pregunta");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 233, 189, -1));

        textoRespuesta.setColumns(20);
        textoRespuesta.setRows(5);
        textoRespuesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textoRespuestaMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(textoRespuesta);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 278, 294, 116));

        botonAgregarPregunta.setText("Agregar");
        botonAgregarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarPreguntaActionPerformed(evt);
            }
        });
        jPanel1.add(botonAgregarPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 412, -1, -1));

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });
        jPanel1.add(botonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 560, -1, -1));

        botonActualizarListas.setText("Actualizar Listas");
        botonActualizarListas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarListasActionPerformed(evt);
            }
        });
        jPanel1.add(botonActualizarListas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, -1, -1));

        jTabbedPane1.addTab("Ingresar preguntas", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaTemasPreguntasTab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaTemasPreguntasTab2MousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(listaTemasPreguntasTab2);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 35, 300, 222));

        jScrollPane5.setViewportView(listaPreguntasTab2);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 285, 300, 267));

        jLabel4.setText("Seleccione un tema para ver lista de preguntas: *");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 13, -1, -1));

        jLabel5.setText("Seleccione una pregunta: *");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 263, 170, -1));

        textoModificarPregunta.setColumns(20);
        textoModificarPregunta.setRows(5);
        textoModificarPregunta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textoModificarPreguntaMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(textoModificarPregunta);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 59, 295, 149));

        jLabel6.setText("Modificar Pregunta");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 25, -1, -1));

        jLabel7.setText("Modificar Respuesta");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 285, -1, -1));

        textoModificarRespuesta.setColumns(20);
        textoModificarRespuesta.setRows(5);
        textoModificarRespuesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textoModificarRespuestaMousePressed(evt);
            }
        });
        jScrollPane7.setViewportView(textoModificarRespuesta);

        jPanel2.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 319, 295, 160));

        botonVolverPreguntas1.setText("Volver");
        botonVolverPreguntas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverPreguntas1ActionPerformed(evt);
            }
        });
        jPanel2.add(botonVolverPreguntas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1253, 744, -1, -1));

        botonCambiarPregunta.setText("Cambiar");
        botonCambiarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarPreguntaActionPerformed(evt);
            }
        });
        jPanel2.add(botonCambiarPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 220, -1, -1));

        botonCambiarRespuesta.setText("Cambiar");
        botonCambiarRespuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarRespuestaActionPerformed(evt);
            }
        });
        jPanel2.add(botonCambiarRespuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 485, -1, -1));

        botonEliminarPregunta.setText("Eliminar pregunta");
        botonEliminarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarPreguntaActionPerformed(evt);
            }
        });
        jPanel2.add(botonEliminarPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 566, -1, 20));

        botonVolverTab2.setText("Volver");
        botonVolverTab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverTab2ActionPerformed(evt);
            }
        });
        jPanel2.add(botonVolverTab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 580, 80, 30));

        jTabbedPane1.addTab("Gestionar Preguntas", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        setBounds(0, 0, 1207, 898);
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverPreguntasActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonVolverPreguntasActionPerformed

    private void botonAgregarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarPreguntaActionPerformed
        agregarPreguntayRespuesta(sistema);

    }//GEN-LAST:event_botonAgregarPreguntaActionPerformed

    private void botonVolverPreguntas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverPreguntas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonVolverPreguntas1ActionPerformed

    private void botonCambiarRespuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarRespuestaActionPerformed
        modificarRespuesta(sistema);
    }//GEN-LAST:event_botonCambiarRespuestaActionPerformed

    private void listaTemasPreguntasTab2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaTemasPreguntasTab2MousePressed
        try {
            int indice = listaTemasPreguntasTab2.getSelectedIndex();
            Tema unTema = sistema.getListaTemas().get(indice);
            mostrarListaPreguntas(sistema, unTema);
        } catch (IndexOutOfBoundsException e) {

        }
    }//GEN-LAST:event_listaTemasPreguntasTab2MousePressed

    private void botonVolverTab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverTab2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonVolverTab2ActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonEliminarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarPreguntaActionPerformed
        eliminarPregunta(sistema);
        actualizarListas();
    }//GEN-LAST:event_botonEliminarPreguntaActionPerformed

    private void botonCambiarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarPreguntaActionPerformed
        modificarPregunta(sistema);
        actualizarListas();

    }//GEN-LAST:event_botonCambiarPreguntaActionPerformed

    private void textoPreguntaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoPreguntaMousePressed
        textoPregunta.setText("");
    }//GEN-LAST:event_textoPreguntaMousePressed

    private void textoRespuestaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoRespuestaMousePressed
        textoRespuesta.setText("");
    }//GEN-LAST:event_textoRespuestaMousePressed

    private void textoModificarPreguntaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoModificarPreguntaMousePressed
        textoModificarPregunta.setText("");
    }//GEN-LAST:event_textoModificarPreguntaMousePressed

    private void textoModificarRespuestaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoModificarRespuestaMousePressed
        textoModificarRespuesta.setText("");
    }//GEN-LAST:event_textoModificarRespuestaMousePressed

    private void botonActualizarListasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarListasActionPerformed
        actualizarListas();
    }//GEN-LAST:event_botonActualizarListasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarListas;
    private javax.swing.JButton botonAgregarPregunta;
    private javax.swing.JButton botonCambiarPregunta;
    private javax.swing.JButton botonCambiarRespuesta;
    private javax.swing.JButton botonEliminarPregunta;
    private javax.swing.JButton botonVolver;
    private javax.swing.JButton botonVolverPreguntas;
    private javax.swing.JButton botonVolverPreguntas1;
    private javax.swing.JButton botonVolverTab2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList listaPreguntasTab2;
    private javax.swing.JList listaTemasPreguntas;
    private javax.swing.JList listaTemasPreguntasTab2;
    private javax.swing.JTextArea textoModificarPregunta;
    private javax.swing.JTextArea textoModificarRespuesta;
    private javax.swing.JTextArea textoPregunta;
    private javax.swing.JTextArea textoRespuesta;
    // End of variables declaration//GEN-END:variables
    private Sistema sistema;
}
