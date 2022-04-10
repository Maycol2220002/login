/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login2;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    String bd ="login_hookah";
    String url ="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="";
    String driver="com.mysql.cj.jdbc.Driver";
    
    Connection cx;

    public Conexion(String bd){
        this.bd=bd;
       
    }
    
    public Connection conectar(){
       try{
           Class.forName(driver);
           cx=DriverManager.getConnection(url+bd, user, password);  
           System.out.println("Conectado a la BD "+bd);  
        
       }catch(ClassNotFoundException |SQLException ex){
           System.out.println("No se puedo conectar a BD "+bd);
           //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
           
       }
           
        return cx;
        
    }
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        Conexion conexion = new Conexion("login_hookah");
        conexion.conectar();        
    }
    
}
