import java.awt.EventQueue;
import javax.swing.SwingUtilities;

public class Arbitrary {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {

				new Units_1();
			}
			
			
		});
		
	}

}
