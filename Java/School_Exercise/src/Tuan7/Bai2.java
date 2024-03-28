package Tuan7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

// Họ tên: Trần Đức Linh
// Mã sinh viên: 725105115
public class Bai2 {
	public static void main(String[] args) throws Exception{
		// Câu a
		ArrayList<KhachHang> listKH = new ArrayList<>();
		listKH.add(new KhachHang("MaKH1", "KH1", "cmnd1", 1997, "kh1@gmail.com", 
					1111, new ArrayList<HoaDon>(Arrays.asList(new HoaDon("hd1", 
					123.0), new HoaDon("hd2", 234.0)) ), new ViTien("Vt1", 22222)));
		
		listKH.add(new KhachHang("MaKH2", "KH2", "cmnd2", 1999, "kh2@gmail.com", 
				2222, new ArrayList<HoaDon>(Arrays.asList(new HoaDon("hd1", 
				321.0), new HoaDon("hd2", 432.0)) ), new ViTien("Vt2", 44444)));
	
		listKH.add(new KhachHang("MaKH3", "KH3", "cmnd3", 2001, "kh3@gmail.com", 
				3333, new ArrayList<HoaDon>(Arrays.asList(new HoaDon("hd1", 
				213.0), new HoaDon("hd2", 243.0)) ), new ViTien("Vt3", 66666)));
		
		QuanLyKH qlkh = new QuanLyKH(listKH);
		qlkh.nhanDoiTienKH();	// Câu b

		String dirPath = "D:\\Learning-Code\\Java\\School_Exercise\\src\\Tuan7\\";
		String fileName = "ListKhachHang.txt";
		String filePath = dirPath + fileName;
		
		File Directory = new File(dirPath);
		if (!Directory.exists()) {
			Directory.mkdirs();
		}
		
		File file = new File(filePath);
		if (!file.exists()) {
			file.createNewFile();
		}
		
		// Câu c
		FileOutputStream foStream = null;
		ObjectOutputStream objoStream = null;
		try {
			foStream = new FileOutputStream(file);
			objoStream = new ObjectOutputStream(foStream);
			objoStream.writeObject(qlkh);
			System.out.println("Ghi file thành công!");
			objoStream.close();
			foStream.close();
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra ở output..." + e);
		}
		
		// Câu d
		QuanLyKH qlkh_input = null;
		FileInputStream fiStream = null;
		ObjectInputStream objiStream = null;
		try {
			fiStream = new FileInputStream(file);
			objiStream = new ObjectInputStream(fiStream);
			qlkh_input = (QuanLyKH)objiStream.readObject();
			objiStream.close();
			fiStream.close();
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra ở input..." + e);
		}
		qlkh_input.hienThiKH();
	}
}
