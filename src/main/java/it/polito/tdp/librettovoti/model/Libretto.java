package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {
	//svolge il ruolo di Model ossia gestiscono i dati
	private List<Voto> voti;
	private Map<String, Voto> votiMap; //identity map: mappa che conserva identità oggetti, quindi nomeEsame sull'oggetto voto
									
	public Libretto() {
		this.voti= new ArrayList<>(); //faccio l'inizializzazione qua e sopra la dichiarazione in modo che
		                              //se volessi cambiare la tipologia di struttura posso farlo in qualsiasi momento e il programma di adatta
		this.votiMap= new HashMap<>();
	}
	public void add(Voto voto) {
		this.voti.add(voto);
		this.votiMap.put(voto.getNome(), voto);
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
		/*Voto risultato=null;
		for(Voto v: voti) {
			if(v.getNome().equals(nomeCorso)) {
				risultato=v;
				break;
			}
		}
		return risultato;*/
		
		//CON LE MAPPE è PIù EFFICIENTE LA RICERCA
		return this.votiMap.get(nomeCorso);		
	}
	/**
	 * Verifica se nel libretto c'è gia un voto con lo stesso
	 * nome e lo stesso voto
	 * @param v
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
		/*boolean trovato=false;
		for(Voto voto: this.voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto()==v.getVoto()) {
				trovato =true;
				break;
			}
		}
		return trovato;*/
		
		//CON LE MAPPE è PIù EFFICIENTE LA RICERCA
		Voto trovato=this.votiMap.get(v.getNome());
		if(trovato==null)
			return false;
		if(trovato.getVoto()==v.getVoto()) 
			return true;
		else 
			return false;
		
	}
	/**
	 *Verifica se nel libretto c'è gia un voto con lo stesso
	 * nome ma voto diverso
	 * @param v
	 * @return
	 */
	public boolean esisteConflitto(Voto v) {
		/*boolean trovato=false;
		for(Voto voto: this.voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto()!=v.getVoto()) {
				trovato =true;
				break;
			}
		}
		return trovato;*/
		
		//CON LE MAPPE è PIù EFFICIENTE LA RICERCA
		Voto trovato=this.votiMap.get(v.getNome());
		if(trovato==null)
			return false;
		if(trovato.getVoto()!=v.getVoto()) 
			return true;
		else 
			return false;
		
	}
	
	public String toString() {
		String s="";
		for(Voto v: voti) {
			s+=v.toString()+"\n";
		}
		return s;
	}
}
