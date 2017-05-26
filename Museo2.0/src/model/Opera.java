package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public abstract class Opera {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date anno;
	@ManyToOne
	private Artista artista;
	
	public Opera(Date data,Artista artista){
		this.anno=data;
		this.artista=artista;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getAnno() {
		return anno;
	}
	public void setAnno(Date anno) {
		this.anno = anno;
	}
	public Artista getArtista(){
		return this.artista;
	}
	
}
