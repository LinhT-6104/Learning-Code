package Tuan7;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Scanner;

public class KhachHang implements Serializable{
	private String maKH, hoTen, soCMND, ngaySinh, email;
	private ArrayList<HoaDon> hoaDons;
	private ViTien viTiens;
	
	// Constructor
	public KhachHang() {
		this.maKH = this.hoTen = this.soCMND = this.ngaySinh = this.email = "";
		this.hoaDons = new ArrayList<HoaDon>();
		this.viTiens = new ViTien();
	}
	public KhachHang(String maKH, String hoTen, String soCMND, String ngaySinh, String email, ArrayList<HoaDon> hoaDons, ViTien viTiens) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.soCMND = soCMND;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.hoaDons = hoaDons;
		this.viTiens = viTiens;
	}

	// Nhập dữ liệu
//	Scanner sc = new Scanner(System.in);
//	
//	public void nhapDuLieu() {
//		System.out.print("Nhập mã KH: ");
//		this.maKH = sc.nextLine();
//		System.out.print("Nhập họ tên: ");
//		this.hoTen = sc.nextLine();
//		System.out.print("Nhập số CMND: ");
//		this.soCMND = sc.nextLine();
//		System.out.print("Nhập ngày sinh: ");
//		this.ngaySinh = sc.nextLine();
//		System.out.print("Nhập email: ");
//		this.email = sc.nextLine();
//		System.out.print("Nhập số hóa đơn: ");
//		int n = sc.nextInt();
//		for (int i = 0; i < n; i++) {
//			System.out.println("---NHẬP THÔNG TIN HÓA ĐƠN " + (i+1) + "---");
//			HoaDon hd = new HoaDon(); 
//			hd.nhapDuLieu();
//			hoaDons.add(hd);
//		}
//		viTiens.nhapDuLieu();
//	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append("KhachHang [Ma KH = ").append(maKH).append(", Ho ten = ").append(hoTen).append(", So CMND = ").append(soCMND).append(", Ngay sinh = ").append(ngaySinh).append(", Email=").append(email);
		sb.append(", Hoa don: ");
		for (HoaDon hd : hoaDons) {
			sb.append(hd);
		}
//		hoaDons.forEach(sb::append);
		sb.append(" Vi tien: ").append(viTiens);
		return sb.toString();
	}
	
	// Check tên khách hàng có họ tên chứa chữ a
	public boolean checkHoTenChuaChuA(String hoTen) {
//		return hoTen.indexOf('a') >= 0;
		return hoTen.contains("a");
	}
	
	// Check sinh trước năm 1996
	public boolean checkNamSinhTruoc1996(String namSinh) {
		String s = namSinh.substring(namSinh.lastIndexOf('/') + 1);
		return Integer.parseInt(s) < 1996;
	}

	
	// Getter & Setter	
	public String getMaKH() { return maKH; }
	public void setMaKH(String maKH) { this.maKH = maKH; }
	public String getHoTen() { return hoTen; }
	public void setHoTen(String hoTen) { this.hoTen = hoTen; }
	public String getSoCMND() { return soCMND; }
	public void setSoCMND(String soCMND) { this.soCMND = soCMND; }
	public String getNgaySinh() {return ngaySinh; }
	public void setNgaySinh(String ngaySinh) {this.ngaySinh = ngaySinh; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public double getTongTienVi() { return viTiens.getTongTienVi(); } 
	public void setTongTienVi(double tien) { viTiens.setTongTienVi(tien);};
	public double getTongHoaDon() {
		double tongTienHoaDon = 0.0;
    	for (HoaDon hd: hoaDons) {
    		tongTienHoaDon += hd.getTienHD();
    	}
		return tongTienHoaDon; 
	}
}
