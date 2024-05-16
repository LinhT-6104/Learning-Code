package test;

import java.io.Serializable;
import java.util.Scanner;

//Họ tên: Trần Đức Linh
//Mã SV: 725105115

public class ConNguoi implements Serializable {
	
	
	private String hoTen;	
	private String gioiTinh;
	
	public ConNguoi() {
		
	}
	
	public ConNguoi(String hoTen, String gioiTinh) {
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
	}

	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhập họ tên: ");
		this.hoTen = sc.nextLine();
		System.out.print("Nhập giới tính: ");
		this.gioiTinh = sc.nextLine();
	}
	
	public void xuatDuLieu() {
		System.out.println("Họ tên: " + this.hoTen);
		System.out.println("Giới tính: " + this.gioiTinh);
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@Override
	public String toString() {
		return "ConNguoi [hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + "]";
	}
	
	
	
}
