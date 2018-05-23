package br.edu.ifrn.clinica.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Profissional extends Pessoa implements Serializable {

    private static final long serialVersionUID = -1965952900019030588L;

    private String conselhoProfissional;
    private String estadoConselho;
    private String numeroConselho;
    private String descricaoAPP;
    @Column(nullable = false)
    private boolean ehAPP;
    @ManyToOne
    private TipoProfissional tipoProfissional;
    @ManyToMany
    private List<Convenio> convenios;
    @ManyToMany
    private List<LocalAtendimento> locaisAtendimento;
    @ManyToMany
    private List<Especialidade> especialidades;

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

    public String getDescricaoAPP() {
        return descricaoAPP;
    }

    public void setDescricaoAPP(String descricaoAPP) {
        this.descricaoAPP = descricaoAPP;
    }

    public boolean getEhAPP() {
        return ehAPP;
    }

    public void setEhAPP(boolean ehAPP) {
        this.ehAPP = ehAPP;
    }

    public TipoProfissional getTipoProfissional() {
        return tipoProfissional;
    }

    public void setTipoProfissional(TipoProfissional tipoProfissional) {
        this.tipoProfissional = tipoProfissional;
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    public List<LocalAtendimento> getLocaisAtendimento() {
        return locaisAtendimento;
    }

    public void setLocaisAtendimento(List<LocalAtendimento> locaisAtendimento) {
        this.locaisAtendimento = locaisAtendimento;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }


}
