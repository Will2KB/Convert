package View;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel errorLabel;
	
	public ErrorFrame() {
		super("Erreur 27");
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Donner la taille de la fenêtre avant de la placer
		this.setSize(500, 200);
		//Centre par rapport au bureau
		this.setLocationRelativeTo(null);

		JPanel contentPanel = (JPanel)this.getContentPane();
		contentPanel.setLayout(new FlowLayout());
		
		this.errorLabel = new JLabel();
		this.errorLabel.setForeground(Color.RED);
		
		contentPanel.add(errorLabel);
	}
	
	public void showError(String error) {
		this.errorLabel.setText(error);
		this.setVisible(true);
	}
	
	public void hideError() {
		this.errorLabel.setText("");
		this.setVisible(false);
	}

}
