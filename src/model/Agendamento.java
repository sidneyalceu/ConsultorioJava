package model;

public class Agendamento {

	private Integer id;
	private Integer data;
	private Integer hora;
	private String paciente;
	private String dentista;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getDentista() {
		return dentista;
	}

	public void setDentista(String dentista) {
		this.dentista = dentista;
	}

}
