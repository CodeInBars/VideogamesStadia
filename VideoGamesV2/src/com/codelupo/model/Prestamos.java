package com.codelupo.model;

import java.util.Date;
import java.util.ArrayList;

public class Prestamos {
	
	private String dni;
	private int codigo;
	private Date fechaPrestamo;
	private Date fDevolucion;

	
	public Prestamos() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Prestamos(String dni, int id, Date fPrestamo, Date fDevolucion) {
		super();
		this.dni = dni;
		this.codigo = id;
		this.fechaPrestamo = fPrestamo;
		this.fDevolucion = fDevolucion;
	}


	


	public Prestamos(String dni, int id, Date fPrestamo) {
		super();
		this.dni = dni;
		this.codigo = id;
		this.fechaPrestamo = fPrestamo;
	}



	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}


	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}


	/**
	 * @return the id
	 */
	public int getCodigo() {
		return codigo;
	}


	/**
	 * @param id the id to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	/**
	 * @return the fPrestamo
	 */
	public Date getfechaPrestamo() {
		return fechaPrestamo;
	}


	/**
	 * @param fPrestamo the fPrestamo to set
	 */
	public void setfechaPrestamo(Date fPrestamo) {
		this.fechaPrestamo = fPrestamo;
	}


	/**
	 * @return the fDevolucion
	 */
	public Date getfDevolucion() {
		return fDevolucion;
	}


	/**
	 * @param fDevolucion the fDevolucion to set
	 */
	public void setfDevolucion(Date fDevolucion) {
		this.fDevolucion = fDevolucion;
	}


	

	

	

}
