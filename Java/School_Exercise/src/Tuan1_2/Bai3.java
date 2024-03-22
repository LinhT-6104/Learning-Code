package Tuan1_2;

import java.util.Scanner;
import java.lang.Math;

public class Bai3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập vào độ dài 3 cạnh tam giác: ");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		
		// Tính chu vi tam giác
		System.out.println("- Chu vi tam giác: " + (a + b + c));

		// Tính diện tích tam giác
		double p = (a+b+c)/2;
		double S = Math.sqrt(p * (p-a) * (p-b) * (p-c));
		System.out.println("- Diện tích tam giác: " + S);
	}
}
