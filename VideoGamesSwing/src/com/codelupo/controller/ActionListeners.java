package com.codelupo.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import com.codelupo.videogames.controller.Controller;
import com.codelupo.videogames.model.Prestamos;
import com.codelupo.videogames.model.Socios;
import com.codelupo.videogames.model.VideoGames;
import com.codelupo.views.MainFrame;

public class ActionListeners implements ActionListener {

	Controller videoclub;
	MainFrame mainframe;
	Socios socio;
	VideoGames game;

	public ActionListeners() {
		super();
	}

	public ActionListeners(Controller videoclub) {
		super();
		this.videoclub = videoclub;
	}

	public Controller getVideoclub() {
		return videoclub;
	}

	public void setVideoclub(Controller videoclub) {
		this.videoclub = videoclub;
	}

	public MainFrame getMainframe() {
		return mainframe;
	}

	public void setMainframe(MainFrame mainframe) {
		this.mainframe = mainframe;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "partners":
			mainframe.getMenu().setVisible(false);
			mainframe.getPartners().setVisible(true);
			mainframe.getPartners().fillTable(videoclub.getAllPartners());
			break;
		case "addPartner":
			if (!videoclub.addPartners(new Socios(mainframe.getPartners().dniField.getText(),
					mainframe.getPartners().nameField.getText(), mainframe.getPartners().surnameField.getText(),
					mainframe.getPartners().countField.getText()))) {
				JOptionPane.showMessageDialog(null, "Error al a�adir el socio");
			} else {
				clean();
				mainframe.getPartners().fillTable(videoclub.getAllPartners());
				
			}
			break;
		case "deletePartner":
			if (!videoclub.removePartners(new Socios(mainframe.getPartners().dniField.getText(),
					mainframe.getPartners().nameField.getText(), mainframe.getPartners().surnameField.getText(),
					mainframe.getPartners().countField.getText()))) {
				JOptionPane.showMessageDialog(null, "Error al borrar el socio");
			} else {
				clean();
				mainframe.getPartners().fillTable(videoclub.getAllPartners());
				
			}
			break;
		case "editPartner":
			if (!videoclub.updatePartner(new Socios(mainframe.getPartners().dniField.getText(),
					mainframe.getPartners().nameField.getText(), mainframe.getPartners().surnameField.getText(),
					mainframe.getPartners().countField.getText()))) {
				JOptionPane.showMessageDialog(null, "Error al editar el socio");
			} else {
				clean();
				mainframe.getPartners().fillTable(videoclub.getAllPartners());
				
			}
			break;
		case "games":
			mainframe.getMenu().setVisible(false);
			mainframe.getGames().setVisible(true);
			mainframe.getGames().fillTable(videoclub.getAllGames());
			break;
		case "addGame":
			if (!videoclub.addVideoGame(new VideoGames(0, mainframe.getGames().nameField.getText(),
					mainframe.getGames().sinopsisField.getText()))) {
				JOptionPane.showMessageDialog(null, "Error al a�adir el juego");
			} else {
				clean();
				mainframe.getGames().fillTable(videoclub.getAllGames());
				
			}
			break;
		case "deleteGame":
			if (!videoclub.removeVideoGame(new VideoGames(Integer.parseInt(mainframe.getGames().codeField.getText()),
					mainframe.getGames().nameField.getText(), mainframe.getGames().sinopsisField.getText()))) {
				JOptionPane.showMessageDialog(null, "Error al borrar el juego");
			} else {
				clean();
				mainframe.getGames().fillTable(videoclub.getAllGames());
				
			}
			break;
		case "editGame":
			if (!videoclub.updateVideoGame(new VideoGames(Integer.parseInt(mainframe.getGames().codeField.getText()),
					mainframe.getGames().nameField.getText(), mainframe.getGames().sinopsisField.getText()))) {
				JOptionPane.showMessageDialog(null, "Error al editar el juego");
			} else {
				clean();
				mainframe.getGames().fillTable(videoclub.getAllGames());
				
			}
			break;
		case "loans":
			mainframe.getMenu().setVisible(false);
			mainframe.getLoans().setVisible(true);
			mainframe.getLoans().fillTable(videoclub.getAllLoans());
			refreshComboBox();
			break;
		case "addLoan":
			try {
				if (!videoclub.addLoan(new Prestamos((Socios) mainframe.getLoans().partnersBox.getSelectedItem(),(VideoGames) mainframe.getLoans().gamesBox.getSelectedItem(),new Date(), null))){
					JOptionPane.showMessageDialog(null, "Error al prestar el juego");
				} else {
					clean();
					mainframe.getLoans().fillTable(videoclub.getAllLoans());
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "giveBackGame":
			try {
				if(!videoclub.updateLoan(new Prestamos(socio,game,new SimpleDateFormat("yyyy-MM-dd").parse(mainframe.getLoans().gamesTable.getModel().getValueAt(mainframe.getLoans().gamesTable.getSelectedRow(), 2).toString()),new Date()))) {
					JOptionPane.showMessageDialog(null, "Error al devolver el juego");
				} else {
					mainframe.getLoans().fillTable(videoclub.getAllLoans());
				}
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "changePartner":
			socio = (Socios) mainframe.getLoans().partnersBox.getSelectedItem();
			break;
		case "changeGame":
			game = (VideoGames) mainframe.getLoans().gamesBox.getSelectedItem();
			break;
		case "backtomenu":
			back();
			break;
		case "clean":
			clean();
			break;
		case "exit":
			System.exit(0);
			break;

		}
	}
	
	private void back() {
		mainframe.getPartners().setVisible(false);
		mainframe.getGames().setVisible(false);
		mainframe.getLoans().setVisible(false);
		mainframe.getMenu().setVisible(true);
	}
	
	private void refreshComboBox() {
		List<VideoGames> juegos = videoclub.getAllGames();
		VideoGames[] modelComboGames = new VideoGames[juegos.size()];
		for (int i = 0; i < juegos.size(); i++) {
			modelComboGames[i] = juegos.get(i);
		}
		mainframe.getLoans().setGamesModelBox(new DefaultComboBoxModel<VideoGames>(modelComboGames));
		mainframe.getLoans().gamesBox.setModel(mainframe.getLoans().getGamesModelBox());
		
		List<Socios> socios = videoclub.getAllPartners();
		Socios[] modelCombo = new Socios[socios.size()];
		for (int i = 0; i < socios.size(); i++) {
			modelCombo[i] = socios.get(i);
		}
		mainframe.getLoans().setPartnersModel(new DefaultComboBoxModel<Socios>(modelCombo));
		mainframe.getLoans().partnersBox.setModel(mainframe.getLoans().getPartnersModel());
	}

	private void clean() {
		mainframe.getPartners().dniField.setText("");
		mainframe.getPartners().nameField.setText("");
		mainframe.getPartners().surnameField.setText("");
		mainframe.getPartners().countField.setText("");

		mainframe.getGames().codeField.setText("");
		mainframe.getGames().nameField.setText("");
		mainframe.getGames().sinopsisField.setText("");
	}

}
