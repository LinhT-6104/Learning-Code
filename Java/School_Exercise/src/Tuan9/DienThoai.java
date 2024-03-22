package Tuan9;

import java.io.Serializable;
import java.util.Scanner;

public class DienThoai extends HangHoa implements Serializable {
	private String maDT;
	private String heDieuHanh;
	
	public DienThoai() {}

	public DienThoai(String tenHH, String xuatXu, int namSX, double donGia, String maDT, String heDieuHanh) {
		super(tenHH, xuatXu, namSX, donGia);
		this.maDT = maDT;
		this.heDieuHanh = heDieuHanh;
	}
	
	public void nhapDuLieu() {
		System.out.println("\n------NHẬP ĐIỆN THOẠI------");
		super.nhapDuLieu();		// Nhập thuộc tính của lớp HangHoa
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã điện thoại: ");
		this.maDT = sc.nextLine();
		System.out.print("Nhập công dụng điện thoại: ");
		this.heDieuHanh = sc.nextLine();
	}

	@Override
	public String toString() {
		return "DienThoai [maDT=" + maDT + ", heDieuHanh=" + heDieuHanh + ", tenHH=" + getTenHH()
				+ ", xuatXu=" + getXuatXu() + ", xamSX=" + getNamSX() + ", donGia=" + getDonGia() + "]";
	}

	public String getMaDT() {
		return maDT;
	}
	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}
	public String getHeDieuHanh() {
		return heDieuHanh;
	}

	public void setHeDieuHanh(String heDieuHanh) {
		this.heDieuHanh = heDieuHanh;
	}
	
}
