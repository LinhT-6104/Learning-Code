//Tran_Duc_Linh_725105115
package BaiTap;

import java.util.ArrayList;

public class main_725105115 {
	public static void main(String[] args) {
		ArrayList<HinhChuNhat> listHCN = new ArrayList<HinhChuNhat>();
		listHCN.add(new HinhChuNhat("ma1", "Do", 15, 57, new KhoHang(15, false)));
		listHCN.add(new HinhChuNhat("ma2", "Xanh", 2, 52, new KhoHang(25, true)));
		listHCN.add(new HinhChuNhat("ma3", "Tim", 4, 652, new KhoHang(54, true)));
		listHCN.add(new HinhChuNhat("ma4", "Do", 125, 4, new KhoHang(3, true)));
		listHCN.add(new HinhChuNhat("ma5", "Do", 1, 12, new KhoHang(45, true)));
		
		QuanLyKhoHang qlkh = new QuanLyKhoHang(listHCN);
		
		// Câu 1
		// qlkh.nhapDuLieu();
		qlkh.ghiFile(listHCN);
		
		// Câu 2
		qlkh.hienThiDuLieuFile();
	}
}
