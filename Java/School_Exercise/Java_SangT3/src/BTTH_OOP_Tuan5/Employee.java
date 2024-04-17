package BTTH_OOP_Tuan5;

public abstract class Employee {
	private int ID;
	private String FullName;
	private String BirthDay;
	private int Phone;
	private String Email;
	private int Employee_type;
	private static int Employee_count;
	private Certificate[] certificate;
	
	public Employee() {}
	public Employee(int iD, String fullName, String birthDay, int phone, String email, 
			int employee_type, int employee_count, Certificate[] certificate) {
		this.ID = iD;
		this.FullName = fullName;
		this.BirthDay = birthDay;
		this.Phone = phone;
		this.Email = email;
		this.Employee_type = employee_type;
		Employee.Employee_count = employee_count;
		this.setCertificate(certificate);
	}

	public void ShowInfo() {
		System.out.println("ID: " + this.ID);
		System.out.println("FullName: " + this.FullName);
		System.out.println("BirthDay: " + this.BirthDay);
		System.out.println("Phone: " + this.Phone);
		System.out.println("Email: " + this.Email);
		if (this.Employee_type == 0) {
			System.out.println("Employee_type: Experience");			
		} 
		else if (this.Employee_type == 1) {
			System.out.println("Employee_type: Fresher");
		}
		else if (this.Employee_type == 2) {
			System.out.println("Employee_type: Intern");
		}
	}
	
	// --------------------GETTER | SETTER--------------------f
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getBirthDay() {
		return BirthDay;
	}
	public void setBirthDay(String birthDay) {
		BirthDay = birthDay;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getEmployee_type() {
		return Employee_type;
	}
	public void setEmployee_type(int employee_type) {
		Employee_type = employee_type;
	}
	public int getEmployee_count() {
		return Employee.Employee_count;
	}
	public void setEmployee_count(int employee_count) {
		Employee_count = employee_count;
	}
	public Certificate[] getCertificate() {
		return certificate;
	}
	public void setCertificate(Certificate[] certificate) {
		this.certificate = certificate;
	}
	
	
}
