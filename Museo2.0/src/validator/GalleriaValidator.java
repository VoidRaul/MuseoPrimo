package validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Galleria;
import service.GalleriaService;

public class GalleriaValidator {
	public boolean validate(HttpServletRequest request, HttpServletResponse response){
		String s1,s2,s3,s4;
		GalleriaService gs = new GalleriaService();
		boolean verify = true;
		Galleria gallery;
		s3 = request.getParameter("nome");
		gallery=(Galleria) request.getAttribute("galleria");
		HttpSession session =request.getSession();
		
		
		if(s3==null||s3.equals("")||s3.equals(" ")){
			request.setAttribute("errNonInserito", "Il nome è un campo richiesto deve essere formato da almeno una lettera");
			return false;
		}
		if(s3.contains("-")||s3.contains("!")||s3.contains("_")||s3.contains(".")||s3.contains(":")||s3.contains(";")||s3.contains(",")||s3.contains("^")){
			request.setAttribute("errSpecialChar", "Il nome non può contenere caratteri speciali");
			return false;
		}
		s1=request.getParameter("nome").substring(0, 1).toUpperCase();
		s2=request.getParameter("nome").substring(1).toLowerCase();
		s4=s1+s2;
		
		session.setAttribute("nomeValidato",s4);
		if (gs.existGalleria(s4))
			session.setAttribute("errNomeGalleriaPreso", "Il nome specificato è già in uso");
		
		
		gallery.setNome(s4);

		return verify;

	}
}


