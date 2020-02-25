package com.codelupo.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

import com.codelupo.videogames.controller.Controller;
import com.codelupo.videogames.model.Prestamos;
import com.codelupo.videogames.model.Socios;
import com.codelupo.videogames.model.VideoGames;
import com.codelupo.views.MainFrame;

public class ActionListeners implements ActionListener {

	Controller videoclub;
	MainFrame mainframe;

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
				JOptionPane.showMessageDialog(null, "Error al añadir el socio");
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
				JOptionPane.showMessageDialog(null, "Error al añadir el juego");
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
			break;
		case "addLoan":
			try {
				if (!videoclub.addLoan(new Prestamos((Socios)mainframe.getLoans().partnersBox.getSelectedItem(),(VideoGames)mainframe.getLoans().gamesBox.getSelectedItem(),new SimpleDateFormat("yyyy-MM-dd").parse(mainframe.getLoans().gamesTable.getModel().getValueAt(mainframe.getLoans().gamesTable.getSelectedRow(), 2).toString()), new SimpleDateFormat("yyyy-MM-dd").parse(mainframe.getLoans().giveItBackField.getText())))){
					JOptionPane.showMessageDialog(null, "Error al prestar el juego");
				} else {
					clean();
					System.out.println("Todo ok");
					mainframe.getLoans().fillTable(videoclub.getAllLoans());
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "giveBackGame":
			
			break;
		case "changePartner":
			mainframe.getLoans().partnersBox.setSelectedIndex(1);
			break;
		case "changeGame":
			
			break;
		case "backtomenu":
			mainframe.getPartners().setVisible(false);
			mainframe.getGames().setVisible(false);
			mainframe.getLoans().setVisible(false);
			mainframe.getMenu().setVisible(true);
			break;
		case "clean":
			clean();
			break;
		case "exit":
			System.exit(0);
			break;

		}
	}

	private void clean() {
		mainframe.getPartners().dniField.setText("");
		mainframe.getPartners().nameField.setText("");
		mainframe.getPartners().surnameField.setText("");
		mainframe.getPartners().countField.setText("");

		mainframe.getGames().codeField.setText("");
		mainframe.getGames().nameField.setText("");
		mainframe.getGames().sinopsisField.setText("");
		
		mainframe.getLoans().giveItBackField.setText("");
	}

}
