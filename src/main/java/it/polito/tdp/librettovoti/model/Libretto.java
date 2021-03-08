package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti= new ArrayList<>(); //faccio l'inizializzazione qua e sopra la dichiarazione in modo che
		                              //se volessi cambiare la tipologia di struttura posso farlo in qualsiasi momento e il programma di adatta
		
	}
	public void add(Voto voto) {
		this.voti.add(voto);
	}
	
	public String toString() {
		String s="";
		for(Voto v: voti) {
			s+=v.toString()+"\n";
		}
		return s;
	}
}
