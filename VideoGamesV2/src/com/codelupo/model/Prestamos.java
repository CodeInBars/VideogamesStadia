package com.codelupo.model;

import java.util.ArrayList;

public class Prestamos {
	private Socios socios;
	private ArrayList<VideoGames> games = new ArrayList<VideoGames>();

	public Prestamos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prestamos(Socios socios, ArrayList<VideoGames> games) {
		super();
		this.socios = socios;
		this.games = games;
	}

	public Socios getSocios() {
		return socios;
	}

	public void setSocios(Socios socios) {
		this.socios = socios;
	}

	public ArrayList<VideoGames> getGames() {
		return games;
	}

	public void setGames(ArrayList<VideoGames> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "Socios: " + socios + "\tGames: " + games;
	}

}
