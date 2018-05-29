package br.edu.ifrn.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.clinica.model.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

}
