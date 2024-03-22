package Tuan1_2;

import java.util.Scanner;

public class Bai1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập a: ");
		int a = sc.nextInt();
		System.out.print("Nhập b: ");
		int b = sc.nextInt();
		System.out.print("Nhập c: ");
		int c = sc.nextInt();
		
		// Tính giá trị lớn nhất trong 3 số
		int max = a;
		if (max < b)	max = b;
		if (max < c)	max = c;
		System.out.println("- Giá trị lớn nhất trong 3 số a,b,c: " + max);
		
		// Tính giá trị trung bình của 3 số
		System.out.println("- Giá trị trung bình của 3 số: " + (double)(a+b+c)/3);
		
		// Tính tổng 3 số
		System.out.println("- Tổng 3 số: " + (a+b+c));
	}
	
}
