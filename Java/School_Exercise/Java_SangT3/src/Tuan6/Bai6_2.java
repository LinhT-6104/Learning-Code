package Tuan6;

public class Bai6_2 {
	public static void main (String[] args) {
		QuanLySinhVien qlsv = new QuanLySinhVien();

		qlsv.getListSV().add(new SinhVien("SV001", "A", 19, 9.2, 1));
		qlsv.getListSV().add(new SinhVien("SV002", "B", 20, 8, 0));
		qlsv.getListSV().add(new SinhVien("SV003", "C", 23, 7.6, 0));
		qlsv.getListSV().add(new SinhVien("SV004", "D", 21, 9.5, 1));
		qlsv.getListSV().add(new SinhVien("SV005", "E", 19, 8.5, 1));
		qlsv.hienThi();
		qlsv.sinhVienTuoiTren25();
		qlsv.sinhVienTheoGT(0);
		qlsv.sapXepDSSV();
		qlsv.hienThi();
	}
}
