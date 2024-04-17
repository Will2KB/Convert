package View;

import java.util.ArrayList;

import javax.swing.JComboBox;

import Model.Unit;

public class ConvertOptionsUnits extends JComboBox<Unit>{

	private static final long serialVersionUID = 1L;

	public ConvertOptionsUnits(ArrayList<Unit> elements) {
		super();
		for(Unit elem : elements) {
			this.addItem(elem);
		}
	}
}
