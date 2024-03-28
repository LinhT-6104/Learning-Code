package BTTH_OOP_Tuan5;

public class Fresher extends Employee {
	private String Graduation_date;
	private String Graduation_rank;
	private String Education;
	
	public Fresher() {
		super();
	}
	public Fresher(int iD, String fullName, String birthDay, int phone, String email, int employee_type,
				int employee_count, String graduation_date, String graduation_rank, String education, Certificate[] certificate) {
		super(iD, fullName, birthDay, phone, email, employee_type, employee_count, certificate);
		Graduation_date = graduation_date;
		Graduation_rank = graduation_rank;
		Education = education;
	}
	
	@Override
	public void ShowInfo() {
		super.ShowInfo();
		System.out.println("Graduation_date: " + this.Graduation_date);
		System.out.println("Graduation_rank: " + this.Graduation_rank);
		System.out.println("Education: " + this.Education);
	}
	
	// --------------------GETTER | SETTER--------------------
	public String getGraduation_date() {
		return Graduation_date;
	}
	public void setGraduation_date(String graduation_date) {
		Graduation_date = graduation_date;
	}
	public String getGraduation_rank() {
		return Graduation_rank;
	}
	public void setGraduation_rank(String graduation_rank) {
		Graduation_rank = graduation_rank;
	}
	public String getEducation() {
		return Education;
	}
	public void setEducation(String education) {
		Education = education;
	}
}
