package br.edu.ifrn.clinica.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.ifrn.clinica.model.enums.TipoAtendimento;

@Entity
public class RegrasAgenda implements Serializable {

    private static final long serialVersionUID = -9008528474011631361L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer numeroAtendimentosPrimeiraVez;
    private Integer numeroAtendimentosConvenio;
    private Integer numeroAtendimentoRetornos;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Calendar dia;
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss")
    private Date horaInicio;
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss")
    private Date horaFim;
    private BigDecimal valorConsulta;
    private Integer tempoMedioConsulta;
    @Enumerated(EnumType.STRING)
    private TipoAtendimento tipoAtendimento;
    @ManyToOne
    private LocalAtendimento localAtendimento;
    @ManyToOne
    private Profissional profissional;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroAtendimentosPrimeiraVez() {
        return numeroAtendimentosPrimeiraVez;
    }

    public void setNumeroAtendimentosPrimeiraVez(Integer numeroAtendimentosPrimeiraVez) {
        this.numeroAtendimentosPrimeiraVez = numeroAtendimentosPrimeiraVez;
    }

    public Integer getNumeroAtendimentosConvenio() {
        return numeroAtendimentosConvenio;
    }

    public void setNumeroAtendimentosConvenio(Integer numeroAtendimentosConvenio) {
        this.numeroAtendimentosConvenio = numeroAtendimentosConvenio;
    }

    public Integer getNumeroAtendimentoRetornos() {
        return numeroAtendimentoRetornos;
    }

    public void setNumeroAtendimentoRetornos(Integer numeroAtendimentoRetornos) {
        this.numeroAtendimentoRetornos = numeroAtendimentoRetornos;
    }

    public Calendar getDia() {
        return dia;
    }

    public void setDia(Calendar dia) {
        this.dia = dia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public BigDecimal getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(BigDecimal valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public Integer getTempoMedioConsulta() {
        return tempoMedioConsulta;
    }

    public void setTempoMedioConsulta(Integer tempoMedioConsulta) {
        this.tempoMedioConsulta = tempoMedioConsulta;
    }

    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public LocalAtendimento getLocalAtendimento() {
        return localAtendimento;
    }

    public void setLocalAtendimento(LocalAtendimento localAtendimento) {
        this.localAtendimento = localAtendimento;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
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
        RegrasAgenda other = (RegrasAgenda) obj;
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
        return "RegrasAgenda [id=" + id + ", numeroAtendimentosPrimeiraVez=" + numeroAtendimentosPrimeiraVez
                + ", numeroAtendimentosConvenio=" + numeroAtendimentosConvenio + ", numeroAtendimentoRetornos="
                + numeroAtendimentoRetornos + ", dia=" + dia + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim
                + ", valorConsulta=" + valorConsulta + ", tempoMedioConsulta=" + tempoMedioConsulta
                + ", tipoAtendimento=" + tipoAtendimento + ", localAtendimento=" + localAtendimento + ", profissional="
                + profissional + "]";
    }

}
