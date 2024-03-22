package Tuan7;

import java.util.Scanner;

public class ThrowTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tuoi;
		System.out.print("Nhập tuổi: ");
		tuoi = sc.nextInt();
		if (tuoi < 18) {
			throw new ArithmeticException("Tuổi chưa đủ 18!");
		} else {
			System.out.println("Chào mừng bạn...!");
		}
		System.out.println("alo");
	}
}
