package com.codelupo.views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.codelupo.controller.ActionListeners;
import com.codelupo.videogames.controller.Controller;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuFrame menu;
	private PartnerFrame partners;
	private GamesFrame games;
	private LoanFrame loans;
	
	public MainFrame(ActionListeners action, Controller videoclub) throws HeadlessException {
		super();
		
		try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		this.setTitle("Video Club Lupo Xan");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setResizable(false);
		JPanel container = new JPanel();
		container.setLayout(new CardLayout(10, 10));
		container.setBackground(Color.DARK_GRAY);
		this.setContentPane(container);
		
		menu = new MenuFrame(action);
		container.add(menu);
		
		partners = new PartnerFrame(action);
		container.add(partners);
		
		games = new GamesFrame(action);
		container.add(games);
		
		loans = new LoanFrame(action,videoclub);
		container.add(loans);
		
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

	public LoanFrame getLoans() {
		return loans;
	}

	public void setLoans(LoanFrame loans) {
		this.loans = loans;
	}

}
