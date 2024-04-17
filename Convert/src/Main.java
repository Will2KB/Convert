import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.*;
import Controller.*;

public class Main {

  public static void main(String[] args) throws UnsupportedLookAndFeelException {    
	UIManager.setLookAndFeel(new NimbusLookAndFeel());
	  
	Controller controller = new Controller("config.xml");
    controller.run();
  }

}