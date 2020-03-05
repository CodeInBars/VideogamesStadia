package com.codelupo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codelupo.model.Socios;
import com.codelupo.model.VideoGames;

/**
 * Servlet implementation class EditarFG
 */
@WebServlet("/EditarFS")
public class EditarFS extends HttpServlet {
	Controller cont = new Controller();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarFS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dni = request.getParameter("dni");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String cuenta = request.getParameter("cuenta");
		Socios vid = new Socios(dni, name, surname, cuenta);
		
		cont.updatePartner(vid);
		RequestDispatcher rd = request.getRequestDispatcher("/SociosInicio");
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
