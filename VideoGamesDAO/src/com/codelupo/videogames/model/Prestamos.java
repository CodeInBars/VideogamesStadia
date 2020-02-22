package com.codelupo.videogames.model;

import java.util.Date;

/**
 * Loans Class
 * 
 * @author lupo.xan
 * @since 22/02/2020
 */
public class Prestamos {
	private Socios socios;
	private VideoGames games;
	private Date fechaPrestamo;
	private Date fechaDevolucion;

	public Prestamos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prestamos(Socios socios, VideoGames games, Date fechaPrestamo, Date fechaDevolucion) {
		super();
		this.socios = socios;
		this.games = games;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
	}

	public Socios getSocios() {
		return socios;
	}

	public void setSocios(Socios socios) {
		this.socios = socios;
	}

	public VideoGames getGames() {
		return games;
	}

	public void setGames(VideoGames games) {
		this.games = games;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	@Override
	public String toString() {
		return "Socio: " + socios + "\tGame: " + games + "\tFecha del préstamo:" + fechaPrestamo
				+ "\tFecha de devolución: " + fechaDevolucion;
	}

}