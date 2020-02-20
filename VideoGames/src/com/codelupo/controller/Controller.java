package com.codelupo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Controller {
	Connection conexion = null;

	private String url = "jdbc:mysql://localhost:5432/videogames";
	
	private String usuario = "root";
	private String clave = "root";

	public Controller() {
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conexion = DriverManager.getConnection(url, usuario, clave);
			System.out.println("Everything is ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Controller(Connection conexion) {
		super();
		this.conexion = conexion;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public void cerrar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
