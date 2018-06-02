package br.edu.ifrn.clinica.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.ifrn.clinica.model.enums.Perfil;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Usuario extends Pessoa implements Serializable {

    private static final long serialVersionUID = 7254898165069427000L;
    
    @JsonIgnore
    private String senha;

    @ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	@Override
	public String toString() {
		return "Usuario [senha=" + senha + ", perfis=" + perfis + "]";
	}


}
