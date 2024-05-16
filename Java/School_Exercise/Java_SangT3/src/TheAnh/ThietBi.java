package TheAnh;

import java.util.Scanner;

public class ThietBi extends DoanhNghiep {
	private String TenTB;
	private	double Gia;
	private PhanLoai PLTB = new PhanLoai();
	
	
	public ThietBi() {
		super();
	}
	public ThietBi(String maDN, String tenDN) {
		super(maDN, tenDN);
	}
	public String getTenTB() {
		return TenTB;
	}
	public void setTenTB(String tenTB) {
		TenTB = tenTB;	
	}
	public double getGia() {
		return Gia;
	}
	public void setGia(double gia) {
		Gia = gia;
	}
	public PhanLoai getPLTB() {
		return PLTB;
	}
	public void setPLTB(PhanLoai pLTB) {
		PLTB = pLTB;
	}
	@Override
	public String toString() {
		return "ThietBi [TenTB=" + TenTB + ", Gia=" + Gia + ", PLTB=" + PLTB + "]";
	}
	public void input() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên thiết bị: ");
		TenTB = sc.nextLine();
		System.out.println("Nhập giá: ");
		Gia = sc.nextDouble();
		System.out.println("Có phải thiết bị điện tử không? (true = có/false = không): ");
		PLTB.setTBDT(sc.nextBoolean());
		System.out.println("Nhập số lượng: ");
		PLTB.setSoLuong(sc.nextInt());
		super.input();
	}
	public void output() 
	{
		super.output();
		System.out.printf("Tên thiết bị: %s\nGiá: " + Gia, TenTB);
		if (PLTB.isTBDT())
		{
			System.out.println("\nThiết bị điện tử");
		}
		else System.out.println("\nKhông phải thiết bị điện tử");
	}

}
