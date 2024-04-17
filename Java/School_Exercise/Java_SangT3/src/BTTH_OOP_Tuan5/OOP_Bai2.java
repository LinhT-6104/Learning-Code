package BTTH_OOP_Tuan5;

import java.util.ArrayList;
import java.util.Scanner;

// Họ tên: Trần Đức Linh
// Mã Sinh viên: 725105115
public class OOP_Bai2 {
	public static void main(String[] args) {	
		QuanLyDaGiac qldg = new QuanLyDaGiac();
		
		ArrayList<DaGiac> listQLDG = new ArrayList<>();
		listQLDG.add(new TamGiac(3, new int[]{30,50,40}));
		listQLDG.add(new TamGiac(3, new int[]{110,70,90}));
		listQLDG.add(new TamGiac(3, new int[]{40,10,60}));
		listQLDG.add(new TamGiac(3, new int[]{100,60,80}));
		
		// Câu 4
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Nhập số lượng tam giác: ");
//		int n = sc.nextInt();
//		sc.nextLine();
//		for (int i = 0; i < n; i++) {
//			listQLDG.get(i).nhapTT();
//		}

		qldg.setQldg(listQLDG);
		qldg.inDanhSach();	// Câu 4
		qldg.canhMaxTamGiac();	// Câu 5
		qldg.search(2);
		System.out.println("\n------MẢNG TAM GIÁC TĂNG DẦN THEO DIỆN TÍCH------");
		qldg.sapXepDienTich();
		qldg.inDanhSach();
	}
}
