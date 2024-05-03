package View;

import java.awt.Dimension;

import javax.swing.JButton;

import Controller.Controller;

public class ConvertButton extends JButton{

	private static final long serialVersionUID = 1L;
	
	public ConvertButton(Controller control) {
		super("Convertir");
		this.addActionListener(new ConvertActionListner(control));
		this.setPreferredSize(new Dimension(100, 30));
	}
}
