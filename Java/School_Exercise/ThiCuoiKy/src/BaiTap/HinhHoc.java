package BaiTap;

import java.io.Serializable;
import java.util.Scanner;

public class HinhHoc implements Serializable {
	private String maHinh;
	private String mauSac;
	
	public HinhHoc() {}

	public HinhHoc(String maHinh, String mauSac) {
		this.maHinh = maHinh;
		this.mauSac = mauSac;
	}
	
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhập mã hình: ");
		this.maHinh = sc.nextLine();
		System.out.print("Nhập màu sắc: ");
		this.mauSac = sc.nextLine();
	}
	
	public void xuatDuLieu() {
		System.out.println("\nMã hình: " + this.maHinh);
		System.out.println("Màu sắc: " + this.mauSac);
	}

	public String getMaHinh() {
		return maHinh;
	}

	public void setMaHinh(String maHinh) {
		this.maHinh = maHinh;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	@Override
	public String toString() {
		return "HinhHoc [maHinh=" + maHinh + ", mauSac=" + mauSac + "]";
	}
	
	
}
