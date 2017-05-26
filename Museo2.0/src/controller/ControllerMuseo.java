package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Galleria;
import service.GalleriaService;
import validator.GalleriaValidator;

@WebServlet("/museo")
public class ControllerMuseo extends HttpServlet{

	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;

	private String nextPage = "/aggiungiGalleria.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Galleria galleria = new Galleria();
		GalleriaService gs = new GalleriaService();
		GalleriaValidator gv = new GalleriaValidator();
//		List<Galleria> gallerie = new ArrayList<Galleria>();
		request.setAttribute("galleria",galleria);
		
		if (gv.validate(request, response)){
			if (gs.existGalleria(galleria.getNome())){
				ServletContext application  = getServletContext();
				RequestDispatcher rd = application.getRequestDispatcher(nextPage);
				rd.forward(request, response);
				return; 
			}
			gs.saveGalleria(galleria);
			nextPage="/galleriaInserita.jsp";
		}
		
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 



	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
				throws ServletException, IOException{
		GalleriaService gs = new GalleriaService();
		List<Galleria> gallerie = new ArrayList<Galleria>();
		gallerie=gs.getGallerie();
		request.setAttribute("galleriePresenti", gallerie);
		nextPage="/visualizzaGallerie.jsp";

		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 
	}


}
