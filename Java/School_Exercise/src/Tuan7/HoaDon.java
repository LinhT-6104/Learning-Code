package Tuan7;

import java.io.Serializable;
//import java.util.Scanner;

public class HoaDon implements Serializable {
	private String MaHD;
	private Double TienHD;
	
	public HoaDon() {
		this.MaHD = "";
		this.TienHD = 0.0;
	}
	public HoaDon(String maHD, Double TienHD) {
		this.MaHD = maHD;
		this.TienHD = TienHD;
	}

//	Scanner sc = new Scanner(System.in);
//	
//	public void nhapDuLieu() {
//		System.out.print("Nhập mã hóa đơn: ");
//		this.MaHD = sc.next();
//		System.out.print("Nhập tổng tiền hóa đơn: ");
//		this.TienHD = Double.parseDouble(sc.next());
//	}
	
	@Override
	public String toString() {
		return " [MaHD = " + MaHD + ", TienHD = " + TienHD + "],";
	}
	
	public String getMaHD() { return MaHD; }
	public void setMaHD(String maHD) { MaHD = maHD; }
	public Double getTienHD() { return TienHD; }
	public void setTienHD(Double TienHD) { this.TienHD = TienHD; }
}
