package Tuan7;

import java.io.Serializable;
import java.util.Scanner;

public class DienThoai_7 extends HangHoa_7 implements Serializable{
	private String maDT;
	private String heDieuHanh;
	
	public DienThoai_7() {
	}

	public DienThoai_7(String maDT, String heDieuHanh, String ten, String xuatXu, int namSX, double donGia) {
		super(ten, xuatXu, namSX, donGia);
		this.maDT = maDT;
		this.heDieuHanh = heDieuHanh;	
	}
	
	public void nhapHangHoa() {
		Scanner sc = new Scanner(System.in);
		super.nhapHangHoa();
		System.out.print("Nhập mã điện thoại: ");
		this.maDT = sc.nextLine();
		System.out.print("Nhập hệ điều hành: ");
		this.heDieuHanh = sc.nextLine();
	}

	@Override
	public String toString() {
		return "DienThoai_7 [maDT=" + maDT + ", heDieuHanh=" + heDieuHanh + ", te)=" + getTen() + ", xuatXu="
				+ getXuatXu() + ", namSX=" + getNamSX() + ", donGia=" + getDonGia() + "]";
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
