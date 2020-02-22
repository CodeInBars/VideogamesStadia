package com.codelupo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codelupo.videogames.controller.Controller;
import com.codelupo.views.MainFrame;
import com.codelupo.views.MenuFrame;

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
		case "games":
			mainframe.getMenu().setVisible(false);
			mainframe.getGames().setVisible(true);
			break;
		case "loans":
			//mainframe.getMenu().setVisible(false);
			break;

		}
	}

}
