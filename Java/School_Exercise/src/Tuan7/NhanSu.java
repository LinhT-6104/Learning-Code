package Tuan7;

import java.io.Serializable;

public class NhanSu implements Serializable{
	private String hoTen, queQuan, gioiTinh;
	private int namSinh;
	
	public NhanSu(String hoTen, String queQuan, String gioiTinh, int namSinh) {
		super();
		this.hoTen = hoTen;
		this.queQuan = queQuan;
		this.gioiTinh = gioiTinh;
		this.namSinh = namSinh;
	}
	
	@Override
	public String toString() {
		return ", hoTen=" + hoTen + ", queQuan=" + queQuan + ", gioiTinh=" + gioiTinh + ", namSinh=" + namSinh;
	}

	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	
}
