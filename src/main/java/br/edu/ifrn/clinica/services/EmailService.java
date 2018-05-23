package br.edu.ifrn.clinica.services;

import org.springframework.mail.SimpleMailMessage;

import br.edu.ifrn.clinica.model.AtendimentoAgendado;
import br.edu.ifrn.clinica.model.Paciente;

public interface EmailService {

	void sendOrderConfirmationEmail(AtendimentoAgendado obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Paciente cliente, String newPass);
}
