package com.codelupo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codelupo.model.Prestamos;
import com.codelupo.model.Socios;
import com.codelupo.model.VideoGames;

/**
 * Servlet implementation class Prestamos
 */
@WebServlet("/Prestamos")
public class PrestamosInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Controller cont = new Controller();
	List<Prestamos> prestamos;
	List<VideoGames> videogames;
	List<Socios> socios;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrestamosInicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		prestamos = cont.getAllLoans();
		videogames = cont.getAllGames();
		socios = cont.getAllPartners();
		request.setAttribute("prestamos", prestamos);
		request.setAttribute("juegos", videogames);
		request.setAttribute("socios", socios);
		RequestDispatcher rd = request.getRequestDispatcher("views/prest.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
