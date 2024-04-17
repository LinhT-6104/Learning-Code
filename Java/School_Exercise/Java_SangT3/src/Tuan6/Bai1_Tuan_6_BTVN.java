package Tuan6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


class HoaDon {
	private String MaHD;
	private Double TienHD;
	
	public HoaDon() {
		this.MaHD = "";
		this.TienHD = 0.0;
	}
	public HoaDon(String maHD, Double TienHD) {
		this.MaHD = maHD;
		this.TienHD = TienHD;
	}

	Scanner sc = new Scanner(System.in);
	
	public void nhapDuLieu() {
		System.out.print("Nhập mã hóa đơn: ");
		this.MaHD = sc.next();
		System.out.print("Nhập tổng tiền hóa đơn: ");
		this.TienHD = Double.parseDouble(sc.next());
	}
	
	@Override
	public String toString() {
		return "\t[MaHD = " + MaHD + ",\tTienHD = " + TienHD + "],";
	}
	
	public String getMaHD() { return MaHD; }
	public void setMaHD(String maHD) { MaHD = maHD; }
	public Double getTienHD() { return TienHD; }
	public void setTienHD(Double TienHD) { this.TienHD = TienHD; }
}

class ViTien {
	private String maVT;
	private Double tongTienVi;
	
	public ViTien() {
		this.maVT = "";
		this.tongTienVi = 0.0;
	}
	public ViTien(String maVT, Double tongTienVi) {
		this.maVT = maVT;
		this.tongTienVi = tongTienVi;
	}
	
	public String getMaVT() { return maVT; }
	public void setMaVT(String maVT) { this.maVT = maVT; }
	public Double getTongTienVi() { return tongTienVi; }
	public void setTongTienVi(Double tongTienVi) { this.tongTienVi = tongTienVi; }	
	
	Scanner sc = new Scanner(System.in);
	
	public void nhapDuLieu() {
		System.out.print("Nhập mã ví: ");
		this.maVT = sc.next();
		System.out.print("Nhập tổng số tiền trong ví: ");
		this.tongTienVi = sc.nextDouble();
	}
	@Override
	public String toString() {
		return ",\tMã ví tiền = " + maVT + ",\tSố tiền trong ví = " + tongTienVi + "]";
	}
}


class KhachHang {
	private String maKH, hoTen, soCMND, ngaySinh, email;
	private ArrayList<HoaDon> hoaDons;
	private ViTien viTiens;
	
	// Constructor
	public KhachHang() {
		this.maKH = this.hoTen = this.soCMND = this.ngaySinh = this.email = "";
		this.hoaDons = new ArrayList<HoaDon>();
		this.viTiens = new ViTien();
	}
	public KhachHang(String maKH, String hoTen, String soCMND, String ngaySinh, String email, ArrayList<HoaDon> hoaDons,
					ViTien viTiens, Scanner sc) {
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
	Scanner sc = new Scanner(System.in);
	
	public void nhapDuLieu() {
		System.out.print("Nhập mã KH: ");
		this.maKH = sc.nextLine();
		System.out.print("Nhập họ tên: ");
		this.hoTen = sc.nextLine();
		System.out.print("Nhập số CMND: ");
		this.soCMND = sc.nextLine();
		System.out.print("Nhập ngày sinh: ");
		this.ngaySinh = sc.nextLine();
		System.out.print("Nhập email: ");
		this.email = sc.nextLine();
		System.out.print("Nhập số hóa đơn: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("---NHẬP THÔNG TIN HÓA ĐƠN " + (i+1) + "---");
			HoaDon hd = new HoaDon(); 
			hd.nhapDuLieu();
			hoaDons.add(hd);
		}
		viTiens.nhapDuLieu();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append("KhachHang [Mã KH = ").append(maKH).append(",\tHọ tên = ").append(hoTen).append(",\tSố CMND = ").append(soCMND).append(",\tNgày sinh = ").append(ngaySinh).append(",\tEmail=").append(email);
		sb.append(",\tHoa don: ");
//		for (HoaDon hd : hoaDons) {
//			sb.append(hd);
//		}
		hoaDons.forEach(sb::append);
		sb.append(",\tVí tiền: ").append(viTiens);
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
	
//	public void sapXepKH_Vi(ArrayList<KhachHang> KHS) {
//		Collections.sort(KHS, new Comparator<KhachHang>() {
//			@Override
//			public int compare(KhachHang KH2, KhachHang KH1) {
//				return (int)(KH1.getTongTienVi() - KH2.getTongTienVi());
//			}
//		});
//	}
	
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
		public double getTongHoaDon() {
			double tongTienHoaDon = 0.0;
        	for (HoaDon hd: hoaDons) {
        		tongTienHoaDon += hd.getTienHD();
        	}
			return tongTienHoaDon; 
		}
}

public class Bai1_Tuan_6_BTVN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số khách hàng: ");
		int n = Integer.parseInt(sc.next());
		
		ArrayList<KhachHang> KHS = new ArrayList<KhachHang>();
		
		for (int i = 0; i < n; i++) {
			System.out.println("\n----------NHẬP THÔNG TIN KHÁCH HÀNG " + (i+1) + "----------");
			KhachHang KH = new KhachHang();
			KH.nhapDuLieu();
			KHS.add(KH);
		}
		
		System.out.println("\n--------------------------------THÔNG TIN KHÁCH HÀNG---------------------------------------");
		for(KhachHang KH: KHS) {
			System.out.println(KH);
		}
//		KHS.forEach(System.out::println);
		
		System.out.println("\n---------DANH SÁCH KHÁCH HÀNG CÓ HỌ TÊN CHỨA CHỮ a-----------");
		for(KhachHang KH: KHS) {
			if (KH.checkHoTenChuaChuA(KH.getHoTen())) {
				System.out.println(KH);
			}
		}
		
		System.out.println("\n---------DANH SÁCH KHÁCH HÀNG SINH TRƯỚC NĂM 1996----------");
		for(KhachHang KH: KHS) {
			if (KH.checkNamSinhTruoc1996(KH.getNgaySinh())) {
				System.out.println(KH);
			}
		}
		
		System.out.println("\n----DANH SÁCH KHÁCH HÀNG CÓ TỔNG TIỀN TRONG VÍ >= 10000----");
		Collections.sort(KHS, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang KH1, KhachHang KH2) {
                return (int) (KH2.getTongTienVi() - KH1.getTongTienVi());
            }
        });
        
        for(KhachHang KH: KHS) {
        	if (KH.getTongTienVi() >= 10000) {
        		System.out.println(KH);        		
        	}
        }
        
        System.out.println("\n----DANH SÁCH KHÁCH HÀNG CÓ TỔNG TIỀN HÓA ĐƠN <= 6000----");
        for (KhachHang KH: KHS) {        	
        	if (KH.getTongHoaDon() <= 6000.0) {
        		System.out.println(KH);
        	}
        }
        
        System.out.println("\n-DANH SÁCH KHÁCH HÀNG CÓ ĐỦ KHẢ NĂNG CHI TRẢ CHO CÁC HÓA ĐƠN CỦA HỌ-");
        for (KhachHang KH: KHS) {
        	if (KH.getTongHoaDon() <= KH.getTongTienVi()) {
        		System.out.println(KH);
        	}
        }
	}
}
