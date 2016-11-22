/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Dentista;
import model.Endereco;

/**
 *
 * @author sidney
 */
public class DentistaDAO {
    
    private Connection con = null;   
    
    public DentistaDAO (Connection con){
        
        this.con = con;
        
    }
    
    public void cadastraDentista(Dentista dentista){
        

            String scriptSql = "INSERT INTO dentista (nome, id)" + "VALUES (?,?)";

            try {

		PreparedStatement stmt = con.prepareStatement(scriptSql);
                

		stmt.setInt(2, dentista.getId());
		stmt.setString(1, dentista.getNome());

		stmt.execute();
		stmt.close();

		System.out.println("\nCd cadastrado Com Sucesso !\n");

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

	 }
}
