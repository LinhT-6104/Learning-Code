package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

//Họ tên: Trần Đức Linh
//Mã SV: 725105115

public class QuanLy implements Serializable{
	private ArrayList<SinhVien> list___VIDU;
	
	public QuanLy() {
		list___VIDU = new ArrayList<SinhVien>();
	}
	
	// -- Hàm khởi tạo có tham số
	
	public void ghiFile(ArrayList<SinhVien> list___VIDU) {
		File file = new File("D:\\hcn.txt");
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null; 
		try {
			fileOutputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(list___VIDU);
			
			System.out.println("Ghi file " + file.getAbsolutePath() + " thành công!");
			
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			System.err.println("Có lỗi ghi file");
			e.printStackTrace();
		}
	}
	
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		// -- System.out.print("Nhập số : ");--
		int n = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < n; i++) {
			list___VIDU.get(i).nhapDuLieu();
		}
		
		ghiFile(list___VIDU);
	}
	
	public ArrayList<SinhVien> docFile() {
		ArrayList<SinhVien> list___VIDU_INPUT = new ArrayList<SinhVien>();
		
		File file = new File("D:\\hcn.txt");
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		
		try {
			fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);
			
			list___VIDU_INPUT.addAll((Collection<? extends SinhVien>) objectInputStream.readObject());
			
			objectInputStream.close();
			fileInputStream.close();
		} catch (Exception e) {
			System.err.println("Có lỗi đọc file");
			e.printStackTrace();
		}
		
		return list___VIDU_INPUT;
	}
	
	public void hienThiDuLieuFile() {
		ArrayList<SinhVien> list___VIDU_OUTPUT = docFile();
		for (int i = 0; i < list___VIDU_OUTPUT.size(); i++) {
			// System.out.println("\nHình " + (i+1));
			list___VIDU_OUTPUT.get(i).xuatDuLieu();
		}
	}
}
