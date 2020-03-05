package com.codelupo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	List<Prestamos> prestamo;
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

		
		prestamo = cont.getAllLoans();
		boolean s = false;
		try {
			
			String dni = request.getParameter("dni");
			String id = request.getParameter("id");
			String fPrestamo = request.getParameter("fechaprestamo");			
			DateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date1= dFormat.parse(fPrestamo);
			prest = new Prestamos(dni, Integer.parseInt(id), date1);
			
			for(int i = 0; i<prestamo.size(); i++) {
				
				if(prestamo.get(i).getDni().equalsIgnoreCase(dni)) {					
					if((prestamo.get(i).getCodigo() == (Integer.parseInt(id))) && prestamo.get(i).getfDevolucion() == null) {
						
						s = true;
					}
				}
			}
			if(!s) {
				System.out.println("AQUI");
				cont.addLoan(prest);
				RequestDispatcher rd = request.getRequestDispatcher("/Prestamos");
				rd.forward(request, response);
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
			    out.println("<script type=\"text/javascript\">");
			    out.println("alert('Este cliente tiene este videojuego sin devolver');");
			    out.println("location.href='../VideoGamesV2/Prestamos'");
			    out.println("</script>");
			}
			
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
