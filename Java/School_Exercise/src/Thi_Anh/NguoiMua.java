package Thi_Anh;

import java.util.Scanner;

public class NguoiMua extends ThietBi {
	private String maNguoiMua;
	private String hoTen;
	private int soLuongMuaTB;
	private String NgayThangNamSinh;
	
	public NguoiMua() {}

	public NguoiMua(String maNguoiMua, String hoTen, int soLuongMuaTB, String ngayThangNamSinh, String maTB, String tenTB, double giaTB) {
		super(maTB, tenTB, giaTB);
		this.maNguoiMua = maNguoiMua;
		this.hoTen = hoTen;
		this.soLuongMuaTB = soLuongMuaTB;
		NgayThangNamSinh = ngayThangNamSinh;
	}

	@Override
	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã người mua: ");
		this.maNguoiMua = sc.nextLine();
		System.out.print("Nhập họ tên người mua: ");
		this.hoTen = sc.nextLine();
		System.out.print("Nhập số lượng mua thiết bị: ");
		this.soLuongMuaTB = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập ngày tháng năm sinh: ");
		this.NgayThangNamSinh = sc.nextLine();
		super.nhapDuLieu();
	}
	
	@Override
	public void xuatDuLieu() {
		System.out.println("------NGƯỜI MUA------");
		System.out.println("Mã người mua: " + this.maNguoiMua);
		System.out.println("Họ tên người mua: " + this.hoTen);
		System.out.println("Số lượng mua thiết bị: " + this.soLuongMuaTB);
		System.out.println("Ngày tháng năm sinh: " + this.NgayThangNamSinh);
		super.xuatDuLieu();
	}

	@Override
	public String toString() {
		return "NguoiMua [maNguoiMua=" + maNguoiMua + ", hoTen=" + hoTen + ", soLuongMuaTB=" + soLuongMuaTB
				+ ", NgayThangNamSinh=" + NgayThangNamSinh + ", maTB=" + getMaTB() + ", tenTB=" + getTenTB()
				+ ", giaTB=" + getGiaTB() + "]";
	}

	public String getMaNguoiMua() {
		return maNguoiMua;
	}

	public void setMaNguoiMua(String maNguoiMua) {
		this.maNguoiMua = maNguoiMua;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getSoLuongMuaTB() {
		return soLuongMuaTB;
	}

	public void setSoLuongMuaTB(int soLuongMuaTB) {
		this.soLuongMuaTB = soLuongMuaTB;
	}

	public String getNgayThangNamSinh() {
		return NgayThangNamSinh;
	}

	public void setNgayThangNamSinh(String ngayThangNamSinh) {
		NgayThangNamSinh = ngayThangNamSinh;
	}
}
