package Thi_Anh;

import java.util.Scanner;

public class DoanhNghiep extends ThietBi {
	private String tenDoanhNghiep;
	private int soLuongSXTB;
	
	public DoanhNghiep() {}

	public DoanhNghiep(String tenDoanhNghiep, int soLuongSXTB, String maTB, String tenTB, double giaTB) {
		super(maTB, tenTB, giaTB);
		this.tenDoanhNghiep = tenDoanhNghiep;
		this.soLuongSXTB = soLuongSXTB;
	}
	
	@Override
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên doanh nghiệp: ");
		this.tenDoanhNghiep = sc.nextLine();
		System.out.print("Nhập số lượng sản xuất thiết bị: ");
		this.soLuongSXTB = Integer.parseInt(sc.nextLine());
		super.nhapDuLieu();
	}
	
	@Override
	public void xuatDuLieu() {
		System.out.println("------DOANH NGHIỆP------");
		System.out.println("Tên doanh nghiệp: " + this.tenDoanhNghiep);
		System.out.println("Số lượng sản xuất thiết bị: " + this.soLuongSXTB);
		super.xuatDuLieu();
	}

	@Override
	public String toString() {
		return "DoanhNghiep [tenDoanhNghiep=" + tenDoanhNghiep + ", soLuongSXTB=" + soLuongSXTB + ", maTB="
				+ getMaTB() + ", tenTB=" + getTenTB() + ", giaTB=" + getGiaTB() + "]";
	}

	public String getTenDoanhNghiep() {
		return tenDoanhNghiep;
	}

	public void setTenDoanhNghiep(String tenDoanhNghiep) {
		this.tenDoanhNghiep = tenDoanhNghiep;
	}

	public int getSoLuongSXTB() {
		return soLuongSXTB;
	}

	public void setSoLuongSXTB(int soLuongSXTB) {
		this.soLuongSXTB = soLuongSXTB;
	}
}
