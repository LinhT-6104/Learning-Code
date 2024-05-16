//Tran_Duc_Linh_725105115
package BaiThi;

import java.io.Serializable;
import java.util.Scanner;

public class ChuyenNghanh implements Serializable {
	
	private String maChuyenNghanh;	
	private String tenChuyenNghanh;	
	
	public ChuyenNghanh() {
		
	}
	
	public ChuyenNghanh(String maChuyenNghanh, String tenChuyenNghanh) {
		this.maChuyenNghanh = maChuyenNghanh;
		this.tenChuyenNghanh = tenChuyenNghanh;
	}



	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhập mã chuyên nghành: ");
		this.maChuyenNghanh = sc.nextLine();
		System.out.print("Nhập tên chuyên nghành: ");
		this.tenChuyenNghanh = sc.nextLine();
	}
	
	public void xuatDuLieu() {
		System.out.println("\nMã chuyên nghành: " + this.maChuyenNghanh);
		System.out.println("Tên chuyên nghành: " + this.tenChuyenNghanh);
	}

	public String getMaChuyenNghanh() {
		return maChuyenNghanh;
	}

	public void setMaChuyenNghanh(String maChuyenNghanh) {
		this.maChuyenNghanh = maChuyenNghanh;
	}

	public String getTenChuyenNghanh() {
		return tenChuyenNghanh;
	}

	public void setTenChuyenNghanh(String tenChuyenNghanh) {
		this.tenChuyenNghanh = tenChuyenNghanh;
	}

	@Override
	public String toString() {
		return "ChuyenNghanh [maChuyenNghanh=" + maChuyenNghanh + ", tenChuyenNghanh=" + tenChuyenNghanh + "]";
	}
}
