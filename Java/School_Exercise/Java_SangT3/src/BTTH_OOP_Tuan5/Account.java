package BTTH_OOP_Tuan5;

import java.util.Scanner;

public class Account {
	private long soTK;
	private String tenTK;
	private double soTienTK = 50;
	private static final double laiSuat = 0.035;
	Scanner sc = new Scanner(System.in);
	
	public Account() {}

	public Account(long soTK, String tenTK, double soTienTK) {
		this.soTK = soTK;
		this.tenTK = tenTK;
		this.soTienTK = soTienTK;
	}
	
	public void napTien(double tienNap) {
		System.out.println("------NẠP TIỀN------");
		while (tienNap < 0) {
			System.out.println("Số tiền nạp không hợp lệ! Vui lòng nhập lại "
					+ "số tiền cần nạp: ");
			tienNap = Double.parseDouble(sc.nextLine());
		}
		this.soTienTK += tienNap;
		System.out.println("NẠP THÀNH CÔNG " + tienNap + " vnđ vào tài khoản" + soTK);
	}
	
	public void rutTien(double tienRut) {
		System.out.println("------RÚT TIỀN------");
		while (tienRut > this.soTienTK) {
			System.out.println("Số tiền rút không hợp lệ! Vui lòng nhập lại "
					+ "số tiền cần rút");
			tienRut = Double.parseDouble(sc.nextLine());
		}
		this.soTienTK -= (tienRut + tienRut * laiSuat);
		System.out.println("RÚT THÀNH CÔNG " + tienRut + " vnđ tài khoản" + soTK);
		
	}
	
	public void daoHan() {
		this.soTienTK += this.soTienTK * laiSuat;
	}
	
	public void chuyenKhoan(Account tkNhanTien, double soTienCK) {
		System.out.println("------CHUYỂN KHOẢN------");
		this.soTienTK -= soTienCK;
		tkNhanTien.napTien(soTienCK);
	}
	
	public double getLaiSuat() {
		return laiSuat;
	}
	
	public long getSoTK() {
		return soTK;
	}

	public void setSoTK(long soTK) {
		this.soTK = soTK;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}

	public double getSoTienTK() {
		return soTienTK;
	}

	public void setSoTienTK(double soTienTK) {
		this.soTienTK = soTienTK;
	}

	@Override
	public String toString() {
		return "Account [soTK=" + soTK + ", tenTK=" + tenTK + ", soTienTK=" + soTienTK + "vnđ]";
	}
}
