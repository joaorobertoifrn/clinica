package br.edu.ifrn.clinica.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AtendimentoAgendado implements Serializable {

    private static final long serialVersionUID = -5715575985130327752L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonFormat(pattern = "HH:mm:ss")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @ManyToOne
    private Convenio convenio;
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private RegrasAgenda regrasAgenda;
    private BigDecimal valorAtendimento;
    private String nomeTemporario;
    private String contatoTemporario;
    @Column(nullable = false)
    private boolean retorno;
    private Integer ordemChegada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public RegrasAgenda getRegrasAgenda() {
        return regrasAgenda;
    }

    public void setRegrasAgenda(RegrasAgenda regrasAgenda) {
        this.regrasAgenda = regrasAgenda;
    }

    public BigDecimal getValorAtendimento() {
        return valorAtendimento;
    }

    public void setValorAtendimento(BigDecimal valorAtendimento) {
        this.valorAtendimento = valorAtendimento;
    }

    public String getNomeTemporario() {
        return nomeTemporario;
    }

    public void setNomeTemporario(String nomeTemporario) {
        this.nomeTemporario = nomeTemporario;
    }

    public String getContatoTemporario() {
        return contatoTemporario;
    }

    public void setContatoTemporario(String contatoTemporario) {
        this.contatoTemporario = contatoTemporario;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public boolean getRetorno() {
        return retorno;
    }

    public void setRetorno(boolean retorno) {
        this.retorno = retorno;
    }

    public Integer getOrdemChegada() {
        return ordemChegada;
    }

    public void setOrdemChegada(Integer ordemChegada) {
        this.ordemChegada = ordemChegada;
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
        AtendimentoAgendado other = (AtendimentoAgendado) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
