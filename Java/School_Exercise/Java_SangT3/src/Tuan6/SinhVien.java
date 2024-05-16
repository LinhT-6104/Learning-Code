package Tuan6;

import java.io.Serializable;
import java.util.Scanner;

public class SinhVien implements Serializable {
	private String maSV;
	private String hoTen;
	private int tuoi;
	private double diemTB;
	private int gioiTinh;	// Nam = 1, Nữ = 0, Khác = Giá trị còn lại
	public SinhVien() {};
	public SinhVien(String maSV, String hoTen, int tuoi, double diemTB, int gioiTinh) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.diemTB = diemTB;
		this.gioiTinh = gioiTinh;
	}
	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoTen=" + hoTen + ", tuoi=" + tuoi + ", diemTB=" + diemTB + ", gioiTinh="
				+ gioiTinh + "]\n";
	}
	public void hienThi() {
		System.out.println(this.toString());
	}
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã sinh viên: ");
		this.maSV = sc.nextLine();
		System.out.print("Nhập họ tên SV: ");
		this.hoTen = sc.nextLine();
		System.out.print("Nhập tuổi SV: ");
		this.tuoi = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập điểm trung bình SV: ");
		this.diemTB = Double.parseDouble(sc.nextLine());
		System.out.println("Nhập giới tính SV: ");
		this.gioiTinh = Integer.parseInt(sc.nextLine());
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public double getDiemTB() {
		return diemTB;
	}
	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
}
