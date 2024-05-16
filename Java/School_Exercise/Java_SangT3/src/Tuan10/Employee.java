package Tuan10;

import java.io.Serializable;
import java.util.Scanner;

public class Employee implements Serializable {
	private int id;
	private String name;
	private int age;
	private String address;
	private float salary;
	public Employee() {}
	public Employee(int id, String name, int age, String address, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", salary=" + salary
				+ "]";
	}
	
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n------NHẬP EMPLOYEE------");
		System.out.print("Nhập mã nhân viên");
		this.id = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập tên nhân viên: ");
		this.name = sc.nextLine();
		System.out.print("Nhập tuổi nhân viên: ");
		this.age = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập địa chỉ nhân viên: ");
		this.address = sc.nextLine();
		System.out.print("Nhập lương nhân viên: ");
		this.salary = Float.parseFloat(sc.nextLine());
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
}
