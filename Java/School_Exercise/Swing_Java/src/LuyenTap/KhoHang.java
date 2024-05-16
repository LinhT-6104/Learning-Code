package LuyenTap;

import java.io.Serializable;

public class KhoHang implements Serializable{
	private int soLuong;
	private boolean conHang;
	
	public KhoHang() { }

	public KhoHang(int soLuong, boolean conHang) {
		this.soLuong = soLuong;
		this.conHang = conHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public boolean isConHang() {
		return conHang;
	}

	public void setConHang(boolean conHang) {
		this.conHang = conHang;
	}

	@Override
	public String toString() {
		return "KhoHang [soLuong=" + soLuong + ", conHang=" + conHang + "]";
	}
	
	
}
