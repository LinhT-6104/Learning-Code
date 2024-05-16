//Tran_Duc_Linh_725105115
package BaiTap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class QuanLyKhoHang implements Serializable{
	private ArrayList<HinhChuNhat> listHCN;
	
	public QuanLyKhoHang() {
		this.listHCN = new ArrayList<HinhChuNhat>();
	}

	public QuanLyKhoHang(ArrayList<HinhChuNhat> listHCN) {
		this.listHCN = listHCN;
	}
	
	public void ghiFile(ArrayList<HinhChuNhat> listHCN) {
		File file = new File("D:\\hcn.txt");
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(listHCN);
			
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra");
			e.printStackTrace();
		}
	}
	
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số hình chữ nhật: ");
		int n = Integer.parseInt(sc.nextLine().trim());
		
		for (int i = 0 ; i < n ; i++) {
			HinhChuNhat hcn = new HinhChuNhat();
			hcn.nhapDuLieu();
			listHCN.add(hcn);
		}
		
		ghiFile(listHCN);
	}
	
	public ArrayList<HinhChuNhat> docFile() {
		ArrayList<HinhChuNhat> listHCN_Input = new ArrayList<HinhChuNhat>();
		
		File file = new File("D:\\hcn.txt");
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);
			
			listHCN_Input.addAll((Collection<? extends HinhChuNhat>) objectInputStream.readObject());
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra");
			e.printStackTrace();
		}
		return listHCN_Input;
	}
	
	public void hienThiDuLieuFile() {
		ArrayList<HinhChuNhat> listHCN_Input = docFile();
		
		for (HinhChuNhat a : listHCN_Input) {
			a.xuatDuLieu();
		}
	}
	
	public void tongSoLuongDoChoiMauDo() {
		int count = 0;
		for (HinhChuNhat a : listHCN) {
			if (a.getMauSac().equals("Do")) {
				count++;
			}
		}
		System.out.println("\nSố lượng đồ chơi màu đỏ trong kho hàng: " + count);
	}
	public void cviMax_dtichMin() {
		double cviMax = listHCN.get(0).chuVi();
		double dtichMin = listHCN.get(0).dienTich();
		
		for (HinhChuNhat a : listHCN) {
			if (a.dienTich() < dtichMin) {
				dtichMin = a.dienTich();
			}
			if (a.chuVi() > cviMax) {
				cviMax = a.chuVi();
			}
		}
		
		System.out.println("------Hình chữ nhật có chu vi nhỏ nhất------");
		for (HinhChuNhat a : listHCN) {
			if (a.chuVi() == cviMax) {
				System.out.println("Chiều dài: " + a.getChieuDai() + " | Chiều rộng: " + a.getChieuRong());
			}
		}
		System.out.println("------Hình chữ nhật có diện tích lớn nhất------");
		for (HinhChuNhat a : listHCN) {
			if (a.dienTich() == dtichMin) {
				System.out.println("Chiều dài: " + a.getChieuDai() + " | Chiều rộng: " + a.getChieuRong());
			}
		}
	}
}
