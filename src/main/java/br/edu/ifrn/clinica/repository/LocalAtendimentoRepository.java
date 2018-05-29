package br.edu.ifrn.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.clinica.model.LocalAtendimento;

public interface LocalAtendimentoRepository extends JpaRepository<LocalAtendimento, Long> {

}
