package Tuan5;

import java.util.Scanner;

class Person {
	Scanner sc = new Scanner(System.in);
	private String ten;
	private int tuoi;
	
	public Person() {
		this.ten = "";
		this.tuoi = 0;
	}
	
	public Person(String ten, int tuoi) {
		this.ten = ten;
		this.tuoi = tuoi;
	}

	public String getTen() { return ten; }
	public void setTen(String ten) { this.ten = ten; }
	public int getTuoi() { return tuoi; }
	public void setTuoi(int tuoi) { this.tuoi = tuoi; }
	
	public void input() {
		System.out.println("Nhập thông tin");
		System.out.print("Nhập tên: ");
		this.ten = sc.nextLine();
		System.out.print("Nhập tuổi: ");
		this.tuoi = sc.nextInt();
	}

	public String toString() {
		return "Person [ten = " + ten + ", tuoi = " + tuoi + "]";
	}
}

class Student extends Person {
	
}

public class bai5_2_giao_trinh {
	public static void main(String[] args) {
		
		
	}
}
