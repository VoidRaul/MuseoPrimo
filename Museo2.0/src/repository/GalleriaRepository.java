package repository;

import java.util.List;

import javax.persistence.EntityManager;

import model.Galleria;

public class GalleriaRepository extends CrudRepositoryJPA<Galleria> {
	public GalleriaRepository(EntityManager em){
		super(em,Galleria.class);
	}
//	public boolean existGalleria(String gal){
//		List<Galleria> galleria = this.findAll();
//		if(galleria.isEmpty()){
//			return false;
//		}
//		for(Galleria gall : galleria){
//			if(gall.getNome().equals(gal))
//				return true;
//		}
//		return false;
//		
//	}
}
