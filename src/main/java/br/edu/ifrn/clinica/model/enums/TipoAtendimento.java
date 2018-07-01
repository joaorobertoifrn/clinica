/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.clinica.model.enums;

/**
 *
 * @author João
 */
public enum TipoAtendimento {

    HORA_MARCADA("Hora Marcada"), 
    HORARIO_CHEGADA("Hora de Chegada");

	private String descricao;
	
	TipoAtendimento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}	
	
}
