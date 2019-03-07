
package com.vistas;

import com.conexion.Conexion;
import com.dao.DaoAlergias;
import com.dao.DaoCitas;
import com.dao.DaoDiagCorto;
import com.dao.DaoEnfermedades;
import com.dao.DaoMedicamentos;
import com.dao.DaoOperaciones;
import com.modelo.Alergias;
import com.modelo.CitasPendientes;
import com.modelo.DiagnosticosCortos;
import com.modelo.Historial;
import com.modelo.Enfermedades;
import com.modelo.Medicamentos;
import com.modelo.Operaciones;
import com.modelo.Referencias;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Nombre de la clase: FrmDiagnostico
 * Fecha: 4-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
 */

public class FrmDiagnositcos extends javax.swing.JFrame {

    DaoCitas daoC = new DaoCitas();
    Historial his = new Historial();
    DaoDiagCorto daoDg = new DaoDiagCorto();
    Enfermedades ref = new Enfermedades();
    Alergias al = new Alergias();
    Operaciones op = new Operaciones();
    Referencias refe = new Referencias();
    Medicamentos medi = new Medicamentos();
    DiagnosticosCortos diagC = new DiagnosticosCortos();
    CitasPendientes cit = new CitasPendientes();
    
    DaoMedicamentos daoM = new DaoMedicamentos();
    DaoEnfermedades daoE = new DaoEnfermedades();
    DaoAlergias daoA = new DaoAlergias();
    DaoOperaciones daoO= new DaoOperaciones();
    public FrmDiagnositcos() {
        try {
            initComponents();
            
            int fila = FrmInicio.jTable1.getSelectedRow();
            jLabel1.setText(String.valueOf(FrmInicio.jTable1.getValueAt(fila, 2)));
            jLabel10.setText(String.valueOf(FrmInicio.jTable1.getValueAt(fila, 0)));
            jLabel9.setText(String.valueOf(FrmInicio.jTable1.getValueAt(fila, 3)));
            jTxtFecha.setText(String.valueOf(FrmInicio.jTable1.getValueAt(fila, 4)));
            jTxtHora.setText(String.valueOf(FrmInicio.jTable1.getValueAt(fila, 5)));
            jLabel17.setText(String.valueOf(FrmInicio.jTable1.getValueAt(fila, 1)));
           
            jCmbEnferHere.setEnabled(false);
            
            
            jCmbOperacion.setEnabled(false);
            
            btnReceta.setVisible(false);
            btnIncapacidad.setVisible(false);
            btnConstancia.setVisible(false);
            jCmbAlergias.setEnabled(false);
            
            jLabel10.setVisible(false);
            jLabel17.setVisible(false);
            
            jLabel9.setVisible(false);
            jLabel23.setVisible(false);
            jTxtFechaOp.setEnabled(false);
            jTxtFecha.setVisible(false);
            jTxtHora.setVisible(false);
            btnAlergias.setVisible(false);
            btnEnfer.setVisible(false);
            btnOperacion.setVisible(false);
           
           
            
            jChOtraAler.setEnabled(false);
           jTxtOtraAlergia.setEnabled(false);
           jTxtOtraEnfermedad.setEnabled(false);
           jTxtOtraOp.setEnabled(false);
            jChOtraEnfer.setEnabled(false);
            jChOtraOp.setEnabled(false);
            
            jChMasAler.setEnabled(false);
            jChMasOp.setEnabled(false);
            jChMasEnfer.setEnabled(false);
           
            jTxtOtroDiagCorto.setEnabled(false);
            jTxtOtroMedicamento.setEnabled(false);
            btnNewDiag.setVisible(false);
            btnNewMedicamento.setVisible(false);
            btnAddAler.setVisible(false);
            btnAddDiag.setVisible(false);
            btnAddEn.setVisible(false);
            btnAddMed.setVisible(false);
            btnAddOp.setVisible(false);
            
          cargarCombo(jCmbMedicamentos, (ArrayList<Medicamentos>) daoM.mostrarMedicamentos());
           cargarCombo1(jCmbEnferHere, (ArrayList<Enfermedades>) daoE.mostrarEnfermedad());
           cargarCombo2(jCmbAlergias, (ArrayList<Alergias>) daoA.mostrarAlergia());
          cargarCombo3(jCmbDiagCorto, (ArrayList<DiagnosticosCortos>) daoDg.mostrarDiagCorto());
           cargarCombo4(jCmbOperacion, (ArrayList<Operaciones>) daoO.mostrarOperacion());
            this.setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(FrmDiagnositcos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void cargarCombo(JComboBox combo, ArrayList<Medicamentos> List) throws Exception
    {
        for(Medicamentos item: List){
        combo.addItem(new ComboItem(item.getIdMedicamento(), item.getMedicamento()));
        
        }
    
    
    }
    
    private void cargarCombo1(JComboBox combo, ArrayList<Enfermedades> List) throws Exception
    {
        for(Enfermedades item: List){
        combo.addItem(new ComboItem(item.getIdEnfermedad(), item.getEnfermedadesHere()));
        
        }
    
    
    }
    
    private void cargarCombo2(JComboBox combo, ArrayList<Alergias> List) throws Exception
    {
        for(Alergias item: List){
        combo.addItem(new ComboItem(item.getIdAlergia(), item.getAlergia()));
        
        }
    
    
    }
    
     private void cargarCombo3(JComboBox combo, ArrayList<DiagnosticosCortos> List) throws Exception
    {
        for(DiagnosticosCortos item: List){
        combo.addItem(new ComboItem(item.getIdDiagCorto(), item.getNombreDiag()));
        
        }
    
    
    }
     
     private void cargarCombo4(JComboBox combo, ArrayList<Operaciones> List) throws Exception
    {
        for(Operaciones item: List){
        combo.addItem(new ComboItem(item.getIdOperacion(), item.getOperacion()));
        
        }
    
    
    }
    
    public int insertarDiagnosticos()
    {
        int resultado=0;
        try {
            String nom=FrmInicio.jLabel3.getText();
        String ape=FrmInicio.jLabel4.getText();
            his.setIdExp(Integer.parseInt(this.jLabel10.getText()));
            his.setDescripcion(this.jTxtDescripcion1.getText());
            his.setPresion(this.jTxtPresion.getText());
            his.setAltura(this.jTxtAltura.getText());
            his.setPeso(this.jTxtPeso.getText());
            his.setFecha(this.jTxtFecha.getText());
            his.setHora(this.jTxtHora.getText());
            his.setIdDiagnostico(daoC.getCodigoDi());
            daoC.modificarDiag(his);
           
            if (!this.jChMasEnfer.isSelected()) {
                ref.setIdExp(Integer.parseInt(this.jLabel10.getText()));

                String enfermedad = jCmbEnferHere.getSelectedItem().toString();
                ComboItem item = new ComboItem();

                for (int i = 0; i < jCmbEnferHere.getItemCount(); i++) {
                    if (enfermedad.equals(jCmbEnferHere.getItemAt(i).toString())) {
                        item = jCmbEnferHere.getModel().getElementAt(i);
                    }
                }

                ref.setIdEnfermedad(item.getValue());

                daoE.insertarEfermedadesExis(ref);
            }
            
                        if (!this.jChMasAler.isSelected()) {

                al.setIdExp(Integer.parseInt(this.jLabel10.getText()));
                String alergia = jCmbAlergias.getSelectedItem().toString();
                ComboItem item = new ComboItem();

                for (int i = 0; i < jCmbAlergias.getItemCount(); i++) {
                    if (alergia.equals(jCmbAlergias.getItemAt(i).toString())) {
                        item = jCmbAlergias.getModel().getElementAt(i);
                    }
                }

                al.setIdAlergia(item.getValue());
                daoA.insertarAlergiasExis(al);
            }
            
               if(!this.jChMasOp.isSelected())
               {
                   op.setIdExp(Integer.parseInt(this.jLabel10.getText()));
                   String operacion = jCmbOperacion.getSelectedItem().toString();
                   ComboItem item = new ComboItem();

                   for (int i = 0; i < jCmbOperacion.getItemCount(); i++) {
                       if (operacion.equals(jCmbOperacion.getItemAt(i).toString())) {
                           item = jCmbOperacion.getModel().getElementAt(i);
                       }
                   }

                   op.setIdOperacion(item.getValue());
                   op.setFechaOperacion(this.jTxtFechaOp.getText());
                   daoO.insertarOperacionesExi(op);
               
               }
               
               if(!this.jChMasMedi.isSelected())
               {
                   medi.setIdDiagnostico(daoM.getDiag());
                   String medicamento = jCmbMedicamentos.getSelectedItem().toString();
                   ComboItem item = new ComboItem();

                   for (int i = 0; i < jCmbMedicamentos.getItemCount(); i++) {
                       if (medicamento.equals(jCmbMedicamentos.getItemAt(i).toString())) {
                           item = jCmbMedicamentos.getModel().getElementAt(i);
                       }
                   }

                   medi.setIdMedicamento(item.getValue());
                   medi.setFechaIncio(this.jTxtFecha.getText());
                   daoM.insertarMedicamentosExi(medi);
               }
               
               if(!this.jChMasDiag.isSelected())
               {
               
               String diag = jCmbDiagCorto.getSelectedItem().toString();
        ComboItem item = new ComboItem();

        for (int i = 0; i < jCmbDiagCorto.getItemCount(); i++) {
            if (diag.equals(jCmbDiagCorto.getItemAt(i).toString())) {
                item = jCmbDiagCorto.getModel().getElementAt(i);
            }
        }
        
        
        diagC.setIdDiagCorto(item.getValue());
       
        try {
            diagC.setIdDiagnostico(daoC.getCodigoDi());
        } catch (Exception ex) {
            Logger.getLogger(FrmDiagnositcos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       daoDg.insertarDiagCorExi(diagC);
        
               }
           resultado=1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar datos","Error", JOptionPane.ERROR_MESSAGE);
        }
    return resultado;
    }
    
    
    
    
    public void Limpiar()
    {
        this.jTxtDescripcion1.setText("");
        this.jTxtPresion.setText("");
        this.jTxtPresion.setText("");
        this.jTxtPeso.setText("");
        this.jTxtFechaOp.setText("");
        
        this.jTxtAltura.setText("");
        
        ocultarchex();
        this.jCheckBox3.setSelected(false);
        this.jCheckBox1.setSelected(false);
        this.jCheckBox5.setSelected(false);
        
        this.jChMasAler.setSelected(false);
        this.jChMasOp.setSelected(false);
        this.jChMasDiag.setSelected(false);
        jChOtraAler.setSelected(false);
        jChOtraEnfer.setSelected(false);
        jChMasEnfer.setSelected(false);
        
        btnAddEn.setVisible(false);
        btnAddAler.setVisible(false);
        btnAddOp.setVisible(false);
        btnAddMed.setVisible(false);
        btnAddDiag.setVisible(false);
        btnNewDiag.setVisible(false);
        btnNewMedicamento.setVisible(false);
        
        this.jCmbAlergias.setSelectedIndex(0);
        this.jCmbDiagCorto.setSelectedIndex(0);
        this.jCmbEnferHere.setSelectedIndex(0);
        this.jCmbMedicamentos.setSelectedIndex(0);
        this.jCmbOperacion.setSelectedIndex(0);
        
        
    }
    
public void ocultarchex()
{
    if(jCheckBox3.isSelected()){
        jCmbEnferHere.setEnabled(false);
        
        
        
        jChMasEnfer.setEnabled(false);
        btnEnfer.setVisible(false);
    } 
   
    
     if(jCheckBox1.isSelected())
    {
        
        jCmbAlergias.setEnabled(false); 
        jChMasAler.setEnabled(false);
        
        jTxtFechaOp.setEnabled(false);
        btnAlergias.setVisible(false);
    }
    
    if(jCheckBox5.isSelected())
    {
        jCheckBox6.setSelected(false);
        
        jCmbOperacion.setEnabled(false);

        jChMasOp.setEnabled(false);
        
        jTxtFechaOp.setEnabled(false);
        btnOperacion.setVisible(false);
    }
       
       
        
}
    
    
   
    
  
    
    public void actualizar()
    {
        try {
            cit.setIdCita(Integer.parseInt(this.jLabel9.getText()));
            cit.setIdPaciente(Integer.parseInt(this.jLabel17.getText()));
            cit.setFecha(this.jTxtFecha.getText());
            cit.setHora(this.jTxtHora.getText());
            cit.setEstado("Realizada");
            cit.setComentarios("");
            daoC.paraCita(cit);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
       
    
    
    }
    
    public void insertarEnfer()
    {
     if(jCheckBox3.isSelected()){
      ref.setEnfermedadesHere(this.jTxtOtraEnfermedad.getText());
      JOptionPane.showMessageDialog(null, "Agregado a lista","Aviso",JOptionPane.INFORMATION_MESSAGE);
    daoE.insertarEfermedades(ref);
    jCmbEnferHere.removeAllItems();
         try {
             cargarCombo1(jCmbEnferHere, (ArrayList<Enfermedades>) daoE.mostrarEnfermedad());
         } catch (Exception ex) {
             Logger.getLogger(FrmDiagnositcos.class.getName()).log(Level.SEVERE, null, ex);
         }
         jChOtraEnfer.setSelected(false);
         jTxtOtraEnfermedad.setText("");
     }
     else
     {
     
     }
    }
    
    public void insertarAlergia()
    {
        if(jCheckBox1.isSelected())
        {
    
    al.setAlergia(this.jTxtOtraAlergia.getText());
    daoA.insertarAlergias(al);
    JOptionPane.showMessageDialog(null, "Agregado a lista","Aviso",JOptionPane.INFORMATION_MESSAGE);
    jCmbAlergias.removeAllItems();
            try {
                cargarCombo2(jCmbAlergias, (ArrayList<Alergias>) daoA.mostrarAlergia());
            } catch (Exception ex) {
                Logger.getLogger(FrmDiagnositcos.class.getName()).log(Level.SEVERE, null, ex);
            }
    jChOtraAler.setSelected(false);
    jTxtOtraAlergia.setText("");
        }
        else
        {
        
        }
    }
    
    public void insertarOp()
    {
        if(jCheckBox5.isSelected())
        {
    
    op.setOperacion(this.jTxtOtraOp.getText());
    op.setFechaOperacion(this.jTxtFechaOp.getText());
    daoO.insertarOperaciones(op);
    JOptionPane.showMessageDialog(null, "Agregado a lista","Aviso",JOptionPane.INFORMATION_MESSAGE);
    jCmbOperacion.removeAllItems();
            try {
                cargarCombo4(jCmbOperacion, (ArrayList<Operaciones>) daoO.mostrarOperacion());
            } catch (Exception ex) {
                Logger.getLogger(FrmDiagnositcos.class.getName()).log(Level.SEVERE, null, ex);
            }
            jChOtraOp.setSelected(false);
            jTxtOtraOp.setText("");
    }
    }
    
    public void insertarM()
    {
    
    medi.setMedicamento(this.jTxtOtroMedicamento.getText());
    daoM.insertarMedicamentos(medi);
    JOptionPane.showMessageDialog(null, "Agregado a lista","Aviso",JOptionPane.INFORMATION_MESSAGE);
    jCmbMedicamentos.removeAllItems();
        try {
            cargarCombo(jCmbMedicamentos, (ArrayList<Medicamentos>) daoM.mostrarMedicamentos());
        } catch (Exception ex) {
            Logger.getLogger(FrmDiagnositcos.class.getName()).log(Level.SEVERE, null, ex);
        }
        jChOtroMedi.setSelected(false);
        jTxtOtroMedicamento.setText("");
    }
    
    public void  insertarDiag()
    {
    diagC.setNombreDiag(this.jTxtOtroDiagCorto.getText());
    daoDg.insertarDiagCor(diagC);
    JOptionPane.showMessageDialog(null, "Agregado a lista","Aviso",JOptionPane.INFORMATION_MESSAGE);
    jCmbDiagCorto.removeAllItems();
        try {
            cargarCombo3(jCmbDiagCorto, (ArrayList<DiagnosticosCortos>) daoDg.mostrarDiagCorto());
        } catch (Exception ex) {
            Logger.getLogger(FrmDiagnositcos.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.jTxtOtroDiagCorto.setText("");
        jChOtroDi.setSelected(false);
    }
   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAnteriores = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTxtFecha = new javax.swing.JTextField();
        jTxtHora = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jCmbEnferHere = new javax.swing.JComboBox<>();
        jCmbDiagCorto = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jCmbOperacion = new javax.swing.JComboBox<>();
        jCmbMedicamentos = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnReceta = new javax.swing.JButton();
        btnConstancia = new javax.swing.JButton();
        btnIncapacidad = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnReferencias = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTxtDescripcion1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jCmbAlergias = new javax.swing.JComboBox<>();
        btnEnfer = new javax.swing.JButton();
        btnAlergias = new javax.swing.JButton();
        btnOperacion = new javax.swing.JButton();
        jChMasAler = new javax.swing.JCheckBox();
        jChMasEnfer = new javax.swing.JCheckBox();
        jChMasOp = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jTxtFechaOp = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTxtPresion = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jTxtAltura = new javax.swing.JFormattedTextField();
        jTxtPeso = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        jChOtraEnfer = new javax.swing.JCheckBox();
        jTxtOtraOp = new javax.swing.JTextField();
        jChOtraOp = new javax.swing.JCheckBox();
        jTxtOtraEnfermedad = new javax.swing.JTextField();
        jChOtraAler = new javax.swing.JCheckBox();
        jTxtOtraAlergia = new javax.swing.JTextField();
        btnNewMedicamento = new javax.swing.JButton();
        jChMasMedi = new javax.swing.JCheckBox();
        jChOtroMedi = new javax.swing.JCheckBox();
        jTxtOtroMedicamento = new javax.swing.JTextField();
        btnNewDiag = new javax.swing.JButton();
        jChMasDiag = new javax.swing.JCheckBox();
        jChOtroDi = new javax.swing.JCheckBox();
        jTxtOtroDiagCorto = new javax.swing.JTextField();
        btnAddDiag = new javax.swing.JButton();
        btnAddEn = new javax.swing.JButton();
        btnAddAler = new javax.swing.JButton();
        btnAddOp = new javax.swing.JButton();
        btnAddMed = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1056, 829));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 120, 150, 22);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Paciente:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 120, 70, 30);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Descripicion del paciente:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(490, 130, 151, 20);

        btnAnteriores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAnteriores.setText("Ver consultas anteriores");
        btnAnteriores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnterioresActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnteriores);
        btnAnteriores.setBounds(40, 170, 181, 40);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Presión:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(710, 140, 50, 20);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Altura:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(870, 190, 50, 20);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Medicamentos:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(150, 540, 92, 17);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Diagnostico (Enfermedad):");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(520, 530, 190, 50);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(340, 30, 90, 17);

        jTxtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtFechaActionPerformed(evt);
            }
        });
        getContentPane().add(jTxtFecha);
        jTxtFecha.setBounds(730, 10, 120, 20);

        jTxtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtHoraActionPerformed(evt);
            }
        });
        getContentPane().add(jTxtHora);
        jTxtHora.setBounds(570, 10, 120, 20);

        jCheckBox1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jCheckBox1.setText("Si");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(510, 280, 35, 25);

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel11.setText("Alergias:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(420, 280, 50, 17);

        jCheckBox2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jCheckBox2.setText("No");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox2);
        jCheckBox2.setBounds(550, 280, 41, 25);

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setText("Alérgico a:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(420, 310, 80, 17);

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel13.setText("Enfermedades Hereditarias:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(50, 280, 164, 17);

        jCheckBox3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jCheckBox3.setText("Si");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox3);
        jCheckBox3.setBounds(230, 280, 35, 25);

        jCheckBox4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jCheckBox4.setText("No");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox4);
        jCheckBox4.setBounds(270, 280, 41, 25);

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel14.setText("Nombre de la enfermedad:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(50, 320, 160, 17);

        jCmbEnferHere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCmbEnferHereMouseClicked(evt);
            }
        });
        jCmbEnferHere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbEnferHereActionPerformed(evt);
            }
        });
        getContentPane().add(jCmbEnferHere);
        jCmbEnferHere.setBounds(230, 310, 140, 30);

        jCmbDiagCorto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCmbDiagCortoMouseClicked(evt);
            }
        });
        getContentPane().add(jCmbDiagCorto);
        jCmbDiagCorto.setBounds(700, 540, 130, 30);

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel15.setText("Operación");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(790, 280, 70, 17);

        jCheckBox5.setText("Si");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox5);
        jCheckBox5.setBounds(870, 280, 33, 23);

        jCheckBox6.setText("No");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox6);
        jCheckBox6.setBounds(910, 280, 39, 23);

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel16.setText("Nombre de la operación:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(710, 310, 150, 17);

        jCmbOperacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCmbOperacionMouseClicked(evt);
            }
        });
        getContentPane().add(jCmbOperacion);
        jCmbOperacion.setBounds(870, 310, 160, 30);

        jCmbMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCmbMedicamentosMouseClicked(evt);
            }
        });
        getContentPane().add(jCmbMedicamentos);
        jCmbMedicamentos.setBounds(260, 530, 170, 30);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(340, 690, 110, 40);

        btnReceta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/limpiar.png"))); // NOI18N
        btnReceta.setText("Generar Receta");
        btnReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecetaActionPerformed(evt);
            }
        });
        getContentPane().add(btnReceta);
        btnReceta.setBounds(210, 740, 170, 40);

        btnConstancia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConstancia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/limpiar.png"))); // NOI18N
        btnConstancia.setText("Generar Constancia");
        btnConstancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConstanciaActionPerformed(evt);
            }
        });
        getContentPane().add(btnConstancia);
        btnConstancia.setBounds(710, 740, 200, 40);

        btnIncapacidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIncapacidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/modificar.png"))); // NOI18N
        btnIncapacidad.setText("Generar Incapacidad");
        btnIncapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncapacidadActionPerformed(evt);
            }
        });
        getContentPane().add(btnIncapacidad);
        btnIncapacidad.setBounds(460, 740, 220, 40);

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(710, 690, 110, 40);

        btnReferencias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReferencias.setText("Datos Médicos");
        btnReferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReferenciasActionPerformed(evt);
            }
        });
        getContentPane().add(btnReferencias);
        btnReferencias.setBounds(230, 170, 140, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Peso:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(710, 190, 40, 20);
        getContentPane().add(jTxtDescripcion1);
        jTxtDescripcion1.setBounds(450, 160, 244, 60);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(340, 10, 90, 17);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("jLabel17");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(340, 50, 80, 14);

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel18.setText("Fecha de Operacion:");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(730, 360, 120, 17);

        jCmbAlergias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCmbAlergiasMouseClicked(evt);
            }
        });
        jCmbAlergias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbAlergiasActionPerformed(evt);
            }
        });
        getContentPane().add(jCmbAlergias);
        jCmbAlergias.setBounds(510, 310, 160, 30);

        btnEnfer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEnfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnEnfer.setText("Agregar otra");
        btnEnfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnferActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnfer);
        btnEnfer.setBounds(230, 410, 125, 40);

        btnAlergias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlergias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnAlergias.setText("Agregar otra");
        btnAlergias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlergiasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlergias);
        btnAlergias.setBounds(550, 410, 130, 40);

        btnOperacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnOperacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnOperacion.setText("Agregar otra");
        btnOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperacionActionPerformed(evt);
            }
        });
        getContentPane().add(btnOperacion);
        btnOperacion.setBounds(890, 460, 140, 40);

        jChMasAler.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jChMasAler.setText("Mas de una alergia");
        jChMasAler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChMasAlerActionPerformed(evt);
            }
        });
        getContentPane().add(jChMasAler);
        jChMasAler.setBounds(403, 420, 140, 25);

        jChMasEnfer.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jChMasEnfer.setText("Mas de una enfermedad");
        jChMasEnfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChMasEnferActionPerformed(evt);
            }
        });
        getContentPane().add(jChMasEnfer);
        jChMasEnfer.setBounds(40, 420, 170, 25);

        jChMasOp.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jChMasOp.setText("Mas de una operación");
        jChMasOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChMasOpActionPerformed(evt);
            }
        });
        getContentPane().add(jChMasOp);
        jChMasOp.setBounds(730, 470, 160, 25);

        jLabel19.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 51));
        jLabel19.setText("Diagnostico");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(30, 20, 180, 40);

        try {
            jTxtFechaOp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(jTxtFechaOp);
        jTxtFechaOp.setBounds(870, 350, 160, 30);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("dd/mm/aa");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(920, 380, 60, 15);

        jPanel1.setBackground(new java.awt.Color(218, 240, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 110, 360, 130);

        try {
            jTxtPresion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###/##  mmhg")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(jTxtPresion);
        jTxtPresion.setBounds(770, 140, 120, 30);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/medicine-2_1.png"))); // NOI18N
        getContentPane().add(jLabel21);
        jLabel21.setBounds(910, 10, 70, 80);

        try {
            jTxtAltura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.## mts")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(jTxtAltura);
        jTxtAltura.setBounds(920, 180, 80, 30);

        try {
            jTxtPeso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.# kg")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(jTxtPeso);
        jTxtPeso.setBounds(770, 180, 90, 30);

        jPanel4.setBackground(new java.awt.Color(218, 240, 240));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        getContentPane().add(jPanel4);
        jPanel4.setBounds(30, 110, 360, 130);

        jPanel3.setBackground(new java.awt.Color(218, 240, 240));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jPanel3);
        jPanel3.setBounds(430, 110, 590, 130);

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(520, 690, 110, 40);

        jChOtraEnfer.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jChOtraEnfer.setText("OtraEnfermedad");
        jChOtraEnfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChOtraEnferActionPerformed(evt);
            }
        });
        getContentPane().add(jChOtraEnfer);
        jChOtraEnfer.setBounds(40, 360, 120, 25);
        getContentPane().add(jTxtOtraOp);
        jTxtOtraOp.setBounds(850, 420, 120, 30);

        jChOtraOp.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jChOtraOp.setText("Otra operación");
        jChOtraOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChOtraOpActionPerformed(evt);
            }
        });
        getContentPane().add(jChOtraOp);
        jChOtraOp.setBounds(730, 420, 120, 25);
        getContentPane().add(jTxtOtraEnfermedad);
        jTxtOtraEnfermedad.setBounds(170, 360, 140, 30);

        jChOtraAler.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jChOtraAler.setText("Otra Alergia");
        jChOtraAler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChOtraAlerActionPerformed(evt);
            }
        });
        getContentPane().add(jChOtraAler);
        jChOtraAler.setBounds(405, 370, 95, 25);
        getContentPane().add(jTxtOtraAlergia);
        jTxtOtraAlergia.setBounds(510, 370, 140, 30);

        btnNewMedicamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNewMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnNewMedicamento.setText("Agregar otra");
        btnNewMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewMedicamentoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewMedicamento);
        btnNewMedicamento.setBounds(300, 630, 125, 40);

        jChMasMedi.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jChMasMedi.setText("Mas de un medicamento");
        jChMasMedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChMasMediActionPerformed(evt);
            }
        });
        getContentPane().add(jChMasMedi);
        jChMasMedi.setBounds(130, 640, 170, 25);

        jChOtroMedi.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jChOtroMedi.setText("Otro Medicamento");
        jChOtroMedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChOtroMediActionPerformed(evt);
            }
        });
        getContentPane().add(jChOtroMedi);
        jChOtroMedi.setBounds(140, 580, 140, 25);
        getContentPane().add(jTxtOtroMedicamento);
        jTxtOtroMedicamento.setBounds(290, 580, 140, 30);

        btnNewDiag.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNewDiag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnNewDiag.setText("Agregar otra");
        btnNewDiag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewDiagActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewDiag);
        btnNewDiag.setBounds(710, 630, 125, 40);

        jChMasDiag.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jChMasDiag.setText("Mas de una enfermedad");
        jChMasDiag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChMasDiagActionPerformed(evt);
            }
        });
        getContentPane().add(jChMasDiag);
        jChMasDiag.setBounds(540, 640, 170, 25);

        jChOtroDi.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jChOtroDi.setText("Otro Enfermedad");
        jChOtroDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChOtroDiActionPerformed(evt);
            }
        });
        getContentPane().add(jChOtroDi);
        jChOtroDi.setBounds(550, 580, 140, 25);
        getContentPane().add(jTxtOtroDiagCorto);
        jTxtOtroDiagCorto.setBounds(700, 580, 140, 30);

        btnAddDiag.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAddDiag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnAddDiag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDiagActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddDiag);
        btnAddDiag.setBounds(850, 580, 40, 30);

        btnAddEn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAddEn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnAddEn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEnActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddEn);
        btnAddEn.setBounds(320, 360, 40, 30);

        btnAddAler.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAddAler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnAddAler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAlerActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddAler);
        btnAddAler.setBounds(660, 370, 40, 30);

        btnAddOp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAddOp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnAddOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOpActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddOp);
        btnAddOp.setBounds(990, 420, 40, 30);

        btnAddMed.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAddMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnAddMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMedActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddMed);
        btnAddMed.setBounds(450, 580, 40, 30);

        jPanel2.setBackground(new java.awt.Color(218, 240, 240));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(30, 270, 1010, 410);

        jLabel23.setText("jLabel23");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(880, 700, 40, 14);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/background.jpg"))); // NOI18N
        getContentPane().add(jLabel22);
        jLabel22.setBounds(0, 0, 1060, 830);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtFechaActionPerformed

    private void jTxtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtHoraActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        if(jCheckBox3.isSelected()){
        jCheckBox4.setSelected(false);
        jCmbEnferHere.setEnabled(true);
        
        
        btnEnfer.setEnabled(true);
       jChMasEnfer.setEnabled(true);
       jChOtraEnfer.setEnabled(true);
        }
        else{
        jCmbEnferHere.setEnabled(false);
        
        jChOtraEnfer.setEnabled(false);
        
        jChMasEnfer.setEnabled(false);
        btnEnfer.setEnabled(false);
        }
        
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        jCheckBox3.setSelected(false);
        jCmbEnferHere.setEnabled(false);
         btnAddEn.setVisible(false);
        jChOtraEnfer.setSelected(false);
        jChOtraEnfer.setEnabled(false);
        btnEnfer.setEnabled(false);
        jTxtOtraEnfermedad.setEnabled(false);
        jChMasEnfer.setEnabled(false);
        jChMasEnfer.setSelected(false);
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCmbEnferHereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbEnferHereActionPerformed
        
    }//GEN-LAST:event_jCmbEnferHereActionPerformed

    private void jCmbEnferHereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCmbEnferHereMouseClicked
        
    }//GEN-LAST:event_jCmbEnferHereMouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected())
        {
            jCheckBox2.setSelected(false);
          
          
          jCmbAlergias.setEnabled(true);
          btnAlergias.setEnabled(true);
          jChMasAler.setEnabled(true);
          jChOtraAler.setEnabled(true);
        }else
        {
        
          
        jCmbAlergias.setEnabled(false);
          
          jChMasAler.setEnabled(false);
         jChOtraAler.setEnabled(false);
            
            btnAlergias.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
          jChOtraAler.setSelected(false);
          jChOtraAler.setEnabled(false);
          jTxtOtraAlergia.setEnabled(false);
          jCheckBox1.setSelected(false);
          jCmbAlergias.setEnabled(false);
          btnAddAler.setVisible(false);
          btnAlergias.setEnabled(false);
          jChMasAler.setEnabled(false);
          jChMasAler.setSelected(false);
          
            
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCmbDiagCortoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCmbDiagCortoMouseClicked
        
    }//GEN-LAST:event_jCmbDiagCortoMouseClicked

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        if(jCheckBox5.isSelected())
        {
            jCheckBox6.setSelected(false);
            
            jCmbOperacion.setEnabled(true);
            
            jChMasOp.setEnabled(true);
            jChMasOp.setSelected(false);
            jChOtraOp.setEnabled(true);
           btnOperacion.setEnabled(true);
            jTxtFechaOp.setEnabled(true);
        }
        else
        {
        jCheckBox6.setSelected(false);
            
            jCmbOperacion.setEnabled(false);
            jChOtraOp.setEnabled(false);
            jChMasOp.setEnabled(false);
           
            jTxtFechaOp.setEnabled(false);
            btnOperacion.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        jTxtOtraOp.setEnabled(false);
        jChOtraOp.setSelected(false);
        jCheckBox5.setSelected(false);
            jChOtraOp.setEnabled(false);
            jCmbOperacion.setEnabled(false);
            btnAddOp.setVisible(false);
            btnOperacion.setEnabled(false);
               
            jChMasOp.setSelected(false);
            jChMasOp.setEnabled(false);
            
            jTxtFechaOp.setEnabled(false);
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCmbOperacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCmbOperacionMouseClicked
        
    }//GEN-LAST:event_jCmbOperacionMouseClicked

    private void jCmbMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCmbMedicamentosMouseClicked
        
    }//GEN-LAST:event_jCmbMedicamentosMouseClicked

    private void btnAnterioresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnterioresActionPerformed
        
        
        FrmHistorial frm = new FrmHistorial();
        frm.setVisible(true);
       
    }//GEN-LAST:event_btnAnterioresActionPerformed

    private void btnReferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReferenciasActionPerformed
        FrmDatos frm = new FrmDatos();
        frm.setVisible(true);
    }//GEN-LAST:event_btnReferenciasActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    if(this.jTxtDescripcion1.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Complete los campos correctamente","Alerta",JOptionPane.WARNING_MESSAGE);
    }else{
        if( insertarDiagnosticos()==1){
            
            actualizar();
            refe.setIdExp(Integer.parseInt(this.jLabel10.getText()));
            refe.setIdReferencia(1);
            daoO.insertarReferencias(refe);
             btnReceta.setVisible(true);
            btnIncapacidad.setVisible(true);
            btnConstancia.setVisible(true);
            jLabel23.setText(daoDg.getDescripcion());
        JOptionPane.showMessageDialog(null, "Datos guardados con éxito","Confirmación",JOptionPane.INFORMATION_MESSAGE);
            Limpiar();
        }
        else
        {
        JOptionPane.showMessageDialog(null, "Error al ingresar","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecetaActionPerformed
        String fec=this.jTxtFecha.getText();
        String hor=this.jTxtHora.getText();
        String nom = this.jLabel1.getText();
        Connection con = null;
       JasperReport reporte;
       Map parameters = new HashMap();
       parameters.put("nombre", nom);
       parameters.put("fecha",fec);
       parameters.put("hora",hor);
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio","root","123456");
        } catch (ClassNotFoundException| SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            reporte = JasperCompileManager.compileReport("src/com/reportes/ReReceta.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(reporte,parameters,con);
            JasperViewer.viewReport(jp,false);
        } catch (JRException e) {
            Logger.getLogger(FrmDiagnositcos.class.getName()).log(Level.SEVERE, null,e);
        }
    }//GEN-LAST:event_btnRecetaActionPerformed

    private void btnConstanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConstanciaActionPerformed
        String fec=this.jTxtFecha.getText();
        String hor=this.jTxtHora.getText();
        Connection con = null;
       JasperReport reporte;
       Map parameters = new HashMap();
       parameters.put("fecha",fec);
       parameters.put("hora",hor);
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio","root","123456");
        } catch (ClassNotFoundException| SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            reporte = JasperCompileManager.compileReport("src/com/reportes/ReConstancia.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(reporte,parameters,con);
            JasperViewer.viewReport(jp,false);
        } catch (JRException e) {
            Logger.getLogger(FrmDiagnositcos.class.getName()).log(Level.SEVERE, null,e);
        }
    }//GEN-LAST:event_btnConstanciaActionPerformed

    private void btnIncapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncapacidadActionPerformed
        String fec=this.jTxtFecha.getText();
        String hor=this.jTxtHora.getText();
        Connection con = null;
       JasperReport reporte;
       Map parameters = new HashMap();
       parameters.put("fecha",fec);
       parameters.put("hora",hor);
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio","root","123456");
        } catch (ClassNotFoundException| SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            reporte = JasperCompileManager.compileReport("src/com/reportes/IncapacidadRe.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(reporte,parameters,con);
            JasperViewer.viewReport(jp,false);
        } catch (JRException e) {
            Logger.getLogger(FrmDiagnositcos.class.getName()).log(Level.SEVERE, null,e);
        }
    }//GEN-LAST:event_btnIncapacidadActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
        FrmInicio frm = new FrmInicio();
        frm.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jCmbAlergiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCmbAlergiasMouseClicked
        
    }//GEN-LAST:event_jCmbAlergiasMouseClicked

    private void jCmbAlergiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbAlergiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCmbAlergiasActionPerformed

    private void jChMasEnferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChMasEnferActionPerformed
        if(jChMasEnfer.isSelected())
        {
        btnEnfer.setVisible(true);
        }
        else
        {
        btnEnfer.setVisible(false);
        }
    }//GEN-LAST:event_jChMasEnferActionPerformed

    private void jChMasAlerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChMasAlerActionPerformed
        if(jChMasAler.isSelected())
        {
        btnAlergias.setVisible(true);
        }
        else
        {
            btnAlergias.setVisible(false);
        }
    }//GEN-LAST:event_jChMasAlerActionPerformed

    private void jChMasOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChMasOpActionPerformed
        if(jChMasOp.isSelected())
        {
        btnOperacion.setVisible(true);
        }
        else
        {
        btnOperacion.setVisible(false);
        }
    }//GEN-LAST:event_jChMasOpActionPerformed

    private void btnEnferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnferActionPerformed

        

        ref.setIdExp(Integer.parseInt(this.jLabel10.getText()));
        
         String enfermedad = jCmbEnferHere.getSelectedItem().toString();
        ComboItem item = new ComboItem();

        for (int i = 0; i < jCmbEnferHere.getItemCount(); i++) {
            if (enfermedad.equals(jCmbEnferHere.getItemAt(i).toString())) {
                item = jCmbEnferHere.getModel().getElementAt(i);
            }
        }
        
        ref.setIdEnfermedad(item.getValue());
       
       daoE.insertarEfermedadesExis(ref);
       JOptionPane.showMessageDialog(null, "Enfermedad Heriditaria agregada","Confirmación",JOptionPane.INFORMATION_MESSAGE);
       jChMasEnfer.setSelected(true);
        
    }//GEN-LAST:event_btnEnferActionPerformed

    private void btnAlergiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlergiasActionPerformed
    al.setIdExp(Integer.parseInt(this.jLabel10.getText()));
         String alergia = jCmbAlergias.getSelectedItem().toString();
        ComboItem item = new ComboItem();

        for (int i = 0; i < jCmbAlergias.getItemCount(); i++) {
            if (alergia.equals(jCmbAlergias.getItemAt(i).toString())) {
                item = jCmbAlergias.getModel().getElementAt(i);
            }
        }
        
        al.setIdAlergia(item.getValue());
        daoA.insertarAlergiasExis(al);
        JOptionPane.showMessageDialog(null, "Alergia agregada","Confirmación",JOptionPane.INFORMATION_MESSAGE);
        jChMasAler.setSelected(true);
    }//GEN-LAST:event_btnAlergiasActionPerformed

    private void btnOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperacionActionPerformed
       
       op.setIdExp(Integer.parseInt(this.jLabel10.getText()));
       String operacion = jCmbOperacion.getSelectedItem().toString();
        ComboItem item = new ComboItem();

        for (int i = 0; i < jCmbOperacion.getItemCount(); i++) {
            if (operacion.equals(jCmbOperacion.getItemAt(i).toString())) {
                item = jCmbOperacion.getModel().getElementAt(i);
            }
        }
        
        op.setIdOperacion(item.getValue());
        op.setFechaOperacion(this.jTxtFechaOp.getText());
        daoO.insertarOperacionesExi(op);
        JOptionPane.showMessageDialog(null, "Operación agregada","Confirmación",JOptionPane.INFORMATION_MESSAGE);
        jChMasOp.setSelected(true);
    }//GEN-LAST:event_btnOperacionActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       if(this.jTxtDescripcion1.getText().length()==0){
    JOptionPane.showMessageDialog(null, "No hay datos ingresados","Alerta",JOptionPane.WARNING_MESSAGE);
    }else{
        Limpiar();
       }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jChOtraEnferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChOtraEnferActionPerformed
       if(jChOtraEnfer.isSelected()){
        jTxtOtraEnfermedad.setEnabled(true);
        btnAddEn.setVisible(true);
       }else
       {
       jTxtOtraEnfermedad.setEnabled(false);
        btnAddEn.setVisible(false);
       }
    }//GEN-LAST:event_jChOtraEnferActionPerformed

    private void jChOtraOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChOtraOpActionPerformed
        if(jChOtraOp.isSelected())
        {
        jTxtOtraOp.setEnabled(true);
        btnAddOp.setVisible(true);
        }else
        {
        jTxtOtraOp.setEnabled(false);
        btnAddOp.setVisible(false);
        }
    }//GEN-LAST:event_jChOtraOpActionPerformed

    private void jChOtraAlerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChOtraAlerActionPerformed
        if(jChOtraAler.isSelected())
        {
            jTxtOtraAlergia.setEnabled(true);
            btnAddAler.setVisible(true);
        }else
        {
        jTxtOtraAlergia.setEnabled(false);
        btnAddAler.setVisible(false);
        }
    }//GEN-LAST:event_jChOtraAlerActionPerformed

    private void btnNewMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewMedicamentoActionPerformed
       medi.setIdDiagnostico(daoM.getDiag());
       String medicamento = jCmbMedicamentos.getSelectedItem().toString();
        ComboItem item = new ComboItem();

        for (int i = 0; i < jCmbMedicamentos.getItemCount(); i++) {
            if (medicamento.equals(jCmbMedicamentos.getItemAt(i).toString())) {
                item = jCmbMedicamentos.getModel().getElementAt(i);
            }
        }
        
        medi.setIdMedicamento(item.getValue());
        medi.setFechaIncio(this.jTxtFecha.getText());
        daoM.insertarMedicamentosExi(medi);
        JOptionPane.showMessageDialog(null, "Medicamento agregado","Confirmación",JOptionPane.INFORMATION_MESSAGE);
        jChMasMedi.setSelected(true);
    }//GEN-LAST:event_btnNewMedicamentoActionPerformed

    private void jChMasMediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChMasMediActionPerformed
        if(jChMasMedi.isSelected())
        {
        btnNewMedicamento.setVisible(true);
        }else
        {
        btnNewMedicamento.setVisible(false);
        }
    }//GEN-LAST:event_jChMasMediActionPerformed

    private void jChOtroMediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChOtroMediActionPerformed
        if(jChOtroMedi.isSelected())
        {
            jTxtOtroMedicamento.setEnabled(true);
            btnAddMed.setVisible(true);
        }else
        {
         jTxtOtroMedicamento.setEnabled(false);
         btnAddMed.setVisible(false);
        }
    }//GEN-LAST:event_jChOtroMediActionPerformed

    private void btnNewDiagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewDiagActionPerformed
       
        String diag = jCmbDiagCorto.getSelectedItem().toString();
        ComboItem item = new ComboItem();

        for (int i = 0; i < jCmbDiagCorto.getItemCount(); i++) {
            if (diag.equals(jCmbDiagCorto.getItemAt(i).toString())) {
                item = jCmbDiagCorto.getModel().getElementAt(i);
            }
        }
        
        
        diagC.setIdDiagCorto(item.getValue());
        
       
        try {
            diagC.setIdDiagnostico(daoC.getCodigoDi());
        } catch (Exception ex) {
            Logger.getLogger(FrmDiagnositcos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       daoDg.insertarDiagCorExi(diagC);
       JOptionPane.showMessageDialog(null, "Enfermedad agregada","Confirmación",JOptionPane.INFORMATION_MESSAGE);
        jChMasDiag.setSelected(true);
    }//GEN-LAST:event_btnNewDiagActionPerformed

    private void jChMasDiagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChMasDiagActionPerformed
        if(jChMasDiag.isSelected())
        {
            btnNewDiag.setVisible(true);
        }
        else
        {
        btnNewDiag.setVisible(false);
        }
        
        
    }//GEN-LAST:event_jChMasDiagActionPerformed

    private void jChOtroDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChOtroDiActionPerformed
       if(jChOtroDi.isSelected())
       {
           jTxtOtroDiagCorto.setEnabled(true);
           btnAddDiag.setVisible(true);
       }else
       {
       jTxtOtroDiagCorto.setEnabled(false);
       btnAddDiag.setVisible(false);
       }
    }//GEN-LAST:event_jChOtroDiActionPerformed

    private void btnAddDiagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDiagActionPerformed
       if(this.jTxtOtroDiagCorto.getText().length()==0){
       JOptionPane.showMessageDialog(null, "Completa el campo","Error",JOptionPane.ERROR_MESSAGE); 
    }else{
        this.insertarDiag();
       }
    }//GEN-LAST:event_btnAddDiagActionPerformed

    private void btnAddEnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEnActionPerformed
    if(this.jTxtOtraEnfermedad.getText().length()==0){
       JOptionPane.showMessageDialog(null, "Completa el campo","Error",JOptionPane.ERROR_MESSAGE); 
    }else{
        this.insertarEnfer();
    }
    }//GEN-LAST:event_btnAddEnActionPerformed

    private void btnAddAlerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAlerActionPerformed
      if(this.jTxtOtraAlergia.getText().length()==0){
       JOptionPane.showMessageDialog(null, "Completa el campo","Error",JOptionPane.ERROR_MESSAGE); 
    }else{
        this.insertarAlergia();
      }
    }//GEN-LAST:event_btnAddAlerActionPerformed

    private void btnAddOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOpActionPerformed
        if(this.jTxtOtraOp.getText().length()==0){
       JOptionPane.showMessageDialog(null, "Completa el campo","Error",JOptionPane.ERROR_MESSAGE); 
    }else{
        this.insertarOp();
        }
    }//GEN-LAST:event_btnAddOpActionPerformed

    private void btnAddMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMedActionPerformed
        if(this.jTxtOtroMedicamento.getText().length()==0){
       JOptionPane.showMessageDialog(null, "Completa el campo","Error",JOptionPane.ERROR_MESSAGE); 
    }else{
        this.insertarM();
        }
    }//GEN-LAST:event_btnAddMedActionPerformed
    
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
            java.util.logging.Logger.getLogger(FrmDiagnositcos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDiagnositcos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDiagnositcos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDiagnositcos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDiagnositcos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAler;
    private javax.swing.JButton btnAddDiag;
    private javax.swing.JButton btnAddEn;
    private javax.swing.JButton btnAddMed;
    private javax.swing.JButton btnAddOp;
    private javax.swing.JButton btnAlergias;
    private javax.swing.JButton btnAnteriores;
    private javax.swing.JButton btnConstancia;
    private javax.swing.JButton btnEnfer;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIncapacidad;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNewDiag;
    private javax.swing.JButton btnNewMedicamento;
    private javax.swing.JButton btnOperacion;
    private javax.swing.JButton btnReceta;
    private javax.swing.JButton btnReferencias;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox jChMasAler;
    private javax.swing.JCheckBox jChMasDiag;
    private javax.swing.JCheckBox jChMasEnfer;
    private javax.swing.JCheckBox jChMasMedi;
    private javax.swing.JCheckBox jChMasOp;
    private javax.swing.JCheckBox jChOtraAler;
    private javax.swing.JCheckBox jChOtraEnfer;
    private javax.swing.JCheckBox jChOtraOp;
    private javax.swing.JCheckBox jChOtroDi;
    private javax.swing.JCheckBox jChOtroMedi;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JComboBox<ComboItem> jCmbAlergias;
    private javax.swing.JComboBox<ComboItem> jCmbDiagCorto;
    private javax.swing.JComboBox<ComboItem> jCmbEnferHere;
    private javax.swing.JComboBox<ComboItem> jCmbMedicamentos;
    private javax.swing.JComboBox<ComboItem> jCmbOperacion;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JFormattedTextField jTxtAltura;
    private javax.swing.JTextField jTxtDescripcion1;
    private javax.swing.JTextField jTxtFecha;
    private javax.swing.JFormattedTextField jTxtFechaOp;
    private javax.swing.JTextField jTxtHora;
    private javax.swing.JTextField jTxtOtraAlergia;
    private javax.swing.JTextField jTxtOtraEnfermedad;
    private javax.swing.JTextField jTxtOtraOp;
    private javax.swing.JTextField jTxtOtroDiagCorto;
    private javax.swing.JTextField jTxtOtroMedicamento;
    private javax.swing.JFormattedTextField jTxtPeso;
    private javax.swing.JFormattedTextField jTxtPresion;
    // End of variables declaration//GEN-END:variables
}
