package com.codelupo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codelupo.model.Prestamos;

/**
 * Servlet implementation class Devolver
 */
@WebServlet("/devolver")
public class Devolver extends HttpServlet {
	
	Controller cont = new Controller();
	Prestamos prest = new Prestamos();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Devolver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String dni = request.getParameter("dni");
		prest.setDni(dni);
		prest.setCodigo(Integer.parseInt(id));
		cont.updateLoan(prest);
		
		RequestDispatcher rd = request.getRequestDispatcher("../VideoGamesV2/Prestamos");
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
