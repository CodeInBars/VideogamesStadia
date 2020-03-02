package com.codelupo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codelupo.model.Socios;
import com.codelupo.model.VideoGames;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/EliminarS")
public class EliminarS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	Controller cont = new Controller();
	Socios soc;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dni = request.getParameter("dni");
		soc = cont.selectPartnerByCode(dni);
		System.out.println(dni);
		cont.removePartners(soc);
		RequestDispatcher rd = request.getRequestDispatcher("/SociosInicio");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
