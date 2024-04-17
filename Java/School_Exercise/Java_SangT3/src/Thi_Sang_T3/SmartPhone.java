package Thi_Sang_T3;

import java.util.Scanner;

//Họ tên: Trần Đức Linh
//Mã sinh viên: 725105115
public class SmartPhone extends HangHoa {
	private String heDH;
	private double dungLuongPin;
	private boolean hoTro5G;
	
	public SmartPhone() {}

	public SmartPhone(String maHangHoa, String tenHangHoa, double donGia, int soLuong, String heDH, double dungLuongPin, boolean hoTro5G) {
		super(maHangHoa, tenHangHoa, donGia, soLuong);
		this.heDH = heDH;
		this.dungLuongPin = dungLuongPin;
		this.hoTro5G = hoTro5G;
	}

	@Override
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n------NHẬP DỮ LIỆU ĐIỆN THOẠI------");
		super.nhapDuLieu();
		System.out.print("Nhập hệ điều hành: ");
		this.heDH = sc.nextLine();
		System.out.print("Nhập dung lượng pin: ");
		this.dungLuongPin = Double.parseDouble(sc.nextLine());
		System.out.print("Hỗ trợ 5G (yes: y | no: n): ");
		String luaChon = sc.nextLine();
		if (luaChon.equals("y"))	this.hoTro5G = true;
		else this.hoTro5G = false;
		sc.close();
	}
	
	@Override
	public void xuatDuLieu() {
		super.xuatDuLieu();
		System.out.print("Hệ điều hành: " + this.heDH);
		System.out.print("Dung lượng pin: " + this.dungLuongPin + "(mAh)");
		System.out.print("Hỗ trợ 5G: " + this.hoTro5G);
	}

	@Override
	public String toString() {
		return "SmartPhone [heDH=" + heDH + ", dungLuongPin=" + dungLuongPin + ", hoTro5G=" + hoTro5G
				+ ", maHangHoa()=" + getMaHangHoa() + ", tenHangHoa=" + getTenHangHoa() + ", donGia="
				+ getDonGia() + ", soLuong=" + getSoLuong() + "]";
	}

	public String getHeDH() {
		return heDH;
	}

	public void setHeDH(String heDH) {
		this.heDH = heDH;
	}

	public double getDungLuongPin() {
		return dungLuongPin;
	}

	public void setDungLuongPin(double dungLuongPin) {
		this.dungLuongPin = dungLuongPin;
	}

	public boolean isHoTro5G() {
		return hoTro5G;
	}

	public void setHoTro5G(boolean hoTro5G) {
		this.hoTro5G = hoTro5G;
	}
	
}
