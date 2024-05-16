package BaiTapTongHop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

// Họ và tên: Trần Đức Linh
// Mã SV: 725015115
public class QuanLyKhoHang implements Serializable{
	private ArrayList<HinhChuNhat> listHCN;
	public QuanLyKhoHang() {
		this.listHCN = new ArrayList<HinhChuNhat>();
	}
	public QuanLyKhoHang(ArrayList<HinhChuNhat> listHCN) {
		this.listHCN = listHCN;
	}
	
	public void ghiFile(ArrayList<HinhChuNhat> listHCN) {
		File file = new File("D:\\hcn.data");
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(listHCN);
			
			System.out.println("Ghi file vào " + file.getAbsolutePath() + " thành công!\n");
			
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra...");
			e.printStackTrace();
		}
	}
	
	public void nhapDuLieu(){
		System.out.print("Nhập số HCN: ");
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<n;i++) {
			HinhChuNhat hcn = new HinhChuNhat();
			hcn.nhapDuLieu();
			listHCN.add(hcn);
		}
		
		ghiFile(listHCN);
	}
	
	public ArrayList<HinhChuNhat> docFile() {
		ArrayList<HinhChuNhat> listHCNInput = new ArrayList<HinhChuNhat>();
		File file = new File("D:\\hcn.txt");
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);
			
			listHCNInput.addAll((Collection<? extends HinhChuNhat>) objectInputStream.readObject());
			
			objectInputStream.close();
			fileInputStream.close();
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra...");
			e.printStackTrace();
		}
		return listHCNInput;
	}
	
	public void inDuLieuFile(ArrayList<HinhChuNhat> listHCNInput) {
		System.out.println("-------------HÌNH CHỮ NHẬT TRONG KHO-------------");
		for (int i = 0; i < listHCNInput.size(); i++) {
			System.out.println("\n------Hình " + (i+1) + "------");
			listHCNInput.get(i).xuatDuLieu();
		}	
	}
	
	public void SL_HCN_Do() {
		int count = 0;
		for (int i = 0; i < listHCN.size(); i++) {
			if (listHCN.get(i).getMauSac().equals("Do")) {
				count++;
			}
		}
		System.out.println("\nTổng số lượng đồ chơi hình chữ nhật màu đỏ trong kho hàng: " + count);
	}
	
	public void cviMin_dtichMax() {
		float min = this.listHCN.get(0).chuVi();
		float max = this.listHCN.get(0).dienTich();

		for (int i = 1; i < listHCN.size(); i++) {
			float chuVi = listHCN.get(i).chuVi();
			float dienTich = listHCN.get(i).dienTich();
			if (min > chuVi) min = chuVi;
			if (max < dienTich) max = dienTich;
		}
		System.out.println("\n------HCN có chu vi nhỏ nhất------");
		for (int i = 0; i < listHCN.size(); i++) {
			if (listHCN.get(i).chuVi() == min) {
				System.out.println("Chiều dài: " + listHCN.get(i).getChieuDai()
								 + " | Chiều rộng: " + listHCN.get(i).getChieuRong());
			}
		}
		System.out.println("\n------HCN có diện tích lớn nhất------");
		for (int i = 0; i < listHCN.size(); i++) {
			if (listHCN.get(i).dienTich() == max) {
				System.out.println("Chiều dài: " + listHCN.get(i).getChieuDai()
						 + " | Chiều rộng: " + listHCN.get(i).getChieuRong());
			}
		}
	}
	
	public void sapXepdienTichHCN() {
		for (int i = 0; i < listHCN.size() - 1; i++) {
			for (int j = i+1; j < listHCN.size(); j++) {
				if (listHCN.get(i).dienTich() < listHCN.get(j).dienTich()) {
					HinhChuNhat temp = listHCN.get(i);
					listHCN.set(i, listHCN.get(j));
					listHCN.set(j, temp);
				}
			}
		}
	}
	
	public void dienTichHCN() {
		ArrayList<Float> dt = new ArrayList<Float>();
		for (int i = 0; i < listHCN.size(); i++) {
			float x = listHCN.get(i).dienTich();
			if (!dt.contains(x)) {
				dt.add(x);
			}
		}
		System.out.println("\nSố lượng diện tích khác nhau: " + dt.size() + "\n");
	}
}
