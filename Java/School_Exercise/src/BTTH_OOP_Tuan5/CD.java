package BTTH_OOP_Tuan5;

import java.util.Scanner;

public class CD {
	private int maCD;
	private String tenCD;
	private String caSy;
	private int soBaiHat;
	private double giaThanh;
	
	public CD() {}
	
	public CD(int maCD, String tenCD, String caSy, int soBaiHat, double giaThanh) {
		this.maCD = maCD;
		this.tenCD = tenCD;
		this.caSy = caSy;
		this.soBaiHat = soBaiHat;
		this.giaThanh = giaThanh;
	}
	
	public void nhapCD() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã CD: ");
		this.maCD = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập tên CD: ");
		this.tenCD = sc.nextLine();
		System.out.print("Nhập tên ca sỹ: ");
		this.caSy = sc.nextLine();
		System.out.print("Nhập số bài hát: ");
		this.soBaiHat = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập giá thành: ");
		this.giaThanh = Double.parseDouble(sc.nextLine());
	}

	@Override
	public String toString() {
		return "CD [maCD=" + maCD + ", tenCD=" + tenCD + ", caSy=" + caSy 
				+ ", soBaiHat=" + soBaiHat + ", giaThanh=" + giaThanh + "]";
	}

	public int getMaCD() {
		return maCD;
	}
	public void setMaCD(int maCD) {
		this.maCD = maCD;
	}
	public String getTenCD() {
		return tenCD;
	}
	public void setTenCD(String tenCD) {
		this.tenCD = tenCD;
	}
	public String getCaSy() {
		return caSy;
	}
	public void setCaSy(String caSy) {
		this.caSy = caSy;
	}
	public int getSoBaiHat() {
		return soBaiHat;
	}
	public void setSoBaiHat(int soBaiHat) {
		this.soBaiHat = soBaiHat;
	}
	public double getGiaThanh() {
		return giaThanh;
	}
	public void setGiaThanh(double giaThanh) {
		this.giaThanh = giaThanh;
	}
}
