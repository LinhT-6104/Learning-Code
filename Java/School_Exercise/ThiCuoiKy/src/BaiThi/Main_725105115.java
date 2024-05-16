// Tran_Duc_Linh_725105115
package BaiThi;

import java.util.ArrayList;

public class Main_725105115 {
	public static void main(String[] args) {
		ArrayList<GiaoTrinh> listGiaoTrinh = new ArrayList<GiaoTrinh>();
		QuanLyGiaoTrinh qlgt = new QuanLyGiaoTrinh();
		
		// Câu 1
		System.out.println("------------Câu a------------");
		qlgt.nhapDuLieu();
		
		// Câu 2
		System.out.println("\n------------Câu b------------");
		qlgt.hienThiDuLieuFile();
		
		// Câu 3
		System.out.println("\n------------Câu c------------");
		qlgt.demGiaoTrinhNangCao();
		
		// Câu 4
		System.out.println("\n------------Câu d------------");
		qlgt.sapXepGiaoTrinh();
	}
}
