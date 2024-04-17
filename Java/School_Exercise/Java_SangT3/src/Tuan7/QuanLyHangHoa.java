package Tuan7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyHangHoa implements Serializable{
	private ArrayList<HangHoa_7> listHH;
	public QuanLyHangHoa() {
		this.listHH = new ArrayList<HangHoa_7>();
	}
	public QuanLyHangHoa(ArrayList<HangHoa_7> listHH) {
		this.listHH = listHH;
	}
	
	public void nhapHH() {
		Scanner sc = new Scanner(System.in);
		System.out.println("------NHẬP THÔNG TIN HÀNG HÓA------");
		System.out.print("Nhập số lượng hàng hóa: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập loại hàng hóa (Mỹ phẩm: mp | Điện thoại: dt): ");
			String luaChon = sc.nextLine().toLowerCase().trim();
			if (luaChon.equals("mp")) {
				MyPham_7 mp = new MyPham_7();
				mp.nhapHangHoa();
				this.listHH.add(mp);
			} else {
				DienThoai_7 dt = new DienThoai_7();
				dt.nhapHangHoa();
				this.listHH.add(dt);
			}
		}
	}
	
	public void hienThiHH() {
		System.out.println("------HIỂN THỊ HÀNG HÓA------");
		for (int i = 0; i < listHH.size(); i++) {
			System.out.println(listHH.get(i));
		}
	}
	
	public void hienThiMyPham() {
		System.out.println("\n------MỸ PHẨM------");
		for (int i = 0; i < listHH.size(); i++) {
			if (listHH.get(i) instanceof MyPham_7) {
				System.out.println(listHH.get(i));
			}
		}
	}
	
	public void hienThiDienThoai() {
		System.out.println("\n------ĐIỆN THOẠI------");
		for (int i = 0; i < listHH.size(); i++) {
			if (listHH.get(i) instanceof DienThoai_7) {
				System.out.println(listHH.get(i));
			}
		}
	}
	
	public ArrayList<HangHoa_7> getlistHH() {
		return listHH;
	}
	public void setlistHH(ArrayList<HangHoa_7> listHH) {
		this.listHH = listHH;
	}
	
	
}
