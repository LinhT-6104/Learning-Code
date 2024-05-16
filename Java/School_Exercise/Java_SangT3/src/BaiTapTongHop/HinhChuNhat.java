package BaiTapTongHop;

import java.io.Serializable;
import java.util.Scanner;

public class HinhChuNhat extends HinhHoc implements Serializable{
	private float chieuDai;
	private float chieuRong;
	private KhoHang hangTrongKho;
	
	public HinhChuNhat() {
		this.chieuDai = 0;
		this.chieuRong = 0;
		this.hangTrongKho = new KhoHang();
	}

	public HinhChuNhat(String maHinh, String mauSac, float chieuDai, float chieuRong, KhoHang hangTrongKho) {
		super(maHinh, mauSac);
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
		this.hangTrongKho = hangTrongKho;
	}
	
	public void nhapDuLieu() {
		super.nhapDuLieu();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập chiều dài: ");
		this.chieuDai = Float.parseFloat(sc.nextLine());
		System.out.print("Nhập chiều rộng: ");
		this.chieuDai = Float.parseFloat(sc.nextLine());
		System.out.print("Nhập số lượng: ");
		this.hangTrongKho.setSoLuong(Integer.parseInt(sc.nextLine()));
		System.out.print("Tình trạng hàng (1 - Còn|| 0 - Hết): ");
		String luaChon = sc.nextLine();
		if (luaChon.equals("1")) {
			this.hangTrongKho.setConHang(true);
		} else {
			this.hangTrongKho.setConHang(false);
		}
	}
	
	public void xuatDuLieu() {
		super.xuatDuLieu();
		System.out.println("Chiều dài: " + this.chieuDai);
		System.out.println("Chiều rộng: " + this.chieuRong);
		System.out.println("Số lượng: " + this.hangTrongKho.getSoLuong());
		if (this.hangTrongKho.isConHang()) {
			System.out.println("Tình trạng hàng: Còn");			
		} else {
			System.out.println("Tình trạng hàng: Hết");
		}
	}

	@Override
	public String toString() {
		return "HinhChuNhat [chieuDai=" + chieuDai + ", chieuRong=" + chieuRong + ", hangTrongKho=" + hangTrongKho
				+ ", MaHinh=" + getMaHinh() + ", MauSac=" + getMauSac() + "]";
	}

	public float getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(float chieuDai) {
		this.chieuDai = chieuDai;
	}

	public float getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(float chieuRong) {
		this.chieuRong = chieuRong;
	}

	public KhoHang getHangTrongKho() {
		return hangTrongKho;
	}

	public void setHangTrongKho(KhoHang hangTrongKho) {
		this.hangTrongKho = hangTrongKho;
	}
	
	public float chuVi() {
		return (this.chieuDai + this.chieuRong)*2;
	}
	public float dienTich() {
		return this.chieuDai * this.chieuRong;
	}
}
