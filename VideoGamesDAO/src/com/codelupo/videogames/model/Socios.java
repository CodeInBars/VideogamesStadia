package com.codelupo.videogames.model;

/**
 * Partners Class
 * 
 * @author lupo.xan
 * @since 22/02/2020
 */
public class Socios {
	private String dni;
	private String name;
	private String surname;
	private String cuenta;

	public Socios() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Socios(String dni, String name, String surname, String cuenta) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.cuenta = cuenta;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Dni: " + dni + "\tName: " + name + "\tSurname: " + surname + "\tCuenta: " + cuenta;
	}

}
