package TheAnh;

import java.util.Scanner;

public class DoanhNghiep {
	private String MaDN;
	private String TenDN;
	
	public DoanhNghiep()
	{
		MaDN = TenDN = "";
	}
	public DoanhNghiep(String maDN, String tenDN) {
		super();
		MaDN = maDN;
		TenDN = tenDN;
	}
	public String getMaDN() {
		return MaDN;
	}
	public void setMaDN(String maDN) {
		MaDN = maDN;
	}
	public String getTenDN() {
		return TenDN;
	}
	public void setTenDN(String tenDN) {
		TenDN = tenDN;
	}
	@Override
	public String toString() {
		return "DoanhNghiep [MaDN=" + MaDN + ", TenDN=" + TenDN + "]";
	}
	public void input() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã doanh nghiệp: ");
		MaDN = sc.nextLine();
		System.out.println("Nhập tên doanh nghiệp: ");
		TenDN = sc.nextLine();
	}
	public void output() 
	{
		System.out.printf("Mã doanh nghiệp: %s\nTên doanh nghiệp: %s\n", MaDN, TenDN);
	}

}
