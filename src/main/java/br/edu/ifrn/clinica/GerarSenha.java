package br.edu.ifrn.clinica;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GerarSenha {

	public static void main(String[] args) {
		
		
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		
		System.out.println(pe.encode("123"));
		

	}

}
