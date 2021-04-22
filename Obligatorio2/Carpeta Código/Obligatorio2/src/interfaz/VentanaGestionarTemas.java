//Martin Cabrera 185091 Michel Kuza 242483
package interfaz;

import java.util.*;
import dominio.*;
import javax.swing.*;
import obligatorio2.Obligatorio2;

public class VentanaGestionarTemas extends javax.swing.JFrame {

    public VentanaGestionarTemas(Sistema unSistema, VentanaGestionarPreguntas unaVentanaGestionarPreguntas, VentanaMenuJugar unaVentanaMenuFlashCards) {
        initComponents();
        sistema = unSistema;
        eliminarTemaBoton.setVisible(false);
        ArrayList<Tema> listTemas = sistema.getListaTemas();
        listaTemasList.setListData(sistema.getListaTemas().toArray());
        listaTemasTab.setListData(sistema.getListaTemas().toArray());
        ventanaGestionarPreguntas = unaVentanaGestionarPreguntas;
        ventanaMenuFlashCards = unaVentanaMenuFlashCards;

    }

    public void eliminarTema(Sistema sistema) {
        //Borra el tema

        int indiceTema = listaTemasTab.getSelectedIndex();
        sistema.eliminarTema(sistema, indiceTema, this);
        //Actualiza las listas
        actualizarListas();
        eliminarTemaBoton.setVisible(false);

    }

    public void actualizarListas() {
        //Actualiza las listas
        listaTemasList.setListData(sistema.getListaTemas().toArray());
        listaTemasTab.setListData(sistema.getListaTemas().toArray());
        ventanaGestionarPreguntas.actualizarListas();
        ventanaMenuFlashCards.actualizarListas();

    }

    public void mostrarCantPreguntas(Sistema unSistema) {
        try {
            if (sistema.getListaTemas().size() > 0) {
                int indiceTema = listaTemasTab.getSelectedIndex();
                int cant = sistema.getListaTemas().get(indiceTema).getListaPreguntas().size();
                cantPreguntas.setText(sistema.getListaTemas().get(indiceTema).mostrarCantidadPreguntas());

                if (cant == 0) {
                    eliminarTemaBoton.setVisible(true);
                }
            }
        }catch (IndexOutOfBoundsException e) {
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Tabs = new javax.swing.JTabbedPane();
        panelTab1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textNombreTema = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        textDescripcionTema = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        agregarBoton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTemasList = new javax.swing.JList();
        labelLista = new javax.swing.JLabel();
        botonVolverTab1 = new javax.swing.JButton();
        botonActualizarListas = new javax.swing.JButton();
        panelTab2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        nuevaDescripcionText = new javax.swing.JTextArea();
        botonModificarDesc = new javax.swing.JButton();
        cantPreguntas = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        eliminarTemaBoton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaTemasTab = new javax.swing.JList();
        botonVolverTab2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTab1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ingrese nombre de tema: ");
        panelTab1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 201, -1));

        textNombreTema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textNombreTemaMousePressed(evt);
            }
        });
        textNombreTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreTemaActionPerformed(evt);
            }
        });
        panelTab1.add(textNombreTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 260, -1));

        textDescripcionTema.setColumns(20);
        textDescripcionTema.setRows(5);
        textDescripcionTema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textDescripcionTemaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(textDescripcionTema);

        panelTab1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 270, 270));

        jLabel2.setText("Ingrese descripción: ");
        panelTab1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 172, -1));

        agregarBoton.setText("Agregar");
        agregarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBotonActionPerformed(evt);
            }
        });
        panelTab1.add(agregarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, -1, -1));

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelTab1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 750, 90, -1));

        listaTemasList.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                listaTemasListComponentAdded(evt);
            }
        });
        listaTemasList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaTemasListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaTemasList);

        panelTab1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 270, 330));

        labelLista.setText("Lista de Temas:");
        panelTab1.add(labelLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 170, 20));

        botonVolverTab1.setText("Volver");
        botonVolverTab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverTab1ActionPerformed(evt);
            }
        });
        panelTab1.add(botonVolverTab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 590, -1, -1));

        botonActualizarListas.setText("Actualizar listas");
        botonActualizarListas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarListasActionPerformed(evt);
            }
        });
        panelTab1.add(botonActualizarListas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, -1));

        Tabs.addTab("Ingreso de temas", panelTab1);

        panelTab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelTab2MouseClicked(evt);
            }
        });
        panelTab2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nuevaDescripcionText.setColumns(20);
        nuevaDescripcionText.setRows(5);
        nuevaDescripcionText.setText("Escriba aqui la nueva descripcion");
        nuevaDescripcionText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuevaDescripcionTextMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nuevaDescripcionTextMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(nuevaDescripcionText);

        panelTab2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 280, 170));

        botonModificarDesc.setText("Modificar Descripcion");
        botonModificarDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarDescActionPerformed(evt);
            }
        });
        panelTab2.add(botonModificarDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, 190, 30));

        cantPreguntas.setText("Cantidad de preguntas: ");
        cantPreguntas.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cantPreguntasComponentShown(evt);
            }
        });
        panelTab2.add(cantPreguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 420, -1));

        jLabel3.setText("Seleccione un tema de la lista:");
        panelTab2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 200, -1));

        eliminarTemaBoton.setText("Eliminar tema");
        eliminarTemaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTemaBotonActionPerformed(evt);
            }
        });
        panelTab2.add(eliminarTemaBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 120, -1));

        listaTemasTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaTemasTabMousePressed(evt);
            }
        });
        listaTemasTab.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaTemasTabValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listaTemasTab);

        panelTab2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 440, 390));

        botonVolverTab2.setText("Volver");
        botonVolverTab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverTab2ActionPerformed(evt);
            }
        });
        panelTab2.add(botonVolverTab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 560, -1, -1));

        Tabs.addTab("Modificar temas", panelTab2);

        getContentPane().add(Tabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 750));

        setBounds(0, 0, 1078, 695);
    }// </editor-fold>//GEN-END:initComponents

    private void textNombreTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreTemaActionPerformed


    }//GEN-LAST:event_textNombreTemaActionPerformed

    private void agregarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBotonActionPerformed
        Tema unTema = new Tema();
        unTema.setNombre(textNombreTema.getText());
        unTema.setDescripcion(textDescripcionTema.getText());
        sistema.agregarTema(sistema, unTema, this);
        //Actualiza las listas
        actualizarListas();


    }//GEN-LAST:event_agregarBotonActionPerformed

    private void listaTemasListComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listaTemasListComponentAdded

    }//GEN-LAST:event_listaTemasListComponentAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listaTemasListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaTemasListMouseClicked

    }//GEN-LAST:event_listaTemasListMouseClicked

    private void nuevaDescripcionTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevaDescripcionTextMouseClicked
        nuevaDescripcionText.setText("");
    }//GEN-LAST:event_nuevaDescripcionTextMouseClicked

    private void botonModificarDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarDescActionPerformed

        int indiceTema = listaTemasTab.getSelectedIndex();
        String texto = nuevaDescripcionText.getText();
        //Actualiza datos cambiados
        sistema.modificarDescripcion(sistema, indiceTema, texto, this);
        //Actualiza las listas
        actualizarListas();


    }//GEN-LAST:event_botonModificarDescActionPerformed

    private void cantPreguntasComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cantPreguntasComponentShown

    }//GEN-LAST:event_cantPreguntasComponentShown

    private void panelTab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTab2MouseClicked

    }//GEN-LAST:event_panelTab2MouseClicked

    private void textDescripcionTemaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textDescripcionTemaMousePressed
        textDescripcionTema.setText("");
        mostrarCantPreguntas(sistema);
    }//GEN-LAST:event_textDescripcionTemaMousePressed

    private void textNombreTemaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textNombreTemaMousePressed
        textNombreTema.setText("");
    }//GEN-LAST:event_textNombreTemaMousePressed

    private void nuevaDescripcionTextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevaDescripcionTextMousePressed
        nuevaDescripcionText.setText("");

    }//GEN-LAST:event_nuevaDescripcionTextMousePressed

    private void eliminarTemaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarTemaBotonActionPerformed
        eliminarTema(sistema);


    }//GEN-LAST:event_eliminarTemaBotonActionPerformed

    private void listaTemasTabValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaTemasTabValueChanged

    }//GEN-LAST:event_listaTemasTabValueChanged

    private void listaTemasTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaTemasTabMousePressed
        mostrarCantPreguntas(sistema);
    }//GEN-LAST:event_listaTemasTabMousePressed

    private void botonVolverTab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverTab1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonVolverTab1ActionPerformed

    private void botonVolverTab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverTab2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonVolverTab2ActionPerformed

    private void botonActualizarListasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarListasActionPerformed
        actualizarListas();
    }//GEN-LAST:event_botonActualizarListasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JButton agregarBoton;
    private javax.swing.JButton botonActualizarListas;
    private javax.swing.JButton botonModificarDesc;
    private javax.swing.JButton botonVolverTab1;
    private javax.swing.JButton botonVolverTab2;
    private javax.swing.JLabel cantPreguntas;
    private javax.swing.JButton eliminarTemaBoton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelLista;
    private javax.swing.JList listaTemasList;
    private javax.swing.JList listaTemasTab;
    private javax.swing.JTextArea nuevaDescripcionText;
    private javax.swing.JPanel panelTab1;
    private javax.swing.JPanel panelTab2;
    private javax.swing.JTextArea textDescripcionTema;
    private javax.swing.JTextField textNombreTema;
    // End of variables declaration//GEN-END:variables
    private Tema tema1;
    private Sistema sistema;
    private VentanaGestionarPreguntas ventanaGestionarPreguntas;
    private VentanaMenuJugar ventanaMenuFlashCards;

}
