package com.codelupo.views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.codelupo.controller.ActionListeners;

public class MainFrame extends JFrame {
	
	private MenuFrame menu;
	private PartnerFrame partners;
	private GamesFrame games;
	
	public MainFrame(ActionListeners action) throws HeadlessException {
		super();
		
		this.setTitle("Video Club Lupo Xan");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setResizable(false);
		JPanel contenedor = new JPanel();
		contenedor.setLayout(new CardLayout(10, 10));
		contenedor.setBackground(Color.DARK_GRAY);
		this.setContentPane(contenedor);
		
		menu = new MenuFrame(action);
		contenedor.add(menu);
		
		partners = new PartnerFrame();
		contenedor.add(partners);
		
		games = new GamesFrame();
		contenedor.add(games);
	}

	public MenuFrame getMenu() {
		return menu;
	}

	public void setMenu(MenuFrame menu) {
		this.menu = menu;
	}

	public PartnerFrame getPartners() {
		return partners;
	}

	public void setPartners(PartnerFrame partners) {
		this.partners = partners;
	}

	public GamesFrame getGames() {
		return games;
	}

	public void setGames(GamesFrame games) {
		this.games = games;
	}

}
