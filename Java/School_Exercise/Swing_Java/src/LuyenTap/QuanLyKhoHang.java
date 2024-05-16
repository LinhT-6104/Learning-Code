package LuyenTap;

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
		listHCN = new ArrayList<HinhChuNhat>();
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
			
			System.out.println("Ghi file " + file.getAbsolutePath() + " thành công!");
			
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra!");
			e.printStackTrace();
		}
	}
	
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số hình chữ nhật: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0 ; i < n; i++) {
			HinhChuNhat hcn = new HinhChuNhat();
			hcn.nhapDuLieu();
			listHCN.add(hcn);
		}
		ghiFile(listHCN);
	}
	
	public ArrayList<HinhChuNhat> docFile() {
		ArrayList<HinhChuNhat> listInput = new ArrayList<HinhChuNhat>();
		
		File file = new File("D:\\hcn.txt");
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);
			
			listInput.addAll((Collection<? extends HinhChuNhat>) objectInputStream.readObject());
			
			objectInputStream.close();
			fileInputStream.close();
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra");
			e.printStackTrace();
		}
		return listInput;
	}
	
	public void docDuLieuFile() {
		ArrayList<HinhChuNhat> dataFile = docFile();
		System.out.println("\n-------------Dữ liệu trong file-------------\n");
		for (int i = 0; i < dataFile.size(); i++) {
			System.out.println("Hình " + (i+1));
			dataFile.get(i).xuatDuLieu();
		}
	}
	
	public void soLuongDoChoiMauDo() {
		int count = 0;
		for (int i = 0; i < listHCN.size(); i++) {
			if (listHCN.get(i).getMauSac().equals("Do")) {
				count++;
			}
		}
		System.out.println("Số lượng đồ chơi màu đỏ là : " + count);
	}
	
	public void cviMin_dtichMax() {
		double cviMin = listHCN.get(0).chuVi();
		double dtichMax = listHCN.get(0).dienTich();
		
		for (int i = 1; i < listHCN.size(); i++) {
			if (listHCN.get(i).chuVi() < cviMin) {
				cviMin = listHCN.get(i).chuVi();
			}
			if (listHCN.get(i).dienTich() > dtichMax) {
				dtichMax = listHCN.get(i).dienTich();
			}
		}
		
		System.out.println("\n------HINH CHU NHAT CO CHU VI NHO NHAT------");
		for (int i = 0; i < listHCN.size(); i++) {
			if (listHCN.get(i).chuVi() == cviMin) {
				System.out.println("Chiều dài: " + listHCN.get(i).getChieuDai() +
								   " | Chiều rộng: " + listHCN.get(i).getChieuRong());
			}
		}
		System.out.println("\n------HINH CHU NHAT CO DIEN TICH LON NHAT------");
		for (int i = 0; i < listHCN.size(); i++) {
			if (listHCN.get(i).dienTich() == dtichMax) {
				System.out.println("Chiều dài: " + listHCN.get(i).getChieuDai() +
								   " | Chiều rộng: " + listHCN.get(i).getChieuRong());
			}
		}
	}
	
	public void soLuongDTHCN() {
		ArrayList<Double> dienTichHCN = new ArrayList<Double>();
		for (int i = 1; i < listHCN.size(); i++) {
			if (!dienTichHCN.contains(listHCN.get(i).dienTich())) {
				dienTichHCN.add(listHCN.get(i).dienTich());
			}
		}
		System.out.println("\nSố lượng diện tích hình chữ nhật là: " + dienTichHCN.size());
	}
}
