package br.edu.ifrn.clinica.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.edu.ifrn.clinica.security.UserSS;



public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
