package Tuan7;

import java.io.Serializable;
import java.util.Scanner;

public class HoaDon implements Serializable{
	private String maHD;
	private double tongTienHD;
	
	public HoaDon() {}
	public HoaDon(String maHD, double tongTienHD) {
		super();
		this.maHD = maHD;
		this.tongTienHD = tongTienHD;
	}
	
	public void nhapHoaDon() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã hóa đơn: ");
		this.maHD = sc.nextLine();
		System.out.print("Nhập tổng tiền hoán đơn: ");
		this.tongTienHD = Double.parseDouble(sc.nextLine());
	}
	
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", tongTienHD=" + tongTienHD + "]";
	}
	
	// GETTER | SETTER
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public double getTongTienHD() {
		return tongTienHD;
	}
	public void setTongTienHD(double	 tongTienHD) {
		this.tongTienHD = tongTienHD;
	}
	
	
}
