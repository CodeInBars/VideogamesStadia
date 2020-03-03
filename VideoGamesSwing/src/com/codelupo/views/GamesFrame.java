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
import com.codelupo.main.BackGround;
import com.codelupo.videogames.model.VideoGames;

public class GamesFrame extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel gamesModel;
	public JTextField codeField, nameField, sinopsisField;
	private JLabel title, labelCode, labelNombre, labelSinopsis;
	private BackGround backGround;
	public GamesFrame(ActionListeners action) {
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
		this.setBackground(Color.GRAY);
		this.setBounds(10, 10, 200, 200);
		// Label title
		title = new JLabel();
		title.setText(" Juegos ");
		title.setFont(new Font(Font.SERIF, Font.BOLD, 24));
		title.setForeground(Color.BLUE);
		title.setOpaque(true);
		title.setPreferredSize(new Dimension(300,50));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 8;
		constraints.gridheight = 1;
		this.add(title, constraints);
		// JLabels
		labelCode = new JLabel("Código");
		labelCode.setOpaque(true);
		labelCode.setBackground(new Color(51,153,255));
		labelCode.setFont(new Font(Font.SERIF,Font.BOLD,15));
		labelCode.setHorizontalAlignment(SwingConstants.CENTER);
		labelCode.setPreferredSize(new Dimension(100,50));
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(labelCode, constraints);
		labelNombre = new JLabel("Nombre");
		labelNombre.setOpaque(true);
		labelNombre.setBackground(new Color(51,153,255));
		labelNombre.setFont(new Font(Font.SERIF,Font.BOLD,15));
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombre.setPreferredSize(new Dimension(100,50));
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(labelNombre, constraints);
		
		labelSinopsis = new JLabel("Sinopsis");
		labelSinopsis.setOpaque(true);
		labelSinopsis.setBackground(new Color(51,153,255));
		labelSinopsis.setFont(new Font(Font.SERIF,Font.BOLD,15));
		labelSinopsis.setHorizontalAlignment(SwingConstants.CENTER);
		labelSinopsis.setPreferredSize(new Dimension(100,50));
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
		String[] columns = { "Código", "Nombre", "Sinopsis" };
		// CEldas no editables
		gamesModel = new DefaultTableModel(columns, 0) {
			private static final long serialVersionUID = 1L;

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
		JButton backToMenu = new JButton("Menú");
		backToMenu.setActionCommand("backtomenu");
		backToMenu.addActionListener(action);
		backToMenu.setPreferredSize(new Dimension(100,50));
		backToMenu.setFont(new Font(Font.SERIF,Font.BOLD,15));
		constraints.gridx = 6;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(backToMenu, constraints);

		JButton cleanButton = new JButton("Limpiar campos");
		cleanButton.setActionCommand("clean");
		cleanButton.addActionListener(action);
		cleanButton.setPreferredSize(new Dimension(150,50));
		cleanButton.setFont(new Font(Font.SERIF,Font.BOLD,15));
		constraints.gridx = 6;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(cleanButton, constraints);

		JButton addGame = new JButton("Añadir Juego");
		addGame.setActionCommand("addGame");
		addGame.addActionListener(action);
		addGame.setBackground(new Color(51,150,70));
		addGame.setPreferredSize(new Dimension(150,75));
		addGame.setFont(new Font(Font.SERIF,Font.BOLD,15));
		constraints.gridx = 5;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(addGame, constraints);

		JButton deleteGame = new JButton("Borrar Juego");
		deleteGame.setActionCommand("deleteGame");
		deleteGame.addActionListener(action);
		deleteGame.setBackground(new Color(150,50,70));
		deleteGame.setPreferredSize(new Dimension(150,75));
		deleteGame.setFont(new Font(Font.SERIF,Font.BOLD,15));
		constraints.gridx = 5;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(deleteGame, constraints);

		JButton editGame = new JButton("Editar Juego");
		editGame.setActionCommand("editGame");
		editGame.addActionListener(action);
		editGame.setBackground(new Color(255,153,0));
		editGame.setPreferredSize(new Dimension(150,75));
		editGame.setFont(new Font(Font.SERIF,Font.BOLD,15));
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
