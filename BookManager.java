import javax.swing.JLabel;
import javax.swing.JTextArea;

public class BookManager {
	public Book[] books;
	
	public BookManager(String[] names, boolean[] isPremiumArr, int[] amounts) {
		books = new Book[names.length];
		
		if(names != null && isPremiumArr != null && amounts != null) {
			fillBooksValues(names, isPremiumArr, amounts);
			printBooksValues();
		}
	}
	
	public void fillBooksValues(String[] names, boolean[] isPremiumArr, int[] amounts) {
		for(int i = 0; i < names.length; i++) {
			books[i] = new Book(names[i], isPremiumArr[i], amounts[i]);
			books[i].name = names[i];
			books[i].isPremium = isPremiumArr[i];
			books[i].amount = amounts[i];
		}
	}
	
	public void printBooksValues() {
		for(int i = 0; i < books.length; i++) {
			System.out.println("Book #" + (i + 1) + ": ");
			System.out.println("    Name: " + books[i].name);
			System.out.println("    Premium: " + books[i].isPremium);
			System.out.println("    Amount: " + books[i].amount);
		}
	}
	
	public void displayEligibleBooks(Student student, JTextArea area) {
		System.out.println();
		System.out.println("Eligible Books for " + student.name + ": ");
		
		area.setText("");
		
		if(student.isPremium) {
			for(int i = 0; i < books.length; i++) {
				System.out.println(books[i].name);
				if(books[i].isPremium) {
					area.setText(area.getText() + System.lineSeparator() + books[i].name + " - Prem - x" + books[i].amount);					
				} else {
					area.setText(area.getText() + System.lineSeparator() + books[i].name + " - x" + books[i].amount);
				}
			}
		} else {
			for(int i = 0; i < books.length; i++) {
				if(!books[i].isPremium) {
					System.out.println(books[i].name);
					area.setText(area.getText() + System.lineSeparator() + books[i].name + " - x" + books[i].amount);
				}
			}
		}
	}
	
	public void issueBookByName(Student student, String name, JLabel label) {
		if(student.isPremium) {
			label.setText(name + " issued to " + student.name);
			for(int i = 0; i < books.length; i++) {
				if(books[i].name.equals(name)) {
					books[i].amount--;
				}
			}
		} else {
			for(int i = 0; i < books.length; i++) {
				if(!books[i].isPremium && books[i].name.equals(name)) {
					label.setText(name + " issued to " + student.name);
					books[i].amount--;
				}
			}
		}
	}
	
	public void returnBookByName(Student student, JLabel label, String bookName) {
		label.setText("Book returned by " + student.name);
		// TODO: increment book amount
		
		for(int i = 0; i < books.length; i++) {
			if(books[i].name.equals(bookName)) {
				books[i].amount++;
				break;
			}
		}
	}
}
















