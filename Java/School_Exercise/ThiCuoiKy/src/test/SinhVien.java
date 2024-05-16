package test;

import java.io.Serializable;
import java.util.Scanner;

//Họ tên: Trần Đức Linh
//Mã SV: 725105115

public class SinhVien extends ConNguoi implements Serializable {
	
	
	private String maSinhVien;
	private DiemSo diemSo;
	
	public SinhVien() {
		super();
		diemSo = new DiemSo();
	}

	public SinhVien(String hoTen, String gioiTinh, String maSinhVien, DiemSo diemSo) {
		super(hoTen, gioiTinh);
		this.maSinhVien = maSinhVien;
		this.diemSo = diemSo;
	}


	public void nhapDuLieu() {
		super.nhapDuLieu();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã sinh viên: ");
		this.maSinhVien = sc.nextLine();
		System.out.print("Nhập điểm giữa kì: ");
		this.diemSo.setDiemGiuaKi(Integer.parseInt(sc.nextLine()));
		System.out.print("Nhập điểm cuối kì: ");
		this.diemSo.setDiemCuoiKi(Integer.parseInt(sc.nextLine()));
	}
	
	public void xuatDuLieu() {
		super.xuatDuLieu();
		System.out.println("Mã sinh viên: " + this.maSinhVien);
		System.out.println("Điểm giữa kì: " + this.diemSo.getDiemGiuaKi());
		System.out.println("Điểm cuối kì: " + this.diemSo.getDiemCuoiKi());
		System.out.println("Điểm trung bình: " + this.diemSo.getDiemTB());
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public DiemSo getDiemSo() {
		return diemSo;
	}

	public void setDiemSo(DiemSo diemSo) {
		this.diemSo = diemSo;
	}

	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", diemSo=" + diemSo + ", HoTen=" + getHoTen()
				+ ", GioiTinh=" + getGioiTinh() + "]";
	}
	
	
}
