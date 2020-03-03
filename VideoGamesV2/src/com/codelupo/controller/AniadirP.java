package com.codelupo.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AniadirP
 */
@WebServlet("/AniadirP")
public class AniadirP extends HttpServlet {
	
	Controller cont = new Controller();
	com.codelupo.model.Prestamos prest;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AniadirP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String dni = request.getParameter("dni");
		String id = request.getParameter("codigo");
		String fPrestamo = request.getParameter("fechaprestamo");
		prest = new com.codelupo.model.Prestamos(dni, Integer.parseInt(id), new Date(fPrestamo));
		cont.addLoan(prest);
		RequestDispatcher rd = request.getRequestDispatcher("/Prestamos");
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
