package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import Tuan6.SinhVien;

public class Object_Input_Output_Stream {
	public static void main(String[] args) throws Exception {
		ArrayList<SinhVien> listSinhViens = new ArrayList<SinhVien>();
		listSinhViens.add(new SinhVien("725105115", "Trần Đức Linh", 20, 2.69, 1));
		listSinhViens.add(new SinhVien("725105008", "Nguyễn Hồng Anh", 20, 3.0, 0));
		listSinhViens.add(new SinhVien("725105111", "Lê Văn A", 24, 2.3, 1));
		listSinhViens.add(new SinhVien("725105117", "Lê Văn B", 21, 4.0, 0));
		
		System.out.println("------------Sinh viên trong danh sách------------");
		for (int i = 0; i < listSinhViens.size(); i++) {
			listSinhViens.get(i).hienThi();
		}
		
		// Ghi Object
		File fileOut = new File("D:\\data.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
		try {
			objectOutputStream.writeObject(listSinhViens);
			System.out.println("Ghi danh sách sinh viên vào file " + fileOut.getAbsolutePath() + " thành công!");
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra...");
			e.printStackTrace();
		}
		
		// Đọc Object
		ArrayList<SinhVien> listSinhVienInput = new ArrayList<SinhVien>();
		File fileIn = new File("D:\\data.txt");
		FileInputStream fileInputStream = new FileInputStream(fileIn);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		
		try {
			listSinhVienInput.addAll((Collection<? extends SinhVien>) objectInputStream.readObject());
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra...");
			e.printStackTrace();
		}
		
		System.out.println("\n------------Sinh viên trong danh sách file------------");
		for (int i = 0; i < listSinhViens.size(); i++) {
			listSinhVienInput.get(i).hienThi();
		}
	}
}
