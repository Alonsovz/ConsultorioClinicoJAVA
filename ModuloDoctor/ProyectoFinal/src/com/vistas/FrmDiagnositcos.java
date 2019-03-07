/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas;

import com.conexion.Conexion;
import com.dao.DaoAlergias;
import com.dao.DaoCitas;
import com.dao.DaoEnfermedades;
import com.dao.DaoMedicamentos;
import com.dao.DaoOperaciones;
import com.modelo.Alergias;
import com.modelo.CitasPendientes;
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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Fabio
 */
public class FrmDiagnositcos extends javax.swing.JFrame {

    DaoCitas daoC = new DaoCitas();
    Historial his = new Historial();
    
    Enfermedades ref = new Enfermedades();
    Alergias al = new Alergias();
    Operaciones op = new Operaciones();
    Referencias refe = new Referencias();
    Medicamentos medi = new Medicamentos();
    
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
            jLabel14.setVisible(false);
            jCmbEnferHere.setVisible(false);
            
            jLabel12.setVisible(false);
            
            jTxtDiagCorto.setEnabled(false);
            jLabel16.setVisible(false);
            jCmbOperacion.setVisible(false);
            
            jTxtMedicamentos.setEnabled(false);
            jCmbAlergias.setVisible(false);
            
            jLabel10.setVisible(false);
            jLabel17.setVisible(false);
            jLabel18.setVisible(false);
            jLabel9.setVisible(false);
            jLabel20.setVisible(false);
            jTxtFechaOp.setVisible(false);
            jTxtFecha.setVisible(false);
            jTxtHora.setVisible(false);
            btnAlergias.setVisible(false);
            btnEnfer.setVisible(false);
            btnOperacion.setVisible(false);
            btnMedica.setVisible(false);
            jCheckBox7.setVisible(false);
            jCheckBox8.setVisible(false);
            jCheckBox9.setVisible(false);
           
            
            jScrollPane1.setVisible(false);
            
           cargarCombo(jCmbMedicamentos, (ArrayList<Medicamentos>) daoM.mostrarMedicamentos());
           cargarCombo1(jCmbEnferHere, (ArrayList<Enfermedades>) daoE.mostrarEnfermedad());
           cargarCombo2(jCmbAlergias, (ArrayList<Alergias>) daoA.mostrarAlergia());
           cargarCombo3(jCmbDiagCorto, (ArrayList<Historial>) daoC.mostrarDiag());
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
    
     private void cargarCombo3(JComboBox combo, ArrayList<Historial> List) throws Exception
    {
        for(Historial item: List){
        combo.addItem(new ComboItem(item.getIdDiagnostico(), item.getDiagCorto()));
        
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
            his.setPresion(this.jtxtPresion.getText());
            his.setAltura(this.jTxtAltura.getText());
            his.setPeso(this.jTxtPeso.getText());
            his.setDiagCorto(this.jTxtDiagCorto.getText());
            his.setFecha(this.jTxtFecha.getText());
            his.setHora(this.jTxtHora.getText());
            daoC.insertarDiagnostico(his);
            
            
            medi.setIdDiagnostico(daoM.getDiag());
            
            if(jRbnMedi.isSelected()){
            medi.setMedicamento(this.jTxtMedicamentos.getText());
            }
            else
            {
                
                jTxtMedicamentos.setText("");
                if(jCmbMedicamentos.getSelectedItem()!=null)
            {
            jTxtMedicamentos.setText("");
            
            String medica = jCmbMedicamentos.getSelectedItem().toString();
            
            ComboItem item = new ComboItem();
            for(int i=0;i< jCmbMedicamentos.getItemCount();i++)
            {
                if(medica.equals(jCmbMedicamentos.getItemAt(i).toString()))
                {    
                    item = (ComboItem) jCmbMedicamentos.getSelectedItem();
                }
            }
                medi.setIdMedicamento(item.getValue());
            }
            medi.setMedicamento(this.jCmbMedicamentos.getSelectedItem().toString());
            }
             
            
            
            
            
            
            al.setIdExp(Integer.parseInt(this.jLabel10.getText()));
            al.setAlergia(this.jCmbAlergias.getSelectedItem().toString());
            op.setIdExp(Integer.parseInt(this.jLabel10.getText()));
            op.setOperacion(this.jCmbOperacion.getSelectedItem().toString());
            op.setFechaOperacion("2019-01-12");
            refe.setIdExp(Integer.parseInt(this.jLabel10.getText()));
            refe.setReferencia("Dr. "+nom+" "+ape+"");
            ref.setIdExp(Integer.parseInt(this.jLabel10.getText()));
            ref.setEnfermedadesHere(this.jCmbEnferHere.getSelectedItem().toString());
            daoM.insertarMedicamentos(medi);
            daoE.insertarEfermedades(ref);
            daoO.insertarOperaciones(op);
            daoO.insertarReferencias(refe);
            daoA.insertarAlergias(al);
           resultado=1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar datos","Error", JOptionPane.ERROR_MESSAGE);
        }
    return resultado;
    }
    
    
   
    
  
    public void Limpiar()
    {
        this.jTxtDescripcion1.setText("");
        this.jtxtPresion.setText("");
        this.jtxtPresion.setText("");
        this.jTxtPeso.setText("");
        this.jTxtFechaOp.setText("");
        this.jTxtMedicamentos.setText("");
        this.jTxtDiagCorto.setText("");
        this.jTxtAltura.setText("");
        this.jTxtIdDiag.setText("");
        ocultarchex();
        this.jCheckBox3.setSelected(false);
        this.jCheckBox1.setSelected(false);
        this.jCheckBox5.setSelected(false);
        
        this.jCheckBox7.setSelected(false);
        this.jCheckBox9.setSelected(false);
        this.jCheckBox10.setSelected(false);
    }
    
public void ocultarchex()
{
    if(jCheckBox3.isSelected()){
        jCmbEnferHere.setVisible(false);
        
        jLabel14.setVisible(false);
        
        jCheckBox8.setVisible(false);
        btnEnfer.setVisible(false);
    } 
   
    
     if(jCheckBox1.isSelected())
    {
        jLabel12.setVisible(false);
        jCmbAlergias.setVisible(false); 
        jCheckBox7.setVisible(false);
        jLabel20.setVisible(false);
        jTxtFechaOp.setVisible(false);
        btnAlergias.setVisible(false);
    }
    
    if(jCheckBox5.isSelected())
    {
        jCheckBox6.setSelected(false);
        jLabel16.setVisible(false);
        jCmbOperacion.setVisible(false);

        jCheckBox9.setVisible(false);
        jLabel18.setVisible(false);  
        jLabel20.setVisible(false);
        jTxtFechaOp.setVisible(false);
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
        jtxtPresion = new javax.swing.JTextField();
        jTxtAltura = new javax.swing.JTextField();
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
        jRbnDiag = new javax.swing.JRadioButton();
        jTxtDiagCorto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jCmbOperacion = new javax.swing.JComboBox<>();
        jCmbMedicamentos = new javax.swing.JComboBox<>();
        jRbnMedi = new javax.swing.JRadioButton();
        jTxtMedicamentos = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnReceta = new javax.swing.JButton();
        btnConstancia = new javax.swing.JButton();
        btnIncapacidad = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnReferencias = new javax.swing.JButton();
        jTxtPeso = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxtDescripcion1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jCmbAlergias = new javax.swing.JComboBox<>();
        btnEnfer = new javax.swing.JButton();
        btnAlergias = new javax.swing.JButton();
        btnOperacion = new javax.swing.JButton();
        btnMedica = new javax.swing.JButton();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTxtIdDiag = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTxtFechaOp = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        btnReferencias1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1059, 830));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 100, 150, 20);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Paciente:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 100, 70, 23);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Descripicion del paciente:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(540, 100, 151, 17);

        btnAnteriores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAnteriores.setText("Ver consultas anteriores");
        btnAnteriores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnterioresActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnteriores);
        btnAnteriores.setBounds(40, 120, 181, 40);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Presión:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(790, 100, 50, 17);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Altura:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(920, 100, 50, 17);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Medicamentos:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(200, 460, 92, 17);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Diagnostico (Enfermedad):");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(520, 450, 190, 50);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(340, 30, 90, 17);

        jtxtPresion.setForeground(new java.awt.Color(0, 153, 153));
        getContentPane().add(jtxtPresion);
        jtxtPresion.setBounds(760, 120, 116, 30);
        getContentPane().add(jTxtAltura);
        jTxtAltura.setBounds(890, 120, 116, 30);

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
        jCheckBox1.setBounds(510, 240, 35, 25);

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel11.setText("Alergias:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(420, 240, 50, 17);

        jCheckBox2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jCheckBox2.setText("No");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox2);
        jCheckBox2.setBounds(550, 240, 41, 25);

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setText("Alérgico a:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(420, 270, 80, 17);

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel13.setText("Enfermedades Hereditarias:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(50, 240, 164, 17);

        jCheckBox3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jCheckBox3.setText("Si");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox3);
        jCheckBox3.setBounds(230, 240, 35, 25);

        jCheckBox4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jCheckBox4.setText("No");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox4);
        jCheckBox4.setBounds(270, 240, 41, 25);

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel14.setText("Nombre de la enfermedad:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(50, 280, 160, 17);

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
        jCmbEnferHere.setBounds(230, 270, 140, 30);

        jCmbDiagCorto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCmbDiagCortoMouseClicked(evt);
            }
        });
        getContentPane().add(jCmbDiagCorto);
        jCmbDiagCorto.setBounds(680, 460, 130, 30);

        jRbnDiag.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jRbnDiag.setText("Otro");
        jRbnDiag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbnDiagActionPerformed(evt);
            }
        });
        getContentPane().add(jRbnDiag);
        jRbnDiag.setBounds(590, 500, 60, 25);
        getContentPane().add(jTxtDiagCorto);
        jTxtDiagCorto.setBounds(670, 500, 140, 30);

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel15.setText("Operación");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(790, 240, 70, 17);

        jCheckBox5.setText("Si");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox5);
        jCheckBox5.setBounds(870, 240, 33, 23);

        jCheckBox6.setText("No");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox6);
        jCheckBox6.setBounds(910, 240, 39, 23);

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel16.setText("Nombre de la operación:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(710, 270, 150, 17);

        jCmbOperacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCmbOperacionMouseClicked(evt);
            }
        });
        getContentPane().add(jCmbOperacion);
        jCmbOperacion.setBounds(870, 270, 160, 30);

        jCmbMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCmbMedicamentosMouseClicked(evt);
            }
        });
        getContentPane().add(jCmbMedicamentos);
        jCmbMedicamentos.setBounds(330, 460, 170, 30);

        jRbnMedi.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jRbnMedi.setText("Otro");
        jRbnMedi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRbnMediMouseClicked(evt);
            }
        });
        jRbnMedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbnMediActionPerformed(evt);
            }
        });
        getContentPane().add(jRbnMedi);
        jRbnMedi.setBounds(200, 500, 60, 25);
        getContentPane().add(jTxtMedicamentos);
        jTxtMedicamentos.setBounds(310, 500, 190, 30);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(30, 600, 110, 40);

        btnReceta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/limpiar.png"))); // NOI18N
        btnReceta.setText("Generar Receta");
        btnReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecetaActionPerformed(evt);
            }
        });
        getContentPane().add(btnReceta);
        btnReceta.setBounds(190, 600, 170, 40);

        btnConstancia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConstancia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/limpiar.png"))); // NOI18N
        btnConstancia.setText("Generar Constancia");
        btnConstancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConstanciaActionPerformed(evt);
            }
        });
        getContentPane().add(btnConstancia);
        btnConstancia.setBounds(660, 600, 200, 40);

        btnIncapacidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIncapacidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/modificar.png"))); // NOI18N
        btnIncapacidad.setText("Generar Incapacidad");
        btnIncapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncapacidadActionPerformed(evt);
            }
        });
        getContentPane().add(btnIncapacidad);
        btnIncapacidad.setBounds(410, 600, 220, 40);

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(900, 600, 110, 40);

        btnReferencias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReferencias.setText("Datos Médicos");
        btnReferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReferenciasActionPerformed(evt);
            }
        });
        getContentPane().add(btnReferencias);
        btnReferencias.setBounds(230, 120, 140, 40);

        jTxtPeso.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        getContentPane().add(jTxtPeso);
        jTxtPeso.setBounds(830, 160, 116, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Peso:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(780, 170, 40, 15);
        getContentPane().add(jTxtDescripcion1);
        jTxtDescripcion1.setBounds(500, 130, 244, 57);

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
        jCmbAlergias.setBounds(510, 270, 160, 30);

        btnEnfer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEnfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnEnfer.setText("Agregar otra");
        getContentPane().add(btnEnfer);
        btnEnfer.setBounds(240, 370, 125, 40);

        btnAlergias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlergias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnAlergias.setText("Agregar otra");
        getContentPane().add(btnAlergias);
        btnAlergias.setBounds(510, 380, 130, 40);

        btnOperacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnOperacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnOperacion.setText("Agregar otra");
        getContentPane().add(btnOperacion);
        btnOperacion.setBounds(880, 400, 140, 40);

        btnMedica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMedica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/insertar.png"))); // NOI18N
        btnMedica.setText("Agregar otro");
        getContentPane().add(btnMedica);
        btnMedica.setBounds(370, 540, 130, 40);

        jCheckBox7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jCheckBox7.setText("Mas de una alergia");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox7);
        jCheckBox7.setBounds(510, 350, 133, 25);

        jCheckBox8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jCheckBox8.setText("Mas de una enfermedad");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox8);
        jCheckBox8.setBounds(70, 380, 170, 25);

        jCheckBox9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jCheckBox9.setText("Mas de una Operación");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox9);
        jCheckBox9.setBounds(710, 410, 160, 25);

        jCheckBox10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jCheckBox10.setText("Mas de un medicamento");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox10);
        jCheckBox10.setBounds(200, 550, 170, 25);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jTable1.setForeground(new java.awt.Color(0, 102, 102));
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 650, 1020, 100);

        jTxtIdDiag.setForeground(new java.awt.Color(0, 102, 102));
        jTxtIdDiag.setCaretColor(new java.awt.Color(0, 102, 102));
        getContentPane().add(jTxtIdDiag);
        jTxtIdDiag.setBounds(220, 30, 40, 20);

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

        jPanel3.setBackground(new java.awt.Color(218, 240, 240));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        getContentPane().add(jPanel3);
        jPanel3.setBounds(480, 80, 550, 120);

        jPanel2.setBackground(new java.awt.Color(221, 242, 242));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 210, 1030, 380);

        jPanel1.setBackground(new java.awt.Color(218, 240, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 80, 360, 110);

        jButton1.setText("Limpiar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(400, 160, 73, 23);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/background.jpg"))); // NOI18N
        jLabel21.setPreferredSize(new java.awt.Dimension(1570, 885));
        getContentPane().add(jLabel21);
        jLabel21.setBounds(0, 0, 1060, 880);

        btnReferencias1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReferencias1.setText("Datos Médicos");
        btnReferencias1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReferencias1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnReferencias1);
        btnReferencias1.setBounds(230, 120, 140, 40);

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
        jCmbEnferHere.setVisible(true);
        
        jLabel14.setVisible(true);
        
       jCheckBox8.setVisible(true);
    }
    else
    {
        jCmbEnferHere.setVisible(false);
        
        jLabel14.setVisible(false);
        
        jCheckBox8.setVisible(false);
        btnEnfer.setVisible(false);
    }
    
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        jCheckBox3.setSelected(false);
        jCmbEnferHere.setVisible(false);
        
        jLabel14.setVisible(false);
        
        btnEnfer.setVisible(false);
        jCheckBox8.setVisible(false);
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCmbEnferHereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbEnferHereActionPerformed
        
    }//GEN-LAST:event_jCmbEnferHereActionPerformed

    private void jCmbEnferHereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCmbEnferHereMouseClicked
        
    }//GEN-LAST:event_jCmbEnferHereMouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected())
        {
            jCheckBox2.setSelected(false);
          jLabel12.setVisible(true);
          
          jCmbAlergias.setVisible(true);
          
          jCheckBox7.setVisible(true);
        }else
        {
        jLabel12.setVisible(false);
          
        jCmbAlergias.setVisible(false);
          
          jCheckBox7.setVisible(false);
          jLabel20.setVisible(false);
            jTxtFechaOp.setVisible(false);
            btnAlergias.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
          jLabel12.setVisible(false);
          
          jCheckBox1.setSelected(false);
          jCmbAlergias.setVisible(false);
          
          btnAlergias.setVisible(false);
          jCheckBox7.setVisible(false);
          jLabel20.setVisible(false);
            jTxtFechaOp.setVisible(false);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCmbDiagCortoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCmbDiagCortoMouseClicked
        jRbnDiag.setSelected(false);
        jTxtDiagCorto.setEnabled(false);
    }//GEN-LAST:event_jCmbDiagCortoMouseClicked

    private void jRbnDiagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbnDiagActionPerformed
        if(jRbnDiag.isSelected())
        {
            jTxtDiagCorto.setEnabled(true);
            jCmbDiagCorto.setEnabled(false);
        }
        else
        {
        jTxtDiagCorto.setEnabled(false);
         jCmbDiagCorto.setEnabled(true);
        }
    }//GEN-LAST:event_jRbnDiagActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        if(jCheckBox5.isSelected())
        {
            jCheckBox6.setSelected(false);
            jLabel16.setVisible(true);
            jCmbOperacion.setVisible(true);
            
            jCheckBox9.setVisible(true);
            jLabel18.setVisible(true);        
            jLabel20.setVisible(true);
            jTxtFechaOp.setVisible(true);
        }
        else
        {
        jCheckBox6.setSelected(false);
            jLabel16.setVisible(false);
            jCmbOperacion.setVisible(false);
            
            jCheckBox9.setVisible(false);
            jLabel18.setVisible(false);  
            jLabel20.setVisible(false);
            jTxtFechaOp.setVisible(false);
            btnOperacion.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        jCheckBox5.setSelected(false);
            jLabel16.setVisible(false);
            jCmbOperacion.setVisible(false);
            
            btnOperacion.setVisible(false);
            jLabel18.setVisible(false);   
            jCheckBox9.setVisible(false);
            jLabel20.setVisible(false);
            jTxtFechaOp.setVisible(false);
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCmbOperacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCmbOperacionMouseClicked
        
    }//GEN-LAST:event_jCmbOperacionMouseClicked

    private void jRbnMediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbnMediActionPerformed
        if(jRbnMedi.isSelected())
        {
            jTxtMedicamentos.setEnabled(true);
            jCmbMedicamentos.setEnabled(false);
        }
        else
        {
            jTxtMedicamentos.setEnabled(false);
            jCmbMedicamentos.setEnabled(true);
        }
    }//GEN-LAST:event_jRbnMediActionPerformed

    private void jCmbMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCmbMedicamentosMouseClicked
        jTxtMedicamentos.setEnabled(false);
        jRbnMedi.setSelected(false);
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
        
        if( insertarDiagnosticos()==1){
            
            actualizar();
        JOptionPane.showMessageDialog(null, "Datos guardados con éxito","Confirmación",JOptionPane.INFORMATION_MESSAGE);
            
        }
        else
        {
        JOptionPane.showMessageDialog(null, "Error al ingresar","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecetaActionPerformed
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
            reporte = JasperCompileManager.compileReport("src/com/reportes/reporteReceta.jrxml");
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
       parameters.put("fec",fec);
       parameters.put("hor",hor);
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio","root","123456");
        } catch (ClassNotFoundException| SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            reporte = JasperCompileManager.compileReport("src/com/reportes/reporteConstancia.jrxml");
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
       parameters.put("fec",fec);
       parameters.put("hor",hor);
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio","root","123456");
        } catch (ClassNotFoundException| SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            reporte = JasperCompileManager.compileReport("src/com/reportes/reporteIncapacidad.jrxml");
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

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        if(jCheckBox8.isSelected())
        {
        btnEnfer.setVisible(true);
        }
        else
        {
        btnEnfer.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        if(jCheckBox7.isSelected())
        {
        btnAlergias.setVisible(true);
        }
        else
        {
            btnAlergias.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        if(jCheckBox9.isSelected())
        {
        btnOperacion.setVisible(true);
        }
        else
        {
        btnOperacion.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
        if(jCheckBox10.isSelected())
        {
        btnMedica.setVisible(true);
        }
        else
        {
        btnMedica.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBox10ActionPerformed
    
    private void jRbnMediMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRbnMediMouseClicked
        if(jRbnMedi.isSelected()){
            medi.setMedicamento(this.jTxtMedicamentos.getText());
            }
            else
            {
                
                jTxtMedicamentos.setText("");
            }
    }//GEN-LAST:event_jRbnMediMouseClicked

    private void btnReferencias1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReferencias1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReferencias1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       Limpiar();
    }//GEN-LAST:event_jButton1MouseClicked

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
    private javax.swing.JButton btnAlergias;
    private javax.swing.JButton btnAnteriores;
    private javax.swing.JButton btnConstancia;
    private javax.swing.JButton btnEnfer;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIncapacidad;
    private javax.swing.JButton btnMedica;
    private javax.swing.JButton btnOperacion;
    private javax.swing.JButton btnReceta;
    private javax.swing.JButton btnReferencias;
    private javax.swing.JButton btnReferencias1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jCmbAlergias;
    private javax.swing.JComboBox<ComboItem> jCmbDiagCorto;
    private javax.swing.JComboBox<String> jCmbEnferHere;
    private javax.swing.JComboBox<String> jCmbMedicamentos;
    private javax.swing.JComboBox<String> jCmbOperacion;
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
    private javax.swing.JRadioButton jRbnDiag;
    private javax.swing.JRadioButton jRbnMedi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtAltura;
    private javax.swing.JTextField jTxtDescripcion1;
    private javax.swing.JTextField jTxtDiagCorto;
    private javax.swing.JTextField jTxtFecha;
    private javax.swing.JFormattedTextField jTxtFechaOp;
    private javax.swing.JTextField jTxtHora;
    private javax.swing.JTextField jTxtIdDiag;
    private javax.swing.JTextField jTxtMedicamentos;
    private javax.swing.JTextField jTxtPeso;
    private javax.swing.JTextField jtxtPresion;
    // End of variables declaration//GEN-END:variables
}
