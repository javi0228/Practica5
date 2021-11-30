/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.*;
import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Javir
 */
public class PanelListarTodos extends javax.swing.JPanel {

    Connection conexion;
    ArrayList empleados=new ArrayList();
    DefaultListModel lista= new DefaultListModel();
    
    /**
     * Creates new form PanelListarTodos1
     */
    public PanelListarTodos() {
        initComponents();
        jList.setModel(lista);
        
    }
    
    public void rellenarArray() throws SQLException{
        
        empleados.clear();
        
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM empleado");
        ResultSetMetaData rsmd = rs.getMetaData();
        
        
        int numCols = rsmd.getColumnCount();
        
        
        //Voy guardando los datos de las columnas en variables
        //que serán los parámetros para el constructor del futuro empleado
        
        int numero;
        String nombre;
        String apellido;
        String foto;
        float sueldo;
        float sueldoMaximo;
        String[] datosfecha=new String[2]; //array de string para almacenar el dia, mes y año 
                                           // mediante split

        while (rs.next()){
            
            numero=(Integer.parseInt(rs.getString(1)));
            nombre=rs.getString(2);
            apellido=rs.getString(3);
            foto=rs.getString(4);
            sueldo=(Float.parseFloat(rs.getString(5)));
            sueldoMaximo=(Float.parseFloat(rs.getString(6)));
            datosfecha=rs.getString(7).split("-");//[0]=año,[1]=mes,[2]=dia
            
            Empleado emp=new Empleado(numero, nombre, apellido, foto, sueldo, sueldoMaximo,
                    Integer.parseInt(datosfecha[0]), Integer.parseInt(datosfecha[1]), Integer.parseInt(datosfecha[2]));
            
            empleados.add(emp);
            
            System.out.println("");
        }
       
    }
    
    
    public void vaciarLista(){
       lista.removeAllElements();
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        btMostrar = new javax.swing.JButton();

        jList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList);

        btMostrar.setText("Mostrar empleados");
        btMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(btMostrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btMostrar)
                .addContainerGap(67, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostrarActionPerformed
        lista.removeAllElements();
        
        for (int i = 0; i < empleados.size(); i++) {
            
            lista.addElement(empleados.get(i));
            
        }
        
    }//GEN-LAST:event_btMostrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMostrar;
    private javax.swing.JList<String> jList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
