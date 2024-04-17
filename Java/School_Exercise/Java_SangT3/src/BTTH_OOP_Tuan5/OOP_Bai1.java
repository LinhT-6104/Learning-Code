package BTTH_OOP_Tuan5;

import java.util.Scanner;

// Họ tên: Trần Đức Linh
// Mã SV: 725105115

public class OOP_Bai1 extends CD {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.print("Nhập số CD tối đa: ");
//		int n = sc.nextInt();
//		sc.nextLine();
		
		QuanLyCD qlcd = new QuanLyCD();
		
		CD[] danhSachCD = new CD[10];
		
		danhSachCD[0] = new CD(1, "cd1", "Duy Mạnh", 6, 12000);
		danhSachCD[1] = new CD(3, "cd2", "Đàm Vĩnh Hưng", 12, 7444000);
		danhSachCD[2] = new CD(2, "cd3", "MCK", 35, 156000);
		danhSachCD[3] = new CD(4, "cd5", "TLinh", 23, 435000);
		
		qlcd.setDanhSachCD(danhSachCD);
		
		System.out.println("SỐ LƯỢNG CD TRONG DANH SÁCH: " + qlcd.soLuongCD());
		System.out.println("TỔNG GIÁ THÀNH CỦA CÁC CD: " + qlcd.tongGiaThanh());
		qlcd.sapXepGiaThanh();
//		qlcd.sapXepTuaCD();
		qlcd.inDanhSachCD();
		
	}
}
