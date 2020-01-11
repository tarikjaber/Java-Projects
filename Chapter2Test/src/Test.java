import javax.swing.*; //swing
import java.awt.*; // color
import java.util.Scanner;
import java.util.Random;
public class Test {
	public static void main(String [] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = reader.nextLine();
		
		int rand = (int)(Math.random() * 20);
		System.out.printf("%s %s", name, rand);
		System.out.println(); 
		System.out.println(rand);
		
		JFrame theGUI = new JFrame();
		theGUI.setSize(400, 400);
		theGUI.setTitle("Aloha");	
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theGUI.setVisible(true);
		
		Container pane = theGUI.getContentPane();
		
		JPanel panel = new JPanel();
		Color randColor = new Color((int)(Math.random() * 256),(int)(Math.random() * 256),(int)(Math.random() * 256));
		panel.setBackground(randColor);
		
		pane.add(panel);
	}
}
