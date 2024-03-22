package Tuan7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Bai4_Tuan7_BTVN {
	public static void main(String[] args) throws Exception {
		// a) Nhập danh sách Giáo Viên và Học Sinh (được lưu trong cùng một danh sách - sử dụng ArrayList) 
		ArrayList<NhanSu> ns = new ArrayList<>();
		ns.add(new GiaoVien("ma_gv1", "gv1", 1989, "Hai Duong", "Nu", "Vat Ly", 10000000.0));
		ns.add(new HocSinh("ma_hs1", "hs1", 2007, "Phu Tho", "Nam", "7E3", 5.8));
		ns.add(new HocSinh("ma_hs2", "hs2", 2008, "Ha Noi", "Nu", "6E1", 7.8));
		ns.add(new GiaoVien("ma_gv2", "gv2", 1999, "Ha Noi", "Nam", "Toan", 7000000.0));
		ns.add(new HocSinh("ma_hs3", "hs3", 2009, "My Duc", "Nu", "5A5", 8));
		
		// b) In lại toàn bộ danh sách Giáo viên và Học sinh đã nhập
		System.out.println("--------------Danh sách Giáo viên và Học sinh--------------");
		for (NhanSu nhanSu: ns) {
			System.out.println(nhanSu);
		}
		System.out.println();
		
		// c) In danh sách chỉ gồm Học sinh
		System.out.println("-----------------Danh sách chỉ gồm Học sinh-----------------");
		for (NhanSu nhanSu: ns) {
			if (nhanSu instanceof HocSinh) {
				System.out.println(nhanSu);
			}
		}
		System.out.println();
		
		// d) In danh sách chỉ gồm Giáo viên
		System.out.println("-----------------Danh sách chỉ gồm Giáo viên-----------------");
		for (NhanSu nhanSu: ns) {
			if (nhanSu instanceof GiaoVien) {
				System.out.println(nhanSu);
			}
		}
		System.out.println();
		
		// e) Ghi toàn bộ danh sách vào file ListNhanSu.text
		File file = new File("D:\\Learning-Code\\Java\\School_Exercise\\src\\Chuong7\\ListNhanSu.text");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		try {
			objectOutputStream.writeObject(ns);
			System.out.println("Ghi danh sách nhân sự vào " + file.getAbsolutePath() + " thành công!");
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra");
			e.printStackTrace();
		} finally {
			objectOutputStream.close();
			fileOutputStream.close();
		}
		
		// f) Đọc và lưu các đối tượng GiaoVien và HocSinh vào danh sách và in ra màn hình.
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		try {
			ArrayList<NhanSu> ns_input = (ArrayList<NhanSu>) objectInputStream.readObject();
			for (NhanSu nhanSu: ns_input) {
				System.out.println(nhanSu);
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
