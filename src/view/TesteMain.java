/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import controller.ConexaoBD;
import controller.PacienteDAO;
import java.util.List;
import model.Paciente;

/**
 *
 * @author sidney
 */
public class TesteMain {
    public static void main(String args[]) {
        
        Connection con = null;
        
        con = ConexaoBD.getConnection();
        
        //Paciente paciente = new Paciente(1,"sidney",0001);
        
        PacienteDAO dao = new PacienteDAO(con);
        //dao.cadastraPaciente(paciente);
        
        Paciente paciente2 = new Paciente(1,"sidneyjr",3);
        
        //dao.atualizarPaciente(paciente2);

        dao.removerPaciente(paciente2);
        
        List<Paciente> listapaciente = dao.listarPaciente();

        for (Paciente lista : listapaciente) {
            
            System.out.print(lista.getId()+" | ");
            System.out.print(lista.getNome()+" | ");
            System.out.println(lista.getCpf());
       
        } 
       
    }
    
}
