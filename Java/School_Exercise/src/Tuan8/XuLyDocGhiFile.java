package Tuan8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class XuLyDocGhiFile {
	public void ghiFile(File file, String data) {
		FileOutputStream foStream = null;
		byte[] byteData = null;
		try {
			foStream = new FileOutputStream(file);
			byteData = data.getBytes();
			foStream.write(byteData);
			System.out.println("Ghi thanh cong: " + file.getAbsolutePath());
			foStream.close();
		} catch (Exception e) {
			System.out.println("Co loi xay ra..." + e);
		}
	}
	
	public void ghiSinhVien(File file, SinhVien sv) {
		FileOutputStream foStream = null;
		ObjectOutputStream objOutputStream = null;
		try {
			foStream = new FileOutputStream(file);
			objOutputStream = new ObjectOutputStream(foStream);
			objOutputStream.writeObject(sv);
			System.out.println("Ghi thanh cong " + sv + ": " + file.getAbsolutePath());
			objOutputStream.close();
			foStream.close();
		} catch (Exception e) {
			System.out.println("Co loi xay ra" + e);
		}
	}
	
	public String docFile(File file) {
		FileInputStream fiStream = null;
		String data = "";
		int c = 0;
		try {
			fiStream = new FileInputStream(file);
			while ((c = fiStream.read()) != -1) {
				data = data + (char)c;
			}
		} catch (Exception e) {
			System.out.println("Co loi xay ra: " + e);
		}
		return data;
	}
	
	public static void main(String[] args) {
		String dirPath = "D:\\Learning-Code\\Java\\School_Exercise\\src\\Tuan8\\"; // Đường dẫn thư mục
		String fileName = "data.out";	// tên . đuôi mở rộng
		String filePath = dirPath + fileName;
		
		File directoty = new File(dirPath);
		if (!directoty.exists()) {		// Nếu chưa có thư mục thì tạo mới
			directoty.mkdirs();
		}
		
		File file = new File(filePath);
		String stringData = "Lập trình thật dễ...!\nLet's Go...";
		XuLyDocGhiFile docGhiFile = new XuLyDocGhiFile();
		docGhiFile.ghiFile(file, stringData);
		
		// Ghi doi tuong
		fileName = "Object.out";
		filePath = dirPath + fileName;
		file = new File(filePath);
		SinhVien sv = new SinhVien("SV001", "Linh", 3.35);
		docGhiFile.ghiSinhVien(file, sv);
		
		// Doc du lieu tu file
		fileName = "data.out";
		filePath = dirPath + fileName;
		file = new File(filePath);
		String ketQua = docGhiFile.docFile(file);
		System.out.println("Du lieu vua doc: " + ketQua);
	}
}
