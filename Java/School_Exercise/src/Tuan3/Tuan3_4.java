package Tuan3;

import java.util.Scanner;

public class Tuan3_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.print("Nhap n: ");
			n = sc.nextInt();
		} while (n > Math.pow(10, 8));
		
		int a = n, b = 0;
		while (n != 0) {
			b = b*10 + n % 10;
			n /= 10;
		}
		if (a == b) {
			System.out.println(a + " la so doi xung");
		} else {
			System.out.println(a + " khong la so doi xung");
		}
		sc.close();
	}
}
