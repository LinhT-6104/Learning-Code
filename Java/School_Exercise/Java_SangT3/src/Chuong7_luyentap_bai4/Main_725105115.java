
package Chuong7_luyentap_bai4;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// Họ tên: Trần Đức Linh
// Mã SV: 725105115
public class Main_725105115 {
	public static void main(String[] args) {
		QuanLyGVHS qlgvhs = new QuanLyGVHS();
		
		ArrayList<NhanSu> listgvhs = new ArrayList<>();
		listgvhs.add(new HocSinh("A", "hs1", 2014, "Hà Nội", 0, "E3", 9.0));
		listgvhs.add(new GiaoVien("X", "gv1", 1990, "Hà Nội", 1, "Toan", 12000.0));
		listgvhs.add(new GiaoVien("Y", "gv2", 1985, "Nam Định", 0, "Van", 12000.0));
		listgvhs.add(new GiaoVien("Z", "gv2", 1996, "Thái Bình", 0, "Anh", 9000.0));
		listgvhs.add(new HocSinh("B", "hs2", 2011, "Đà Nẵng", 1, "A5", 10.0));
		listgvhs.add(new HocSinh("C", "hs3", 2015, "Hải Phòng", 0, "B", 3.0));
		
		qlgvhs.setListNS(listgvhs);
		qlgvhs.inDuLieu();		// B
		qlgvhs.inGiaoVien();	// C
		qlgvhs.inHocSinh(); 	// D
		
		// Ghi file
		String dirPath = "D:\\Learning-Code\\Java\\School_Exercise\\src\\Chuong7_luyentap_bai4\\";
		String fileName = "ListNhanSu.text";
		String filePath = dirPath + fileName;
		
		File directory = new File(dirPath);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		
		File file = new File(filePath);
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(listgvhs);
			System.out.println("Ghi danh sach thanh cong vao " + file.getAbsolutePath());
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			System.out.println("Co loi xay ra..." + e);
		}
		
		// Doc file
		FileInputStream fiStream = null;
		ObjectInputStream objiStream = null;
		try {
			fiStream = new FileInputStream(file);
			objiStream = new ObjectInputStream(fiStream);
			Object obj;
			while ((obj = objiStream.readObject()) != null) {
				if (obj instanceof NhanSu) {
					listgvhs.add((NhanSu)obj);
				}
			}
			objiStream.close();
			fiStream.close();
		} catch (EOFException e) {
			
		} catch (Exception e) {
			System.out.println("Co loi xay ra " + e);
		}
		
		System.out.println("\nDanh sách sau khi đọc từ file:");
		for (NhanSu ns : listgvhs) {
		    System.out.println(ns);
		}
		
		System.out.println();
		qlgvhs.timGVLuongMax();
		System.out.println("\nĐiểm trung bình của các học sinh là " + qlgvhs.tinhDiemTBHS());
	}
}
