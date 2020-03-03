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

import com.codelupo.model.VideoGames;

/**
 * Servlet implementation class EditarG
 */
@WebServlet("/EditarG")
public class EditarG extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Controller cont = new Controller();
    VideoGames vid;
    List<VideoGames> vids = new ArrayList<VideoGames>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarG() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		vid = cont.selectGameByCode(id);
		vids.removeAll(vids);
		vids.add(vid);

		request.setAttribute("games", vids);
		RequestDispatcher rd = request.getRequestDispatcher("views/editG.jsp");
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
