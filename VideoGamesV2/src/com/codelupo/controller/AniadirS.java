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
 * Servlet implementation class AniadirG
 */
@WebServlet("/AniadirS")
public class AniadirS extends HttpServlet {
	
	Controller cont = new Controller();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AniadirS() {
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
		String account = request.getParameter("account");
		Socios soc = new Socios(dni, name, surname, account);
		cont.addPartners(soc);
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
