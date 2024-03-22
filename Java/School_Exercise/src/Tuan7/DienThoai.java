package Tuan7;

import java.io.Serializable;

public class DienThoai extends HangHoa implements Serializable{
private String maDienThoai, heDieuHanh;
	
	// Constructor DienThoai
	public DienThoai() {
		super();
		this.maDienThoai = this.heDieuHanh = "";
	}

	public DienThoai(String ten, String xuatXu, int namSX, Double donGia, String maDienThoai, String heDieuHanh) {
		super(ten, xuatXu, namSX, donGia);
		this.maDienThoai = maDienThoai;
		this.heDieuHanh = heDieuHanh;
	}
	
	// Hiển thị
	@Override
	public String toString() {
		return super.toString() + ", Mã điện thoại = " + maDienThoai + ", Hệ điều hành = " + heDieuHanh + "]";
	}

	// Setter & Getter DienThoai
	public String getMaDienThoai() { return maDienThoai; }
	public void setMaDienThoai(String maDienThoai) { this.maDienThoai = maDienThoai; }
	public String getHeDieuHanh() { return heDieuHanh; }
	public void setHeDieuHanh(String heDieuHanh) { this.heDieuHanh = heDieuHanh;}	

}
