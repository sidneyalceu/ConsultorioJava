package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Paciente;

public class PacienteDAO {

	private Connection con = null;   
    
	 public PacienteDAO(Connection con){
        
            this.con = con;
        
        }
	
	public void cadastraPaciente(Paciente paciente){

		 String scriptSql = "INSERT INTO paciente (id, name, cpf)" + "VALUES (?,?,?)";

		 try {

			PreparedStatement stmt = con.prepareStatement(scriptSql);

			stmt.setInt(1, paciente.getId());
			stmt.setString(2, paciente.getNome());
			stmt.setInt(3, paciente.getCpf());

			stmt.execute();
			stmt.close();

			System.out.println("\nCd cadastrado Com Sucesso !\n");

		 	} catch (SQLException e) {

		 		System.out.println(e.getMessage());

		 	}

	 }

	 public void atualizarPaciente(Paciente paciente){

		 String scriptSql = "UPDATE tbl_paciente SET nome = ?, cpf = ?, rg = ?, telefone = ? WHERE id = ?";

		 try {

			 PreparedStatement stmt = con.prepareStatement(scriptSql);

			 stmt.setString(1, paciente.getNome());
			 stmt.setInt(2, paciente.getCpf());
			 stmt.setInt(5, paciente.getId());

			 stmt.execute();
			 stmt.close();

			 System.out.println("\nCd atualizado Com Sucesso !\n");

	 	} catch (Exception e) {

		 System.out.println("Erro : " + e.getMessage());

	 	}

	 }

	 public void removerPaciente(Paciente paciente){

		 String scriptSql = "DELETE FROM tbl_paciente WHERE id = ?";

		 try {

			 PreparedStatement stmt = con.prepareStatement(scriptSql);
			 stmt.setInt(1, paciente.getId());
			 stmt.execute();
			 stmt.close();

			 System.out.println("\nEndereco excluido Com Sucesso !\n");

		 } catch (SQLException e) {

			 System.out.println(e.getMessage());

		 }
	 }

	 public List<Paciente> listarPaciente() {

	 	 List<Paciente> listaPacientes = new ArrayList<Paciente>();

		 String scriptSql = "SELECT * FROM tbl_paciente";

		 try {

			 PreparedStatement stmt = con.prepareStatement(scriptSql);
			 ResultSet resultSet = stmt.executeQuery();

			 while(resultSet.next()){
				 Paciente paciente = new Paciente();

				 paciente.setId(resultSet.getInt("id"));
				 paciente.setNome(resultSet.getString("nome"));
				 paciente.setCpf(resultSet.getInt("cpf"));
				 listaPacientes.add(paciente);
			 }

			 resultSet.close();
			 stmt.close();

		 } catch (Exception e) {

			 System.out.println("Erro : " + e.getMessage());

		 }

		 return listaPacientes;

	 }


}
