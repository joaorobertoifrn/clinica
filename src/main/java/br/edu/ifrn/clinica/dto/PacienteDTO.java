package br.edu.ifrn.clinica.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ifrn.clinica.model.Paciente;

public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	
	private String email;
	
	private String cpf;
	
	public PacienteDTO() {
	}
	
	public PacienteDTO(Paciente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		cpf = obj.getCpf();
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}