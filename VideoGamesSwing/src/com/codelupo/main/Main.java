package com.codelupo.main;

import com.codelupo.controller.ActionListeners;
import com.codelupo.videogames.controller.Controller;
import com.codelupo.views.MainFrame;

public class Main {
	
	private static ActionListeners actionlisteners;
	
	public static void main(String[] args) {
		Controller videoClub = new Controller();
		MainFrame mainFrame = null;
		if(videoClub.getConexion() != null) {
			actionlisteners = new ActionListeners(videoClub);
			
			mainFrame = new MainFrame(actionlisteners, videoClub);
			mainFrame.setUndecorated(true);
			actionlisteners.setMainframe(mainFrame);
			mainFrame.setVisible(true);
			
			
		}
	}
}
