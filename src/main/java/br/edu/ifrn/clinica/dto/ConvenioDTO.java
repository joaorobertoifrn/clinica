package br.edu.ifrn.clinica.dto;

import java.io.Serializable;

import javax.persistence.Column;

import org.hibernate.validator.constraints.br.CNPJ;

import br.edu.ifrn.clinica.model.Convenio;

public class ConvenioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String nome;
    private String registroANS;
    private String razaoSocial;
    @CNPJ
    private String cnpj;
    private String codigoCNS;
    private String telefone;
    private String email;
    private Integer periodoRetorno;
    @Column(nullable = false)
    private boolean particular;
	
    public ConvenioDTO(){
    	
    }
    
    
    public ConvenioDTO(Convenio obj) {
		super();
		id = obj.getId();
		nome = obj.getNome();
		registroANS = obj.getRegistroANS();
		razaoSocial = obj.getRazaoSocial();
		cnpj = obj.getCnpj();
		codigoCNS = obj.getCodigoCNS();
		telefone = obj.getTelefone();
		email = obj.getEmail();
		periodoRetorno = obj.getPeriodoRetorno();
		particular = obj.getParticular();
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
	public String getRegistroANS() {
		return registroANS;
	}
	public void setRegistroANS(String registroANS) {
		this.registroANS = registroANS;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCodigoCNS() {
		return codigoCNS;
	}
	public void setCodigoCNS(String codigoCNS) {
		this.codigoCNS = codigoCNS;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPeriodoRetorno() {
		return periodoRetorno;
	}
	public void setPeriodoRetorno(Integer periodoRetorno) {
		this.periodoRetorno = periodoRetorno;
	}
	public boolean isParticular() {
		return particular;
	}
	public void setParticular(boolean particular) {
		this.particular = particular;
	}
	
    
	
}