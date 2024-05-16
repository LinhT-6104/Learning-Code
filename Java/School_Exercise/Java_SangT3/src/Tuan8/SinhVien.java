package Tuan8;

import java.io.Serializable;

public class SinhVien implements Serializable {
	private String maSV, hoTen;
	private double gpa;
	private SinhVien() { }
	public SinhVien(String maSV, String hoTen, double gpa) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.gpa = gpa;
	}
	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoTen=" + hoTen + ", gpa=" + gpa + "]";
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
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
