package br.edu.ifrn.clinica.dto;

import java.io.Serializable;

import br.edu.ifrn.clinica.model.Profissional;

public class ProfissionalDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
    private String conselhoProfissional;
    private String estadoConselho;
    private String numeroConselho;
	
    public ProfissionalDTO(){
    	
    }

    
	public ProfissionalDTO(Profissional obj) {
		super();
		id = obj.getId();
		nome = obj.getNome();
		conselhoProfissional = obj.getConselhoProfissional();
		estadoConselho = obj.getEstadoConselho();
		numeroConselho = obj.getNumeroConselho();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getConselhoProfissional() {
		return conselhoProfissional;
	}

	public void setConselhoProfissional(String conselhoProfissional) {
		this.conselhoProfissional = conselhoProfissional;
	}

	public String getEstadoConselho() {
		return estadoConselho;
	}

	public void setEstadoConselho(String estadoConselho) {
		this.estadoConselho = estadoConselho;
	}

	public String getNumeroConselho() {
		return numeroConselho;
	}

	public void setNumeroConselho(String numeroConselho) {
		this.numeroConselho = numeroConselho;
	}
    
}