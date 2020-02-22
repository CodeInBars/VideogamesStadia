package com.codelupo.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class GamesFrame extends JPanel{

	public GamesFrame() {
		super();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 3;
		constraints.weighty = 2;

		this.setLayout(new GridBagLayout());
		this.setBackground(Color.GRAY);
		this.setBounds(10, 10, 200, 200);
		// Label title
		JLabel title = new JLabel();
		title.setText(" Juegos ");
		title.setFont(new Font("Tahoma", Font.PLAIN, 24));
		title.setForeground(Color.BLUE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		this.add(title, constraints);
	}

}
