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
import com.codelupo.videogames.model.Socios;

public class PartnerFrame extends JPanel {

	private DefaultTableModel partnersModel;
	public JTextField dniField,nameField,surnameField,countField;
	private JLabel title,labelDni,labelNombre,labelSurname,labelCount;
	public PartnerFrame(ActionListeners action) {
		super();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 1000;
		constraints.weighty = 1;

		this.setLayout(new GridBagLayout());
		this.setBackground(Color.GRAY);
		this.setBounds(10, 10, 200, 200);
		// Label title
		title = new JLabel();
		title.setText(" Socios ");
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
		labelDni = new JLabel("DNI");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(labelDni, constraints);
		labelNombre = new JLabel("Nombre");
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(labelNombre, constraints);
		labelSurname = new JLabel("Apellidos");
		constraints.gridx = 4;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(labelSurname, constraints);
		labelCount = new JLabel("Cuenta del banco");
		constraints.gridx = 6;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(labelCount, constraints);
		// JTextFields
		dniField = new JTextField();
		dniField.setColumns(10);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(dniField, constraints);
		nameField = new JTextField();
		nameField.setColumns(10);
		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(nameField, constraints);
		surnameField = new JTextField();
		surnameField.setColumns(10);
		constraints.gridx = 5;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(surnameField, constraints);
		countField = new JTextField();
		countField.setColumns(13);
		constraints.gridx = 7;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(countField, constraints);
		// Table
		String[] columns = { "DNI", "Nombre", "Apellidos", "Cuenta" };
		// CEldas no editables
		partnersModel = new DefaultTableModel(columns, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;// This causes all cells to be not editable
			}

		};
		JTable partnersTable = new JTable(partnersModel);
		partnersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		partnersTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (!partnersTable.getSelectionModel().isSelectionEmpty()) {
					dniField.setText(partnersTable.getModel().getValueAt(partnersTable.getSelectedRow(), 0).toString());
					nameField
							.setText(partnersTable.getModel().getValueAt(partnersTable.getSelectedRow(), 1).toString());
					surnameField
							.setText(partnersTable.getModel().getValueAt(partnersTable.getSelectedRow(), 2).toString());
					countField
							.setText(partnersTable.getModel().getValueAt(partnersTable.getSelectedRow(), 3).toString());
				}
			}
		});

		JScrollPane table = new JScrollPane(partnersTable);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 4;
		constraints.gridheight = 4;
		this.add(table, constraints);
		
		// Buttons
		JButton backToMenu = new JButton("Menú");
		backToMenu.setActionCommand("backtomenu");
		backToMenu.addActionListener(action);
		constraints.gridx = 8;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(backToMenu, constraints);
		
		JButton cleanButton = new JButton("Limpiar campos");
		cleanButton.setActionCommand("clean");
		cleanButton.addActionListener(action);
		constraints.gridx = 8;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(cleanButton, constraints);
		
		JButton addPartner = new JButton("Añadir Socio");
		addPartner.setActionCommand("addPartner");
		addPartner.addActionListener(action);
		constraints.gridx = 5;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(addPartner, constraints);
		
		JButton deletePartner = new JButton("Borrar Socio");
		deletePartner.setActionCommand("deletePartner");
		deletePartner.addActionListener(action);
		constraints.gridx = 5;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(deletePartner, constraints);
		
		JButton editPartner = new JButton("Editar Socio");
		editPartner.setActionCommand("editPartner");
		editPartner.addActionListener(action);
		constraints.gridx = 5;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(editPartner, constraints);
		
	}

	public void fillTable(List<Socios> partnersList) {
		// Borramos los datos de la tabla libros
		int filas = partnersModel.getRowCount();
		if (filas > 0) {
			for (int i = filas - 1; i >= 0; i--) {
				partnersModel.removeRow(i);
			}
		}
		// modelo.fireTableDataChanged();
		// Rellenamos de nuevo la tabla libros

		for (int i = 0; i < partnersList.size(); i++) {
			Socios partner = partnersList.get(i);
			Object[] fila = { partner.getDni(), partner.getName(), partner.getSurname(), partner.getCuenta() };
			partnersModel.addRow(fila);
		}

	}

}
