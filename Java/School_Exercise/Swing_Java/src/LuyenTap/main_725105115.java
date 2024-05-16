package LuyenTap;

import java.util.ArrayList;

public class main_725105115 {
	public static void main(String[] args) {
		ArrayList<HinhChuNhat> listHCN = new ArrayList<HinhChuNhat>();
		listHCN.add(new HinhChuNhat("m1", "Do", 200, 500, new KhoHang(200, true)));
		listHCN.add(new HinhChuNhat("m2", "Xanh", 300, 512, new KhoHang(100, true)));
		listHCN.add(new HinhChuNhat("m3", "Do", 512, 300, new KhoHang(0, false)));
		listHCN.add(new HinhChuNhat("m4", "Hong", 20, 200, new KhoHang(240, true)));
		listHCN.add(new HinhChuNhat("m5", "Vang", 300, 432, new KhoHang(142, false)));
		
		QuanLyKhoHang qlkh = new QuanLyKhoHang(listHCN);

		// Câu 1
		// qlkh.nhapDuLieu();
		 qlkh.ghiFile(listHCN);
		
		// Câu 2
		qlkh.docDuLieuFile();
		
		// Câu 3
		qlkh.soLuongDoChoiMauDo();
		
		// Câu 4
		qlkh.cviMin_dtichMax();
		
		// Câu 5
		qlkh.soLuongDTHCN();
	}
}
