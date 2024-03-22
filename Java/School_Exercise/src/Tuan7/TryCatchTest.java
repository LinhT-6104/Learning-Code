package Tuan7;

import java.util.Scanner;

public class TryCatchTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, tong = 0;
		
		try {
			System.out.print("A = ");
			a = sc.nextInt();
		} catch (Exception e) {
			System.err.println("Giá trị A không hợp lệ... => A = 10");
			e.printStackTrace();
			a = 10;
			sc = new Scanner(System.in);
		}
		
		try {
			System.out.print("B = ");
			b = sc.nextInt();
		} catch (Exception e) {
			System.err.println("Giá trị A không hợp lệ... => B = 5");
			e.printStackTrace();
			b = 5;
			sc = new Scanner(System.in);
		}
		
		tong = a + b;
		System.out.println("Tong = " + a + " + " + b + " = " + tong);
	}
}
