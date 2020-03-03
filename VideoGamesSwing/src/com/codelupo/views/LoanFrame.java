package com.codelupo.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.codelupo.controller.ActionListeners;
import com.codelupo.main.BackGround;
import com.codelupo.videogames.controller.Controller;
import com.codelupo.videogames.model.Prestamos;
import com.codelupo.videogames.model.Socios;
import com.codelupo.videogames.model.VideoGames;

public class LoanFrame extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel gamesModel;
	private DefaultComboBoxModel<Socios> partnersModel;
	private DefaultComboBoxModel<VideoGames> gamesModelBox;

	public JComboBox<Socios> partnersBox;
	public JComboBox<VideoGames> gamesBox;
	
	private JLabel title, labelPartner, labelGame;
	public JTable gamesTable;
	private BackGround backGround;
	
	public LoanFrame(ActionListeners action, Controller videoclub) {
		super();
		
		try {
			backGround = new BackGround(ImageIO.read(new File("src/com/codelupo/images/blue.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setBorder(backGround);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 1000;
		constraints.weighty = 1;

		this.setLayout(new GridBagLayout());
		this.setBounds(10, 10, 200, 200);
		// Label title
		title = new JLabel();
		title.setText(" Préstamos ");
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		title.setOpaque(true);
		title.setPreferredSize(new Dimension(300,50));
		title.setForeground(Color.BLUE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		constraints.gridheight = 1;
		this.add(title, constraints);
		// JLabels
		labelPartner = new JLabel("Socio");
		labelPartner.setOpaque(true);
		labelPartner.setBackground(new Color(51,153,255));
		labelPartner.setForeground(new Color(255,0,0));
		labelPartner.setFont(new Font(Font.SERIF,Font.BOLD,20));
		labelPartner.setPreferredSize(new Dimension(75,50));
		labelPartner.setHorizontalAlignment(SwingConstants.CENTER);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(labelPartner, constraints);
		labelGame = new JLabel("Juego");
		labelGame.setOpaque(true);
		labelGame.setBackground(new Color(51,153,255));
		labelGame.setForeground(new Color(255,0,0));
		labelGame.setFont(new Font(Font.SERIF,Font.BOLD,20));
		labelGame.setPreferredSize(new Dimension(75,50));
		labelGame.setHorizontalAlignment(SwingConstants.CENTER);
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(labelGame, constraints);

		// JTextFields
		List<Socios> socios = videoclub.getAllPartners();
		Socios[] modelCombo = new Socios[socios.size()];
		for (int i = 0; i < socios.size(); i++) {
			modelCombo[i] = socios.get(i);
		}
		partnersModel = new DefaultComboBoxModel<Socios>(modelCombo);
		partnersBox = new JComboBox<Socios>(partnersModel);
		partnersBox.setPreferredSize(new Dimension(200,50));
		((JLabel)partnersBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		partnersBox.setActionCommand("changePartner");
		partnersBox.addActionListener(action);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(partnersBox, constraints);

		List<VideoGames> juegos = videoclub.getAllGames();
		VideoGames[] modelComboGames = new VideoGames[juegos.size()];
		for (int i = 0; i < juegos.size(); i++) {
			modelComboGames[i] = juegos.get(i);
		}
		gamesModelBox = new DefaultComboBoxModel<VideoGames>(modelComboGames);
		gamesBox = new JComboBox<VideoGames>(gamesModelBox);
		gamesBox.setPreferredSize(new Dimension(200,50));
		((JLabel)gamesBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		gamesBox.setActionCommand("changeGame");
		gamesBox.addActionListener(action);
		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(gamesBox, constraints);
		
		// Table
		String[] columns = { "Código", "Nombre", "Préstamo", "Devolución" };
		// CEldas no editables
		gamesModel = new DefaultTableModel(columns, 0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;// This causes all cells to be not editable
			}

		};
		gamesTable = new JTable(gamesModel);
		gamesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gamesTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (!gamesTable.getSelectionModel().isSelectionEmpty()) {

					for (int i = 0; i < partnersModel.getSize(); i++) {

						if (gamesTable.getModel().getValueAt(gamesTable.getSelectedRow(), 0)
								.equals(partnersModel.getElementAt(i).getDni())) {
							partnersBox.setSelectedIndex(i);
						}
					}

					for (int i = 0; i < gamesModelBox.getSize(); i++) {

						if (gamesTable.getModel().getValueAt(gamesTable.getSelectedRow(), 1)
								.equals(gamesModelBox.getElementAt(i).getName())) {
							gamesBox.setSelectedIndex(i);
						}
					}
				}
			}
		});

		JScrollPane table = new JScrollPane(gamesTable);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 3;
		constraints.gridheight = 3;
		this.add(table, constraints);

		// Buttons
		JButton backToMenu = new JButton("Menú");
		backToMenu.setActionCommand("backtomenu");
		backToMenu.addActionListener(action);
		backToMenu.setPreferredSize(new Dimension(100,50));
		backToMenu.setFont(new Font(Font.SERIF,Font.BOLD,15));
		constraints.gridx = 4;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(backToMenu, constraints);

		JButton addLoan = new JButton("Hacer préstamo");
		addLoan.setActionCommand("addLoan");
		addLoan.addActionListener(action);
		addLoan.setPreferredSize(new Dimension(200, 100));
		addLoan.setBackground(new Color(150,255,50));
		addLoan.setFont(new Font(Font.SERIF,Font.BOLD,20));
		constraints.gridx = 3;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(addLoan, constraints);

		JButton giveBackLoan = new JButton("Devolver Juego");
		giveBackLoan.setActionCommand("giveBackGame");
		giveBackLoan.addActionListener(action);
		giveBackLoan.setPreferredSize(new Dimension(200, 100));
		giveBackLoan.setBackground(new Color(255,150,50));
		giveBackLoan.setFont(new Font(Font.SERIF,Font.BOLD,20));
		constraints.gridx = 3;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(giveBackLoan, constraints);

	}

	public DefaultComboBoxModel<Socios> getPartnersModel() {
		return partnersModel;
	}

	public void setPartnersModel(DefaultComboBoxModel<Socios> partnersModel) {
		this.partnersModel = partnersModel;
	}

	public DefaultComboBoxModel<VideoGames> getGamesModelBox() {
		return gamesModelBox;
	}

	public void setGamesModelBox(DefaultComboBoxModel<VideoGames> gamesModelBox) {
		this.gamesModelBox = gamesModelBox;
	}

	public void fillTable(List<Prestamos> loanList) {
		// Borramos los datos de la tabla libros
		int filas = gamesModel.getRowCount();
		if (filas > 0) {
			for (int i = filas - 1; i >= 0; i--) {
				gamesModel.removeRow(i);
			}
		}
		// modelo.fireTableDataChanged();
		// Rellenamos de nuevo la tabla libros

		for (int i = 0; i < loanList.size(); i++) {
			Prestamos loan = loanList.get(i);
			Object[] fila = { loan.getSocios().getDni(), loan.getGames().getName(), loan.getFechaPrestamo(),
					loan.getFechaDevolucion() };
			gamesModel.addRow(fila);
		}

	}
}
