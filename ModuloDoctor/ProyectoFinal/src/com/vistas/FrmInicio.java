
package com.vistas;

import com.conexion.Conexion;
import com.dao.DaoCitas;
import com.dao.DaoRoles;
import com.modelo.CitasPendientes;
import com.modelo.Roles;
import com.vistas.FrmLoginDoctor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fabio
 */
public class FrmInicio extends javax.swing.JFrame {

    Roles rol = new Roles();
    DaoRoles daoR = new DaoRoles();
      DaoCitas daoC = new DaoCitas();
    CitasPendientes cit = new CitasPendientes();
    public FrmInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        jLabel4.setText(daoR.ingresarN());
        llenarTabla();
    }
    String [] botones ={"Registrar Cita","Cancelar"};
    String [] botones1 ={"Primera Consulta","Nueva Consulta"};
        public void llenarTabla()
        {
            try {
                String [] columnas={"Expediente","Cod. Paciente","Nombre","Num. Cita","Fecha","Hora",};
            Object [] obj= new Object[6];
            DefaultTableModel tabla = new DefaultTableModel(null,columnas);
            
            List lista = daoC.mostrarCitas();
            
            for(int i=0;i<lista.size();i++){
            cit = (CitasPendientes)lista.get(i);
            obj[0]= cit.getIdExp();
            obj[1]= cit.getIdPaciente();
            obj[2] = cit.getNombre();
            obj[3] = cit.getIdCita();
            obj[4] = cit.getFecha();
            obj[5] = cit.getHora();
            
            tabla.addRow(obj);
            }
            lista = daoC.mostrarCitas();
            this.jTable1.setModel(tabla);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
            

        }
    public static int form=0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnRolesUs1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(710, 440));
        setResizable(false);
        getContentPane().setLayout(null);

        btnCerrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCerrar.setText("Gestionar usuarios");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(400, 20, 150, 40);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Bienvenido Dr: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 20, 115, 23);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Consultas a realizar este día");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(170, 80, 350, 29);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(306, 103, 0, 0);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(150, 20, 70, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 20, 70, 20);

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 130, 647, 200);

        BtnRolesUs1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnRolesUs1.setText("Cerrar Sesión");
        BtnRolesUs1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRolesUs1ActionPerformed(evt);
            }
        });
        getContentPane().add(BtnRolesUs1);
        BtnRolesUs1.setBounds(570, 20, 120, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/background.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 710, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
       JOptionPane.showMessageDialog(null, "Por seguridad, necesitas tus credenciales","Alerta",JOptionPane.INFORMATION_MESSAGE);
       FrmLoginDoctorAgain dr = new FrmLoginDoctorAgain();
       dr.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila=this.jTable1.getSelectedRow();
        String nombre = String.valueOf(this.jTable1.getValueAt(fila, 2));

        int variable = JOptionPane.showOptionDialog(rootPane, "¿Registrar diagnostico para "+nombre+"?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, NORMAL);

        if(variable==0){
            
                FrmDiagnositcos frm1 = new FrmDiagnositcos();
            frm1.setVisible(true);
            this.dispose();
           
            }
            
            
        


    }//GEN-LAST:event_jTable1MouseClicked

    private void BtnRolesUs1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRolesUs1ActionPerformed
         int variable = JOptionPane.showConfirmDialog(null, "¿Desea cerrar Sesión?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if(variable==0){
            
                FrmLoginDoctor frm1 = new FrmLoginDoctor();
            frm1.setVisible(true);
            this.dispose();
           
            }
    }//GEN-LAST:event_BtnRolesUs1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRolesUs1;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
