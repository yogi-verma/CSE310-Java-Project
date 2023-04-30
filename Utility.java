import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Utility {
	
	static JLabel addText(JFrame frame, String text, int x, int y, int width, int height) {
		JLabel label = new JLabel(text);
		label.setBounds(x, y, width, height);
		frame.add(label);
		
		return label;
	}
	
	static JTextField addTextField(JFrame frame, String text, int x, int y, int width, int height) {
		JTextField field = new JTextField(text);
		field.setBounds(x, y, width, height);
		frame.add(field);
		
		return field;
	}
	
	static JButton addButton(JFrame frame, String text, int x, int y, int width, int height) {
		JButton button = new JButton(text);
		button.setBounds(x, y, width, height);
		frame.add(button);
		
		return button;
		
	}
	
	static JTextArea addTextArea(JFrame frame, String text, int x, int y, int width, int height) {
		JTextArea area = new JTextArea(text);
		area.setBounds(x, y, width, height);
		frame.add(area);
		
		return area;
	}
	
}
