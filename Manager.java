public class Manager {
	public Student[] students;
	
	public Manager(String[] studentNames, String[] passwords, boolean[] isPremiumArr) {
		students = new Student[studentNames.length];
		if(studentNames != null && passwords != null) {
			fillStudentDetails(studentNames, passwords, isPremiumArr);
			printStudentDetails();
		}
	}
	
	public void fillStudentDetails(String[] studentNames, String[] passwords, boolean[] isPremiumArr) {
		for(int i = 0; i < students.length; i++) {
			students[i] = new Student(studentNames[i], passwords[i], isPremiumArr[i]);
		}
	}
	
	public void printStudentDetails() {
		for(int i = 0; i < students.length; i++) {
			System.out.println("Student #" + (i + 1) + ": ");
			System.out.println("    Name: " + students[i].name);
			System.out.println("    Password: " + students[i].password);
			System.out.println("    Premium: " + students[i].isPremium);
		}
	}
	
	public boolean checkIsStudentEligible(String name, String password) {
		for(int i = 0; i < students.length; i++) {
			if(students[i].name.equals(name) && students[i].password.equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public Student getStudentByName(String name) {
		for(int i = 0; i < students.length; i++) {
			if(students[i].name.equals(name)) return students[i];
		}
		return null;
	}
	
}
