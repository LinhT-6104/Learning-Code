package Thi_Sang_T3;

import java.util.Scanner;

//Họ tên: Trần Đức Linh
//Mã sinh viên: 725105115
public class HangHoa {
	private String maHangHoa;
	private String tenHangHoa;
	private double donGia;
	private int soLuong;
	
	public HangHoa() {}

	public HangHoa(String maHangHoa, String tenHangHoa, double donGia, int soLuong) {
		this.maHangHoa = maHangHoa;
		this.tenHangHoa = tenHangHoa;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}
	
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã hàng hóa: ");
		this.maHangHoa = sc.nextLine();
		System.out.print("Nhập tên hàng hóa: ");
		this.tenHangHoa = sc.nextLine();
		System.out.print("Nhập đơn giá: ");
		this.donGia = Double.parseDouble(sc.nextLine());
		System.out.print("Nhập số lượng: ");
		this.soLuong = Integer.parseInt(sc.nextLine());
	}
	
	public void xuatDuLieu() {
		System.out.println("Mã hàng hóa: " + this.maHangHoa);
		System.out.println("Tên hàng hóa: " + this.tenHangHoa);
		System.out.println("Đơn giá: " + this.donGia);
		System.out.println("Số lượng: " + this.soLuong);
	}

	@Override
	public String toString() {
		return "HangHoa [maHangHoa=" + maHangHoa + ", tenHangHoa=" + tenHangHoa + ", donGia=" + donGia + ", soLuong="
				+ soLuong + "]";
	}

	public String getMaHangHoa() {
		return maHangHoa;
	}

	public void setMaHangHoa(String maHangHoa) {
		this.maHangHoa = maHangHoa;
	}

	public String getTenHangHoa() {
		return tenHangHoa;
	}

	public void setTenHangHoa(String tenHangHoa) {
		this.tenHangHoa = tenHangHoa;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
}
