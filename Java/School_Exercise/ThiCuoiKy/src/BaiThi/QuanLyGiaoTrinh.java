//Tran_Duc_Linh_725105115
package BaiThi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


public class QuanLyGiaoTrinh implements Serializable{
	private ArrayList<GiaoTrinh> listGiaoTrinh;
	
	public QuanLyGiaoTrinh() {
		listGiaoTrinh = new ArrayList<GiaoTrinh>();
	}
	
	public QuanLyGiaoTrinh(ArrayList<GiaoTrinh> listGiaoTrinh) {
		this.listGiaoTrinh = listGiaoTrinh;
	}

	public void ghiFile(ArrayList<GiaoTrinh> listGiaoTrinh) {
		File file = new File("D:\\giaotrinh.txt");
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null; 
		try {
			fileOutputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(listGiaoTrinh);
			
//			System.out.println("Ghi file " + file.getAbsolutePath() + " thành công!");
			
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			System.err.println("Có lỗi ghi file");
			e.printStackTrace();
		}
	}
	
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số giáo trình (0 < n < 100): ");
		int n = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < n; i++) {
			GiaoTrinh gt = new GiaoTrinh();
			gt.nhapDuLieu();
			listGiaoTrinh.add(gt);
		}
		
		ghiFile(listGiaoTrinh);
	}
	
	public ArrayList<GiaoTrinh> docFile() {
		ArrayList<GiaoTrinh> listGiaoTrinh_INPUT = new ArrayList<GiaoTrinh>();
		
		File file = new File("D:\\giaotrinh.txt");
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		
		try {
			fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);
			
			listGiaoTrinh_INPUT.addAll((Collection<? extends GiaoTrinh>) objectInputStream.readObject());
			
			objectInputStream.close();
			fileInputStream.close();
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra");
			e.printStackTrace();
		}
		
		return listGiaoTrinh_INPUT;
	}
	
	public void hienThiDuLieuFile() {
		ArrayList<GiaoTrinh> listGiaoTrinh_OUTPUT = docFile();
		for (int i = 0; i < listGiaoTrinh_OUTPUT.size(); i++) {
			 System.out.println("\nGiáo trình " + (i+1));
			listGiaoTrinh_OUTPUT.get(i).xuatDuLieu();
		}
	}
	
	public void demGiaoTrinhNangCao() {
		int count = 0;
		for (GiaoTrinh gt : listGiaoTrinh) {
			if (gt.getPhanLoaiGiaoTrinh().getLoai().equals("nâng cao")) {
				count++;
			}
		}
		System.out.println("\nSố lượng giáo trình thuộc loại nâng cao: " + count);
	}
	
	public void sapXepGiaoTrinh() {
		for (int i = 0 ; i < listGiaoTrinh.size() - 1; i++) {
			for (int j = i+1; j < listGiaoTrinh.size(); j++) {
				if (listGiaoTrinh.get(i).getGia() > listGiaoTrinh.get(j).getGia()) {
					Collections.swap(listGiaoTrinh, i, j);
				}
			}
		}
		
		for (GiaoTrinh gt : listGiaoTrinh) {
			gt.xuatDuLieu();
		}
	}
}
