package Tuan9;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyHangHoa implements Serializable{
	private ArrayList<HangHoa> listHH;
	public QuanLyHangHoa() {
		this.listHH = new ArrayList<HangHoa>();
	}
	public QuanLyHangHoa(ArrayList<HangHoa> lstHH) {
		this.listHH = lstHH;
	}
	
	public void hienThi() {			// Câu B
		System.out.println("------DANH SÁCH HÀNG HÓA------");
		for (int i = 0; i < this.listHH.size(); i++) {
			System.out.println(this.listHH.get(i));
		}
	}
	
	public void hienThiMyPham() {	// Câu C
		System.out.println("\n------DANH SÁCH MỸ PHẨM-------");
		for (int i = 0; i < this.listHH.size(); i++) {
			if (this.listHH.get(i) instanceof MyPham) {
				System.out.println(this.listHH.get(i));
			}
		}
	}
	
	public void hienThiDienThoai() {	// Câu D
		System.out.println("\n------DANH SÁCH ĐIỆN THOẠI-------");
		for (int i = 0; i < this.listHH.size(); i++) {
			if (this.listHH.get(i) instanceof DienThoai) {
				System.out.println(this.listHH.get(i));
			}
		}
	}
	
	public void nhapDuLieu() {	// Câu A
		System.out.println("\nNHẬP DANH SÁCH HÀNG HÓA-------");
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số lượng hàng hóa: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập loại hàng (mp: mỹ phẩm | dt: điện thoại): ");
			String luaChon = sc.nextLine();
			if (luaChon.equals("mp")) {
				MyPham mp = new MyPham();
				mp.nhapDuLieu();
				this.listHH.add(mp);
			} else {
				DienThoai dt = new DienThoai();
				dt.nhapDuLieu();
				this.listHH.add(dt);
			}
		}
	}
	public ArrayList<HangHoa> getListHH() {
		return listHH;
	}
	public void setListHH(ArrayList<HangHoa> listHH) {
		this.listHH = listHH;
	}
	
}
