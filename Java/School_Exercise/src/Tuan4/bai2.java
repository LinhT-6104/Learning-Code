/*
	Viết chương trình quản lý SinhVien. Mỗi sinh viên sẽ gồm thông tin cơ bản, 
	ngoài ra còn có thông tin về điểm số của các môn học (Điểm môn chuyên ngành, 
	môn tự chọn, điểm trung bình, điểm trung bình hệ chữ - Gợi ý: Tạo lớp DiemSo). 
	Biết rằng cách quy đổi điểm
	số sang điểm chữ như sau:
	A (8.5- 10) ; B+ (8.0 - 8.4); B (7.0 - 7.9); C+ (6.5 - 6.9);
	C (5.5 - 6,4); D+ (5.0 - 5.4) ; D (4.0 - 4.9); F (0 – 3.9).
	Trong đó:
		- Lớp SinhVien gồm các thông tin: MaSV, họ tên, năm sinh, email, số đt, 
		khoa quản lý, khóa đào tạo, lớp, điểm số các môn.
		Chương trình gồm các chức năng xử lý sau:
		- Nhập danh sách sinh viên
		- In lại toàn bộ danh sách sinh viên và chi tiết về các thông tin của 
		mỗi sinh viên
		- In danh sách sinh viên có họ tên chứa chữ “a”
		- In danh sách sinh viên có 3 số cuối số điện thoại là 026
		- In danh sách sinh viên khoa CNTT và có họ tên chứa chữ “d”
		- In danh sách sinh viên có điểm tb không lớn hơn 7.5
		- In danh sách sinh viên có điểm hệ chữ từ B+ trở lên
		- Sắp xếp danh sách sinh viên theo điểm tb không giảm
 */

package Tuan4;

import java.util.Scanner;

class DiemSo {
	Scanner sc = new Scanner(System.in);
	private double diemChuyenNganh, diemTuChon, diemTB;
	private String diemChu;
	
	// constructor
	public DiemSo() {
		this.diemChuyenNganh = this.diemTuChon = 0;
	}
	
	public DiemSo(double diemChuyenNganh, double diemTuChon) {
		this.diemChuyenNganh = diemChuyenNganh;
		this.diemTuChon = diemTuChon;
		this.diemTB = (diemChuyenNganh + diemTuChon) / 2;
		this.diemChu = convertAlphabet();
	}
	
	// convert
	private String convertAlphabet() {
		if (diemTB < 4)	return "F";
		else if (diemTB < 5) return "D";
		else if (diemTB < 5.5) return "D+";
		else if (diemTB < 6.5) return "C";
		else if (diemTB < 7) return "C+";
		else if (diemTB < 8) return "B";
		else if (diemTB < 8.5) return "B+";
		else return "A";
	}
	
	// getter
	public double getDiemChuyenNganh() { return diemChuyenNganh; }	
	public double getDiemTuChon() { return diemTuChon; }	
	public double getDiemTB() { return diemTB; }
	public String getDiemChu() { return diemChu; }
	
	// input score
	public void input() {
		System.out.print("Điểm môn chuyên nghành: ");
		diemChuyenNganh = sc.nextInt();
		
		System.out.print("Điểm môn tự chọn: ");
		diemTuChon = sc.nextInt();
		
		System.out.println();
		this.diemTB = (diemChuyenNganh + diemTuChon) / 2;
		this.diemChu = convertAlphabet();
	}
	
	// showDiem
	public void show() {
		System.out.println(", Điểm môn chuyên nghành: " + diemChuyenNganh + ", Điểm môn tự chọn: " + diemTuChon + ", Điểm trung bình: " + diemTB + ", Điểm trung bình hệ chữ: " + diemChu);
	}
}

class QuanLy extends DiemSo{
	Scanner sc = new Scanner(System.in);
	private String maSV, hoTen, namSinh, email, soDT, khoaQL, khoaDT, lop;
	
	// constructor
	public QuanLy() {
		this.maSV = this.hoTen = this.namSinh = this.email = this.soDT = this.khoaQL = this.khoaDT = this.lop = "";
	}
	
	public QuanLy(double diemChuyenNganh, double diemTuChon, String maSV, String hoTen, String namSinh, String email,
			String soDT, String khoaQL, String khoaDT, String lop) {
		super(diemChuyenNganh, diemTuChon);
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.email = email;
		this.soDT = soDT;
		this.khoaQL = khoaQL;
		this.khoaDT = khoaDT;
		this.lop = lop;
	}
	
	// getter
	public String getMaSV() { return maSV; }
	public String getHoTen() { return hoTen; }
	public String getNamSinh() { return namSinh; }
	public String getEmail() { return email; }
	public String getSoDT() { return soDT; }
	public String getKhoaQL() { return khoaQL; }
	public String getKhoaDT() { return khoaDT; }
	public String getLop() { return lop; }
	
	// Input
	public void input() {
		System.out.print("Nhập mã sinh viên: ");
		maSV = sc.next();
		
		sc.nextLine();
		
		System.out.print("Nhập họ tên sinh viên: " );
		hoTen = sc.nextLine();
		
		System.out.print("Nhập năm sinh: ");
		namSinh = sc.next();
		
		System.out.print("Nhập email: ");
		email = sc.next();
		
		System.out.print("Nhập số điện thoại: ");
		soDT = sc.next();
		
		System.out.print("Nhập khoa quản lý: ");
		khoaQL = sc.next();
		
		System.out.print("Nhập khóa đào tạo: ");
		khoaDT = sc.next();
		
		System.out.print("Nhập lớp: ");
		lop = sc.next();
		
		super.input();
	}
	
	// Show
	public void show() {
		System.out.print(": Mã sinh viên: " + maSV + ", Họ tên sinh viên: " + hoTen + ", Năm sinh: " + namSinh + ", Email: " + email + ", Số điện thoại: " + soDT + ", Khoa quản lý: " + khoaQL + ", Khóa đào tạo: " + khoaDT + ", Lớp: " + lop);
		super.show();
	}
}

public class bai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số sinh viên: ");
		int n = sc.nextInt();
		
		// Nhập danh sách sinh viên
		QuanLy [] sinhVien = new QuanLy[n];
		System.out.println("\nNhập thông tin các sinh viên");
		for (int i = 0; i < n; i++) {
			System.out.println("Sinh viên " + (i+1));
			sinhVien[i] = new QuanLy();
			sinhVien[i].input();
		}
		
		// In lại toàn bộ danh sách sinh viên và chi tiết về các thông tin của mỗi sinh viên
		System.out.println("\nHiển thị thông tin sinh viên");
		for (int i = 0; i < n; i++) {
			System.out.print("- Sinh viên " + (i+1));
			sinhVien[i].show();
		}
		
		// In danh sách sinh viên có họ tên chứa chữ "a"
		System.out.println("\nThông tin sinh viên có tên chứa chữ 'a'");
		for (int i = 0; i < n; i++) {
			String name = sinhVien[i].getHoTen();
//			for (int j = name.lastIndexOf(' '); j < name.length(); j++) {
//				if (name.charAt(j) == 'a') {
//					System.out.print("Sinh vien " + (i+1));
//					sinhVien[i].show();
//				}
//			}
			if (name.substring(name.lastIndexOf(" ")).contains("a")) {
				System.out.print("- Sinh viên " + (i+1));
				sinhVien[i].show();
			}
		}
		
		// In danh sách sinh viên có 3 số cuối số điện thoại là 026
		System.out.println("\nSinh viên có 3 số cuối điện thoại là 026");
		for (int i = 0; i < n; i++) {
			if (sinhVien[i].getSoDT().endsWith("026")) {
				System.out.print("- Sinh viên " + (i+1));
				sinhVien[i].show();
			}	
		}
		
		// In danh sách sinh viên khoa CNTT và có họ tên chứa chữ "d" 
		System.out.println("\nDanh sách sinh viên khoa CNTT có họ tên chứa chữ 'd'");
		for (int i = 0; i < n; i++) {
			if (sinhVien[i].getKhoaQL().equals("CNTT") && sinhVien[i].getHoTen().contains("d")) {
				System.out.print("- Sinh viên " + (i+1));
				sinhVien[i].show();
			}
		}
		
		// In danh sách sinh viên có điểm tb không lớn hơn 7.5 
		System.out.println("\nDanh sách sinh viên khoa có điểm trung bình <= 7.5");
		for (int i = 0; i < n; i++) {
			if (sinhVien[i].getDiemTB() <= 7.5) {
				System.out.print("- Sinh viên " + (i+1));
				sinhVien[i].show();
			}
		}
		
			
		// In danh sách sinh viên có điểm hệ chữ từ B+ trở lên
		System.out.println("\nDanh sách sinh viên khoa CNTT có họ tên chứa chữ 'd'");
		for (int i = 0; i < n; i++) {
			if (sinhVien[i].getDiemChu().equals("B+") || sinhVien[i].getDiemChu().equals("A")) {
				System.out.print("- Sinh viên " + (i+1));
				sinhVien[i].show();
			}
		}
		
		// Sắp xếp danh sách sinh viên theo điểm tb không giảm
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if (sinhVien[i].getDiemTB() > sinhVien[j].getDiemTB()) {
					QuanLy a = sinhVien[i];
					sinhVien[i] = sinhVien[j];
					sinhVien[j] = a;
				}
			}
		}
		
		// Hiện thị danh sách sinh viên sau khi sắp xếp
		System.out.println("\nDanh sách sinh viên sau khi sắp xếp: ");
		for (int i = 0; i < n; i++) {
			System.out.print("- Sinh viên " + (i+1));
			sinhVien[i].show();
		}
	}
}
