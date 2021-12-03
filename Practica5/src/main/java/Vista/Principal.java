
package Vista;


import java.sql.*;
import javax.swing.JOptionPane;



public class Principal extends javax.swing.JFrame {
    
    static private Connection conexion;
    static private boolean conectado=false;
    
    public Principal(){
        initComponents();
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPractica = new javax.swing.JLabel();
        BarraMenu = new javax.swing.JMenuBar();
        MenuConectarDesconectar = new javax.swing.JMenu();
        ConectarItem = new javax.swing.JMenuItem();
        DesconectarItem = new javax.swing.JMenuItem();
        Listar = new javax.swing.JMenu();
        Listar1 = new javax.swing.JMenuItem();
        ListarTodos = new javax.swing.JMenuItem();
        Ayuda = new javax.swing.JMenu();
        AcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Principal"); // NOI18N

        labelPractica.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        labelPractica.setText("PRÁCTICA 5");

        MenuConectarDesconectar.setText("Conectar/Desconectar");

        ConectarItem.setText("Conectar BD");
        ConectarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConectarItemActionPerformed(evt);
            }
        });
        MenuConectarDesconectar.add(ConectarItem);

        DesconectarItem.setText("Desconectar BD");
        DesconectarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesconectarItemActionPerformed(evt);
            }
        });
        MenuConectarDesconectar.add(DesconectarItem);

        BarraMenu.add(MenuConectarDesconectar);

        Listar.setLabel("Listar");
        Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarActionPerformed(evt);
            }
        });

        Listar1.setText("Ver todos los empleados 1 a 1");
        Listar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Listar1ActionPerformed(evt);
            }
        });
        Listar.add(Listar1);

        ListarTodos.setText("Ver lista de empleados");
        ListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarTodosActionPerformed(evt);
            }
        });
        Listar.add(ListarTodos);

        BarraMenu.add(Listar);

        Ayuda.setLabel("Ayuda");

        AcercaDe.setText("Acerca de...");
        AcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcercaDeActionPerformed(evt);
            }
        });
        Ayuda.add(AcercaDe);

        BarraMenu.add(Ayuda);

        setJMenuBar(BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(labelPractica)
                .addContainerGap(262, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(labelPractica)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcercaDeActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_AcercaDeActionPerformed

    private void ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarActionPerformed
         
        
    }//GEN-LAST:event_ListarActionPerformed

    private void Listar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Listar1ActionPerformed
        
        if(conectado){
        
            this.setContentPane(panelListar);

            panelListar.conexion=conexion;
            panelListar.conectar("SELECT * FROM empleado");
            panelListar.inicializarCampos();
            panelListar.apagarBotones();

            pack();
        }else
            setMensajeError("Debe conectarse a la base de datos.");
    }//GEN-LAST:event_Listar1ActionPerformed

    public static void setConexion(Connection con){
        Principal.conexion=con;
        conectado=true;
    }
    
    public void setMensajeError(String mensaje){
        JOptionPane.showMessageDialog(this,mensaje,"Base de datos desconectada.",JOptionPane.ERROR_MESSAGE);
    }
    
    
    public void setMensajeExito(String mensaje){
        JOptionPane.showMessageDialog(this,mensaje,"Desconectado",JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    
    private void ListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarTodosActionPerformed
        
        if(conectado){
            this.setContentPane(panelListarTodos);
            panelListarTodos.conexion=conexion;

            pack();
       
        }else
            setMensajeError("Debe conectarse a la base de datos.");
    }//GEN-LAST:event_ListarTodosActionPerformed

    private void ConectarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConectarItemActionPerformed
        this.setContentPane(panelConectar);
        panelConectar.inicializarCampos();
        pack();
    }//GEN-LAST:event_ConectarItemActionPerformed

    private void DesconectarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesconectarItemActionPerformed

        if (conectado) {
            try {
                Principal.conexion.close();
                conectado=false;
                this.setContentPane(panelConectar);
                setMensajeExito("Desconectado con éxito.");
            } catch (SQLException ex) {
                setMensajeError("Erro al desconectase de la base de datos.");
            }
        }else
            setMensajeError("Debe conectarse a la base datos.");
        
    }//GEN-LAST:event_DesconectarItemActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
            
                
            
        });  
    }
   
    private final PanelListarTodos panelListarTodos=new PanelListarTodos();
    private final PanelListar panelListar= new PanelListar();
    private final PanelConectar panelConectar= new PanelConectar();
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AcercaDe;
    private javax.swing.JMenu Ayuda;
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JMenuItem ConectarItem;
    private javax.swing.JMenuItem DesconectarItem;
    private javax.swing.JMenu Listar;
    private javax.swing.JMenuItem Listar1;
    private javax.swing.JMenuItem ListarTodos;
    private javax.swing.JMenu MenuConectarDesconectar;
    private javax.swing.JLabel labelPractica;
    // End of variables declaration//GEN-END:variables

   
}
