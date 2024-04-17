package View;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class ConvertTextField extends JTextField{

	private static final long serialVersionUID = 1L;

	public ConvertTextField(boolean editable) {
		super();
		this.setEditable(editable);
		this.setPreferredSize(new Dimension(100, 30));
		

	}
	
	@Override
	 public void processKeyEvent(KeyEvent ev) {
		char c = ev.getKeyChar();
	        if (Character.isDigit(c) || c==KeyEvent.VK_PERIOD) {
	            super.processKeyEvent(ev);
	        }
	        ev.consume();
	        return;
	    }
}
