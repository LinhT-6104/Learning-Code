package Tuan6;

import java.util.ArrayList;
import java.util.Scanner;

class HangHoa {
	private String ten, xuatXu;
	private double namSX;
	private Double donGia;
	
	// Constructor HangHoa
	public HangHoa () {
		this.ten = this.xuatXu = "";
		this.namSX = 0;
		this.donGia = 0.0;
	}

	public HangHoa(String ten, String xuatXu, int namSX, Double donGia) {
		super();
		this.ten = ten;
		this.xuatXu = xuatXu;
		this.namSX = namSX;
		this.donGia = donGia;
	}
	
	Scanner sc = new Scanner(System.in);
	
	// INPUT
	public void nhapDuLieu() {
		System.out.print("Nhập tên: ");
		this.ten = sc.nextLine();
		System.out.print("Nhập xuất xứ: ");
		this.xuatXu = sc.nextLine();
		System.out.print("Nhập năm sản xuất: ");
		this.namSX = Integer.parseInt(sc.next());
		System.out.print("Nhập đơn giá: ");
		this.namSX = Double.parseDouble(sc.next());
	}
	
	// Hiển thị
	@Override
	public String toString() {
		return "[Tên = " + ten + ", Xuất xứ = " + xuatXu + ", Năm sản xuất = " + namSX + ", Đơn giá = "  + donGia;
	}
	
	// Setter & getter HangHoa
	public String getTen() { return ten; }
	public void setTen(String ten) { this.ten = ten; }
	public String getxuatXu() { return xuatXu; }
	public void setxuatXu(String xuatXu) { this.xuatXu = xuatXu; }
	public double getNamSX() { return namSX; }
	public void setNamSX(int namSX) { this.namSX = namSX; }
	public Double getDonGia() { return donGia; }
	public void setDonGia(Double donGia) { this.donGia = donGia; }
}

class MyPham extends HangHoa {
	private String maMyPham, congDung;

	// Constructor MyPham
	public MyPham() {
		super();
		this.maMyPham = this.congDung = "";
	}

	public MyPham(String ten, String xuatXu, int namSX, Double donGia, String maMyPham, String congDung) {
		super(ten, xuatXu, namSX, donGia);
		this.maMyPham = maMyPham;
		this.congDung = congDung;
	}
	
	// INPUT
	@Override
	public void nhapDuLieu() {
		super.nhapDuLieu();
		System.out.print("Nhập mã mỹ phẩm: ");
		this.maMyPham = sc.next();
		sc.nextLine();
		System.out.print("Nhập công cụng: ");
		this.congDung = sc.nextLine();
	}
	
	// Hiển thị
	@Override
	public String toString() {
		return super.toString() + ", Mã mỹ phẩm = " + maMyPham + ", Công dụng = " + congDung + "]";
	}

	// Getter & Setter MyPham
	public String getMaMyPham() { return maMyPham; }
	public void setMaMyPham(String maMyPham) { this.maMyPham = maMyPham; }
	public String getCongDung() { return congDung; }
	public void setCongDung(String congDung) { this.congDung = congDung; }
}

class DienThoai extends HangHoa {
	private String maDienThoai, heDieuHanh;
	
	// Constructor DienThoai
	public DienThoai() {
		super();
		this.maDienThoai = this.heDieuHanh = "";
	}

	public DienThoai(String ten, String xuatXu, int namSX, Double donGia, String maDienThoai, String heDieuHanh) {
		super(ten, xuatXu, namSX, donGia);
		this.maDienThoai = maDienThoai;
		this.heDieuHanh = heDieuHanh;
	}
	
	// INPUT
	public void nhapDuLieu() {
		super.nhapDuLieu();
		System.out.print("Nhập mã điện thoại: ");
		this.maDienThoai = sc.nextLine();
		System.out.print("Nhập hệ điều hành: ");
		this.heDieuHanh = sc.nextLine();
	}
	
	// Hiển thị
	@Override
	public String toString() {
		return super.toString() + ", Mã điện thoại = " + maDienThoai + ", Hệ điều hành = " + heDieuHanh + "]";
	}

	// Setter & Getter DienThoai
	public String getMaDienThoai() { return maDienThoai; }
	public void setMaDienThoai(String maDienThoai) { this.maDienThoai = maDienThoai; }
	public String getHeDieuHanh() { return heDieuHanh; }
	public void setHeDieuHanh(String heDieuHanh) { this.heDieuHanh = heDieuHanh;}	
}

public class Bai2_Tuan_6_BTVN {
	public static void main(String[] args) {
		ArrayList<HangHoa> hangHoa = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		// Nhập danh sách mỹ phẩm
		System.out.print("Nhập số lượng mỹ phẩm: ");		
		int mp_size = Integer.parseInt(sc.next());
		
		for (int i = 0; i < mp_size; i++) {
			System.out.println("Nhập thông tin mỹ phẩm " + (i+1));
			MyPham mp = new MyPham();
			mp.nhapDuLieu();
			hangHoa.add(mp);
		}
		
		// Nhập danh sách điện thoại
		System.out.print("Nhập số lượng điện thoại: ");		
		int dt_size = Integer.parseInt(sc.next());
		
		for (int i = 0; i < dt_size; i++) {
			System.out.println("Nhập thông tin điện thoại " + (i+1));
			DienThoai dt = new DienThoai();
			dt.nhapDuLieu();
			hangHoa.add(dt);
		}
		
		// In toàn bộ danh sách
		for (HangHoa a: hangHoa) {
			System.out.println(a);
		}
		
		// In danh sách chỉ gồm Mỹ phẩm
		System.out.println("DANH SÁCH MỸ PHẨM");
//		for (int i = 0; i < mp_size; i++) {
//			System.out.println(hangHoa);
//		}
		for (HangHoa hh: hangHoa) {
			if (hh instanceof MyPham) {
				System.out.println(hh);
			}
		}
		
		// In danh sách chỉ gồm điện thoại
		System.out.println("DANH SÁCH ĐIỆN THOẠI");
//		for (int i = 0; i < dt_size; i++) {
//			System.out.println(hangHoa);
//		}
		for (HangHoa hh: hangHoa) {
			if (hh instanceof DienThoai) {
				System.out.println(hh);
			}
		}
		
		// Tìm danh sách Điện thoại chạy hệ điều hành Android
		System.out.println("DANH SÁCH ĐIỆN THOẠI CHẠY HỆ ĐIỀU HÀNH ANDROID");
		for (HangHoa hh: hangHoa) {
			if (hh instanceof DienThoai) {
				DienThoai dt = (DienThoai) hh;	// Ép kiểu để gọi phương thức của điện thoại
				if (dt.getHeDieuHanh().equals("Android")) {
					System.out.println(dt);					
				}
			}
		}
		
		// Tổng đơn giá của các Mỹ phẩm xuất xứ từ Hàn quốc
		System.out.print("TỔNG ĐƠN GIÁ MỸ PHẨM HÀN QUỐC: ");
		int sum = 0;
		for (HangHoa hh: hangHoa) {
			if (hh instanceof MyPham) {
				MyPham mp = (MyPham) hh;
				if (mp.getxuatXu().equals("Hàn Quốc")) {
					sum += mp.getDonGia();
				}
			}
		}
		System.out.print(sum);
	}
}
