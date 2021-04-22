//Martin Cabrera 185091 Michel Kuza 242483
package interfaz;

import dominio.Pregunta;
import dominio.Sistema;
import dominio.Tema;
import javax.swing.JOptionPane;


public class VentanaCargarArchivos extends javax.swing.JFrame {

    public VentanaCargarArchivos(Sistema unSistema) {
        initComponents();
        sistema = unSistema;

        elegirArchivo = new VentanaFileChooser(sistema, this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        labelPregAgregadas = new javax.swing.JLabel();
        labelPregIgnoradas = new javax.swing.JLabel();
        labelPregActualizadas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        temasAuto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pregAuto = new javax.swing.JTextField();
        botonGenerarAuto = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Elegir Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelPregAgregadas.setText("Preguntas Agregadas: ");

        labelPregIgnoradas.setText("Preguntas Ignoradas:");

        labelPregActualizadas.setText("Preguntas Actualizadas:");

        jLabel1.setText("Generar preguntar automaticas:");

        jLabel2.setText("Cantidad de Temas: ");

        temasAuto.setText("0");

        jLabel3.setText("Cantidad de Preguntas:");

        pregAuto.setText("0");

        botonGenerarAuto.setText("Generar");
        botonGenerarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarAutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelPregAgregadas, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(labelPregIgnoradas, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelPregActualizadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(71, 71, 71))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(48, 48, 48)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(temasAuto, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                    .addComponent(pregAuto)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(botonGenerarAuto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelPregAgregadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPregActualizadas)
                .addGap(8, 8, 8)
                .addComponent(labelPregIgnoradas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(temasAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pregAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonGenerarAuto)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(547, Short.MAX_VALUE)
                .addComponent(botonVolver)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(botonVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        elegirArchivo.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void generarAuto(Sistema unSistema, int cantTemas, int cantPreg) {
        sistema = unSistema;
        for (int i = 1; i <= cantTemas; i++) {
            Tema unTema = new Tema("T:" + i, "Descripcion de T" + i);
            sistema.agregarTemaCargarArchivo(sistema, unTema);
            
            for (int j = 1; j <= cantPreg; j++) {
                String unaPregunta ="T:" + i + " P:" + j + " Texto de P" + j;
                String unaRespuesta = "T:" + i + " P:" + j + "Respuesta de P" + j;
                Pregunta pregunta = new Pregunta("T:" + j + " P:" + j + " Texto de P" + j, "T:" + j + " P:" + j + " Respuesta de P" + j, unTema);
                sistema.agregarPregunta(sistema, unaPregunta, unaRespuesta, unTema);
                //unTema.getListaPreguntas().add(unaPregunta);
                
            }
        }
        
    }


    private void botonGenerarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarAutoActionPerformed
        //int cantTemas = 1;
        //int cantPreguntas = 2;
        int cantTemas = Integer.parseInt(temasAuto.getText());
        int cantPreguntas = Integer.parseInt(pregAuto.getText());

        generarAuto(sistema, cantTemas, cantPreguntas);
    }//GEN-LAST:event_botonGenerarAutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGenerarAuto;
    private javax.swing.JButton botonVolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel labelPregActualizadas;
    public javax.swing.JLabel labelPregAgregadas;
    public javax.swing.JLabel labelPregIgnoradas;
    private javax.swing.JTextField pregAuto;
    private javax.swing.JTextField temasAuto;
    // End of variables declaration//GEN-END:variables
    private Sistema sistema;
    private VentanaFileChooser elegirArchivo;
}
