//Tran_Duc_Linh_725105115
package BaiThi;

import java.io.Serializable;

public class PhanLoai implements Serializable{
		
	private String loai;	
	private int soLuong;
	
	public PhanLoai() {
		
	}

	public PhanLoai(String loai, int soLuong) {
		this.loai = loai;
		this.soLuong = soLuong;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "PhanLoai [loai=" + loai + ", soLuong=" + soLuong + "]";
	}
}
