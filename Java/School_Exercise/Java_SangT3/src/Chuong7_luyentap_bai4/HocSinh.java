package Chuong7_luyentap_bai4;

import java.io.Serializable;
import java.util.Scanner;

public class HocSinh extends NhanSu implements Serializable{
	private String maHS;
	private String lop;
	private Double diem;
	
	public HocSinh() {}

	public HocSinh(String maHS, String hoTen, int namSinh, String queQuan, int gioiTinh, String lop, Double diem) {
		super(hoTen, namSinh, queQuan, gioiTinh);
		this.maHS = maHS;
		this.lop = lop;
		this.diem = diem;
	}

	@Override
	public String toString() {
		return "HocSinh [ma HS=" + diem + ", hoTen()=" + getHoTen() + ", namSinh()=" + getNamSinh() 
				+ ", queQuan()=" + getQueQuan() + ", gioiTinh()=" + getGioiTinh() + maHS 
				+ ", lop=" + lop + ", diem="  + diem + "]";
	}
	
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n------NHẬP HỌC SINH------");
		System.out.print("Nhập mã HS: ");
		this.maHS = sc.nextLine();
		super.nhapDuLieu();
		System.out.print("Nhập lớp: ");
		this.lop = sc.nextLine();
		System.out.print("Nhập điểm: ");
		this.diem = Double.parseDouble(sc.nextLine());
	}

	public String getMaHS() {
		return maHS;
	}

	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public Double getDiem() {
		return diem;
	}

	public void setDiem(Double diem) {
		this.diem = diem;
	}
}
