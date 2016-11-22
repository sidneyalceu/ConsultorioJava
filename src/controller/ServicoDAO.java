package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Servico;

public class ServicoDAO {

	private Connection con;

	 public void CdDAO(){

		 ConexaoBD cbd = new ConexaoBD();
		 con = cbd.getConnection();

	 }

	 public void cadastraServ(Servico servico){

		 String scriptSql = "INSERT INTO tbl_servico (id, descricao, valor)" + "VALUES (?,?,?)";

	 try {

		PreparedStatement stmt = con.prepareStatement(scriptSql);

		stmt.setInt(1, servico.getId());
		stmt.setString(2, servico.getDescricao());
		stmt.setInt(3, servico.getValor());


		stmt.execute();
		stmt.close();

		System.out.println("\nCd cadastrado Com Sucesso !\n");

	 	} catch (SQLException e) {

	 		System.out.println(e.getMessage());

	 	}

	 }

	 public void removerSer(Servico servico){

		 String scriptSql = "DELETE FROM tbl_servico WHERE id = ?";

		 try {

			 PreparedStatement stmt = con.prepareStatement(scriptSql);
			 stmt.setInt(1, servico.getId());
			 stmt.execute();
			 stmt.close();

			 System.out.println("\nServico excluido Com Sucesso !\n");

		 } catch (SQLException e) {

			 System.out.println(e.getMessage());

		 }
	 }

	 public void atualizarSer(Servico servico){

		 String scriptSql = "UPDATE tbl_servico SET descricao = ?, valor = ? WHERE id = ?";

		 try {

			 PreparedStatement stmt = con.prepareStatement(scriptSql);

			 stmt.setString(1, servico.getDescricao());
			 stmt.setInt(2, servico.getValor());
			 stmt.setInt(3, servico.getId());

			 stmt.execute();
			 stmt.close();

			 System.out.println("\nCd atualizado Com Sucesso !\n");

	 	} catch (Exception e) {

		 System.out.println("Erro : " + e.getMessage());

	 	}

	 }


	 public List<Servico> listarServico() {

	 	 List<Servico> listaServicos = new ArrayList<Servico>();

		 String scriptSql = "SELECT * FROM tbl_servico";

		 try {

			 PreparedStatement stmt = con.prepareStatement(scriptSql);
			 ResultSet resultSet = stmt.executeQuery();

			 while(resultSet.next()){
				 Servico servico = new Servico();

				 servico.setId(resultSet.getInt("id"));
				 servico.setDescricao(resultSet.getString("descricao"));
				 servico.setValor(resultSet.getInt("valor"));
				 listaServicos.add(servico);
			 }

			 resultSet.close();
			 stmt.close();

		 } catch (Exception e) {

			 System.out.println("Erro : " + e.getMessage());

		 }

		 return listaServicos;

	 }

}
