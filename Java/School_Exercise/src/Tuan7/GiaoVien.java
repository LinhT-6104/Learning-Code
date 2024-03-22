package Tuan7;

import java.io.Serializable;

public class GiaoVien extends NhanSu implements Serializable {
	private String maGV, phongBan;
	private double luong;
	
	public GiaoVien(String maGV, String hoTen, int namSinh, String queQuan, String gioiTinh, String phongBan, double luong) {
		super(hoTen, queQuan, gioiTinh, namSinh);
		this.maGV = maGV;
		this.phongBan = phongBan;
		this.luong = luong;
	}
	
	@Override
	public String toString() {
		return "GiaoVien [maGV=" + maGV + super.toString() + ", phongBan=" + phongBan + ", luong=" + luong + "]";
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

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}
	
	
}
