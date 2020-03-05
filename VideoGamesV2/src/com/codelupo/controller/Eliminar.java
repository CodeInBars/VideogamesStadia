package com.codelupo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codelupo.model.Prestamos;
import com.codelupo.model.VideoGames;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<Prestamos> presta;
	Controller cont = new Controller();
	VideoGames vid;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Boolean s = false;
		String id = request.getParameter("id");
		vid = cont.selectGameByCode(id);
		presta = cont.getAllLoans();
		try {
			
			for(int i=0; i<presta.size(); i++) {
				boolean flag = false;
				if(presta.get(i).getfDevolucion() == null) {
					flag = true;
				}
				if((presta.get(i).getCodigo() == vid.getCode()) && flag) {
					s = true;
				}
			}
			if(!s) {
				cont.removeLoans(vid);
				cont.removeVideoGame(vid);
				
				RequestDispatcher rd = request.getRequestDispatcher("/inicio");
				rd.forward(request, response);
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
			    out.println("<script type=\"text/javascript\">");
			    out.println("alert('Este videojuegos tiene prestamos sin entregar');");
			    out.println("location.href='../VideoGamesV2/inicio'");
			    out.println("</script>");
				//RequestDispatcher rd = request.getRequestDispatcher("/inicio");
				//rd.forward(request, response);
			}
			
		}catch(Exception e) {
			cont.removeVideoGame(vid);
			RequestDispatcher rd = request.getRequestDispatcher("/inicio");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
