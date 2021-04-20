package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

import DAO.DictionaryDAO;

public class Anagramma {

	String nome;
	boolean check;
	DictionaryDAO dizionario;

	public Anagramma() {
	dizionario = new DictionaryDAO();
	}

	public boolean paroleCorrette(String anagramma) {
return this.dizionario.isCorrect(anagramma);
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
