//Martin Cabrera 185091 Michel Kuza 242483
package interfaz;

import dominio.*;
import javax.swing.JOptionPane;

public class VentanaMenuJugar extends javax.swing.JFrame {

    public VentanaMenuJugar(Sistema unSistema) {
        initComponents();
        sistema = unSistema;
        ventanaJuegoFlash = new VentanaJuegoFlash(sistema);
        ventanaMemory = new VentanaMemory(sistema);

    }

    public void actualizarListas() {
        listaTemasDisponibles.setListData(sistema.getListaTemasDisponibles().toArray());
        listaTemasSeleccionados.setListData(sistema.getListaTemasSeleccionados().toArray());
    }

    public void agregarTemaSeleccionado(Sistema sistema) {
        if (existeIndiceTema(listaTemasDisponibles.getSelectedIndex())) {
            int indice = listaTemasDisponibles.getSelectedIndex();
            Tema unTema = sistema.getListaTemasDisponibles().get(indice);
            if (!(unTema.getListaPreguntas().size() == 0)) {
                sistema.agregarTemaSeleccionado(unTema);
            } else {
                JOptionPane.showMessageDialog(this, "No puede seleccionar este tema porque no tiene preguntas", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un tema", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void quitarTemaSeleccionado(Sistema sistema) {
        if (existeIndiceTema(listaTemasSeleccionados.getSelectedIndex())) {
            int indice = listaTemasSeleccionados.getSelectedIndex();
            Tema unTema = sistema.getListaTemasSeleccionados().get(indice);
            sistema.quitarTemaSeleccionado(unTema);

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un tema", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Comprueba que existe el objeto en el indice Seleccionado
    public boolean existeIndiceTema(int indice) {
        boolean existe = false;

        try {
            Tema unTema = sistema.getListaTemas().get(indice);
            existe = true;
        } catch (IndexOutOfBoundsException e) {
            existe = false;
        }
        return existe;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTemasDisponibles = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaTemasSeleccionados = new javax.swing.JList();
        botonVolverMenuFlash = new javax.swing.JButton();
        botonAnadir = new javax.swing.JButton();
        botonQuitar = new javax.swing.JButton();
        botonJugarMemory = new javax.swing.JButton();
        botonJugarFlash = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Temas disponibles: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 150, -1));

        jLabel3.setText("Temas seleccionados:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 150, -1));

        jScrollPane1.setViewportView(listaTemasDisponibles);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 310, 280));

        jScrollPane2.setViewportView(listaTemasSeleccionados);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 290, 290));

        botonVolverMenuFlash.setText("Volver");
        botonVolverMenuFlash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverMenuFlashActionPerformed(evt);
            }
        });
        jPanel1.add(botonVolverMenuFlash, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 540, -1, -1));

        botonAnadir.setText("Añadir");
        botonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirActionPerformed(evt);
            }
        });
        jPanel1.add(botonAnadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, -1));

        botonQuitar.setText("Quitar");
        botonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarActionPerformed(evt);
            }
        });
        jPanel1.add(botonQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, -1, -1));

        botonJugarMemory.setText("JUGAR MEMORY");
        botonJugarMemory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonJugarMemoryActionPerformed(evt);
            }
        });
        jPanel1.add(botonJugarMemory, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 210, 50));

        botonJugarFlash.setText("JUGAR FLASH CARDS");
        botonJugarFlash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonJugarFlashActionPerformed(evt);
            }
        });
        jPanel1.add(botonJugarFlash, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 210, 50));

        botonActualizar.setText("Actualizar Listas");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 150, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverMenuFlashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverMenuFlashActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonVolverMenuFlashActionPerformed

    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed

        agregarTemaSeleccionado(sistema);
        actualizarListas();
    }//GEN-LAST:event_botonAnadirActionPerformed

    private void botonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarActionPerformed
        quitarTemaSeleccionado(sistema);
        actualizarListas();
    }//GEN-LAST:event_botonQuitarActionPerformed

    private void botonJugarMemoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonJugarMemoryActionPerformed

        if (!(sistema.getListaTemasSeleccionados().size() == 0)) {
            ventanaMemory.setVisible(true);
            ventanaMemory.titulos();
        } else {
            JOptionPane.showMessageDialog(this, "No hay temas seleccionados o el tema no contiene preguntas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonJugarMemoryActionPerformed

    private void botonJugarFlashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonJugarFlashActionPerformed
        if (!(sistema.getListaTemasSeleccionados().size() == 0)) {
            ventanaJuegoFlash.setVisible(true);
            ventanaJuegoFlash.mostrarPregunta(0, 0);
        } else {
            JOptionPane.showMessageDialog(this, "No hay temas seleccionados o el tema no contiene preguntas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonJugarFlashActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        actualizarListas();
    }//GEN-LAST:event_botonActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAnadir;
    private javax.swing.JButton botonJugarFlash;
    private javax.swing.JButton botonJugarMemory;
    private javax.swing.JButton botonQuitar;
    private javax.swing.JButton botonVolverMenuFlash;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaTemasDisponibles;
    private javax.swing.JList listaTemasSeleccionados;
    // End of variables declaration//GEN-END:variables
    private Sistema sistema;
    VentanaJuegoFlash ventanaJuegoFlash;
    VentanaMemory ventanaMemory;
}
