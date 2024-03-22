package Tuan7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Bai3_Tuan_7_BTVN {
	public static void main(String[] args) throws IOException {
		
		// a) Nhập danh sách Mỹ phẩm và Điện thoại (được lưu trong cùng một danh sách - sử dụng ArrayList) 
		ArrayList<HangHoa> hangHoa = new ArrayList<HangHoa>();
		hangHoa.add(new MyPham("mp1", "xxmp1", 1997, 24000.0, "maMP1", "cd1"));
		hangHoa.add(new DienThoai("dth1","xxdth1", 1999, 44000.0, "maDTH1", "Iphone"));
		hangHoa.add(new MyPham("mp2", "xxmp2", 1998, 34000.0, "maMP2", "cd2"));
		hangHoa.add(new DienThoai("dth2","xxdth2", 2000, 55000.0, "maDTH2", "Android"));
		hangHoa.add(new MyPham("mp3", "xxmp3", 1995, 34000.0, "maMP3", "cd3"));
		
		// b) In lại toàn bộ danh sách Mỹ phẩm và Điện thoại đã nhập
		for (HangHoa hanghoa: hangHoa) {
			System.out.println(hanghoa);
		}
		System.out.println();
			
		// c) In danh sách chỉ gồm Mỹ phẩm
		for (HangHoa hanghoa: hangHoa) {
			if (hanghoa instanceof MyPham) {
				System.out.println(hanghoa);
			}
		}
		System.out.println();
		
		// d) In danh sách chỉ gồm Điện thoại
		for (HangHoa hanghoa: hangHoa) {
			if (hanghoa instanceof DienThoai) {
				System.out.println(hanghoa);
			}
		}
		System.out.println();

		// e)Ghi toàn bộ danh sách vào file text 
		File file = new File("D:\\Learning-Code\\Java\\School_Exercise\\src\\Chuong7\\ListHangHoa.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		try {
			objectOutputStream.writeObject(hangHoa);
			System.out.println("Ghi danh sách hàng hóa vào file " + file.getAbsolutePath() + " thành công!");
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra...");
			e.printStackTrace();
		} finally {
			objectOutputStream.close();
			fileOutputStream.close();
		}
		
		// f) Đọc từ file và lưu các đối tượng MyPham hoặc DienThoai vào danh sách và in ra màn hình.
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		try {
			ArrayList<HangHoa> hangHoa_input = (ArrayList<HangHoa>)objectInputStream.readObject();
			for (HangHoa hanghoa: hangHoa_input) {
				System.out.println(hanghoa);
			}
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra");
			e.printStackTrace();
		} finally {
			objectInputStream.close();
			fileInputStream.close();
		}
		
	}
}
