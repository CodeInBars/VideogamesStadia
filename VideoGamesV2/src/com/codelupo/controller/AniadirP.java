package com.codelupo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codelupo.model.Prestamos;

/**
 * Servlet implementation class AniadirP
 */
@WebServlet("/AniadirP")
public class AniadirP extends HttpServlet {
	
	Controller cont = new Controller();
	Prestamos prest;
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

		
		
		try {
			
			String dni = request.getParameter("dni");
			String id = request.getParameter("id");
			String fPrestamo = request.getParameter("fechaprestamo");			
			DateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date1= dFormat.parse(fPrestamo);
			prest = new Prestamos(dni, Integer.parseInt(id), date1);
			cont.addLoan(prest);
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamos");
			rd.forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
