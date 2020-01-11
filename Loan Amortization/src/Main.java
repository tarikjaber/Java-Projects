import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		JFrame theGUI = new JFrame();
		theGUI.setTitle("Loan Amortization");
		theGUI.setLayout(null);
		theGUI.setSize(350, 160);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ColorPanel mama = new ColorPanel(Color.white);
		Container  pane = theGUI.getContentPane();
		
		pane.add(mama);

		theGUI.setVisible(true);
		
		
		System.out.println("Hello");
		
		/*
		JLabel downPayment = new JLabel("Down payment:");
		downPayment.setBounds(10, 60, 100, 20);
		
		JTextField downPaymentText = new JTextField(50);
		downPaymentText.setBounds(200, 60, 80, 20);
		theGUI.add(downPaymentText);
		//downPaymentText.setText("");
		 * */
		 
		
		JLabel purchasePrice = new JLabel("Purchase price:");
		purchasePrice.setBounds(10, 50, 100, 20);
		
		JTextField purchasePriceText = new JTextField(50);
		purchasePriceText.setBounds(110, 50, 80, 20);
		theGUI.add(purchasePriceText);
		purchasePriceText.setText("");
		
		JButton calculate = new JButton("Calculate");
		calculate.setBounds(200, 50, 100, 20);

		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mama.createTable(Double.parseDouble(purchasePriceText.getText()));
			}
		});
		
		JLabel blank = new JLabel("");
		
		purchasePrice.setVisible(true);
		calculate.setVisible(true);
		
		//theGUI.add(downPayment);
		theGUI.add(purchasePrice);
		theGUI.add(calculate);
		theGUI.setSize(351, 160);

		mama.updateUI();
		
	}

}
