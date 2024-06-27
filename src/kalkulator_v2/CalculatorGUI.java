package kalkulator_v2;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CalculatorGUI {

	// GUI objects
	public JFrame frmCalculator;
	private static JTextField textField;
	
	// Variables for calculating result
	private static int argument1 = 0;
	private static int argument2 = 0;
	private static int result = 0; 
	private static String operator = "";
	
	// Variables to track current application status and cover every scenario
	private static boolean equals_asserted = false;
	private static boolean operator_asserted = false;
	private static boolean number_asserted = false;

	// Method to handle calculating results after operator case
	public static void operation_handler() {
		try {
		switch (operator) {
		
		case "+":
			result = argument1 + argument2;
			textField.setText(result + "");
			break;
		case "-":
			result = argument1 - argument2;
			textField.setText(result + "");
			break;
		case "*":
			result = argument1 * argument2;
			textField.setText(result + "");
			break;
		case "/":
			result = argument1 / argument2;
			textField.setText(result + "");
			break;
		
		}
		}
		catch (ArithmeticException E) {
			textField.setText("Division by zero");
			argument1 = 0; argument2 = 0; operator = "";
			equals_asserted = false; operator_asserted = false; number_asserted = false;
			}
		catch (NumberFormatException E) {
			argument1 = 0; argument2 = 0; operator = "";
			equals_asserted = false; operator_asserted = false; number_asserted = false;
		}
		operator_asserted = false;
	
	}

	/**
	 * Constructor initializing application.
	 */
	public CalculatorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.getContentPane().setBackground(new Color(221, 160, 221));
		frmCalculator.setTitle("Calculator\r\n");
		frmCalculator.setResizable(false);
		frmCalculator.setBounds(100, 100, 290, 350);
		frmCalculator.setLocationRelativeTo(null);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(new Color(219, 112, 147));
		textField.setFont(new Font("Arial", Font.BOLD, 28));
		textField.setBounds(25, 24, 220, 48);
		frmCalculator.getContentPane().add(textField);
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setColumns(10);
		textField.setText("0");
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clearing textField and application data after = 
				if (textField.getText().equals("Division by zero")) textField.setText("");
				if (equals_asserted) {
					textField.setText("0");
					argument1 = 0; argument2 = 0; operator = "";
					equals_asserted = false; operator_asserted = false; number_asserted = false;
				}
				// Clearing textField after operator
				if (!operator.equals("") && !number_asserted) textField.setText("");
				// Clearing 0 on textField, to write requested number
				if (textField.getText().equals("0")) textField.setText("");
				String number = textField.getText() + btn1.getText();
				textField.setText(number);
				number_asserted = true;
				System.out.println("Button: " + btn1.getText());
			}
		});
		btn1.setBackground(new Color(230, 230, 250));
		btn1.setFont(new Font("Arial", Font.BOLD, 11));
		btn1.setBounds(25, 80, 40, 40);
		frmCalculator.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setBackground(new Color(230, 230, 250));
		btn2.setFont(new Font("Arial", Font.BOLD, 11));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("Division by zero")) textField.setText("");
				// Clearing textField and application data after = 
				if (equals_asserted) {
					textField.setText("0");
					argument1 = 0; argument2 = 0; operator = "";
					equals_asserted = false; operator_asserted = false; number_asserted = false;
				}
				// Clearing textField after operator
				if (!operator.equals("") && !number_asserted) textField.setText("");
				// Clearing 0 on textField, to write requested number
				if (textField.getText().equals("0")) textField.setText("");
				String number = textField.getText() + btn2.getText();
				textField.setText(number);
				number_asserted = true;
				System.out.println("Button: " + btn2.getText());
			}
		});
		btn2.setBounds(85, 80, 40, 40);
		frmCalculator.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("Division by zero")) textField.setText("");
				// Clearing textField and application data after = 
				if (equals_asserted) {
					textField.setText("0");
					argument1 = 0; argument2 = 0; operator = "";
					equals_asserted = false; operator_asserted = false; number_asserted = false;
				}
				// Clearing textField after operator
				if (!operator.equals("") && !number_asserted) textField.setText("");
				// Clearing 0 on textField, to write requested number
				if (textField.getText().equals("0")) textField.setText("");
				String number = textField.getText() + btn3.getText();
				textField.setText(number);
				number_asserted = true;
				System.out.println("Button: " + btn3.getText());
			}
		});
		btn3.setBackground(new Color(230, 230, 250));
		btn3.setFont(new Font("Arial", Font.BOLD, 11));
		btn3.setBounds(145, 80, 40, 40);
		frmCalculator.getContentPane().add(btn3);
		
		JButton btn_add = new JButton("+");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if (textField.getText().equals("Division by zero")) textField.setText("0");
				// Covering case to perform add operation after =
				if (equals_asserted) {
					argument1 = result;
					equals_asserted = false;
				}
				// Covering case of operation after operator
				if (operator_asserted && number_asserted) {
					argument2 = Integer.parseInt(textField.getText());
					operation_handler();
				}
				// Covering parsing 0
				if (textField.getText().equals("0")) {
					argument1 = 0;
				}
				// Print 0 on textField if it is null
				else if (textField.getText().equals("")) textField.setText("0");
				else {
					argument1 = Integer.parseInt(textField.getText());
				}
				operator = "+";
				operator_asserted = true;
				number_asserted = false;
				System.out.println("Button: " + btn_add.getText());
				System.out.println("Current operator: " + operator);
				}
				catch(NumberFormatException E) {
					argument1 = 0; argument2 = 0; operator = "";
					equals_asserted = false; operator_asserted = false; number_asserted = false;
				}
			}
		});
		btn_add.setBackground(new Color(230, 230, 250));
		btn_add.setFont(new Font("Arial", Font.BOLD, 11));
		btn_add.setBounds(205, 80, 40, 40);
		frmCalculator.getContentPane().add(btn_add);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("Division by zero")) textField.setText("");
				// Clearing textField and application data after = 
				if (equals_asserted) {
					textField.setText("0");
					argument1 = 0; argument2 = 0; operator = "";
					equals_asserted = false; operator_asserted = false; number_asserted = false;
				}
				// Clearing textField after operator
				if (!operator.equals("") && !number_asserted) textField.setText("");
				// Clearing 0 on textField, to write requested number
				if (textField.getText().equals("0")) textField.setText("");
				String number = textField.getText() + btn4.getText();
				textField.setText(number);
				number_asserted = true;
				System.out.println("Button: " + btn4.getText());
			}
		});
		btn4.setBackground(new Color(230, 230, 250));
		btn4.setFont(new Font("Arial", Font.BOLD, 11));
		btn4.setBounds(25, 135, 40, 40);
		frmCalculator.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("Division by zero")) textField.setText("");
				// Clearing textField and application data after = 
				if (equals_asserted) {
					textField.setText("0");
					argument1 = 0; argument2 = 0; operator = "";
					equals_asserted = false; operator_asserted = false; number_asserted = false;
				}
				// Clearing textField after operator
				if (!operator.equals("") && !number_asserted) textField.setText("");
				// Clearing 0 on textField, to write requested number
				if (textField.getText().equals("0")) textField.setText("");
				String number = textField.getText() + btn5.getText();
				textField.setText(number);
				number_asserted = true;
				System.out.println("Button: " + btn5.getText());
			}
		});
		btn5.setBackground(new Color(230, 230, 250));
		btn5.setFont(new Font("Arial", Font.BOLD, 11));
		btn5.setBounds(85, 135, 40, 40);
		frmCalculator.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("Division by zero")) textField.setText("");
				// Clearing textField and application data after = 
				if (equals_asserted) {
					textField.setText("0");
					argument1 = 0; argument2 = 0; operator = "";
					equals_asserted = false; operator_asserted = false; number_asserted = false;
				}
				// Clearing textField after operator
				if (!operator.equals("") && !number_asserted) textField.setText("");
				// Clearing 0 on textField, to write requested number
				if (textField.getText().equals("0")) textField.setText("");
				String number = textField.getText() + btn6.getText();
				textField.setText(number);
				number_asserted = true;
				System.out.println("Button: " + btn6.getText());
			}
		});
		btn6.setBackground(new Color(230, 230, 250));
		btn6.setFont(new Font("Arial", Font.BOLD, 11));
		btn6.setBounds(145, 135, 40, 40);
		frmCalculator.getContentPane().add(btn6);
		
		JButton btn_sub = new JButton("-");
		btn_sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if (textField.getText().equals("Division by zero")) textField.setText("0");
				// Covering case to perform subtract operation after =
				if (equals_asserted) {
					argument1 = result;
					equals_asserted = false;
				}
				// Covering case of operation after operator
				if (operator_asserted && number_asserted) {
					argument2 = Integer.parseInt(textField.getText());
					operation_handler();
				}
				// Covering case of susbtracting 0
				if (textField.getText().equals("0")) {
					argument1 = 0;
				}
				// Print 0 on textField if it is null
				else if (textField.getText().equals("")) textField.setText("");
				else {
					argument1 = Integer.parseInt(textField.getText());
				}
				operator = "-";
				operator_asserted = true;
				number_asserted = false;
				System.out.println("Button: " + btn_sub.getText());
				System.out.println("Current operator: " + operator);
				}
				catch(NumberFormatException E) {
					argument1 = 0; argument2 = 0; operator = "";
					equals_asserted = false; operator_asserted = false; number_asserted = false;
				}
			}
		});
		btn_sub.setBackground(new Color(230, 230, 250));
		btn_sub.setFont(new Font("Arial", Font.BOLD, 11));
		btn_sub.setBounds(205, 135, 40, 40);
		frmCalculator.getContentPane().add(btn_sub);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("Division by zero")) textField.setText("");
				// Clearing textField and application data after = 
				if (equals_asserted) {
					textField.setText("0");
					argument1 = 0; argument2 = 0; operator = "";
					equals_asserted = false; operator_asserted = false; number_asserted = false;
				}
				// Clearing textField after operator
				if (!operator.equals("") && !number_asserted) textField.setText("");
				// Clearing 0 on textField, to write requested number
				if (textField.getText().equals("0")) textField.setText("");
				String number = textField.getText() + btn7.getText();
				textField.setText(number);
				number_asserted = true;
				System.out.println("Button: " + btn7.getText());
			}
		});
		btn7.setBackground(new Color(230, 230, 250));
		btn7.setFont(new Font("Arial", Font.BOLD, 11));
		btn7.setBounds(25, 190, 40, 40);
		frmCalculator.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("Division by zero")) textField.setText("");
				// Clearing textField and application data after = 
				if (equals_asserted) {
					textField.setText("0");
					argument1 = 0; argument2 = 0; operator = "";
					equals_asserted = false; operator_asserted = false; number_asserted = false;
				}
				// Clearing textField after operator
				if (!operator.equals("") && !number_asserted) textField.setText("");
				// Clearing 0 on textField, to write requested number
				if (textField.getText().equals("0")) textField.setText("");
				String number = textField.getText() + btn8.getText();
				textField.setText(number);
				number_asserted = true;
				System.out.println("Button: " + btn8.getText());
			}
		});
		btn8.setBackground(new Color(230, 230, 250));
		btn8.setFont(new Font("Arial", Font.BOLD, 11));
		btn8.setBounds(85, 190, 40, 40);
		frmCalculator.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("Division by zero")) textField.setText("");
				// Clearing textField and application data after = 
				if (equals_asserted) {
					textField.setText("0");
					argument1 = 0; argument2 = 0; operator = "";
					equals_asserted = false; operator_asserted = false; number_asserted = false;
				}
				// Clearing textField after operator
				if (!operator.equals("") && !number_asserted) textField.setText("");
				// Clearing 0 on textField, to write requested number
				if (textField.getText().equals("0")) textField.setText("");
				String number = textField.getText() + btn9.getText();
				textField.setText(number);
				number_asserted = true;
				System.out.println("Button: " + btn9.getText());
			}
		});
		btn9.setBackground(new Color(230, 230, 250));
		btn9.setFont(new Font("Arial", Font.BOLD, 11));
		btn9.setBounds(145, 190, 40, 40);
		frmCalculator.getContentPane().add(btn9);
		
		JButton btn_mul = new JButton("*");
		btn_mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if (textField.getText().equals("Division by zero")) textField.setText("0");
				// Covering case to perform multiply operation after =
				if (equals_asserted) {
					argument1 = result;
					equals_asserted = false;
				}
				// Covering case of operation after operator
				if (operator_asserted && number_asserted) {
					argument2 = Integer.parseInt(textField.getText());
					operation_handler();
				}
				// Covering case of multiplying by 0
				if (textField.getText().equals("0")) {
					argument1 = 0;
				}
				// Print 0 on textField if it is null
				else if (textField.getText().equals("")) textField.setText("0");
				else {
					argument1 = Integer.parseInt(textField.getText());
				}
				operator = "*";
				operator_asserted = true;
				number_asserted = false;
				System.out.println("Button: " + btn_mul.getText());
				System.out.println("Current operator: " + operator);
				}
				catch(NumberFormatException E) {
					argument1 = 0; argument2 = 0; operator = "";
					equals_asserted = false; operator_asserted = false; number_asserted = false;
				}
			}
		});
		btn_mul.setBackground(new Color(230, 230, 250));
		btn_mul.setFont(new Font("Arial", Font.BOLD, 11));
		btn_mul.setBounds(205, 190, 40, 40);
		frmCalculator.getContentPane().add(btn_mul);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("Division by zero")) textField.setText("");
				// Clearing textField and application data after = 
				if (equals_asserted) {
					textField.setText("0");
					argument1 = 0; argument2 = 0; operator = "";
					equals_asserted = false; operator_asserted = false; number_asserted = false;
				}
				// Clearing textField after operator
				if (!operator.equals("") && !number_asserted) textField.setText("");
				// Clearing 0 on textField, to write requested number
				if (textField.getText().equals("0")) textField.setText("");
				String number = textField.getText() + btn0.getText();
				textField.setText(number);
				number_asserted = true;
				System.out.println("Button: " + btn0.getText());
			}
		});
		btn0.setBackground(new Color(230, 230, 250));
		btn0.setFont(new Font("Arial", Font.BOLD, 11));
		btn0.setBounds(25, 245, 40, 40);
		frmCalculator.getContentPane().add(btn0);
		
		JButton btn_eq = new JButton("=");
		btn_eq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("Division by zero")) textField.setText("0");
				// Covering case to compute = after = asserted yet
				if (equals_asserted) argument1 = result;
				
				if (!operator.equals("") && !equals_asserted) argument2 = Integer.parseInt(textField.getText());
				switch (operator) {
				case "+":
					result = argument1 + argument2;
					textField.setText(result + "");
					break;
				case "-":
					result = argument1 - argument2;
					textField.setText(result + "");
					break;
				case "*":
					result = argument1 * argument2;
					textField.setText(result + "");
					break;
				case "/":
					try {
						result = argument1 / argument2;
						textField.setText(result + "");
						break;
					}
					catch (ArithmeticException E) {
	    				textField.setText("Division by zero");
	    				argument1 = 0; argument2 = 0; operator = "";
	    				equals_asserted = false; operator_asserted = false; number_asserted = false;	
					}
				default:
					result = argument1;
					break;
				}
				equals_asserted = true;
				operator_asserted = false;
				number_asserted = false;
				System.out.println("Button: " + btn_eq.getText());
			}
		});
		btn_eq.setBackground(new Color(230, 230, 250));
		btn_eq.setFont(new Font("Arial", Font.BOLD, 11));
		btn_eq.setBounds(85, 245, 40, 40);
		frmCalculator.getContentPane().add(btn_eq);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear all
				textField.setText("0");
				argument1 = 0; argument2 = 0; operator = "";
				equals_asserted = false; operator_asserted = false; number_asserted = false;
				System.out.println("Button: " + btnC.getText());
			}
		});
		btnC.setBackground(new Color(230, 230, 250));
		btnC.setFont(new Font("Arial", Font.BOLD, 8));
		btnC.setBounds(145, 245, 40, 40);
		frmCalculator.getContentPane().add(btnC);
		
		JButton btn_div = new JButton("/");
		btn_div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if (textField.getText().equals("Division by zero")) textField.setText("0");
				// Covering case to perform divide operation after =
				if (equals_asserted) {
					argument1 = result;
					equals_asserted = false;
				}
				// Covering case when operator is asserted and argument1 has value
				if (operator_asserted && number_asserted) {
					argument2 = Integer.parseInt(textField.getText());
					operation_handler();
				}
				// Covering case of 0 divided by argument2
				if (textField.getText().equals("0")) {
					argument1 = 0;
				}
				// Print 0 on textField if it is null
				else if (textField.getText().equals("")) textField.setText("0");
				else {
					argument1 = Integer.parseInt(textField.getText());
				}
				operator = "/";
				operator_asserted = true;
				number_asserted = false;
				System.out.println("Button: " + btn_div.getText());
				System.out.println("Current operator: " + operator);
				}
				catch(NumberFormatException E) {
					argument1 = 0; argument2 = 0; operator = "";
					equals_asserted = false; operator_asserted = false; number_asserted = false;
				}
			}
		});
		btn_div.setBackground(new Color(230, 230, 250));
		btn_div.setFont(new Font("Arial", Font.BOLD, 11));
		btn_div.setBounds(205, 245, 40, 40);
		frmCalculator.getContentPane().add(btn_div);
	}
}
