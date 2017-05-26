package model;

import java.util.Date;

import javax.persistence.Entity;


@Entity
public class Quadro extends Opera{
	String tipologiaDiPittura;
	public Quadro(Date data,Artista artista, String Descrizione){
		super(data, artista);
		this.tipologiaDiPittura.equals(Descrizione);
	}
	
}
