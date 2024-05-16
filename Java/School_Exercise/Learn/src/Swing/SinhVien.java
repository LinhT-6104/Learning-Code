package Swing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SinhVien implements Serializable{
	private String maSV;
	private String hoVaTen;
	private String Khoa;
	private float diemTB;
	private Date ngaySinh;
	private boolean gioiTinh; // true: nam || false: nữ
	private ArrayList<String> listKyNang;
	
	public SinhVien() {}

	public SinhVien(String maSV, String hoVaTen, String khoa, float diemTB, Date ngaySinh, boolean gioiTinh,
			ArrayList<String> listKyNang) {
		super();
		this.maSV = maSV;
		this.hoVaTen = hoVaTen;
		Khoa = khoa;
		this.diemTB = diemTB;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.listKyNang = listKyNang;
	}

	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoVaTen=" + hoVaTen
				+ ", \nngaySinh=" + ngaySinh + ", Khoa=" + Khoa 
				+ ", \ngioiTinh=" + gioiTinh + ", diemTB=" + diemTB
				+ ", \nlistKyNang=" + listKyNang + "]";
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
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

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
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
}
