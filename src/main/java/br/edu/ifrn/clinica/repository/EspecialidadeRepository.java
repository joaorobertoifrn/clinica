package br.edu.ifrn.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.clinica.model.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {

}
