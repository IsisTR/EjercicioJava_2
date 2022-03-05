/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.clientesDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author itreq
 */
public class conexion {
    String strConexionDB="jdbc:sqlite:C:/Users/itreq/Documents/BD/db/sistema.s3db";
    Connection conn= null;
    
    
    public conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn= (Connection) DriverManager.getConnection(strConexionDB);
            
            System.out.println("Conexion establecida");
            
        } catch (Exception e) {
            System.out.println("Error de Conexion"+e);
        }
    }
    
    public int ejecutarSentenciaSQL(String strSentenciaSQL){
        try{
            PreparedStatement pstm= conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } 
        catch(SQLException e){
            System.out.println(e);
            return 0;
        }
    }
    
    public ResultSet consultarRegiatros(String strSentenciaSQL){  //Metodo para devolver informacion y si la informacion existe o no
        try {
            PreparedStatement pstm= conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta= pstm.executeQuery(); //devuelve la informacion que se esta generando con la consulta: strSentenciaSQL
            
            return respuesta;
            
            
        } catch (Exception e) {
            System.out.println(e); //Si hay alguna falla, se imprimira para saber cual es.
            return null;
        }
    
    
    }
    
}
