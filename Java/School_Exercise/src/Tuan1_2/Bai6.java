package Tuan1_2;

import java.util.Scanner;

public class Bai6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input
		System.out.print("- Nhập mã sinh viên: ");
		long msv = sc.nextLong();
		sc.nextLine();
		System.out.print("- Nhập họ và tên sinh viên: ");
		String hoTen = sc.nextLine();
		System.out.print("- Nhập khoa quản lý: ");
		String Khoa = sc.nextLine();
		System.out.print("- Nhập khóa đào tạo: ");
		int khoa = sc.nextInt();
		System.out.print("- Nhập giới tính sinh viên: ");
		boolean gioiTinh = sc.nextBoolean();
		System.out.print("- Nhập lớp: ");
		char lop = sc.next().charAt(0);
		System.out.print("- Nhập điểm TB: ");
		double diemTB = sc.nextDouble();

		// Output
		System.out.print("Sinhvien[" + msv + " - " + hoTen + " - " + Khoa);
		System.out.print(" - " + khoa + " - " + gioiTinh + " - " + lop);
		System.out.print(" - " + diemTB + "]");

		sc.close(); 	
	}
}
