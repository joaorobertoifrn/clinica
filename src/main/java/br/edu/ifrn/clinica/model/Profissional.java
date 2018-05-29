package br.edu.ifrn.clinica.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import br.edu.ifrn.clinica.model.enums.Sexo;

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

    public Profissional() {
    	
    }
    
    
    
    public Profissional(Long id, String nome, String email, Sexo sexo, Date dataNascimento, String cpf, String rg,
			String orgaoEmissor, String nomeSocial, String cns, String cep, String endereco, Integer numero,
			String complemento, String bairro, Cidade cidade, String nomePai, String nomeMae, Set<String> telefones) {
		super(id, nome, email, sexo, dataNascimento, cpf, rg, orgaoEmissor, nomeSocial, cns, cep, endereco, numero, complemento,
				bairro, cidade, nomePai, nomeMae, telefones);
		// TODO Auto-generated constructor stub
	}



	public Profissional(Long id, String nome, String conselhoProfissional, String estadoConselho, String numeroConselho) {
		super(id, nome);
		this.conselhoProfissional = conselhoProfissional;
		this.estadoConselho = estadoConselho;
		this.numeroConselho = numeroConselho;
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
