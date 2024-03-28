package Chuong7_luyentap_bai4;

import java.io.Serializable;
import java.util.Scanner;

public class NhanSu implements Serializable{
	private String hoTen;
	private int namSinh;
	private String queQuan;
	private int gioiTinh;
	
	public NhanSu() {}

	public NhanSu(String hoTen, int namSinh, String queQuan, int gioiTinh) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.queQuan = queQuan;
		this.gioiTinh = gioiTinh;
	}

	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập họ tên: ");
		this.hoTen = sc.nextLine();
		System.out.print("Nhập năm sinh: ");
		this.namSinh = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập quê quán: ");
		this.queQuan = sc.nextLine();
		System.out.print("Nhập giới tính (1: Nữ | 2: Nam): ");
		this.gioiTinh = Integer.parseInt(sc.nextLine());
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	
	
}
