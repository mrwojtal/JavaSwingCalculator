/**
 * 
 */
package kalkulator_v2;


import javax.swing.SwingUtilities;

/**
 * 
 */
public class Calculator_v2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI window = new CalculatorGUI();
					window.frmCalculator.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
