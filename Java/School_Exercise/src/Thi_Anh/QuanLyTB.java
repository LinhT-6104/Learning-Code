package Thi_Anh;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyTB {
	private ArrayList<ThietBi> listTB;
	
	public QuanLyTB() {
		listTB = new ArrayList<ThietBi>();
	}

	public QuanLyTB(ArrayList<ThietBi> listTB) {
		this.listTB = listTB;
	}
	
	public void nhapDuLieuDoanhNghiep() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số thiết bị: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			DoanhNghiep DN = new DoanhNghiep();
			DN.nhapDuLieu();
			listTB.add(DN);
		}
	}
	
	public void hienThiDoanhNghiep() {
		for (int i = 0; i < listTB.size(); i++) {
			if (listTB.get(i) instanceof DoanhNghiep) {
				System.out.println(listTB.get(i));
			}
		}
	}
	
	public void hienThiHutBuiDoanhNghiep() {
		for (int i = 0; i < listTB.size(); i++) {
			if (listTB.get(i) instanceof DoanhNghiep) {
				DoanhNghiep dn = (DoanhNghiep) listTB.get(i);
				if (dn.getTenTB().equals("robot hút bụi") && dn.getSoLuongSXTB() == 1000) {
					System.out.println(dn);
				}
			}
		}
	}
	
	public void hienThiHutBui() {
		int count = 0;
		for (int i = 0; i < listTB.size(); i++) {
			if (listTB.get(i) instanceof DoanhNghiep) {
				DoanhNghiep dn = (DoanhNghiep) listTB.get(i);
				if (dn.getTenTB().equals("robot hút bụi")) {
					System.out.println(dn);
					count++;
				}
			}
		}
		System.out.println("Số doanh nghiệp sản xuất thiết bị robot hút bụi: " + count);
	}
	
	public void sapXepDoanhNghiep() {
		for (int i = 0; i < listTB.size() - 1; i++) {
			for (int j = i + 1; j < listTB.size(); j++) {
				if (listTB.get(i) instanceof DoanhNghiep && listTB.get(j) instanceof DoanhNghiep) {
					DoanhNghiep dn1 = (DoanhNghiep) listTB.get(i);
					DoanhNghiep dn2 = (DoanhNghiep) listTB.get(j);
					if (dn1.getSoLuongSXTB() < dn2.getSoLuongSXTB()) {
						listTB.set(i, dn2);
						listTB.set(j, dn1);
					}
				}
			}
		}
	}
	
	public ArrayList<ThietBi> getListTB() {
		return listTB;
	}

	public void setListTB(ArrayList<ThietBi> listTB) {
		this.listTB = listTB;
	}
	
	
}
