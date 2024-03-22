package Tuan5;

class MyEmployee {
	private int salary;
	public int getSalary() { return this.salary; }
	public void setSalary(int salary) {
		this.salary = salary;
		System.out.println("Cập nhật salary = " + salary);
	}
}

class MyManager extends MyEmployee {
	private int bonus;
	public void setBonus (int bonus) { this.bonus = bonus; }
	@Override
	public int getSalary() {
		return super.getSalary() + this.bonus;
	}
}

public class GhiDe {
	public static void main(String[] args) {
		MyManager manager = new MyManager();
		manager.setSalary(50000);
		manager.setBonus(12000);
		System.out.println("Manager's salary = " + manager.getSalary());
	}
}
