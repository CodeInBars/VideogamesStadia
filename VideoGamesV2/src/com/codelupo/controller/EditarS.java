package com.codelupo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codelupo.model.Socios;
import com.codelupo.model.VideoGames;

/**
 * Servlet implementation class EditarG
 */
@WebServlet("/EditarS")
public class EditarS extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Controller cont = new Controller();
    Socios vid;
    List<Socios> vids = new ArrayList<Socios>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dni = request.getParameter("dni");
		System.out.println(dni);
		vid = cont.selectPartnerByCode(dni);
		vids.removeAll(vids);
		vids.add(vid);
		request.setAttribute("socios", vids);
		RequestDispatcher rd = request.getRequestDispatcher("views/editS.jsp");
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
