package Tuan7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


// Họ tên: Trần Đức Linh
// Mã sinh viên: 725105115
public class Bai3 {
	public static void main(String[] args) {
		QuanLyHangHoa qlhh = new QuanLyHangHoa();
		ArrayList<HangHoa_7> listHangHoa = new ArrayList<HangHoa_7>();
		listHangHoa.add(new MyPham_7("mp001", "Trị gàu", "Dầu gội", "Việt Nam", 2015, 75000));
		listHangHoa.add(new MyPham_7("mp002", "Lưu hương", "Nước hoa", "Pháp", 2020, 3570000));
		listHangHoa.add(new MyPham_7("mp003", "Trị mụn", "Sữa rửa mặt", "Mỹ", 2024, 256000));
		listHangHoa.add(new DienThoai_7("dt001", "Android", "Xiaomi 13", "Trung Quốc", 2023, 6255000));
		listHangHoa.add(new DienThoai_7("dt002", "iOS", "Iphone 15", "Mỹ", 2024, 26150000));
		listHangHoa.add(new DienThoai_7("dt003", "Android", "Vinsmart 8", "Việt Nam", 2019, 7125000));
//		qlhh.nhapHH();
		qlhh.setlistHH(listHangHoa);
		qlhh.hienThiHH();
		qlhh.hienThiMyPham();
		qlhh.hienThiDienThoai();
				
		FileOutputStream foStream = null;
		ObjectOutputStream objoStream = null;
		
	}
}
