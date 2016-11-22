package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    public static Connection getConnection(){

	Connection con = null;

	try {
        
            con = DriverManager.getConnection("jdbc:mysql://localhost/consultorio", "root", "hewlett");
	
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
        
        }

        return con;

    }
};