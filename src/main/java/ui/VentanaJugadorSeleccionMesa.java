/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import controllers.ControllerJugador;
import dominio.Jugador;
import dominio.Mesa;
import java.util.ArrayList;

/**
 *
 * @author gcana
 */
public class VentanaJugadorSeleccionMesa extends javax.swing.JFrame {

    private ControllerJugador controlador;
    
    /**
     * Creates new form VentanaJugador
     */
    public VentanaJugadorSeleccionMesa(Jugador jugador) {
        initComponents();
        this.controlador = new ControllerJugador(this, jugador);
        this.setTitle("Bienvenido " + jugador.getNombre());
        this.getMesas();
    }
    
    public void getMesas(){
        ArrayList<Mesa> mesas = controlador.getMesas();
        jComboMesasDisponibles.removeAllItems();
        
        for(Mesa m: mesas){
            jComboMesasDisponibles.addItem(m);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboMesasDisponibles = new javax.swing.JComboBox();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboMesasDisponibles.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboMesasDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMesasDisponiblesActionPerformed(evt);
            }
        });

        btnEntrar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboMesasDisponibles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jComboMesasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntrar)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboMesasDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMesasDisponiblesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboMesasDisponiblesActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        Mesa mesaSeleccionada = (Mesa)jComboMesasDisponibles.getSelectedItem();

        controlador.agregarJugadorAMesa(mesaSeleccionada);
        
        //ejecutar vista nueva!;
        //le paso la mesa y el jugador???
        new VentanaJugadorMesa(mesaSeleccionada, controlador.getJugador()).setVisible(true);

    }//GEN-LAST:event_btnEntrarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JComboBox jComboMesasDisponibles;
    // End of variables declaration//GEN-END:variables

    
}