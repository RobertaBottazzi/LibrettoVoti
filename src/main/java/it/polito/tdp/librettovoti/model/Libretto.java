package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {
	//svolge il ruolo di Model ossia gestiscono i dati
	private List<Voto> voti;
	
	public Libretto() {
		this.voti= new ArrayList<>(); //faccio l'inizializzazione qua e sopra la dichiarazione in modo che
		                              //se volessi cambiare la tipologia di struttura posso farlo in qualsiasi momento e il programma di adatta
		
	}
	public void add(Voto voto) {
		this.voti.add(voto);
	}
	
	public void stampaVotiUguali(int punteggio) {
		//il libretto stampa da solo i voti
		//Se devo insierire questi voti in un'interfaccia grafica
		//questo non mi serve a nulla perchè stampa senza restituire nulla.
	}
	
	/*public String votiUguali(int punteggio) {
		/*Calcola una stringa che contiene i voti
		 *sarà poi il chiamante a stamparli.
		 * 
		 *Stampo solo il nome o anche il voto? 
		 */
		/*return null;
	}*/
	
	public List<Voto> listaVotiUguali(int punteggio){
		//restituisce solo i voti uguali al criterio
		//questo potrebbe crearmi problemi nel momento in cui cambiassi la struttura interna del libretto
		//per esempio cambiando da ArrayList a LinkedList.
		List<Voto> risultato= new ArrayList<>();
		for(Voto v: voti) {
			if(v.getVoto()==punteggio)
				risultato.add(v);
		}
		return risultato;
	}
	
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato= new Libretto();
		for(Voto v: voti) {
			if(v.getVoto()==punteggio)
				risultato.add(v);
		}
		return risultato;
		//restituisce un nuovo libretto che contiene solo i voti pari al punteggio
	}
	/**
	 * Ricerca voto corrispondente del corso di cui è specificato il nome
	 * se il corso non esiste restituisce null.
	 * @param nomeCorso
	 * @return
	 */
	public Voto ricercaVoto(String nomeCorso) {
		Voto risultato=null;
		for(Voto v: voti) {
			if(v.getNome().equals(nomeCorso)) {
				risultato=v;
				break;
			}
		}
		return risultato;
	}
	
	public String toString() {
		String s="";
		for(Voto v: voti) {
			s+=v.toString()+"\n";
		}
		return s;
	}
}
