package br.edu.ifrn.clinica.dto;

import java.io.Serializable;

public class DashboardDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long totalPacientes;
	private Long totalConvenios;
	private Long totalProfissionais;
	
    public DashboardDTO(){
    	
    }

	public DashboardDTO(Long totalPacientes, Long totalConvenios, Long totalProfissionais) {
		super();
		this.totalPacientes = totalPacientes;
		this.totalConvenios = totalConvenios;
		this.totalProfissionais = totalProfissionais;
	}

	public Long getTotalPacientes() {
		return totalPacientes;
	}

	public void setTotalPacientes(Long totalPacientes) {
		this.totalPacientes = totalPacientes;
	}

	public Long getTotalConvenios() {
		return totalConvenios;
	}

	public void setTotalConvenios(Long totalConvenios) {
		this.totalConvenios = totalConvenios;
	}

	public Long getTotalProfissionais() {
		return totalProfissionais;
	}

	public void setTotalProfissionais(Long totalProfissionais) {
		this.totalProfissionais = totalProfissionais;
	}  
    
}