package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

import DAO.DictionaryDAO;

public class Model {

	List<String> paroleSbagliate;
	List<String> paroleGiuste;
	DictionaryDAO dizionario;

	public Model() {
		dizionario = new DictionaryDAO();
	}
	
	

	/**
	 * @return the paroleSbagliate
	 */
	public List<String> getParoleSbagliate() {
		return paroleSbagliate;
	}


	/**
	 * @return the paroleGiuste
	 */
	public List<String> getParoleGiuste() {
		return paroleGiuste;
	}


	public void setListe(List<String> input) {
		this.paroleGiuste = new ArrayList<String>();
		this.paroleSbagliate = new ArrayList<String>();
		for (String s : input) {
			if (this.dizionario.isCorrect(s) && !paroleGiuste.contains(s)) {
				paroleGiuste.add(s);
			} else if (!this.dizionario.isCorrect(s) && !paroleSbagliate.contains(s)){
				paroleSbagliate.add(s);
			}
		}
	}

	public List<String> anagramma(String parola) { // deve restituire una lista di parole (STRINGHE)

		List<String> risultato = new ArrayList<String>();
		recursive("", parola, 0, risultato);
		// cancella dalla lista le parole non valide (leggendo il dizionario)
		return risultato;
	}

	private void recursive(String parziale, String lettere, int livello, List<String> risultato) {

		// caso terminale prima di ricorsione

		if (lettere.length() == 0) {

			// sol parziale = sol completa (mi hai dato una stringa senza lettere
			// if (parziale è una parola valida)

			risultato.add(parziale);
			System.out.println(parziale);

		} else {

			// fai ricorsione
			// sottoproblema == una lettere (singolo carattere) di 'lettere'

			for (int pos = 0; pos < lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos); // accede al singolo carattere della stringa

				String nuovaparziale = parziale + tentativo;
				String nuovalettere = lettere.substring(0, pos) + lettere.substring(pos + 1); // togli in carattere pos
																								// da lettere

				// if (nuovaparziale è un prefisso valido di almeno una parola nel dizionario es
				// "aqz" --> NO, non esiste

				recursive(nuovaparziale, nuovalettere, livello + 1, risultato);

				// backtracking
				// rimetti a posto parziale
				// rimetti a posto lettere
			}
		}

	}

}
