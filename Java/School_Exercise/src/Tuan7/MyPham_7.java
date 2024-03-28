package Tuan7;

import java.util.Scanner;

public class MyPham_7 extends HangHoa_7{
	private String maMyPham;
	private String congDung;
	public MyPham_7() {
		super();
	}
	public MyPham_7(String maMyPham, String congDung, String ten, String xuatXu, int namSX, double donGia) {
		super(ten, xuatXu, namSX, donGia);
		this.maMyPham = maMyPham;
		this.congDung = congDung;
	}
	
	@Override
	public void nhapHangHoa() {
		Scanner sc = new Scanner(System.in);
		super.nhapHangHoa();
		System.out.print("Nhập mã mỹ phẩm: ");
		this.maMyPham = sc.nextLine();
		System.out.print("Nhập công dụng: ");
		this.congDung = sc.nextLine();
	}
	
	@Override
	public String toString() {
		return "MyPham_7 [maMyPham=" + maMyPham + ", congDung=" + congDung + ", getTen()=" + getTen() + ", xuatXu="
				+ getXuatXu() + ", namSX=" + getNamSX() + ", donGia=" + getDonGia() + "]";
	}
	public String getMaMyPham() {
		return maMyPham;
	}
	public void setMaMyPham(String maMyPham) {
		this.maMyPham = maMyPham;
	}
	public String getCongDung() {
		return congDung;
	}
	public void setCongDung(String congDung) {
		this.congDung = congDung;
	}
	
	
}
