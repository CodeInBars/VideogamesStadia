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
import javax.swing.JTextField;

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
			if (checkFields(mainframe.getPartners().dniField, mainframe.getPartners().nameField,
					mainframe.getPartners().surnameField, mainframe.getPartners().countField)) {
				if (!videoclub.addPartners(new Socios(mainframe.getPartners().dniField.getText(),
						mainframe.getPartners().nameField.getText(), mainframe.getPartners().surnameField.getText(),
						mainframe.getPartners().countField.getText()))) {
					JOptionPane.showMessageDialog(null, "Error al añadir el socio");
				} else {
					clean();
					mainframe.getPartners().fillTable(videoclub.getAllPartners());

				}
			} else {
				JOptionPane.showMessageDialog(null, "Rellena los campos antes de añadir el socio");
			}
			break;
		case "deletePartner":
			boolean flag = true;
			List<Prestamos> prestamos;
			if (checkFields(mainframe.getPartners().dniField, mainframe.getPartners().nameField,
					mainframe.getPartners().surnameField, mainframe.getPartners().countField)) {

				Socios s = videoclub.selectPartnerByCode(new Socios(mainframe.getPartners().dniField.getText(),
						mainframe.getPartners().nameField.getText(), mainframe.getPartners().surnameField.getText(),
						mainframe.getPartners().countField.getText()));

				prestamos = videoclub.selectLoanByCode(s);

				for (Prestamos p : prestamos) {
					if (p.getFechaDevolucion() == null) {
						flag = false;
						break;
					}
				}
				if (flag) {
					if (!videoclub.removePartners(s)) {
						JOptionPane.showMessageDialog(null, "Error al borrar el socio");
					} else {
						clean();
						mainframe.getPartners().fillTable(videoclub.getAllPartners());

					}
				} else {
					JOptionPane.showMessageDialog(null, "El socio aún tiene préstamos pendientes");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Rellena los campos");
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
			if (checkFields(mainframe.getGames().codeField, mainframe.getGames().nameField,
					mainframe.getGames().sinopsisField)) {
				if (!videoclub.addVideoGame(new VideoGames(0, mainframe.getGames().nameField.getText(),
						mainframe.getGames().sinopsisField.getText()))) {
					JOptionPane.showMessageDialog(null, "Error al añadir el juego");
				} else {
					clean();
					mainframe.getGames().fillTable(videoclub.getAllGames());

				}
			} else {
				JOptionPane.showMessageDialog(null, "Rellenar los campos antes de añadir");
			}

			break;
		case "deleteGame":
			flag = true;
			if (checkFields(mainframe.getGames().codeField, mainframe.getGames().nameField,
					mainframe.getGames().sinopsisField)) {
				VideoGames vg = videoclub.selectGameByCode(new VideoGames(
						Integer.parseInt(mainframe.getGames().codeField.getText()),
						mainframe.getGames().nameField.getText(), mainframe.getGames().sinopsisField.getText()));

				prestamos = videoclub.selectLoanByCode(vg);

				for (Prestamos p : prestamos) {
					if (p.getFechaDevolucion() == null) {
						flag = false;
						break;
					}
				}

				if (flag) {
					if (!videoclub.removeVideoGame(vg)) {
						JOptionPane.showMessageDialog(null, "Error al borrar el juego");
					} else {
						clean();
						mainframe.getGames().fillTable(videoclub.getAllGames());

					}
				} else {
					JOptionPane.showMessageDialog(null, "Alguien tiene el juego sin devolver aún");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Rellenar los campos antes de borrar");
			}
			break;
		case "editGame":
			if (checkFields(mainframe.getGames().codeField, mainframe.getGames().nameField,
					mainframe.getGames().sinopsisField)) {
				if (!videoclub.updateVideoGame(new VideoGames(
						Integer.parseInt(mainframe.getGames().codeField.getText()),
						mainframe.getGames().nameField.getText(), mainframe.getGames().sinopsisField.getText()))) {
					JOptionPane.showMessageDialog(null, "Error al editar el juego");
				} else {
					clean();
					mainframe.getGames().fillTable(videoclub.getAllGames());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Rellenar los campos antes de editar");
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
				if (!videoclub.addLoan(new Prestamos((Socios) mainframe.getLoans().partnersBox.getSelectedItem(),
						(VideoGames) mainframe.getLoans().gamesBox.getSelectedItem(), new Date(), null))) {
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
				if (!videoclub.updateLoan(new Prestamos(socio, game,
						new SimpleDateFormat("yyyy-MM-dd").parse(mainframe.getLoans().gamesTable.getModel()
								.getValueAt(mainframe.getLoans().gamesTable.getSelectedRow(), 2).toString()),
						new Date()))) {
					JOptionPane.showMessageDialog(null, "Error al devolver el juego");
				} else {
					mainframe.getLoans().fillTable(videoclub.getAllLoans());
				}
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "Error, la fecha no es correcta");
			} catch (ArrayIndexOutOfBoundsException e2) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar primero un préstamo");
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

	private boolean checkFields(JTextField... fields) {
		boolean res = true;
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getText().equals("")) {
				res = false;
				break;
			}
		}
		return res;
	}

}
