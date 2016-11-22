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

    public void AgendamentoDAO(Connection con){
        
	this.con = con;
        
    }

    public void cadastraAgenda(Agendamento agendamento){

	String scriptSql = "INSERT INTO agendamento (id,idpaciente,iddentista,idservico,data)" + "VALUES (?,?,?,?,?)";

	try {

            PreparedStatement stmt = con.prepareStatement(scriptSql);

            stmt.setInt(1, agendamento.getId());
            stmt.setInt(2, agendamento.getIdpaciente());
            stmt.setInt(3, agendamento.getIddentista());
            stmt.setInt(4, agendamento.getIdservico());
            stmt.setString(5, agendamento.getData());


            stmt.execute();
            stmt.close();

            System.out.println("\nCd cadastrado Com Sucesso !\n");

	} catch (SQLException e) {

            System.out.println(e.getMessage());

	}

    }

    public void removerAgenda(Agendamento agendamento){

	String scriptSql = "DELETE FROM agendamento WHERE id = ?";

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

	String scriptSql = "UPDATE agendamento SET hora = ?, valor = ?, paciente = ?, dentista = ?, data = ? WHERE id = ?";

	try {

            PreparedStatement stmt = con.prepareStatement(scriptSql);

            stmt.setInt(1, agendamento.getId());
            stmt.setInt(2, agendamento.getIdpaciente());
            stmt.setInt(3, agendamento.getIddentista());
	    stmt.setInt(4, agendamento.getIdservico());
            stmt.setString(5, agendamento.getData());

            stmt.execute();
            stmt.close();

            System.out.println("\nCd atualizado Com Sucesso !\n");

	} catch (Exception e) {

            System.out.println("Erro : " + e.getMessage());

	}

    }

    public List<Agendamento> listarAgendamento() {

	List<Agendamento> listaServicos = new ArrayList<Agendamento>();

	String scriptSql = "SELECT * FROM agendamento";

	try {

            PreparedStatement stmt = con.prepareStatement(scriptSql);
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
		
                Agendamento agendamento = new Agendamento();

		agendamento.setId(resultSet.getInt("id"));
                agendamento.setIdpaciente(resultSet.getInt("idpaciente"));
                agendamento.setIddentista(resultSet.getInt("iddentista"));
		agendamento.setIdservico(resultSet.getInt("idservico"));
		agendamento.setData(resultSet.getString("data"));
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