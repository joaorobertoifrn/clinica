/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.clinica.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author João
 */
@Entity
public class Convenio implements Serializable {

    private static final long serialVersionUID = 3942838773516177741L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
    
    
    public Convenio() {
    	
    }
    
    public Convenio( String registroANS, String razaoSocial, String cnpj, String codigoCNS,
			String telefone, String email, Integer periodoRetorno) {
		this.registroANS = registroANS;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.codigoCNS = codigoCNS;
		this.telefone = telefone;
		this.email = email;
		this.periodoRetorno = periodoRetorno;
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

    public boolean getParticular() {
        return particular;
    }

    public void setParticular(boolean particular) {
        this.particular = particular;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Convenio other = (Convenio) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Convenio [id=" + id + ", nome=" + nome + ", registroANS=" + registroANS + ", razaoSocial=" + razaoSocial
                + ", cnpj=" + cnpj + ", codigoCNS=" + codigoCNS + ", telefone=" + telefone + ", email=" + email
                + ", periodoRetorno=" + periodoRetorno + "]";
    }

}
