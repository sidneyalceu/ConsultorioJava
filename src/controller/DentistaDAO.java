/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Dentista;
import model.Endereco;
import model.Dentista;

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
        

        String scriptSql = "INSERT INTO dentista (id,nome,cro)" + "VALUES (?,?,?)";

        try {

            PreparedStatement stmt = con.prepareStatement(scriptSql);
                
            stmt.setInt(1, dentista.getId());
            stmt.setString(2, dentista.getNome());
            stmt.setInt(3, dentista.getCro());
	
            stmt.execute();
            stmt.close();

            System.out.println("\nCd cadastrado Com Sucesso !\n");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    public void atualizarDentista(Dentista dentista){

            String scriptSql = "UPDATE dentista SET nome = ?, cpf= ? WHERE id = ?";

	try {

            PreparedStatement stmt = con.prepareStatement(scriptSql);

            stmt.setInt(1, dentista.getId());
            stmt.setString(2, dentista.getNome());
            stmt.setInt(3, dentista.getCro());

            stmt.execute();
            stmt.close();

            System.out.println("\nCd atualizado Com Sucesso !\n");

        } catch (Exception e) {

            System.out.println("Erro : " + e.getMessage());

        }

    }

	 public void removerDentista(Dentista dentista){

		 String scriptSql = "DELETE FROM dentista WHERE id = ?";

		 try {

			 PreparedStatement stmt = con.prepareStatement(scriptSql);
			 stmt.setInt(1, dentista.getId());
			 stmt.execute();
			 stmt.close();

			 System.out.println("\nEndereco excluido Com Sucesso !\n");

		 } catch (SQLException e) {

			 System.out.println(e.getMessage());

		 }
	 }

	 public List<Dentista> listarDentista() {

	 	 List<Dentista> listaDentistas = new ArrayList<Dentista>();

		 String scriptSql = "SELECT * FROM dentista";

		 try {

			 PreparedStatement stmt = con.prepareStatement(scriptSql);
			 ResultSet resultSet = stmt.executeQuery();

			 while(resultSet.next()){
				 Dentista dentista = new Dentista();

				 dentista.setId(resultSet.getInt("id"));
				 dentista.setNome(resultSet.getString("nome"));
				 dentista.setCpf(resultSet.getInt("cpf"));
				 listaDentistas.add(dentista);
			 }

			 resultSet.close();
			 stmt.close();

		 } catch (Exception e) {

			 System.out.println("Erro : " + e.getMessage());

		 }

		 return listaDentistas;

	 }

















}
