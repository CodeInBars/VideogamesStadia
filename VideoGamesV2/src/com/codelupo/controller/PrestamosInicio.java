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

/**
 * Servlet implementation class Prestamos
 */
@WebServlet("/Prestamos")
public class PrestamosInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Controller cont = new Controller();
	List<Prestamos> prestamos;
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
		request.setAttribute("prestamos", prestamos);
		
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
