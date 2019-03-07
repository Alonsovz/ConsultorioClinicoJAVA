
package com.vistas;

import com.dao.DaoRoles;
import com.modelo.Roles;
import com.utilidades.FuncionesValidacion;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Nombre de la clase: FrmRoles
 * Fecha: 5-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
 */
public class FrmRoles extends javax.swing.JFrame {
    FuncionesValidacion fun = new FuncionesValidacion();
    
    public FrmRoles() {
        initComponents();
        mostrar();
        this.jLabel1.setVisible(false);
        this.jTxtCod.setVisible(false);
        this.setLocationRelativeTo(null);
    }
    
    String [] botones ={"Modificar","Eliminar","Cancelar"};
    
    DaoRoles daoR = new DaoRoles();
    Roles rol = new Roles();
    
    public void mostrar()
    {
        try 
        {
            String [] columnas = {"Id Rol","Nombre","Apellido","Teléfono","Usuario","Contraseña","Nivel de Acceso"};
            Object [] obj = new Object[7];
            DefaultTableModel tabla = new DefaultTableModel(null,columnas);
            
            List lista = daoR.mostrarRoles();
            
            for(int i=0;i<lista.size();i++)
            {
                rol=(Roles)lista.get(i);
                obj[0]=rol.getIdRol();
                obj[1]=rol.getNombre();
                obj[2]=rol.getApellido();
                obj[3]=rol.getTelefono();
                obj[4]=rol.getUsername();
                obj[5]=rol.getPass();
                obj[6]=rol.getNivelAcc();
                tabla.addRow(obj);
                
                
            }
            lista = daoR.mostrarRoles();
            this.jTablaRoles.setModel(tabla);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar tabla "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    
    public void insertar()
    {
        try {
            rol.setNombre(this.jTxtNombre.getText());
            rol.setApellido(this.jTxtApellido.getText());
            rol.setTelefono(this.jTxtTelefono.getText());
            rol.setUsername(this.jTxtUsuario.getText());
            rol.setPass(this.jTxtContra.getText());
            if(this.jCmbCargo.getSelectedIndex()==0){
            rol.setNivelAcc(1);
            
            }
            else{
            rol.setNivelAcc(2);
            }
            daoR.insertar(rol);
            JOptionPane.showMessageDialog(null, "Ingresado con éxito","INFORMACIÓN",JOptionPane.INFORMATION_MESSAGE );
            limpiar();
            mostrar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    
    }
    
    public void llenarTabla()
    {
        int fila=this.jTablaRoles.getSelectedRow();
        
        this.jLabel1.setVisible(true);
        this.jTxtCod.setVisible(true);
        
        this.jTxtCod.setText(String.valueOf(this.jTablaRoles.getValueAt(fila, 0)));
        this.jTxtNombre.setText(String.valueOf(this.jTablaRoles.getValueAt(fila, 1)));
        this.jTxtApellido.setText(String.valueOf(this.jTablaRoles.getValueAt(fila, 2)));
        this.jTxtTelefono.setText(String.valueOf(this.jTablaRoles.getValueAt(fila, 3)));
        this.jTxtUsuario.setText(String.valueOf(this.jTablaRoles.getValueAt(fila, 4)));
        this.jTxtContra.setText(String.valueOf(this.jTablaRoles.getValueAt(fila, 5)));
        
        if(this.jTablaRoles.getValueAt(fila, 6).equals(1))
        {
            this.jCmbCargo.setSelectedItem("Doctor/a");
        
        }
        else
        {
            this.jCmbCargo.setSelectedItem("Secretario/a");
        
        }
        
    
    
    }
    
    public void eliminar()
    {
        
        try {
            int fila = this.jTablaRoles.getSelectedRow();
        this.jTxtCod.setText(String.valueOf(this.jTablaRoles.getValueAt(fila, 0)));
        
        rol.setIdRol(Integer.parseInt(this.jTxtCod.getText()));
        
        JOptionPane.showMessageDialog(null, "Estás a punto de realizar una acción que no podrás cambiar","Aviso",JOptionPane.INFORMATION_MESSAGE);
            int siOno=JOptionPane.showConfirmDialog(null, "¿Deseas eliminar los datos?","Confirmación",JOptionPane.WARNING_MESSAGE,JOptionPane.YES_NO_OPTION);
            
            if(siOno==0){
            daoR.eliminar(rol);
            limpiar();
            JOptionPane.showMessageDialog(null, "Eliminado con éxito","Aviso",JOptionPane.INFORMATION_MESSAGE);
                mostrar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar datos "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void modificar(){
        
        try {
            rol.setIdRol(Integer.parseInt(this.jTxtCod.getText()));
            rol.setNombre(this.jTxtNombre.getText());
            rol.setApellido(this.jTxtApellido.getText());
            rol.setTelefono(this.jTxtTelefono.getText());
            rol.setUsername(this.jTxtUsuario.getText());
            rol.setPass(this.jTxtContra.getText());
            if(this.jCmbCargo.getSelectedIndex()==0){
            rol.setNivelAcc(1);
            
            }
            else{
            rol.setNivelAcc(2);
            }
            
            daoR.modificar(rol);
            JOptionPane.showMessageDialog(null, "Modificado con éxito","Aviso",JOptionPane.INFORMATION_MESSAGE);
            limpiar();
            mostrar();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar datos "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    
    }
    
    public void limpiar()
    {
        this.jTxtCod.setVisible(false);
        this.jLabel1.setVisible(false);
        this.jTxtCod.setText("");
        this.jTxtNombre.setText("");
        this.jTxtContra.setText("");
        this.jTxtApellido.setText("");
        this.jTxtTelefono.setText("");
        this.jTxtUsuario.setText("");
        this.jCmbCargo.setSelectedIndex(0);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaRoles = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTxtCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTxtContra = new javax.swing.JTextField();
        jCmbCargo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jTxtNombre = new javax.swing.JTextField();
        jTxtApellido = new javax.swing.JTextField();
        jTxtTelefono = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(796, 544));
        setResizable(false);
        getContentPane().setLayout(null);

        jTablaRoles.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablaRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaRolesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaRoles);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 384, 693, 122);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo rol:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(320, 81, 76, 17);

        jTxtCod.setEditable(false);
        getContentPane().add(jTxtCod);
        jTxtCod.setBounds(406, 74, 46, 34);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(78, 152, 61, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Apellido:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(78, 200, 59, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Teléfono:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(78, 247, 65, 17);
        getContentPane().add(jTxtUsuario);
        jTxtUsuario.setBounds(584, 147, 159, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(403, 152, 57, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Contraseña:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(403, 200, 85, 17);
        getContentPane().add(jTxtContra);
        jTxtContra.setBounds(584, 195, 159, 30);

        jCmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doctor/a", "Enfermero/a" }));
        getContentPane().add(jCmbCargo);
        jCmbCargo.setBounds(584, 243, 159, 28);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nivel de acceso-Cargo");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(403, 247, 152, 17);

        btnInsertar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsertar);
        btnInsertar.setBounds(120, 320, 120, 41);

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(400, 320, 110, 41);

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar);
        btnModificar.setBounds(260, 320, 120, 41);

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/eliminar.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(540, 320, 110, 41);

        jTxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtNombreKeyTyped(evt);
            }
        });
        getContentPane().add(jTxtNombre);
        jTxtNombre.setBounds(172, 147, 159, 30);

        jTxtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtApellidoKeyTyped(evt);
            }
        });
        getContentPane().add(jTxtApellido);
        jTxtApellido.setBounds(172, 195, 159, 30);

        try {
            jTxtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(503) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(jTxtTelefono);
        jTxtTelefono.setBounds(172, 243, 159, 28);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/user.png"))); // NOI18N
        jLabel8.setText("Gestión de Roles");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(290, 20, 240, 50);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/medicine-2_1.png"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(690, 20, 60, 70);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/background.jpg"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 800, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if(this.jTxtNombre.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Complete los campos correctamente","Alerta",JOptionPane.WARNING_MESSAGE);
    }else{
        insertar();
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void jTablaRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaRolesMouseClicked
        int variable = JOptionPane.showOptionDialog(rootPane, "Acción a realizar", "Acción", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, NORMAL);
        
        if(variable==0){
            llenarTabla();
        }
        
        if(variable==1)
        {
        eliminar();
        
        }
    }//GEN-LAST:event_jTablaRolesMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       int siOno=JOptionPane.showConfirmDialog(null, "¿Deseas modificar los datos?","Confirmación",JOptionPane.WARNING_MESSAGE,JOptionPane.YES_NO_OPTION);
            
            if(siOno==0){
            
            
            modificar();
            }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       if(this.jTxtNombre.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Complete los campos correctamente","Alerta",JOptionPane.WARNING_MESSAGE);
    }else{ limpiar();}
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        JOptionPane.showMessageDialog(null, "Cualquier acción no guardada se perderá","Aviso",JOptionPane.INFORMATION_MESSAGE);
        FrmInicio frm = new FrmInicio();
            this.dispose();
            frm.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jTxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtNombreKeyTyped
       fun.wordsOnly(evt);
    }//GEN-LAST:event_jTxtNombreKeyTyped

    private void jTxtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtApellidoKeyTyped
       fun.wordsOnly(evt);
    }//GEN-LAST:event_jTxtApellidoKeyTyped

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
            java.util.logging.Logger.getLogger(FrmRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRoles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> jCmbCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaRoles;
    private javax.swing.JTextField jTxtApellido;
    private javax.swing.JTextField jTxtCod;
    private javax.swing.JTextField jTxtContra;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JFormattedTextField jTxtTelefono;
    private javax.swing.JTextField jTxtUsuario;
    // End of variables declaration//GEN-END:variables
}
