package Test;

import java.util.Scanner;

public class HinhChuNhat extends HinhHoc {
	private float chieuDai;
	private float chieuRong;
	private KhoHang khoHang;

	public HinhChuNhat() {
		khoHang = new KhoHang();
	}

	public HinhChuNhat(float chieuDai, float chieuRong, KhoHang khoHang, String maHinh, String mauSac) {
		super(maHinh, mauSac);
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
		this.khoHang = khoHang;
	}

	@Override
	public String toString() {
		return "HinhChuNhat [chieuDai=" + chieuDai + ", chieuRong=" + chieuRong + ", khoHang=" + khoHang
				+ ", MaHinh=" + layMaHinh() + ", MauSac=" + layMauSac() + "]";
	}

	public float layChieuDai() {
		return chieuDai;
	}

	public void datChieuDai(float chieuDai) {
		this.chieuDai = chieuDai;
	}

	public float layChieuRong() {
		return chieuRong;
	}

	public void datChieuRong(float chieuRong) {
		this.chieuRong = chieuRong;
	}

	public KhoHang layKhoHang() {
		return khoHang;
	}

	public void datKhoHang(KhoHang khoHang) {
		this.khoHang = khoHang;
	}

	public void nhapDuLieu() {
		super.nhapThongTin();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập chiều dài hình chữ nhật: ");
		this.chieuDai = Float.parseFloat(sc.nextLine());
		System.out.print("Nhập chiều rộng hình chữ nhật: ");
		this.chieuRong = Float.parseFloat(sc.nextLine());
	}

	public float tinhChuVi() {
		return 2 * (chieuDai + chieuRong);
	}

	public float tinhDienTich() {
		return chieuDai * chieuRong;
	}
}
