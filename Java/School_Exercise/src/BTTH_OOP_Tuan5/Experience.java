package BTTH_OOP_Tuan5;

public class Experience extends Employee {
	private int ExpInYear;
	private String ProSkill;

	public Experience() {
		super();
	}
	
	public Experience(int iD, String fullName, String birthDay, int phone, String email, int employee_type,
					int employee_count, int expInYear, String proSkill, Certificate[] certificate) {
		super(iD, fullName, birthDay, phone, email, employee_type, employee_count, certificate);
		ExpInYear = expInYear;
		ProSkill = proSkill;
	}
	
	@Override
	public void ShowInfo() {
		super.ShowInfo();
		System.out.println("ExpInYear: " + this.ExpInYear);
		System.out.println("ProSkill: " + this.ProSkill);
	}

	// --------------------GETTER | SETTER--------------------


	public int getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}

	public String getProSkill() {
		return ProSkill;
	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}
	
}
