package model;

public class Paciente {

    private Integer id;
    private String nome;
    private Integer cpf;
    
    public Paciente() {

    }

    public Paciente(Integer id, String nome, Integer cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCpf() {
    	return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }


}

