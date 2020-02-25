package com.codelupo.videogames.model;

/**
 * VideoGames Class
 * 
 * @author lupo.xan
 * @since 22/02/2020
 */
public class VideoGames {
	private int code;
	private String name;
	private String sinopsis;

	public VideoGames() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideoGames(int code, String name, String sinopsis) {
		super();
		this.code = code;
		this.name = name;
		this.sinopsis = sinopsis;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	@Override
	public String toString() {
		return name;
	}

}
