/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import controller.ConexaoBD;
import controller.PacienteDAO;
import model.Paciente;

/**
 *
 * @author sidney
 */
public class TesteMain {
    public static void main(String args[]) {
        
        Connection con = null;
        
        con = ConexaoBD.getConnection();
        
        Paciente paciente = new Paciente(1,"sidney",0001);
        
        PacienteDAO dao = new PacienteDAO(con);
        dao.cadastraPaciente(paciente);
       
    }
    
}
