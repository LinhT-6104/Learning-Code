package Tuan1_2;

import java.util.Scanner;

public class Bai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập vào bán kính r: ");
		double r = sc.nextDouble();
		
		// Chu vi hình tròn
		System.out.println("- Chu vi hình tròn: " + (2 * 3.14 * r));
		
		// Diện tích hình tròn
		System.out.println("- Diện tích hình tròn: " + (3.14 * r * r));
	}
}
