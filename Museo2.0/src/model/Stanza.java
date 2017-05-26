package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Stanza {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nomeStanza;
	@OneToMany
	private List<Opera> opereEsposte;
	
	public Stanza (String nomeStanza){
		this.nomeStanza=nomeStanza;
		this.opereEsposte=new ArrayList<Opera>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeStanza() {
		return nomeStanza;
	}

	public void setNomeStanza(String nomeStanza) {
		this.nomeStanza = nomeStanza;
	}

	public List<Opera> getOpereEsposte() {
		return opereEsposte;
	}

	public void setOpereEsposte(List<Opera> opereEsposte) {
		this.opereEsposte = opereEsposte;
	}
	
	public void addOpera(Opera opera){
		this.opereEsposte.add(opera);
	}

}
