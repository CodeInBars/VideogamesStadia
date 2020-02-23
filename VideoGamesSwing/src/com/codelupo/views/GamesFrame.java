package com.codelupo.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.codelupo.controller.ActionListeners;
import com.codelupo.videogames.model.VideoGames;

public class GamesFrame extends JPanel {

	private DefaultTableModel gamesModel;
	public JTextField codeField, nameField, sinopsisField;
	private JLabel title, labelCode, labelNombre, labelSinopsis;

	public GamesFrame(ActionListeners action) {
		super();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 1000;
		constraints.weighty = 1;

		this.setLayout(new GridBagLayout());
		this.setBackground(Color.GRAY);
		this.setBounds(10, 10, 200, 200);
		// Label title
		title = new JLabel();
		title.setText(" Juegos ");
		title.setFont(new Font("Tahoma", Font.PLAIN, 24));
		title.setForeground(Color.BLUE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 8;
		constraints.gridheight = 1;
		this.add(title, constraints);
		// JLabels
		labelCode = new JLabel("C�digo");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(labelCode, constraints);
		labelNombre = new JLabel("Nombre");
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(labelNombre, constraints);
		
		labelSinopsis = new JLabel("Sinopsis");
		constraints.gridx = 4;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(labelSinopsis, constraints);
		// JTextFields
		codeField = new JTextField();
		codeField.setColumns(10);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(codeField, constraints);
		nameField = new JTextField();
		nameField.setColumns(10);
		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(nameField, constraints);
		
		sinopsisField = new JTextField();
		sinopsisField.setColumns(13);
		constraints.gridx = 5;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(sinopsisField, constraints);
		// Table
		String[] columns = { "C�digo", "Nombre", "Sinopsis" };
		// CEldas no editables
		gamesModel = new DefaultTableModel(columns, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;// This causes all cells to be not editable
			}

		};
		JTable gamesTable = new JTable(gamesModel);
		gamesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gamesTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (!gamesTable.getSelectionModel().isSelectionEmpty()) {
					codeField.setText(gamesTable.getModel().getValueAt(gamesTable.getSelectedRow(), 0).toString());
					nameField
							.setText(gamesTable.getModel().getValueAt(gamesTable.getSelectedRow(), 1).toString());
					sinopsisField
							.setText(gamesTable.getModel().getValueAt(gamesTable.getSelectedRow(), 2).toString());
				}
			}
		});

		JScrollPane table = new JScrollPane(gamesTable);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 4;
		constraints.gridheight = 4;
		this.add(table, constraints);

		// Buttons
		JButton backToMenu = new JButton("Men�");
		backToMenu.setActionCommand("backtomenu");
		backToMenu.addActionListener(action);
		constraints.gridx = 6;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(backToMenu, constraints);

		JButton cleanButton = new JButton("Limpiar campos");
		cleanButton.setActionCommand("clean");
		cleanButton.addActionListener(action);
		constraints.gridx = 6;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(cleanButton, constraints);

		JButton addGame = new JButton("A�adir Juego");
		addGame.setActionCommand("addGame");
		addGame.addActionListener(action);
		constraints.gridx = 5;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(addGame, constraints);

		JButton deleteGame = new JButton("Borrar Juego");
		deleteGame.setActionCommand("deleteGame");
		deleteGame.addActionListener(action);
		constraints.gridx = 5;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(deleteGame, constraints);

		JButton editGame = new JButton("Editar Juego");
		editGame.setActionCommand("editGame");
		editGame.addActionListener(action);
		constraints.gridx = 5;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(editGame, constraints);

	}

	public void fillTable(List<VideoGames> gamesList) {
		// Borramos los datos de la tabla libros
		int filas = gamesModel.getRowCount();
		if (filas > 0) {
			for (int i = filas - 1; i >= 0; i--) {
				gamesModel.removeRow(i);
			}
		}
		// modelo.fireTableDataChanged();
		// Rellenamos de nuevo la tabla libros

		for (int i = 0; i < gamesList.size(); i++) {
			VideoGames game = gamesList.get(i);
			Object[] fila = { game.getCode(), game.getName(), game.getSinopsis() };
			gamesModel.addRow(fila);
		}

	}
}
