package Tuan6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Collections;

public class QuanLySinhVien {
	private ArrayList<SinhVien> listSV;
	
	public QuanLySinhVien() {
		this.listSV = new ArrayList<>();
	}
	public QuanLySinhVien(ArrayList<SinhVien> listSV) {
		this.listSV = listSV;
	}
	public void hienThi() {
		System.out.println("-----------DANH SÁCH SINH VIÊN-------------");
		for (SinhVien sv: this.listSV) {
			System.out.print(sv);
		}
	}
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số lượng sinh viên: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			SinhVien sv = new SinhVien();
			sv.nhapDuLieu();
			this.listSV.add(sv);
		}
	}
	public void sinhVienTuoiTren25() {
		System.out.println("------SINH VIÊN TUỔI > 25------");
		for (SinhVien sv: this.listSV) {
			if (sv.getTuoi() > 25) { System.out.print(sv); };
		}
	}
	public void sinhVienTheoGT(int gt) {
		String gioiTinh = "";
		if (gt == 0) { gioiTinh = "NỮ";}
		else if (gt == 1) { gioiTinh = "NAM"; }
		else { gioiTinh = "GT KHÁC"; }
		System.out.println("------SINH VIÊN " + gioiTinh + "-------");
		for (SinhVien sv : this.listSV) {
			if (sv.getGioiTinh() == gt ) { System.out.print(sv); }
		}
	}
	Comparator<SinhVien> soSanhSV = new Comparator<SinhVien>() {
		@Override
		public int compare(SinhVien o1, SinhVien o2 ) {
			if (o1.getDiemTB() > o2.getDiemTB()) { return 1; }
			else if (o1.getDiemTB() < o2.getDiemTB()) { return -1; }
			else { return 0; }
		}
	};
	
	public void sapXepDSSV() {
		Collections.sort(this.listSV, soSanhSV);
	}
	
	public ArrayList<SinhVien> getListSV() {
		return listSV;
	}
	public void setListSV(ArrayList<SinhVien> listSV) {
		this.listSV = listSV;
	}
}
