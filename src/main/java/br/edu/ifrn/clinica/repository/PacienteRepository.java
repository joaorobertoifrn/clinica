package br.edu.ifrn.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.clinica.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>  {

	public List<Paciente> findByNomeStartingWithIgnoreCase(String nome);

	public Paciente findByEmail(String email);

}

