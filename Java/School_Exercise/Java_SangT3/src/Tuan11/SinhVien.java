package Tuan11;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SinhVien implements Serializable {
	private String maSV;
	private String hoTen;
	private Date ngaySinh;
	private String Khoa;
	private float diemTB;
	private boolean gioiTinh;
	private ArrayList<String> listKyNang;
	
	public SinhVien() {}

	public SinhVien(String maSV, String hoTen, Date ngaySinh, String khoa, float diemTB, boolean gioiTinh,
			ArrayList<String> listKyNang) {
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		Khoa = khoa;
		this.diemTB = diemTB;
		this.gioiTinh = gioiTinh;
		this.listKyNang = listKyNang;
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

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getKhoa() {
		return Khoa;
	}

	public void setKhoa(String khoa) {
		Khoa = khoa;
	}

	public float getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(float diemTB) {
		this.diemTB = diemTB;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public ArrayList<String> getListKyNang() {
		return listKyNang;
	}

	public void setListKyNang(ArrayList<String> listKyNang) {
		this.listKyNang = listKyNang;
	}

	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoTen=" + hoTen 
				+ ", \nngaySinh=" + ngaySinh + ", Khoa=" + Khoa 
				+ ", \ndiemTB=" + diemTB + ", gioiTinh=" + gioiTinh 
				+ ", \nlistKyNang=" + listKyNang + "]";
	}
	
	
}
