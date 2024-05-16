//Tran_Duc_Linh_725105115
package BaiThi;

import java.io.Serializable;
import java.util.Scanner;


public class GiaoTrinh extends ChuyenNghanh implements Serializable {
	
	
	private String tenGiaoTrinh;
	private double gia;		
	private PhanLoai phanLoaiGiaoTrinh;
	
	public GiaoTrinh() {
		super();
		phanLoaiGiaoTrinh = new PhanLoai();
	}
	
	public GiaoTrinh(String maChuyenNghanh, String tenChuyenNghanh, String tenGiaoTrinh, double gia, PhanLoai phanLoaiGiaoTrinh) {
		super(maChuyenNghanh, tenChuyenNghanh);
		this.tenGiaoTrinh = tenGiaoTrinh;
		this.gia = gia;
		this.phanLoaiGiaoTrinh = phanLoaiGiaoTrinh;
	}

	public void nhapDuLieu() {
		super.nhapDuLieu();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên giáo trình: ");
		this.tenGiaoTrinh = sc.nextLine();
		System.out.print("Nhập giá: ");
		this.gia = Double.parseDouble(sc.nextLine().trim());
		System.out.print("Nhập loại giáo trình (cơ bản | nâng cao): ");
		this.phanLoaiGiaoTrinh.setLoai(sc.nextLine());	
		System.out.print("Nhập số lượng: ");
		this.phanLoaiGiaoTrinh.setSoLuong(Integer.parseInt(sc.nextLine().trim()));
	}
	
	public void xuatDuLieu() {
		super.xuatDuLieu();
		System.out.println("Tên giáo trình: " + this.tenGiaoTrinh);
		System.out.println("Giá: " + this.gia);
		System.out.println("Loại giáo trình: " + this.phanLoaiGiaoTrinh.getLoai());
		System.out.println("Số lượng: " + this.phanLoaiGiaoTrinh.getSoLuong());
	}

	public String getTenGiaoTrinh() {
		return tenGiaoTrinh;
	}

	public void setTenGiaoTrinh(String tenGiaoTrinh) {
		this.tenGiaoTrinh = tenGiaoTrinh;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public PhanLoai getPhanLoaiGiaoTrinh() {
		return phanLoaiGiaoTrinh;
	}

	public void setPhanLoaiGiaoTrinh(PhanLoai phanLoaiGiaoTrinh) {
		this.phanLoaiGiaoTrinh = phanLoaiGiaoTrinh;
	}

	@Override
	public String toString() {
		return "GiaoTrinh [tenGiaoTrinh=" + tenGiaoTrinh + ", gia=" + gia + ", phanLoaiGiaoTrinh=" + phanLoaiGiaoTrinh
				+ ", MaChuyenNghanh=" + getMaChuyenNghanh() + ", TenChuyenNghanh=" + getTenChuyenNghanh()
				+ "]";
	}
}
