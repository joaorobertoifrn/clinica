package br.edu.ifrn.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.clinica.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByEmail(String email);

}

