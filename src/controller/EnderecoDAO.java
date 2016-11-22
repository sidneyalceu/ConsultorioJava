package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Endereco;


public class EnderecoDAO {

	private Connection con;

	public void CdDAO(){

            ConexaoBD cbd = new ConexaoBD();
            con = cbd.getConnection();

	}

	public void cadastraEnd(Endereco endereco){

            String scriptSql = "INSERT INTO tbl_endereco (id, logradouro, complemento, cpe, bairro, numero, cidade, estado)" + "VALUES (?,?,?,?,?,?,?,?)";

            try {

		PreparedStatement stmt = con.prepareStatement(scriptSql);

		stmt.setInt(1, endereco.getId());
		stmt.setString(2, endereco.getLogradouro());
		stmt.setString(3, endereco.getComplemento());
		stmt.setInt(4, endereco.getCpe());
		stmt.setString(5, endereco.getBairro());
		stmt.setInt(6, endereco.getNumero());
		stmt.setString(7,endereco.getCidade());
		stmt.setString(8,endereco.getEstado());


		stmt.execute();
		stmt.close();

		System.out.println("\nCd cadastrado Com Sucesso !\n");

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

	 }

	 public void atualizarEnd(Endereco endereco){

		 String scriptSql = "UPDATE tbl_endereco SET titulo = ?,artista = ?,numeroFaixas = ?,gravadora = ? WHERE codCd = ?";

		 try {

			 PreparedStatement stmt = con.prepareStatement(scriptSql);

			 stmt.setInt(1, endereco.getId());
			 stmt.setString(2, endereco.getLogradouro());
			 stmt.setString(3, endereco.getComplemento());
			 stmt.setInt(4, endereco.getCpe());
			 stmt.setString(5, endereco.getBairro());
			 stmt.setInt(6, endereco.getNumero());
			 stmt.setString(7,endereco.getCidade());
			 stmt.setString(8,endereco.getEstado());

			 stmt.execute();
			 stmt.close();

			 System.out.println("\nCd atualizado Com Sucesso !\n");

	 	} catch (Exception e) {

		 System.out.println("Erro : " + e.getMessage());

	 	}

	 }

	 public void removerEnd(Endereco endereco){

		 String scriptSql = "DELETE FROM tbl_endereco WHERE id = ?";

		 try {

			 PreparedStatement stmt = con.prepareStatement(scriptSql);
			 stmt.setInt(1, endereco.getId());
			 stmt.execute();
			 stmt.close();

			 System.out.println("\nEndereco excluido Com Sucesso !\n");

		 } catch (SQLException e) {

			 System.out.println(e.getMessage());

		 }
	 }

	 public List<Endereco> listarEndereco() {

	 	 List<Endereco> listaEnderecos = new ArrayList<Endereco>();

		 String scriptSql = "SELECT * FROM tbl_endereco";

		 try {

			 PreparedStatement stmt = con.prepareStatement(scriptSql);
			 ResultSet resultSet = stmt.executeQuery();

			 while(resultSet.next()){
				 Endereco endereco = new Endereco();

				 endereco.setId(resultSet.getInt("codCd"));
				 endereco.setLogradouro(resultSet.getString("titulo"));
				 endereco.setComplemento(resultSet.getString("artista"));
				 endereco.setCpe(resultSet.getInt("numeroFaixas"));
				 endereco.setBairro(resultSet.getString("gravadora"));
				 listaEnderecos.add(endereco);
			 }

			 resultSet.close();
			 stmt.close();

		 } catch (Exception e) {

			 System.out.println("Erro : " + e.getMessage());

		 }

		 return listaEnderecos;

         }

}
 