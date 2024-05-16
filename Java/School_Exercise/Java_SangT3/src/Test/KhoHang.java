package Test;

import java.util.Scanner;

public class KhoHang {
	private int soLuong;
	private boolean conHang;
	
	public KhoHang() {}
	
	public KhoHang(int soLuong, boolean conHang) {
		this.soLuong = soLuong;
		this.conHang = conHang;
	}

	public void nhapThongTin() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số lượng: ");
		this.soLuong = sc.nextInt();
		System.out.print("Còn hàng (true/false): ");
		this.conHang = sc.nextBoolean();
	}
	
	@Override
	public String toString() {
		return "KhoHang [soLuong=" + soLuong + ", conHang=" + conHang + "]";
	}

	public int laySoLuong() {
		return soLuong;
	}

	public void datSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public boolean kiemTraConHang() {
		return conHang;
	}

	public void datConHang(boolean conHang) {
		this.conHang = conHang;
	}
}
