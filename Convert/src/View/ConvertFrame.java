package View;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;

import Controller.Controller;
import Model.Unit;

public class ConvertFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private ConvertTextField inTextField;
	private ConvertOptionsUnits inOptionsUnit;
	private ConvertTextField outTextField;
	private ConvertOptionsUnits outOptionsUnit;
	
	public ConvertFrame() {
		super("Mon convertisseur");
	}
	
	public void buildFrame(Controller control) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Donner la taille de la fenêtre avant de la placer
		this.setSize(500, 100);
		//Centre par rapport au bureau
		this.setLocationRelativeTo(null);

		JPanel contentPanel = (JPanel)this.getContentPane();
		contentPanel.setLayout(new FlowLayout());
		
		ArrayList<Unit> unitsMap = control.getUnitsMap();
		this.inTextField = new ConvertTextField(true);
		this.inOptionsUnit = new ConvertOptionsUnits(unitsMap);
		this.outTextField = new ConvertTextField(false); 
		this.outOptionsUnit = new ConvertOptionsUnits(unitsMap); 
		
		contentPanel.add(this.inTextField);
		contentPanel.add(this.inOptionsUnit);
		contentPanel.add(this.outTextField);
		contentPanel.add(this.outOptionsUnit);
		contentPanel.add(new ConvertButton(control));
		
		this.setVisible(true);
	}
	
	public String getInTextField() {
		return this.inTextField.getText();
	}
	public void setInTextField(String val) {
		this.inTextField.setText(val);
	}
	
	public String getOutTextField() {
		return this.outTextField.getText();
	}
	public void setOutTextField(String val) {
		this.outTextField.setText(val);
	}

	public Unit getSelectedInOptionsUnit() {
		return (Unit)this.inOptionsUnit.getSelectedItem();
	}
	public void setSelectedInOptionsUnit(Unit unit) {
		this.inOptionsUnit.setSelectedItem(unit);
	}
	
	public Unit getSelectedOutOptionsUnit() {
		return (Unit)this.outOptionsUnit.getSelectedItem();
	}
	public void setSelectedOutOptionsUnit(Unit unit) {
		this.outOptionsUnit.setSelectedItem(unit);
	}
	
}
