/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas;

import com.dao.DaoCitas;
import com.dao.DaoDiagCorto;
import com.dao.DaoMedicamentos;
import com.modelo.DiagnosticosCortos;
import com.modelo.Historial;
import static com.vistas.FrmDiagnositcos.jLabel1;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Nombre de la clase: FrmHistorial
 * Fecha: 4-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
 */
public class FrmHistorial extends javax.swing.JFrame {

    DaoCitas daoC = new DaoCitas();
    Historial his = new Historial();
    DaoMedicamentos daoM = new DaoMedicamentos();
    DaoDiagCorto daoDg = new DaoDiagCorto();
    DiagnosticosCortos dg = new DiagnosticosCortos();
    Medi med = new Medi();
    
    public static int val=0;
    public FrmHistorial() {
        
        
       
        initComponents();
        
       this.setLocationRelativeTo(null);
            llenarTabla();
            llenarTabla1();
            llenarTabla2();
            int fila = FrmInicio.jTable1.getSelectedRow();
        jLabel2.setText(String.valueOf(FrmInicio.jTable1.getValueAt(fila, 2)));
            
        
        
        
    }
    
    
    public  void llenarTabla()
    {
        try {
        
            String[] columnas = {"Fecha","Hora","Descripción","Peso","Altura","Presión"};
            Object [] obj = new Object[6];
            DefaultTableModel tabla = new DefaultTableModel(null,columnas);
            
            List lista = daoC.mostrarHistorial();
            
            for(int i=0; i<lista.size();i++)
            {
             his = (Historial)lista.get(i);
             obj[0]=his.getFecha();
             obj[1]=his.getHora();
             obj[2]=his.getDescripcion();
             obj[3]=his.getPeso();
             obj[4]=his.getAltura();
             obj[5]=his.getPresion();
             
            tabla.addRow(obj);
             
            }
            lista = daoC.mostrarHistorial();
            this.jTablaHistorial.setModel(tabla);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al general tabla");
        }
    
    
    }
    
    public  void llenarTabla1()
    {
        try {
        
            String[] columnas = {"Medicamentos","Inicio de Tratamiento"};
            Object [] obj = new Object[2];
            DefaultTableModel tabla = new DefaultTableModel(null,columnas);
            
            List lista = daoM.mostrarMedicamentosH();
            
            for(int i=0; i<lista.size();i++)
            {
             med = (Medi)lista.get(i);
             obj[0]=med.getMedicamento();
             obj[1]=med.getFecha_diag();
            
            tabla.addRow(obj);
             
            }
            lista = daoM.mostrarMedicamentosH();
            this.jTablaMe.setModel(tabla);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al general tabla");
        }
    
    
    }
    
    public  void llenarTabla2()
    {
        try {
        
            String[] columnas = {"Mis Enfermedades"};
            Object [] obj = new Object[1];
            DefaultTableModel tabla = new DefaultTableModel(null,columnas);
            
            List lista = daoDg.mostrarDiagCortoHistorial();
            
            for(int i=0; i<lista.size();i++)
            {
             dg = (DiagnosticosCortos)lista.get(i);
             obj[0]=dg.getNombreDiag();
            
            tabla.addRow(obj);
             
            }
            lista = daoDg.mostrarDiagCortoHistorial();
            this.jTablaDiag.setModel(tabla);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al general tabla");
        }
    
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaHistorial = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaMe = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablaDiag = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(659, 359));
        setResizable(false);
        getContentPane().setLayout(null);

        jTablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablaHistorial);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 87, 639, 122);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Historial del paciente:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 20, 261, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(390, 30, 110, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/eliminar.png"))); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(520, 10, 130, 37);

        jTablaMe.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTablaMe);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(360, 220, 249, 121);

        jTablaDiag.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTablaDiag);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(60, 220, 249, 121);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/fondo-clinica-baron-de-carcer-2.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 660, 360);

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
            java.util.logging.Logger.getLogger(FrmHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
               
                new FrmHistorial().setVisible(false);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTablaDiag;
    public static javax.swing.JTable jTablaHistorial;
    private javax.swing.JTable jTablaMe;
    // End of variables declaration//GEN-END:variables
}
