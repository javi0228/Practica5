/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

/**
 *
 * @author Rubén Martín
 */
public class PanelListar extends javax.swing.JPanel {

    Connection conexion;
    Statement stmt;
    ResultSet rset=null;
    
    public PanelListar()  {
        
        initComponents();
        
        nombreField.setEditable(false);
        numeroField.setEditable(false);
        sueldoField.setEditable(false);
        sueldoMaxField.setEditable(false);
        fechaAltaField.setEditable(false);
        apellidoField.setEditable(false);
        
    }
    
    private void setMensajeError(String mensaje){
        JOptionPane.showMessageDialog(this,mensaje,"Consulta fallida",JOptionPane.ERROR_MESSAGE);
    }
    
    
    public boolean conectar(String consulta){
        
        try{
            this.stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            this.rset=stmt.executeQuery(consulta);
        
            if(rset.next()){
                rset.beforeFirst();
                return true;
            }
            return false;
        } catch (SQLException e){
            setMensajeError("Ha ocurrido un error al realizar la consulta");
            return false;
        }  
    }
    
    
    
    
    public void inicializarCampos() {
        
        String rutaFoto="C:\\Users\\Javir\\OneDrive\\Escritorio\\DAM\\2ºDAM\\PMDM\\Practica5Git\\"
                + "Practica5\\Practica5\\Fotos\\";
        
        try {
            rset.next();
         
            numeroField.setText(""+rset.getInt(1));
            nombreField.setText(""+rset.getString(2));
            apellidoField.setText(""+rset.getString(3));
            System.out.println(rutaFoto+rset.getString(4));
            
            ImageIcon imgIcon=new ImageIcon(rutaFoto+rset.getString(4));
            Icon icono=new ImageIcon(imgIcon.getImage().getScaledInstance(fotoLabel.getWidth(), fotoLabel.getHeight(), Image.SCALE_DEFAULT));
            fotoLabel.setIcon(icono);
            
            sueldoField.setText(""+rset.getFloat(5));
            sueldoMaxField.setText(""+rset.getFloat(6));
            fechaAltaField.setText(""+rset.getString(7));
        }catch (SQLException ex) {
            setMensajeError("Ha ocurrido un error al realizar la consulta");
        }
        
        btAnterior.setEnabled(false);
    }
    
    public void apagarBotones()  {

        try {
            if (rset.isLast()) {
                btSiguiente.setEnabled(false);
                
            } else {
                btSiguiente.setEnabled(true);
            }
            
        } catch (SQLException ex) {
            setMensajeError("Ha ocurrido un error al realizar la consulta");
        }
        
        btAnterior.setEnabled(false);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        numeroLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        apellidoLabel = new javax.swing.JLabel();
        sueldoLabel = new javax.swing.JLabel();
        sueldoMaxLabel = new javax.swing.JLabel();
        fechaAltaLabel = new javax.swing.JLabel();
        numeroField = new javax.swing.JTextField();
        nombreField = new javax.swing.JTextField();
        apellidoField = new javax.swing.JTextField();
        sueldoField = new javax.swing.JTextField();
        sueldoMaxField = new javax.swing.JTextField();
        fechaAltaField = new javax.swing.JTextField();
        btSiguiente = new javax.swing.JButton();
        btAnterior = new javax.swing.JButton();
        fotoLabel = new javax.swing.JLabel();

        numeroLabel.setText("Número:");

        nombreLabel.setText("Nombre:");

        apellidoLabel.setText("Apellido:");

        sueldoLabel.setText("Sueldo:");

        sueldoMaxLabel.setText(" Sueldo Máximo:");

        fechaAltaLabel.setText("Fecha de Alta:");

        btSiguiente.setText("Siguiente");
        btSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSiguienteActionPerformed(evt);
            }
        });

        btAnterior.setText("Anterior");
        btAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btAnterior)
                .addGap(428, 428, 428)
                .addComponent(btSiguiente)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaAltaLabel)
                    .addComponent(sueldoMaxLabel)
                    .addComponent(sueldoLabel)
                    .addComponent(apellidoLabel)
                    .addComponent(nombreLabel)
                    .addComponent(numeroLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fechaAltaField)
                    .addComponent(sueldoMaxField)
                    .addComponent(sueldoField)
                    .addComponent(apellidoField)
                    .addComponent(nombreField)
                    .addComponent(numeroField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(fotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(fotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroLabel)
                    .addComponent(numeroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoLabel)
                    .addComponent(apellidoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sueldoLabel)
                    .addComponent(sueldoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sueldoMaxLabel)
                    .addComponent(sueldoMaxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaAltaLabel)
                    .addComponent(fechaAltaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSiguiente)
                    .addComponent(btAnterior))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSiguienteActionPerformed
        
        try {
            rset.next();
            if(rset.isLast()){
                btSiguiente.setEnabled(false);
            } 
            btAnterior.setEnabled(true);
            
            String rutaFoto="C:\\Users\\Javir\\OneDrive\\Escritorio\\DAM\\2ºDAM\\PMDM\\Practica5Git\\"
                + "Practica5\\Practica5\\Fotos\\";
            
            
            numeroField.setText(""+rset.getInt(1));
            nombreField.setText(""+rset.getString(2));
            apellidoField.setText(""+rset.getString(3));
            
            ImageIcon imgIcon=new ImageIcon(rutaFoto+rset.getString(4));
            Icon icono=new ImageIcon(imgIcon.getImage().getScaledInstance(fotoLabel.getWidth(), fotoLabel.getHeight(), Image.SCALE_DEFAULT));
            fotoLabel.setIcon(icono);
            
            sueldoField.setText(""+rset.getFloat(5));
            sueldoMaxField.setText(""+rset.getFloat(6));
            fechaAltaField.setText(""+rset.getString(7));
            
            
            
        } catch (SQLException ex) {
            setMensajeError("Ha ocurrido un error al realizar la consulta");
        }
    }//GEN-LAST:event_btSiguienteActionPerformed

    private void btAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnteriorActionPerformed
        
        try {
            rset.previous();
            if(rset.isFirst()){
                btAnterior.setEnabled(false);
            } 
            btSiguiente.setEnabled(true);
            
            String rutaFoto="C:\\Users\\Javir\\OneDrive\\Escritorio\\DAM\\2ºDAM\\PMDM\\Practica5Git\\"
                + "Practica5\\Practica5\\Fotos\\";
            
            numeroField.setText(""+rset.getInt(1));
            nombreField.setText(""+rset.getString(2));
            apellidoField.setText(""+rset.getString(3));
            
            ImageIcon imgIcon=new ImageIcon(rutaFoto+rset.getString(4));
            Icon icono=new ImageIcon(imgIcon.getImage().getScaledInstance(fotoLabel.getWidth(), fotoLabel.getHeight(), Image.SCALE_DEFAULT));
            fotoLabel.setIcon(icono);
            
            sueldoField.setText(""+rset.getFloat(5));
            sueldoMaxField.setText(""+rset.getFloat(6));
            fechaAltaField.setText(""+rset.getString(7));
            
            
            
        } catch (SQLException ex) {
            setMensajeError("Ha ocurrido un error al realizar la consulta");
        }
    }//GEN-LAST:event_btAnteriorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoField;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JButton btAnterior;
    private javax.swing.JButton btSiguiente;
    private javax.swing.JTextField fechaAltaField;
    private javax.swing.JLabel fechaAltaLabel;
    private javax.swing.JLabel fotoLabel;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField numeroField;
    private javax.swing.JLabel numeroLabel;
    private javax.swing.JTextField sueldoField;
    private javax.swing.JLabel sueldoLabel;
    private javax.swing.JTextField sueldoMaxField;
    private javax.swing.JLabel sueldoMaxLabel;
    // End of variables declaration//GEN-END:variables
}
