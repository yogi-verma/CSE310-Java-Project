import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		
		Image loginFrameBackground = Toolkit.getDefaultToolkit().getImage("login_background.jpg");
		Image mainFrameBackground = Toolkit.getDefaultToolkit().getImage("main_background.jpg");
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		int width = 500;
		int height = 500;
		
		JFrame loginFrame = new JFrame();
		JFrame mainFrame = new JFrame();

		loginFrame.setTitle("LMS");
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setTitle("Main LMS");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Utility.addText(loginFrame, "Name: ", 0, 0, 50, 20).setForeground(Color.WHITE);		
		Utility.addText(loginFrame, "Password: ", 0, 30, 80, 20).setForeground(Color.WHITE);
		
		
		JTextField enteredName = Utility.addTextField(loginFrame, null, 80, 0, 150, 20);
		JTextField enteredPassword = Utility.addTextField(loginFrame, null, 80, 30, 150, 20);
		JTextArea area = Utility.addTextArea(mainFrame, null, 200, 200, 300, 200);
		
		JButton loginButton =  Utility.addButton(loginFrame, "Log in", 50, 150, 100, 50);
		JButton issueButton = Utility.addButton(mainFrame, "Issue", 50, 200, 100, 50);
		JButton returnButton = Utility.addButton(mainFrame, "Return", 50, 350, 100, 50);
		
		Utility.addText(mainFrame, "Book name", 50, 250, 80, 20);
		JTextField issueField =  Utility.addTextField(mainFrame, null, 50, 270, 150, 20);
		JLabel issueLabel = Utility.addText(mainFrame, null, 0, 300, 200, 20);
		
		loginFrame.setSize(width - 100, height - 200);
		loginFrame.setLayout(null);
		loginFrame.setResizable(false);
		
		Container c = loginFrame.getContentPane();
		JLabel imageLabel = new JLabel();
		imageLabel.setIcon(new ImageIcon(loginFrameBackground));
		imageLabel.setBounds(0, 0, width - 100, height - 200);
		c.add(imageLabel);
		
		loginFrame.setVisible(true);
		
		mainFrame.setSize(width, height);
		mainFrame.setLayout(null);
		mainFrame.setResizable(false);
		
		Container c2 = mainFrame.getContentPane();
		JLabel imageLabel2 = new JLabel();
		imageLabel2.setIcon(new ImageIcon(mainFrameBackground));
		imageLabel2.setBounds(0, 0, width, height);
		c2.add(imageLabel2);
		

		
		String[] students = {
			"Rakesh Sharma",
			"Priyansh Sharma",
			"Anupam Tripathi",
			"Sai Chikkam"
		};
		
		String[] passwords = {
			"123456",
			"7877777",
			"6969",
			"111111111"
		};
		
		boolean[] isPremiumStudentArr = {
			true,
			false,
			false,
			false
		};
		
		String[] books = {
			"Hercules",
			"Harry Potter",
			"Dracula",
			"Java for Dummies",
			"Computer Organisation and Design",
			"Alice in Wonderland"
		};
		
		boolean[] isPremiumBookArr = {
			true,
			true,
			true,
			false,
			false,
			true
		};
		
		int[] bookAmounts = {
			3,
			2,
			1,
			1,
			1,
			5
		};
		
		Manager manager = new Manager(students, passwords, isPremiumStudentArr);
		
		BookManager bookManager = new BookManager(books, isPremiumBookArr, bookAmounts);
		
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
				System.out.println("Login button pressed!");
				
				System.out.println("Entered name: " + enteredName.getText());
				System.out.println("Entered password: " + enteredPassword.getText());
				
				String enteredNameString = enteredName.getText();
				String enteredPasswordString = enteredPassword.getText();
				
				System.out.println("Button group: " + buttonGroup);
				
				if(manager.checkIsStudentEligible(enteredNameString, enteredPasswordString)) {
					System.out.println("Logged in!");
					
					mainFrame.setVisible(true);
					
					bookManager.displayEligibleBooks(manager.getStudentByName(enteredNameString), area);
					
					issueButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
							bookManager.issueBookByName(manager.getStudentByName(enteredNameString), issueField.getText(), issueLabel);

							bookManager.displayEligibleBooks(manager.getStudentByName(enteredNameString), area);
						}
						
					});
					
					returnButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							bookManager.returnBookByName(manager.getStudentByName(enteredNameString), issueLabel, issueField.getText());
						
							bookManager.displayEligibleBooks(manager.getStudentByName(enteredNameString), area);
						}
						
					});
					
				} else {
					System.out.println("Can't log in. :(");
				}
			
			}
			
		});
	}
	
}
