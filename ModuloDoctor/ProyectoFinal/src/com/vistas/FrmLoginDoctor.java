
package com.vistas;

import com.conexion.Conexion;
import com.dao.DaoRoles;
import com.modelo.Roles;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabio
 */
public class FrmLoginDoctor extends javax.swing.JFrame {
    DaoRoles daoR = new DaoRoles();
    
    
    public FrmLoginDoctor() {
        initComponents();
        this.setLocationRelativeTo(null);
        jProgressBar1.setVisible(false);
    } 
    
    
    
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtUsuario = new javax.swing.JTextField();
        jTxtContra = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBtnSalir = new javax.swing.JButton();
        jBtnInicio = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(892, 557));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inicio de Sesión");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 0, 300, 70);

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/p.png"))); // NOI18N
        jLabel3.setText("Contraseña:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 240, 159, 60);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/doctor11.png"))); // NOI18N
        jLabel2.setText("Usuario:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 170, 130, 50);

        jBtnSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBtnSalir.setForeground(new java.awt.Color(255, 51, 51));
        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/e.png"))); // NOI18N
        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnSalir);
        jBtnSalir.setBounds(120, 430, 130, 40);

        jBtnInicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBtnInicio.setForeground(new java.awt.Color(255, 51, 51));
        jBtnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/right.png"))); // NOI18N
        jBtnInicio.setText("Iniciar Sesión");
        jBtnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInicioActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnInicio);
        jBtnInicio.setBounds(80, 370, 210, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("-------------------");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(180, 80, 210, 29);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("-------------------");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 80, 200, 29);

        jProgressBar1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jProgressBar1StateChanged(evt);
            }
        });
        jPanel1.add(jProgressBar1);
        jProgressBar1.setBounds(10, 310, 340, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(260, 10, 370, 510);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/Imagen1.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, -20, 900, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public String mandoNombre()
{
    String usuario = this.jTxtUsuario.getText();
    return usuario + this.jTxtUsuario.getText();
}
    private void jBtnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInicioActionPerformed
       if(this.jTxtUsuario.getText().length()==0 || this.jTxtContra.getText().length()==0){
        JOptionPane.showMessageDialog(null,"Complete los campos correctamente");
        }
        else{
        String texto="<html><center><b>Bienvenido Dr:&nbsp; <b><font size=4 color='red' face='Comic Sans MS'>" +daoR.ingresarN()+"";
        if(daoR.ingresar()==1){
            
            JOptionPane.showMessageDialog(null, texto);
            jProgressBar1.setVisible(true);
            cargar hilo;
            hilo = new cargar (jProgressBar1);
        hilo.start();
        hilo=null;
           
            
            
           
        }
        else{
        JOptionPane.showMessageDialog(null,"Datos erroneos");
        jTxtUsuario.setText("");
        jTxtContra.setText("");
        }
        }
    }//GEN-LAST:event_jBtnInicioActionPerformed

    private void jTxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtUsuarioActionPerformed

    private void jProgressBar1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jProgressBar1StateChanged
         if(jProgressBar1.getValue()==100){
            FrmInicio frm = new FrmInicio();
           this.dispose();
            frm.setVisible(true); 
            }
    }//GEN-LAST:event_jProgressBar1StateChanged

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jBtnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLoginDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLoginDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLoginDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLoginDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLoginDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnInicio;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    public static javax.swing.JPasswordField jTxtContra;
    public static javax.swing.JTextField jTxtUsuario;
    // End of variables declaration//GEN-END:variables
}
