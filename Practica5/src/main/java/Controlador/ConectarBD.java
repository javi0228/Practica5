/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Vista.Principal;

import java.sql.*;



/**
 *
 * @author Javir
 */
public class ConectarBD {
    Connection con;
    Statement stm;
    ResultSet rs;
    
    
    public Connection conectar(String user,String password) throws SQLException{
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            //Class.forName("com.inet.csv.CsvDriver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("JDBC driver falied to load."+e.getMessage());
            return null;
        }

        
          // en Servidor remoto Connection con = DriverManager.getConnection("jdbc:oracle:thin:@server:1521:infor","banquero","banquero");
          Connection conn;
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Empresa",user,password);
         
          //Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","banquero","banquero");
          //Connection con = DriverManager.getConnection("jdbc:odbc:DB","","");
          

          /* 
             Con esta versiï¿½n, sin parï¿½metros, del mï¿½todo createStatement(), creamos un objeto Statement
             que producurï¿½ un ResultSet que sï¿½lo se puede recorrer hacia delante con next()
           */
//          Statement stmt = con.createStatement();
//          ResultSet rs = stmt.executeQuery("SELECT * FROM empleado WHERE apellido = 'GARCIA'");
//          ResultSetMetaData rsmd = rs.getMetaData();
//
//          int numCols = rsmd.getColumnCount();
//
//          while (rs.next()) {
//            for (int i = 1; i <= numCols; i++) {
//              System.out.print(rs.getString(i) + " ");
//            }
//            System.out.println("");
//          }


          /*int count = stmt.executeUpdate("INSERT INTO  " +
                                                "VALUES (1031,'AndrÃ©s','PEREZ','default.jpg',2500,3000,'10/17/2021')");
          System.out.print("Insetadas: " + count + "filas");*/

//          rs.close();
//          stmt.close();
            
            return conn;
        
    }
    
    Principal p;
    
    
   
}
