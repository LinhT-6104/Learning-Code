package Tuan7;

import java.io.Serializable;

public class HocSinh extends NhanSu implements Serializable{
	private String maHS, lop;
	private double diem;
	
	public HocSinh(String maHS, String hoTen, int namSinh, String queQuan, String gioiTinh, String lop, double diem) {
		super(hoTen, queQuan, gioiTinh, namSinh);
		this.maHS = maHS;
		this.lop = lop;
		this.diem = diem;
	}
	
	@Override
	public String toString() {
		return "HocSinh [maHS=" + maHS + super.toString() + ", lop=" + lop + ", diem=" + diem + "]";
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
	public double getDiem() {
		return diem;
	}
	public void setDiem(double diem) {
		this.diem = diem;
	}
	
}
