package com.codelupo.videogames.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.codelupo.videogames.model.Prestamos;
import com.codelupo.videogames.model.Socios;
import com.codelupo.videogames.model.VideoGames;

/**
 * Dao Class for VideoGamesStadia Project
 * 
 * @author lupo.xan
 * @since 22/02/2020
 */
public class Controller {
	Connection conexion = null;

	//private String url = "jdbc:mysql://localhost:5432/videogames";
	private String url = "jdbc:mysql://localhost:3306/videogames";

	private String usuario = "root";
	private String clave = "root";

	/**
	 * Controller builder
	 */
	public Controller() {
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conexion = DriverManager.getConnection(url, usuario, clave);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Controller builder
	 * 
	 * @param conexion Connection to database
	 */
	public Controller(Connection conexion) {
		super();
		this.conexion = conexion;
	}

	/**
	 * Get connection from database
	 * 
	 * @return Connection to database
	 */
	public Connection getConexion() {
		return conexion;
	}

	/**
	 * Set connection to database
	 * 
	 * @param conexion Connection to database
	 */
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	/**
	 * Close connection to database
	 */
	public void cerrar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/***************************************/
	/************* VideoGames **************/
	/***************************************/
	
	/**
	 * Get a game selected by it code
	 * @param gameCode Object VideoGames
	 * @return The selected game
	 */
	public VideoGames selectGameByCode(VideoGames gameCode) {
		VideoGames game = null;

		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from games where codigo = ?");

			sentencia.setInt(1, gameCode.getCode());

			ResultSet rs = sentencia.executeQuery();
			if (rs.next()) {
				game = new VideoGames(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return game;
	}

	/**
	 * Get all the games stored
	 * @return List of games
	 */
	public List<VideoGames> getAllGames() {
		List<VideoGames> videogames = new ArrayList<VideoGames>();

		try {
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery("select * from games");
			while (rs.next()) {
				videogames.add(new VideoGames(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return videogames;
	}

	/**
	 * Add a video game to database
	 * @param game The game to be stored
	 * @return If false --> Something큦 wrong
	 */
	public boolean addVideoGame(VideoGames game) {
		boolean res = false;

		try {
			PreparedStatement sentencia = conexion.prepareStatement("insert into games values (null, ?, ?)");

			sentencia.setString(1, game.getName());
			sentencia.setString(2, game.getSinopsis());

			if (sentencia.executeUpdate() == 1) {
				res = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * Delete game from database
	 * @param game The game to be removed
	 * @return If false --> Something큦 wrong
	 */
	public boolean removeVideoGame(VideoGames game) {
		boolean res = false;

		try {
			PreparedStatement sentencia = conexion.prepareStatement("delete from games where codigo = ?");

			sentencia.setInt(1, game.getCode());

			if (sentencia.executeUpdate() == 1) {
				res = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * Update game from database
	 * @param game The game to be updated
	 * @return If false --> Something큦 wrong
	 */
	public boolean updateVideoGame(VideoGames game) {
		boolean res = false;

		try {
			PreparedStatement sentencia = conexion
					.prepareStatement("update games set nombre = ?, sinopsis = ? where codigo = ?");

			sentencia.setString(1, game.getName());
			sentencia.setString(2, game.getSinopsis());
			sentencia.setInt(3, game.getCode());

			if (sentencia.executeUpdate() == 1) {
				res = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	/***************************************/
	/************** Partners ***************/
	/***************************************/
	
	/**
	 * Get a partner selected by it code
	 * @param partnerCode Object Socios
	 * @return The selected Socios
	 */
	public Socios selectPartnerByCode(Socios partnerCode) {
		Socios socio = null;

		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from socios where dni = ?");

			sentencia.setString(1, partnerCode.getDni());

			ResultSet rs = sentencia.executeQuery();
			if (rs.next()) {
				socio = new Socios(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return socio;
	}

	/**
	 * Get all the partners stored
	 * @return List of partners
	 */
	public List<Socios> getAllPartners() {
		List<Socios> partners = new ArrayList<Socios>();

		try {
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery("select * from socios");
			while (rs.next()) {
				partners.add(new Socios(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return partners;
	}

	/**
	 * Add a partner to database
	 * @param partner The partner to be stored
	 * @return If false --> Something큦 wrong
	 */
	public boolean addPartners(Socios partner) {
		boolean res = false;

		try {
			PreparedStatement sentencia = conexion.prepareStatement("insert into socios values (?, ?, ?, ?)");

			sentencia.setString(1, partner.getDni());
			sentencia.setString(2, partner.getName());
			sentencia.setString(3, partner.getSurname());
			sentencia.setString(4, partner.getCuenta());

			if (sentencia.executeUpdate() == 1) {
				res = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * Delete partner from database
	 * @param partner The partner to be removed
	 * @return If false --> Something큦 wrong
	 */
	public boolean removePartners(Socios partner) {
		boolean res = false;

		try {
			PreparedStatement sentencia = conexion.prepareStatement("delete from socios where dni = ?");

			sentencia.setString(1, partner.getDni());

			if (sentencia.executeUpdate() == 1) {
				res = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * Update partner from database
	 * @param partner The partner to be updated
	 * @return If false --> Something큦 wrong
	 */
	public boolean updatePartner(Socios partner) {
		boolean res = false;

		try {
			PreparedStatement sentencia = conexion.prepareStatement("update socios set nombre = ?, apellidos = ?, tarjetaBancaria = ? where dni = ?");

			sentencia.setString(1, partner.getName());
			sentencia.setString(2, partner.getSurname());
			sentencia.setString(3, partner.getCuenta());
			sentencia.setString(4, partner.getDni());

			if (sentencia.executeUpdate() == 1) {
				res = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	/***************************************/
	/**************** Loans ****************/
	/***************************************/
	
	/**
	 * Get loans selected by partner code
	 * @param partnerCode Object Socios
	 * @return Partner큦 loans
	 */
	public List<Prestamos> selectLoanByCode(Socios partnerCode) {
		List<Prestamos> prestamos = new ArrayList<Prestamos>();
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from prestamos where dni = ?");

			sentencia.setString(1, partnerCode.getDni());

			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {
				prestamos.add(new Prestamos(this.selectPartnerByCode(new Socios(rs.getString(1),null,null,null)),this.selectGameByCode(new VideoGames(rs.getInt(2),null,null)),rs.getDate(3),rs.getDate(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prestamos;
	}

	/**
	 * Get all the loans stored
	 * @return List of Loans
	 */
	public List<Prestamos> getAllLoans() {
		List<Prestamos> loans = new ArrayList<Prestamos>();

		try {
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia.executeQuery("select * from prestamos");
			while (rs.next()) {
				loans.add(new Prestamos(this.selectPartnerByCode(new Socios(rs.getString(1),null,null,null)),this.selectGameByCode(new VideoGames(rs.getInt(2),null,null)),rs.getDate(3),rs.getDate(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return loans;
	}

	/**
	 * Add a loan to database
	 * @param loan The loan to be stored
	 * @return If false --> Something큦 wrong
	 */
	public boolean addLoan(Prestamos loan) {
		boolean res = false;

		try {
			PreparedStatement sentencia = conexion.prepareStatement("insert into prestamos values (?, ?, ?, null)");

			sentencia.setString(1, loan.getSocios().getDni());
			sentencia.setInt(2, loan.getGames().getCode());
			sentencia.setDate(3, new java.sql.Date(new Date().getTime()));

			if (sentencia.executeUpdate() == 1) {
				res = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * Update loan from database
	 * @param loan The loan to be updated
	 * @return If false --> Something큦 wrong
	 */
	public boolean updateLoan(Prestamos loan) {
		boolean res = false;
		
		try {
			PreparedStatement sentencia = conexion.prepareStatement("update prestamos set fechaDevolucion = ? where dni = ? and codigo = ? and fechaPrestamo = ?");

			sentencia.setDate(1, new java.sql.Date(new Date().getTime()));
			sentencia.setString(2, loan.getSocios().getDni());
			sentencia.setInt(3, loan.getGames().getCode());
			sentencia.setDate(4, new java.sql.Date(loan.getFechaPrestamo().getTime()));

			if (sentencia.executeUpdate() == 1) {
				res = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public List<String> getLoansDates(Socios partner, VideoGames game){
		List<String> dates = new ArrayList<String>();

		try {
			PreparedStatement sentencia = conexion.prepareStatement("select fechaPrestamo from prestamos where dni = ? and codigo = ?");
			
			sentencia.setString(1, partner.getDni());
			sentencia.setInt(2, game.getCode());
			
			ResultSet rs = sentencia.executeQuery();

			while (rs.next()) {
				dates.add(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dates;
	}

}
