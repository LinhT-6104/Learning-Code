package Tuan7;

import java.io.Serializable;
import java.util.Scanner;

public class HangHoa_7 implements Serializable{
	private String ten;
	private String xuatXu;
	private int namSX;
	private double donGia;
	
	public HangHoa_7() {}

	public HangHoa_7(String ten, String xuatXu, int namSX, double donGia) {
		super();
		this.ten = ten;
		this.xuatXu = xuatXu;
		this.namSX = namSX;
		this.donGia = donGia;
	}
	
	public void nhapHangHoa() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên: ");
		this.ten = sc.nextLine();
		System.out.print("Nhập xuất xứ: ");
		this.xuatXu = sc.nextLine();
		System.out.print("Nhập năm sản xuất: ");
		this.namSX = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập đơn giá: ");
		this.donGia = Double.parseDouble(sc.nextLine()); 
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}

	public int getNamSX() {
		return namSX;
	}

	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
}
