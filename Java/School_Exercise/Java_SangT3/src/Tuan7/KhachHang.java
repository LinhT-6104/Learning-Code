package Tuan7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class KhachHang implements Serializable{
	private String MaKH;
	private String hoTen;
	private String soCMND;
	private int namSinh;
	private String email;
	private int soDT;
	private ArrayList<HoaDon> dshd;
	private ViTien viTien;
	
	public KhachHang() {}
	
	public KhachHang(String maKH, String hoTen, String soCMND, int namSinh, String email, int soDT,
			ArrayList<HoaDon> dshd, ViTien viTien) {
		this.MaKH = maKH;
		this.hoTen = hoTen;
		this.soCMND = soCMND;
		this.namSinh = namSinh;
		this.email = email;
		this.soDT = soDT;
		this.dshd = dshd;
		this.viTien = viTien;
	}

	public void nhapTTKH() {
		System.out.println("------NHẬP THÔNG TIN KHÁCH HÀNG------");
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã KH: ");
		this.MaKH = sc.nextLine();
		System.out.print("Nhập họ tên KH: ");
		this.hoTen = sc.nextLine();
		System.out.print("Nhập số CMND KH: ");
		this.soCMND = sc.nextLine();
		System.out.print("Nhập năm sinh KH: ");
		this.namSinh = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập số hóa đơn KH: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			System.out.println("------NHẬP THÔNG TIN HÓA ĐƠN " + (i + 1) + "------");
			this.dshd.get(i).nhapHoaDon();
		}
		System.out.print("Nhập thông tin ví tiền: ");
		this.viTien.nhapViTien();
		sc.close();
	}

	@Override
	public String toString() {
		return "KhachHang [MaKH=" + MaKH + ", hoTen=" + hoTen + ", soCMND=" + soCMND + ", namSinh=" + namSinh
				+ ", email=" + email + ", soDT=" + soDT + ", dshd=" + dshd.toString() + ", viTien=" + viTien.toString() + "]";
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSoDT() {
		return soDT;
	}

	public void setSoDT(int soDT) {
		this.soDT = soDT;
	}

	public ArrayList<HoaDon> getDshd() {
		return dshd;
	}

	public void setDshd(ArrayList<HoaDon> dshd) {
		this.dshd = dshd;
	}

	public ViTien getViTien() {
		return viTien;
	}

	public void setViTien(ViTien viTien) {
		this.viTien = viTien;
	}
	
}
