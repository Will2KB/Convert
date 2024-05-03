package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Controller;

public class ConvertActionListner implements ActionListener{
	
	private Controller controller;
	
	public ConvertActionListner (Controller controller) {
		this.controller = controller;
	}
	
	public void actionPerformed(ActionEvent e){
    	this.controller.convertion();
    }
}
