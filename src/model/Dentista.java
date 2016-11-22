package model;

public class Dentista {

	private Integer id;
	private String nome;
	private Integer cro;
        
        public Dentista (Integer id, String nome){
            this.id = id;
            this.nome = nome;
        }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCro() {
		return cro;
	}

	public void setCro(Integer cro) {
		this.cro = cro;
	}
}
