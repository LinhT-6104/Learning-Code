package LuyenTap;

import java.io.Serializable;
import java.util.Scanner;

public class HinhChuNhat extends HinhHoc implements Serializable{
	private double chieuDai;
	private double chieuRong;
	private KhoHang hangTrongKho;
	
	public HinhChuNhat() {
		super();
		hangTrongKho = new KhoHang();
	}
	public HinhChuNhat(String maHinh, String mauSac, double chieuDai, double chieuRong, KhoHang hangTrongKho) {
		super(maHinh, mauSac);
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
		this.hangTrongKho = hangTrongKho;
	}
	
	public void nhapDuLieu() {
		super.nhapDuLieu();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập chiều dài: ");
		this.chieuDai = Double.parseDouble(sc.nextLine());
		System.out.print("Nhập chiều rộng: ");
		this.chieuRong = Double.parseDouble(sc.nextLine());
		System.out.print("Nhập số lượng: ");
		this.hangTrongKho.setSoLuong(Integer.parseInt(sc.nextLine()));
		System.out.print("Nhập tình trạng (còn - 1 | không - 0): ");
		this.hangTrongKho.setConHang(Boolean.parseBoolean(sc.nextLine()));
	}
	public void xuatDuLieu() {
		super.xuatDuLieu();
		System.out.println("Chiều dài: " + this.chieuDai);
		System.out.println("Chiều rộng: " + this.chieuRong);
		System.out.println("Số lượng: " + this.hangTrongKho.getSoLuong());
		if (this.hangTrongKho.isConHang()) {
			System.out.println("Còn hàng: Còn\n");			
		} else {
			System.out.println("Còn hàng: Không\n");
		}
	}
	public double getChieuDai() {
		return chieuDai;
	}
	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}
	public double getChieuRong() {
		return chieuRong;
	}
	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}
	public KhoHang getHangTrongKho() {
		return hangTrongKho;
	}
	public void setHangTrongKho(KhoHang hangTrongKho) {
		this.hangTrongKho = hangTrongKho;
	}
	@Override
	public String toString() {
		return "HinhChuNhat [chieuDai=" + chieuDai + ", chieuRong=" + chieuRong + ", hangTrongKho=" + hangTrongKho
				+ ", MaHinh=" + getMaHinh() + ", MauSac=" + getMauSac() + "]";
	}
	
	public double chuVi() {
		return 2 * (this.chieuDai + this.chieuRong);
	}
	public double dienTich() {
		return this.chieuDai * this.chieuRong;
	}
}
