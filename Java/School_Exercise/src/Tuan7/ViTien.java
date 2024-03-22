package Tuan7;

import java.io.Serializable;
//import java.util.Scanner;

public class ViTien implements Serializable{
	private String maVT;
	private Double tongTienVi;
	
	public ViTien() {
		this.maVT = "";
		this.tongTienVi = 0.0;
	}
	public ViTien(String maVT, Double tongTienVi) {
		this.maVT = maVT;
		this.tongTienVi = tongTienVi;
	}
	
	public String getMaVT() { return maVT; }
	public void setMaVT(String maVT) { this.maVT = maVT; }
	public Double getTongTienVi() { return tongTienVi; }
	public void setTongTienVi(Double tongTienVi) { this.tongTienVi = tongTienVi; }	
	
//	Scanner sc = new Scanner(System.in);
	
//	public void nhapDuLieu() {
//		System.out.print("Nhập mã ví: ");
//		this.maVT = sc.next();
//		System.out.print("Nhập tổng số tiền trong ví: ");
//		this.tongTienVi = sc.nextDouble();
//	}
	@Override
	public String toString() {
		return "Ma vi tien = " + maVT + ", So tien trong vi = " + tongTienVi + "]";
	}

}
