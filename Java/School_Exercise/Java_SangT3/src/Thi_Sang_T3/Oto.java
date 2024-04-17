package Thi_Sang_T3;

import java.util.Scanner;

//Họ tên: Trần Đức Linh
//Mã sinh viên: 725105115
public class Oto extends HangHoa {
	private int namSX;
	private String hopSo;
	private double maLuc;
	private String mauSac;
	
	public Oto() {
		super();
	}

	public Oto(String maHangHoa, String tenHangHoa, double donGia, int soLuong, int namSX, String hopSo, double maLuc, String mauSac) {
		super(maHangHoa, tenHangHoa, donGia, soLuong);		
		this.namSX = namSX;
		this.hopSo = hopSo;
		this.maLuc = maLuc;
		this.mauSac = mauSac;
	}

	@Override
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n------NHẬP DỮ LIỆU OTO------");
		super.nhapDuLieu();
		System.out.print("Nhập năm sản xuất: ");
		this.namSX = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập hộp số(Tự động/Số sàn): ");
		this.hopSo = sc.nextLine();
		System.out.print("Nhập mã lực: ");
		this.maLuc = Double.parseDouble(sc.nextLine());
		System.out.print("Nhập màu sắc: ");
		this.mauSac = sc.nextLine();
	}
	
	@Override
	public void xuatDuLieu() {
		super.xuatDuLieu();
		System.out.println("Năm sản xuất: " + this.namSX);
		System.out.println("Hộp số: " + this.hopSo);
		System.out.println("Mã lực: " + this.maLuc);
		System.out.println("Màu sắc: " + this.mauSac);
	}

	@Override
	public String toString() {
		return "Oto [namSX=" + namSX + ", hopSo=" + hopSo + ", maLuc=" + maLuc + ", mauSac=" + mauSac
				+ ", maHangHoa=" + getMaHangHoa() + ", tenHangHoa=" + getTenHangHoa() + ", donGia="
				+ getDonGia() + ", soLuong=" + getSoLuong() + "]";
	}

	public int getNamSX() {
		return namSX;
	}

	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}

	public String getHopSo() {
		return hopSo;
	}

	public void setHopSo(String hopSo) {
		this.hopSo = hopSo;
	}

	public double getMaLuc() {
		return maLuc;
	}

	public void setMaLuc(double maLuc) {
		this.maLuc = maLuc;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}
}
