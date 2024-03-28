package Tuan7;

import java.io.Serializable;
import java.util.Scanner;

public class ViTien implements Serializable{
	private String maVT;
	private double tongTienTrongVi;
	
	public ViTien() {}
	public ViTien(String maVT, double tongTienTrongVi) {
		super();
		this.maVT = maVT;
		this.tongTienTrongVi = tongTienTrongVi;
	}
	
	public void nhapViTien() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã hóa đơn: ");
		this.maVT = sc.nextLine();
		System.out.print("Nhập tổng tiền hoán đơn: ");
		this.tongTienTrongVi = Double.parseDouble(sc.nextLine());
	}
	
	@Override
	public String toString() {
		return "ViTien [maVT=" + maVT + ", tongTienTrongVi=" + tongTienTrongVi + "]";
	}
	
	// GETTER | SETTER
	public String getmaVT() {
		return maVT;
	}
	public void setmaVT(String maVT) {
		this.maVT = maVT;
	}
	public double getTongTienTrongVi() {
		return tongTienTrongVi;
	}
	public void setTongTienTrongVi(double tongTienTrongVi) {
		this.tongTienTrongVi = tongTienTrongVi;
	}
	
	
}
