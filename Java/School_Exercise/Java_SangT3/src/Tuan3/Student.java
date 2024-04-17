package Tuan3;

public class Student extends Person {
	private String major;
	
	public String getMajor() { return major; }

	public void setMajor(String major) { this.major = major; }

	public Student() {
		super();
	}
	
	public Student(String major, String name, int age) {
		super(name, age); 
		this.major = major;
	}
	
	public void showInfo() {
		System.out.println("Name: " + this.getName() + "\nAge: " + this.getAge() + "\nMajor: " + this.getMajor());
	}
	
	public static void main(String[] args) {
		Student student = new Student("CNPM", "Ninh Duong Lan Ngoc", 25);
		student.showInfo();
	}
}
