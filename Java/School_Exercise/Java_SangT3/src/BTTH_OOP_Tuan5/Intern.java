package BTTH_OOP_Tuan5;

public class Intern extends Employee {
	private String Majors;
	private int Semester;
	private String University_name;
	public Intern() {
		super();
	}
	public Intern(int iD, String fullName, String birthDay, int phone, String email, int employee_type,
			int employee_count, Certificate[] certificate, String majors, int semester, String university_name) {
		super(iD, fullName, birthDay, phone, email, employee_type, employee_count, certificate);
		this.Majors = majors;
		this.Semester = semester;
		this.University_name = university_name;
	}
	
	// ----------------GETTER | SETTER----------------
	public String getMajors() {
		return Majors;
	}
	public void setMajors(String majors) {
		Majors = majors;
	}
	public int getSemester() {
		return Semester;
	}
	public void setSemester(int semester) {
		Semester = semester;
	}
	public String getUniversity_name() {
		return University_name;
	}
	public void setUniversity_name(String university_name) {
		University_name = university_name;
	}
	
	
}
