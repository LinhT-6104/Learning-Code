package Tuan9;

import java.util.ArrayList;

// Mã sv: 725105115
// Họ tên: Trần Đức Linh
public class MainProgram_725105115 {
	public static void main(String[] args) {
		QuanLyHangHoa qlHangHoa = new QuanLyHangHoa();
//		qlHangHoa.nhapDuLieu();		// Câu A
//		qlHangHoa.hienThi();		// Câu B
		ArrayList<HangHoa> listHangHoa = new ArrayList<HangHoa>();
		listHangHoa.add(new MyPham("Dầu gội", "Việt Nam", 2015, 75000, "mp001", "Trị gàu"));
		listHangHoa.add(new MyPham("Nước hoa", "Pháp", 2020, 3570000, "mp002", "Lưu hương"));
		listHangHoa.add(new MyPham("Sữa rửa mặt", "Mỹ", 2024, 256000, "mp003", "Trị mụn"));
		listHangHoa.add(new DienThoai("Xiaomi 13", "Trung Quốc", 2023, 6255000, "dt001", "Android"));
		listHangHoa.add(new DienThoai("Iphone 15", "Mỹ", 2024, 26150000, "dt002", "iOS"));
		listHangHoa.add(new DienThoai("Vinsmart 8", "Việt Nam", 2019, 7125000, "dt003", "Android"));
		qlHangHoa.setListHH(listHangHoa);
		qlHangHoa.nhapDuLieu();
		qlHangHoa.hienThi();
		qlHangHoa.hienThiMyPham();
		qlHangHoa.hienThiDienThoai();
	}
}
