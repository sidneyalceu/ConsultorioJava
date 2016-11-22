package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {
    public static Connection getConnection(){
        
        try {   
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
	Connection con = null;

	try {

            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/consultorio", "postgres", "post");
	
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
        
        }

        return con;

    }
};