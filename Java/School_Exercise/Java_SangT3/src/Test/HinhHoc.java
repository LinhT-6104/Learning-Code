package Test;

import java.util.Scanner;

public class HinhHoc {
	private String maHinh;
	private String mauSac;
	
	public HinhHoc() {}

	public HinhHoc(String maHinh, String mauSac) {
		this.maHinh = maHinh;
		this.mauSac = mauSac;
	}
	
	public void nhapThongTin() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã hình: ");
		this.maHinh = sc.nextLine();
		System.out.print("Nhập màu sắc: ");
		this.mauSac = sc.nextLine();
	}
	
	public void xuatThongTin() {
		System.out.println("Mã hình: " + this.maHinh);
		System.out.println("Màu sắc: " + this.mauSac);
	}
	
	@Override
	public String toString() {
		return "HinhHoc [maHinh=" + maHinh + ", mauSac=" + mauSac + "]";
	}

	public String layMaHinh() {
		return maHinh;
	}

	public void datMaHinh(String maHinh) {
		this.maHinh = maHinh;
	}

	public String layMauSac() {
		return mauSac;
	}

	public void datMauSac(String mauSac) {
		this.mauSac = mauSac;
	}
}
