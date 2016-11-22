package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {
  
    private static final String url = "jdbc:postgresql://localhost:5432/consultorio";
    private static final String usuario = "postgres";
    private static final String senha = "post";
    
    public static Connection getConnection(){
        
         
        try {   
            
            Class.forName("org.postgresql.Driver");
            
        } catch (ClassNotFoundException ex) {
            
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
	Connection con = null;

	try {

            con = DriverManager.getConnection(url, usuario, senha);
	
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
        
        }

        return con;

    }
};