package Chuong7_luyentap_bai4;

import java.io.Serializable;
import java.util.Scanner;

public class GiaoVien extends NhanSu implements Serializable {
	private String maGV;
	private String phongBan;
	private Double luong;
	
	public GiaoVien() {}

	public GiaoVien(String maGV, String hoTen, int namSinh, String queQuan, int gioiTinh,  String phongBan, Double luong) {
		super(hoTen, namSinh, queQuan, gioiTinh);
		this.maGV = maGV;
		this.phongBan = phongBan;
		this.luong = luong;
	}

	@Override
	public String toString() {
		return "GiaoVien [maGV=" + maGV + ", hoTen()=" + getHoTen() + ", namSinh()=" + getNamSinh() 
		+ ", queQuan()=" + getQueQuan() + ", gioiTinh()=" + getGioiTinh()  + ", phongBan=" +  phongBan 
		+ ", luong=" + luong + "]";
	}
	
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n------NHẬP GIÁO VIÊN------");
		System.out.print("Nhập mã GV: ");
		this.maGV = sc.nextLine();
		super.nhapDuLieu();
		System.out.print("Nhập phòng ban: ");
		this.phongBan = sc.nextLine();
		System.out.print("Nhập lương: ");
		this.luong = Double.parseDouble(sc.nextLine());
	}

	public String getMaGV() {
		return maGV;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public Double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}
}
