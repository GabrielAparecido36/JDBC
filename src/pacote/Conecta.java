/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conecta {
    
    public static Connection getConexao() throws SQLException{
        Connection con = null;
        try{
            String serverName = "localhost";
            String mydatabase = "alunos";
            String username = "root";
            String password = "";
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String url = "jdbc:mysql://"+serverName+"/"+mydatabase;
            
            con = DriverManager.getConnection(url, username, password);
                    
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não foi encrontrado"+e.toString());
        }catch(SQLException e){
            System.out.println("Erro ao conectar com o BD "+e.toString());
        }
        return con;
    }
    
}
