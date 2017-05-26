package service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Galleria;
import repository.CrudRepositoryJPA;
import repository.GalleriaRepository;

public class GalleriaService {
	private CrudRepositoryJPA<Galleria> gr;
	private EntityManager em;

	public GalleriaService(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("museo");
		this.em = emf.createEntityManager(); 
		this.gr = new CrudRepositoryJPA<Galleria>(this.em,Galleria.class);
	}
	public void saveGalleria(Galleria gal){
		gr.save(gal);
	}
	public boolean existGalleria(String gal){
		List<Galleria> gallerie = new ArrayList<Galleria>();
		gallerie=gr.findAll();
		if(gallerie.isEmpty()){
			return false;
		}
		for(Galleria gall : gallerie){
			if(gall.getNome().equals(gal))
				return true;
		}
		return false;


	}
	public List<Galleria> getGallerie() {
		return gr.findAll();
	}
}
