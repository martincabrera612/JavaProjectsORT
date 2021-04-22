//Martin Cabrera 185091 Michel Kuza 242483
package interfaz;

import dominio.Sistema;
import dominio.Tema;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal(Sistema unSistema) {
        initComponents();
        sistema = unSistema;
        
        ventanaMemory = new VentanaMemory(sistema);
        ventanaGestionarPreguntas = new VentanaGestionarPreguntas(sistema);
        ventanaMenuJugar = new VentanaMenuJugar(sistema);
        ventanaGestionarTemas = new VentanaGestionarTemas(sistema, ventanaGestionarPreguntas, ventanaMenuJugar);
        ventanaCargarArchivos = new VentanaCargarArchivos(sistema);
        botonJugar.setForeground(new Color(248, 248, 248));
        botonJugar.setBackground(new Color(41, 138, 180));
        panel.setBackground(Color.DARK_GRAY);
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        panel = new javax.swing.JPanel();
        botonJugar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        menubar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        opcionMenuTemas = new javax.swing.JMenuItem();
        opcionMenuPreguntas = new javax.swing.JMenuItem();
        opcionMenuCargar = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonJugar.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        botonJugar.setText("JUGAR");
        botonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonJugarActionPerformed(evt);
            }
        });

        botonSalir.setText("Salir");
        botonSalir.setToolTipText("");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonSalir)
                .addGap(21, 21, 21))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(botonJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(358, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(223, Short.MAX_VALUE)
                .addComponent(botonJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206)
                .addComponent(botonSalir)
                .addGap(21, 21, 21))
        );

        jMenu1.setBorder(new javax.swing.border.MatteBorder(null));
        jMenu1.setText("Menu");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });

        opcionMenuTemas.setText("Gestionar Temas");
        opcionMenuTemas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                opcionMenuTemasMousePressed(evt);
            }
        });
        opcionMenuTemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuTemasActionPerformed(evt);
            }
        });
        jMenu1.add(opcionMenuTemas);

        opcionMenuPreguntas.setText("Gestionar Preguntas");
        opcionMenuPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuPreguntasActionPerformed(evt);
            }
        });
        jMenu1.add(opcionMenuPreguntas);

        opcionMenuCargar.setText("Cargar Preguntas");
        opcionMenuCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuCargarActionPerformed(evt);
            }
        });
        jMenu1.add(opcionMenuCargar);

        menubar.add(jMenu1);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 987, 635);
    }// </editor-fold>//GEN-END:initComponents

    private void opcionMenuPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuPreguntasActionPerformed
        ventanaGestionarPreguntas.setVisible(true);
        ventanaGestionarPreguntas.getListaTemasPreguntas().setListData(sistema.getListaTemas().toArray());
    }//GEN-LAST:event_opcionMenuPreguntasActionPerformed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MousePressed

    private void botonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonJugarActionPerformed
        ventanaMenuJugar.setVisible(true);
    }//GEN-LAST:event_botonJugarActionPerformed

    private void opcionMenuTemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuTemasActionPerformed
        ventanaGestionarTemas.setVisible(true);
       
    }//GEN-LAST:event_opcionMenuTemasActionPerformed

    private void opcionMenuTemasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionMenuTemasMousePressed

    }//GEN-LAST:event_opcionMenuTemasMousePressed

    
    private void serializarGuardar(String ruta) {
        
        try {
            FileOutputStream  archivo = new FileOutputStream(ruta);
            ObjectOutputStream info = new ObjectOutputStream(archivo); 
            info.writeObject(sistema);
            
            
        } catch (Exception e) {
            System.out.println("No se pudo guardar");
            System.exit(1);
        }

        System.exit(0);
    }                              
    
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
    
        try {
            FileOutputStream  archivo = new FileOutputStream("archivos/datos");
            ObjectOutputStream info = new ObjectOutputStream(archivo); 
            info.writeObject(sistema);
            
            
        } catch (Exception e) {
            System.out.println("No se pudo guardar");
            System.exit(1);
        }

        System.exit(0);

    }//GEN-LAST:event_botonSalirActionPerformed

    private void opcionMenuCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuCargarActionPerformed
        ventanaCargarArchivos.setVisible(true);
    }//GEN-LAST:event_opcionMenuCargarActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonJugar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenuItem opcionMenuCargar;
    private javax.swing.JMenuItem opcionMenuPreguntas;
    private javax.swing.JMenuItem opcionMenuTemas;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
    private VentanaMemory ventanaMemory;
    private VentanaGestionarTemas ventanaGestionarTemas;
    private VentanaGestionarPreguntas ventanaGestionarPreguntas;
    private VentanaMenuJugar ventanaMenuJugar;
    private VentanaCargarArchivos ventanaCargarArchivos;
    private Sistema sistema;
 
   
}
