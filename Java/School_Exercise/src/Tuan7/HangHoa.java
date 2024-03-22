package Tuan7;

import java.io.Serializable;

public class HangHoa implements Serializable{
	private String ten, xuatXu;
	private int namSX;
	private Double donGia;
	
	// Constructor HangHoa
	public HangHoa () {
		this.ten = this.xuatXu = "";
		this.namSX = 0;
		this.donGia = 0.0;
	}

	public HangHoa(String ten, String xuatXu, int namSX, Double donGia) {
		super();
		this.ten = ten;
		this.xuatXu = xuatXu;
		this.namSX = namSX;
		this.donGia = donGia;
	}

	// Hiển thị
	@Override
	public String toString() {
		return "[Tên = " + ten + ", Xuất xứ = " + xuatXu + ", Năm sản xuất = " + namSX + ", Đơn giá = "  + donGia;
	}
	
	// Setter & getter HangHoa
	public String getTen() { return ten; }
	public void setTen(String ten) { this.ten = ten; }
	public String getxuatXu() { return xuatXu; }
	public void setxuatXu(String xuatXu) { this.xuatXu = xuatXu; }
	public double getNamSX() { return namSX; }
	public void setNamSX(int namSX) { this.namSX = namSX; }
	public Double getDonGia() { return donGia; }
	public void setDonGia(Double donGia) { this.donGia = donGia; }
}
