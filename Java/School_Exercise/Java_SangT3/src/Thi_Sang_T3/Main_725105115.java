package Thi_Sang_T3;

import java.util.ArrayList;

// Họ tên: Trần Đức Linh
// Mã sinh viên: 725105115
public class Main_725105115 {
	public static void main(String[] args) {
		ArrayList<HangHoa> listHH = new ArrayList<HangHoa>();
		
		listHH.add(new SmartPhone("MaDT1", "DT1", 2400000, 5000, "Android", 40009, true));
        listHH.add(new SmartPhone("MaDT4", "DT1", 2400000, 5000, "Android", 500, false));
        listHH.add(new SmartPhone("MaDT3", "DT3", 4200000, 5000, "Android", 45, false));
        listHH.add(new SmartPhone("MaDT2", "DT2", 1500000, 3000, "HDH2", 55000, true));
        listHH.add(new Oto("MaOto1", "Oto1", 40000000, 20000, 2012, "Tự động", 320, "Xanh"));
        listHH.add(new Oto("MaOto2", "Oto2", 50000000, 40000, 2011, "Số sàn", 240, "Đỏ"));
        listHH.add(new Oto("MaOto3", "Oto2", 90000000, 60000, 2020, "Số sàn", 500, "Tím"));

		QuanLyHH qlhh = new QuanLyHH(listHH);
		// Câu a
//		qlhh.nhapDuLieu();
		qlhh.hienThiHH();
		qlhh.hienThiDienThoai();
		qlhh.hienThiOto();
		
		// Câu b
		System.out.println("\nCau b: " + qlhh.tongTienAndroid());
		
		// Câu c
		System.out.println("\nCÂU C: " + qlhh.demAndroidTM());
		
		// Câu d
		qlhh.sapXep();
		qlhh.hienThiHH();
		
		// Câu f
		System.out.println("\nCâu F: ");
		qlhh.xoaOto();
		qlhh.hienThiHH();
	}
}
