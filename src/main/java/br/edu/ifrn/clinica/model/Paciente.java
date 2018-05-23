/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.clinica.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author João
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Paciente extends Pessoa  implements Serializable {

    private static final long serialVersionUID = 5389961478721720268L;

    public Paciente() {

    }

    public Paciente(Long id, String nome) {
        setId(id);
        setNome(nome);
    }

    @ManyToOne
    private Convenio convenio;
    private Boolean usaAPP = false;
    @JsonIgnore
    private String tokenFCM;

    public String getTokenFCM() {
        return tokenFCM;
    }

    public void setTokenFCM(String tokenFCM) {
        this.tokenFCM = tokenFCM;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Boolean isUsaAPP() {
        return usaAPP;
    }

    public void setUsaAPP(Boolean usaAPP) {
        this.usaAPP = usaAPP;
    }

}
