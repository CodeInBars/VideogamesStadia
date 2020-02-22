package com.codelupo.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.codelupo.controller.ActionListeners;

public class MenuFrame extends JPanel {

	public MenuFrame(ActionListeners actions) {
		super();

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 3;
		constraints.weighty = 2;

		this.setLayout(new GridBagLayout());
		this.setBackground(Color.GRAY);
		this.setBounds(10, 10, 200, 200);
		// Label title
		JLabel title = new JLabel();
		title.setText(" Video Games Lupo Xan ");
		title.setFont(new Font("Tahoma", Font.PLAIN, 24));
		title.setForeground(Color.BLUE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		this.add(title, constraints);
		// Partners button
		JButton partner = new JButton();
		partner.setActionCommand("partners");
		partner.addActionListener(actions);
		partner.setIcon(new ImageIcon("src/com/codelupo/images/socios.png"));
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(partner, constraints);
		// Games button
		JButton games = new JButton();
		games.setActionCommand("games");
		games.addActionListener(actions);
		games.setIcon(new ImageIcon("src/com/codelupo/images/games.png"));
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(games, constraints);
		// Loans button
		JButton loans = new JButton();
		loans.setActionCommand("loans");
		loans.addActionListener(actions);
		loans.setIcon(new ImageIcon("src/com/codelupo/images/loan.png"));
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(loans, constraints);

	}

}
