package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Agendamento;

public class AgendamentoDAO {

	private Connection con;

	public void CdDAO(){
		ConexaoBD cbd = new ConexaoBD();
		con = cbd.getConnection();
	}

	public void cadastraAgenda(Agendamento agendamento){

		String scriptSql = "INSERT INTO tbl_servico (id,data,hora,paciente,dentista)" + "VALUES (?,?,?,?,?)";

		try {

			PreparedStatement stmt = con.prepareStatement(scriptSql);

			stmt.setInt(1, agendamento.getId());
			stmt.setInt(2, agendamento.getData());
			stmt.setInt(3, agendamento.getHora());
			stmt.setString(4, agendamento.getDentista());
			stmt.setString(5, agendamento.getPaciente());


			stmt.execute();
			stmt.close();

			System.out.println("\nCd cadastrado Com Sucesso !\n");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	public void removerAgenda(Agendamento agendamento){

		String scriptSql = "DELETE FROM tbl_servico WHERE id = ?";

		try {

			 PreparedStatement stmt = con.prepareStatement(scriptSql);
			 stmt.setInt(1, agendamento.getId());
			 stmt.execute();
			 stmt.close();

			 System.out.println("\nServico excluido Com Sucesso !\n");

		 } catch (SQLException e) {

			 System.out.println(e.getMessage());

		 }
	}

	public void atualizarAgenda(Agendamento agendamento){

		String scriptSql = "UPDATE tbl_servico SET hora = ?, valor = ?, paciente = ?, dentista = ?, data = ? WHERE id = ?";

		try {

			 PreparedStatement stmt = con.prepareStatement(scriptSql);

			 stmt.setInt(1, agendamento.getHora());
			 stmt.setString(2, agendamento.getDentista());
			 stmt.setString(3, agendamento.getPaciente());
			 stmt.setInt(4, agendamento.getData());
			 stmt.setInt(3, agendamento.getId());

			 stmt.execute();
			 stmt.close();

			 System.out.println("\nCd atualizado Com Sucesso !\n");

		} catch (Exception e) {

			System.out.println("Erro : " + e.getMessage());

		}

	}


	public List<Agendamento> listarAgendamento() {

		List<Agendamento> listaServicos = new ArrayList<Agendamento>();

		String scriptSql = "SELECT * FROM tbl_agendamento";

		try {

			PreparedStatement stmt = con.prepareStatement(scriptSql);
			ResultSet resultSet = stmt.executeQuery();

		while(resultSet.next()){
			Agendamento agendamento = new Agendamento();

			agendamento.setId(resultSet.getInt("id"));
			agendamento.setHora(resultSet.getInt("hora"));
			agendamento.setData(resultSet.getInt("data"));
			agendamento.setDentista(resultSet.getString("Dentista"));
			agendamento.setPaciente(resultSet.getString("Paciente"));
			listaServicos.add(agendamento);
		}

			resultSet.close();
			stmt.close();

		} catch (Exception e) {

			 System.out.println("Erro : " + e.getMessage());

		}

		 return listaServicos;

	 }

}