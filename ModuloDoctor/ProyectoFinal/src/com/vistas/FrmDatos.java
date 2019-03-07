/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas;

import com.dao.DaoAlergias;
import com.dao.DaoCitas;
import com.dao.DaoEnfermedades;
import com.dao.DaoOperaciones;
import com.modelo.Alergias;
import com.modelo.Enfermedades;
import com.modelo.Operaciones;
import com.modelo.Referencias;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fabio
 */
public class FrmDatos extends javax.swing.JFrame {
    DaoCitas daoC = new DaoCitas();
    Enfermedades ref = new Enfermedades();
    DaoEnfermedades daoE = new DaoEnfermedades();
    
    DaoAlergias daoA = new DaoAlergias();
    Alergias al = new Alergias();
    
    DaoOperaciones daoO = new DaoOperaciones();
    Operaciones op = new Operaciones();
    
    Referencias refer = new Referencias();
    
    public FrmDatos() {
        initComponents();
        llenarTabla1();
        llenarTabla2();
        llenarTabla3();
        llenarTabla4();
        int fila = FrmInicio.jTable1.getSelectedRow();
        jLabel2.setText(String.valueOf(FrmInicio.jTable1.getValueAt(fila, 2)));
    }
    
    public void llenarTabla1()
    {
        try {
            String [] columnas = {"Enfermedad Hereditaria"};
            Object [] obj = new Object[1];
            DefaultTableModel tabla = new DefaultTableModel(null,columnas);
            
            List lista = daoE.mostrarEnfermedades();
            for(int i=0;i< lista.size();i++)
            {
                ref=(Enfermedades)lista.get(i);
                obj[0]=ref.getEnfermedadesHere();
                tabla.addRow(obj);
            
            }
            lista = daoE.mostrarEnfermedades();
            this.jTablaEnferme.setModel(tabla);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error generando tabla");
        }
    
    }
    
    
     public void llenarTabla2()
    {
        try {
            String [] columnas = {"Alergias"};
            Object [] obj = new Object[1];
            DefaultTableModel tabla = new DefaultTableModel(null,columnas);
            
            List lista = daoA.mostrarAlergias();
            for(int i=0;i< lista.size();i++)
            {
                al=(Alergias)lista.get(i);
                obj[0]=al.getAlergia();
                tabla.addRow(obj);
            
            }
            lista = daoA.mostrarAlergias();
            this.jTablaAlergias.setModel(tabla);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error generando tabla");
        }
    
    }
     
     
     public void llenarTabla3()
    {
        try {
            String [] columnas = {"Operación","Fecha de Operación"};
            Object [] obj = new Object[2];
            DefaultTableModel tabla = new DefaultTableModel(null,columnas);
            
            List lista = daoO.mostrarOperaciones();
            for(int i=0;i< lista.size();i++)
            {
                op=(Operaciones)lista.get(i);
                obj[0]=op.getOperacion();
                obj[1]=op.getFechaOperacion();
                tabla.addRow(obj);
            
            }
            lista = daoO.mostrarOperaciones();
            this.jTablaOperaciones.setModel(tabla);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error generando tabla");
        }
    
    }
     
     
     public void llenarTabla4()
    {
        try {
            String [] columnas = {"Referencias Médicas"};
            Object [] obj = new Object[1];
            DefaultTableModel tabla = new DefaultTableModel(null,columnas);
            
            List lista = daoO.mostrarReferencias();
            for(int i=0;i< lista.size();i++)
            {
                refer=(Referencias)lista.get(i);
                obj[0]=refer.getReferencia();
                
                tabla.addRow(obj);
            
            }
            lista = daoO.mostrarReferencias();
            this.jTablaReferencias.setModel(tabla);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error generando tabla");
        }
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaEnferme = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaAlergias = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablaOperaciones = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablaReferencias = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(959, 319));
        setResizable(false);
        getContentPane().setLayout(null);

        jTablaEnferme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablaEnferme);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 100, 157, 188);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Datos médicos:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 20, 190, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(790, 30, 40, 15);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(840, 20, 90, 30);

        jTablaAlergias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTablaAlergias);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(210, 100, 174, 188);

        jTablaOperaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTablaOperaciones);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(420, 100, 307, 188);

        jTablaReferencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTablaReferencias);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(760, 100, 174, 188);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Enfermedades Hereditarias");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 70, 186, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Alergias");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(270, 70, 54, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Referencias medicas");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(770, 70, 150, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Operaciones");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(530, 70, 85, 17);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/fondo-clinica-baron-de-carcer-2.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 960, 320);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTablaAlergias;
    private javax.swing.JTable jTablaEnferme;
    private javax.swing.JTable jTablaOperaciones;
    private javax.swing.JTable jTablaReferencias;
    // End of variables declaration//GEN-END:variables
}
