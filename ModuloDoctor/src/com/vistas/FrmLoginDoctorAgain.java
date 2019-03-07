
package com.vistas;

import com.conexion.Conexion;
import com.dao.DaoRoles;
import com.modelo.Roles;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 * Nombre de la clase: FrmLoginDoctorAgain
 * Fecha: 5-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
 */

public class FrmLoginDoctorAgain extends javax.swing.JFrame {
     DaoRoles daoR = new DaoRoles();
    
    
    public FrmLoginDoctorAgain() {
        initComponents();
        jProgressBar.setVisible(false);
        this.setLocationRelativeTo(null);
    }
    
   
    
    
     
   
   
    
    
    
    Conexion con = new Conexion();
    
    
    public int ingresar(){
        String usu = this.jTxtUsuario.getText();
        String pass = this.jTxtContra.getText();
        
        con.conectar();
        int resultado =0;
        
        
        try 
        {
            String sql="Select username, pass from Roles where username='"+usu+"' and pass='"+pass+"' and nivelAcc=1;";
           
            PreparedStatement pre= con.getCon().prepareStatement(sql);
            
            
            
            ResultSet st =pre.executeQuery();
           
            
            if(st.next())
            {
            resultado=1;
            
            
            
            }
            
          
          
          
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
        }
    
    
    return resultado;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtUsuario = new javax.swing.JTextField();
        jTxtContra = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jBtnSalir1 = new javax.swing.JButton();
        jBtnInicio1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jProgressBar = new javax.swing.JProgressBar();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(897, 562));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Credenciales");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 0, 300, 70);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/iconoIn.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(140, 60, 80, 80);

        jTxtUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(jTxtUsuario);
        jTxtUsuario.setBounds(200, 180, 150, 30);

        jTxtContra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(jTxtContra);
        jTxtContra.setBounds(200, 260, 150, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/p.png"))); // NOI18N
        jLabel6.setText("Contraseña:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 240, 159, 60);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/doctor11.png"))); // NOI18N
        jLabel7.setText("Usuario:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 170, 130, 50);

        jBtnSalir1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBtnSalir1.setForeground(new java.awt.Color(255, 51, 51));
        jBtnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/e.png"))); // NOI18N
        jBtnSalir1.setText("Salir");
        jBtnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalir1ActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnSalir1);
        jBtnSalir1.setBounds(120, 430, 130, 40);

        jBtnInicio1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBtnInicio1.setForeground(new java.awt.Color(255, 51, 51));
        jBtnInicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/right.png"))); // NOI18N
        jBtnInicio1.setText("Validar sesión");
        jBtnInicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInicio1ActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnInicio1);
        jBtnInicio1.setBounds(80, 370, 210, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("-------------------");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(180, 80, 210, 29);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("-------------------");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(0, 80, 200, 29);

        jProgressBar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jProgressBarStateChanged(evt);
            }
        });
        jPanel1.add(jProgressBar);
        jProgressBar.setBounds(10, 310, 340, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(260, 10, 370, 510);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/Imagen1.png"))); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(900, 564));
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, -20, 900, 600);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
public String mandoNombre()
{
    String usuario = this.jTxtUsuario.getText();
    return usuario + this.jTxtUsuario.getText();
}
    private void jTxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtUsuarioActionPerformed

    private void jBtnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalir1ActionPerformed
       FrmInicio frm = new FrmInicio();
            this.dispose();
            frm.setVisible(true);
    }//GEN-LAST:event_jBtnSalir1ActionPerformed

    private void jBtnInicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInicio1ActionPerformed
        if(this.jTxtUsuario.getText().length()==0 || this.jTxtContra.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Complete los campos correctamente");
        }
        else{
            String texto="<html><center><b>Credenciales Dr:&nbsp; <b><font size=4 color='red' face='Comic Sans MS'>" +daoR.ingresarN()+"";
            if(daoR.ingresar()==1){

                JOptionPane.showMessageDialog(null, texto);
                jProgressBar.setVisible(true);
                cargar hilo;
                hilo = new cargar (jProgressBar);
                hilo.start();
                hilo=null;

            }
            else{
                JOptionPane.showMessageDialog(null,"Datos erroneos");
                jTxtUsuario.setText("");
                jTxtContra.setText("");
            }
        }
    }//GEN-LAST:event_jBtnInicio1ActionPerformed

    private void jProgressBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jProgressBarStateChanged
        if(jProgressBar.getValue()==100){
            FrmRoles frm = new FrmRoles();
            this.dispose();
            frm.setVisible(true);
        }
    }//GEN-LAST:event_jProgressBarStateChanged

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
            java.util.logging.Logger.getLogger(FrmLoginDoctorAgain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLoginDoctorAgain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLoginDoctorAgain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLoginDoctorAgain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLoginDoctorAgain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnInicio1;
    private javax.swing.JButton jBtnSalir1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar;
    public static javax.swing.JPasswordField jTxtContra;
    public static javax.swing.JTextField jTxtUsuario;
    // End of variables declaration//GEN-END:variables
}
