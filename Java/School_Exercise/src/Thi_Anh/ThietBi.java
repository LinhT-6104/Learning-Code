package Thi_Anh;

import java.util.Scanner;

public class ThietBi {
	private String maTB;
	private String tenTB;
	private double giaTB;
	
	public ThietBi() {}

	public ThietBi(String maTB, String tenTB, double giaTB) {
		this.maTB = maTB;
		this.tenTB = tenTB;
		this.giaTB = giaTB;
	}
	
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã thiết bị: ");
		this.maTB = sc.nextLine();
		System.out.print("Nhập tên thiết bị: ");
		this.tenTB = sc.nextLine();
		System.out.print("Nhập giá thiết bị: ");
		this.giaTB = Double.parseDouble(sc.nextLine());
	}
	 
	public void xuatDuLieu() {
		System.out.print("Mã thiết bị: " + this.maTB);
		System.out.print("Tên thiết bị: " + this.tenTB);
		System.out.print("Giá thiết bị: " + this.giaTB);
	}

	@Override
	public String toString() {
		return "ThietBi [maTB=" + maTB + ", tenTB=" + tenTB + ", giaTB=" + giaTB + "]";
	}

	public String getMaTB() {
		return maTB;
	}

	public void setMaTB(String maTB) {
		this.maTB = maTB;
	}

	public String getTenTB() {
		return tenTB;
	}

	public void setTenTB(String tenTB) {
		this.tenTB = tenTB;
	}

	public double getGiaTB() {
		return giaTB;
	}

	public void setGiaTB(double giaTB) {
		this.giaTB = giaTB;
	}
}
