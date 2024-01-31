package chuong1_2;

import java.util.Scanner;

public class test {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap x: ");
		int x = sc.nextInt();
		System.out.print("Nhap y: ");
		int y = sc.nextInt();
		System.out.println("x = " + (x-300));
		System.out.println("y = " + (250-y));	
		sc.close();
	}
}
