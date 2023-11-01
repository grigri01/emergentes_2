package com.emergentes.utiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConexionDB {

   static String driver ="com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_biblioteca";
   static String usuario = "root";
   static String password="";
   
   protected Connection con = null;
public ConexionDB() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, password);
            if (con != null) {
                System.out.println("Conexion establecida: "+con);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error en Driver "+e.getMessage());
        }catch (SQLException ex) {
            System.out.println("Error en SQL "+ex.getMessage());
        }
    }
     public Connection conectar(){
        return con;
    }
    public void desconectar(){
        try {
            con.close();
        } catch (SQLException ex) {
           System.out.println("Error al cerrar "+ex.getMessage());
        }
    }
        
}