package Tuan7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyKH implements Serializable{
	private ArrayList<KhachHang> qlkh = new ArrayList<KhachHang>();

	public QuanLyKH() {
		this.qlkh = new ArrayList<KhachHang>();
	}
	
	public QuanLyKH(ArrayList<KhachHang> qlkh) {
		this.qlkh = qlkh;
	}
	
	public void nhapThongTinKH() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("------NHẬP THÔNG TIN KHÁCH HÀNG------");
		System.out.println("Nhập số khách hàng: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			KhachHang kh = new KhachHang();
			kh.nhapTTKH();
			this.qlkh.add(kh);
		}
	}

	public void hienThiKH() {
		for (KhachHang a : qlkh) {
			System.out.println(a);
		}
	}
	
	public void nhanDoiTienKH() {
		for (KhachHang kh : qlkh) {
			double tien = kh.getViTien().getTongTienTrongVi();
			kh.getViTien().setTongTienTrongVi(tien * 2);
		}
	}
	
	public ArrayList<KhachHang> getQlkh() {
		return qlkh;
	}

	public void setQlkh(ArrayList<KhachHang> qlkh) {
		this.qlkh = qlkh;
	}
}
