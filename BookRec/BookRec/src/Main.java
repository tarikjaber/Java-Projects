import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main {

	public static void main(String[] args) {
		Library library = new Library("resources\\books.txt");
		Ratings ratings = new Ratings("resources\\readerratings.txt");

		JFrame j = new JFrame();
		JPanel controls = new JPanel();
		JPanel output = new JPanel();
		JComboBox<String> people = new JComboBox<String>(
				ratings.getReaders().stream().map(a -> a.getName()).toArray(String[]::new));
		JComboBox<String> methods = new JComboBox<String>(new String[] { "Method A", "Method B", "Method C" });
		JButton btnGetRec = new JButton("Find the recommended book");
		JTextArea book = new JTextArea();
		
		Toolkit t = Toolkit.getDefaultToolkit();
		
		btnGetRec.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Book recomendation = new Book(null, null);
				switch ((String) methods.getSelectedItem()) {
				case "Method A":
					recomendation = library.getBooks().get(ratings.getRecommendationA(people.getSelectedIndex()));
					break;
				case "Method B":
					recomendation = library.getBooks().get(ratings.getRecommendationB(people.getSelectedIndex()));
					break;
				case "Method C":
					recomendation = library.getBooks().get(ratings.getRecommendationC(people.getSelectedIndex()));
					break;
				}
				
				Image background = t.getImage("resources\\images\\" + recomendation.getTitle() + ".jpg");
				output.getGraphics().drawImage(background, 150, 50, 150, 300, null);
				
				
				
				book.setText(recomendation.toString());
			}
		});

		//controls.setLayout(new GridLayout(1, 3));
		controls.setLayout(null);
		people.setBounds(20, 100, 120, 30);
		methods.setBounds(20, 260, 120, 30);
		btnGetRec.setBounds(20, 520, 330, 30);
	
		controls.add(people);
		controls.add(methods);
		controls.add(btnGetRec);
		
		controls.setBounds(0, 0, 400, 600);

		book.setBounds(150, 400, 200, 400);
		book.setEditable(false);
		book.setLineWrap(true);
		book.setBackground(null);
		
		output.setLayout(null);
		output.add(book);
		output.setBounds(0, 50, 400, 600);

		j.setResizable(false);
		j.setSize(400, 600);
		j.setLayout(null);
		j.add(controls);
		j.add(output);
		j.setVisible(true);

	}
}
