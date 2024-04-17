package Tuan9;	// Bai 3

import java.io.Serializable;
import java.util.Scanner;

public class HangHoa implements Serializable {
	private String tenHH;
	private String xuatXu;
	private int namSX;
	private double donGia;
	public HangHoa() {}
	public HangHoa(String tenHH, String xuatXu, int namSX, double donGia) {
		super();
		this.tenHH = tenHH;
		this.xuatXu = xuatXu;
		this.namSX = namSX;
		this.donGia = donGia;
	}
//	@Override
//	public String toString() {
//		return "HangHoa [tenHH=" + tenHH + ", xuatXu=" + xuatXu + ", namSX=" + namSX + ", donGia=" + donGia + "]";
//	}
	
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên hàng hóa: ");
		this.tenHH = sc.nextLine();
		System.out.print("Nhập xuất xứ hàng hóa: ");
		this.xuatXu = sc.nextLine();
		System.out.print("Nhập năm sản xuất hàng hóa: ");
		this.namSX = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập đơn giá hàng hóa: ");
		this.donGia = Double.parseDouble(sc.nextLine());
	}
	
	public String getTenHH() {
		return tenHH;
	}
	public void setTenHH(String tenHH) {
		this.tenHH = tenHH;
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
