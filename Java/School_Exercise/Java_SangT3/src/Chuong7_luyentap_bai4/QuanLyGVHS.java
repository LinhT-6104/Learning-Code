package Chuong7_luyentap_bai4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyGVHS {
	public ArrayList<NhanSu> listNS;
	
	public QuanLyGVHS() {
		this.listNS = new ArrayList<>();
	}
	
	public QuanLyGVHS(ArrayList<NhanSu> listNS) {
		this.listNS = listNS;
	}
	
	public void nhapDuLieu() {
		System.out.print("\n------NHẬP DANH SÁCH GIÁO VIÊN VÀ HỌC SINH-----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số lượng giáo viên và học sinh: ");
		int n = sc.nextInt();
		sc.nextLine();	
		for (int i = 0; i < n ; i++) {
			System.out.print("Nhập chức vụ (Giáo viên: gv | Học sinh: hs) :");
			String luaChon = sc.nextLine().toLowerCase().trim();
			if (luaChon.equals("gv")) {
				GiaoVien gv = new GiaoVien();
				gv.nhapDuLieu();
				this.listNS.add(gv);
			} else {
				HocSinh hs = new HocSinh();
				hs.nhapDuLieu();
				this.listNS.add(hs);
			}
		}
	}

	public ArrayList<NhanSu> getListNS() {
		return listNS;
	}

	public void setListNS(ArrayList<NhanSu> listNS) {
		this.listNS = listNS;
	}
	
	public void inDuLieu() {
		System.out.println("------DANH SÁCH GIÁO VIÊN | HỌC SINH------");
		for (int i = 0; i < listNS.size(); i++) {
			System.out.println(this.listNS.get(i));
		}
		System.out.println();
	}
	
	public void inGiaoVien() {
		System.out.println("------DANH SÁCH GIÁO VIÊN------");
		for (int i = 0; i < listNS.size(); i++) {
			if (listNS.get(i) instanceof GiaoVien) {
				System.out.println(this.listNS.get(i));
			}
		}
		System.out.println();
	}
	
	public void inHocSinh() {
		System.out.println("------DANH SÁCH HỌC SINH------");
		for (int i = 0; i < listNS.size(); i++) {
			if (listNS.get(i) instanceof HocSinh) {
				System.out.println(this.listNS.get(i));
			}
		}
		System.out.println();
	}
	
	public double tinhDiemTBHS() {
		int count = 0;
		int sum = 0;
		for (int i = 0; i < listNS.size(); i++) {
			if (listNS.get(i) instanceof HocSinh) {
				HocSinh a = (HocSinh)listNS.get(i);
				sum += a.getDiem();
				count += 1;
			}
		}
		return sum/count;
	}
	
	public void timGVLuongMax() {
		System.out.println("------GIÁO VIÊN CÓ LƯƠNG MAX------");
		double a = 0;
		GiaoVien result = new GiaoVien();
		for (int i = 1; i < listNS.size(); i++) {
			if (listNS.get(i) instanceof GiaoVien) {
				result = (GiaoVien)listNS.get(i);
				if (a < result.getLuong()) {
					a = result.getLuong();
				}
			}
		}
		
		for (int i = 0; i < listNS.size(); i++) {
			if ( (listNS.get(i) instanceof GiaoVien) 
				&& (((GiaoVien)listNS.get(i)).getLuong() == a) ){
				System.out.println(listNS.get(i));
			}
		}
		
		System.out.println();
	}
	
	Comparator<NhanSu> comp = new Comparator<NhanSu>() {
		@Override
		public int compare(NhanSu o1, NhanSu o2) {
			if (o1 instanceof GiaoVien && o2 instanceof GiaoVien) {
				double luong1 = ((GiaoVien)o1).getLuong();
	            double luong2 = ((GiaoVien)o2).getLuong();
				if (luong1 > luong2) return 1;
				else if (luong1 < luong2) return -1;
			}
			return 0;
		}
	};
	
	public void sapXep() {
		Collections.sort(this.listNS, comp);
	}
	
	
}
