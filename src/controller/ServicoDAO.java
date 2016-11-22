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

    public void ServicoDAO(Connection con){

	this.con = con;

    }

    public void cadastraServico(Servico servico){

        String scriptSql = "INSERT INTO servico (id, descricao)" + "VALUES (?,?)";

        try {

            PreparedStatement stmt = con.prepareStatement(scriptSql);

            stmt.setInt(1, servico.getId());
            stmt.setString(2, servico.getDescricao());
            
            stmt.execute();
            stmt.close();

            System.out.println("\nCd cadastrado Com Sucesso !\n");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    public void removerSer(Servico servico){

	String scriptSql = "DELETE FROM servico WHERE id = ?";

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

	String scriptSql = "UPDATE servico SET descricao = ? WHERE id = ?";

        try {

            PreparedStatement stmt = con.prepareStatement(scriptSql);

            stmt.setString(1, servico.getDescricao());
            stmt.setInt(2, servico.getId());

            stmt.execute();
            stmt.close();

            System.out.println("\nCd atualizado Com Sucesso !\n");

	} catch (Exception e) {

            System.out.println("Erro : " + e.getMessage());

	}

    }


    public List<Servico> listarServico() {

	List<Servico> listaServicos = new ArrayList<Servico>();

	String scriptSql = "SELECT * FROM servico";

	try {

            PreparedStatement stmt = con.prepareStatement(scriptSql);
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                Servico servico = new Servico();

		servico.setId(resultSet.getInt("id"));
		servico.setDescricao(resultSet.getString("descricao"));
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
