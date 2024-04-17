package Tuan9;

import java.io.Serializable;
import java.util.Scanner;

public class MyPham extends HangHoa implements Serializable{
	private String maMP;
	private String congDung;
	public MyPham() {}
	public MyPham(String tenHH, String xuatXu, int namSX, double donGia, String maMP, String congDung) {
		super(tenHH, xuatXu, namSX, donGia);
		this.maMP = maMP;
		this.congDung = congDung;
	}
	
	@Override
	public String toString() {
		return "MyPham [maMP=" + maMP + ", congDung=" + congDung + ", tenHH=" + getTenHH() + ", XuatXu="
				+ getXuatXu() + ", namSX=" + getNamSX() + ", donGia=" + getDonGia() + "]";
	}
	
	public void nhapDuLieu() {
		System.out.println("\n------NHẬP MỸ PHẨM------");
		super.nhapDuLieu();		// Nhập thuộc tính của lớp HangHoa
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã mỹ phẩm: ");
		this.maMP = sc.nextLine();
		System.out.print("Nhập công dụng mỹ phẩm: ");
		this.congDung = sc.nextLine();
	}
	
	public String getMaMP() {
		return maMP;
	}
	public void setMaMP(String maMP) {
		this.maMP = maMP;
	}
	public String getCongDung() {
		return congDung;
	}
	public void setCongDung(String congDung) {
		this.congDung = congDung;
	}
	
	
}
