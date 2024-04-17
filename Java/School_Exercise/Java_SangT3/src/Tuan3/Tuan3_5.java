package Tuan3;

import java.util.Scanner;

public class Tuan3_5 {
	public static int countNumber(char a, String n) {
		int count = 0;
		for (int i = 0; i < n.length(); i++) {
			if (a == n.charAt(i)) {
				count++;
			}
		}
		return count; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n;
		System.out.print("Nhap n: ");
		n = sc.next();
		int count0 = 0;
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) == '0') {
				count0++;
			}
		}
		System.out.println("0: " + count0);
		
		for (int i = 0; i <= 9; i++) {
			char a = Integer.toString(i).charAt(0);
			if (countNumber(a, n) > 0) {
				System.out.println(a + ": " + countNumber(a, n));
			}
		}
	}
}