package Tuan1_2;

import java.util.Scanner;

public class Bai7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String a = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			a += s.charAt(i);
		}
		System.out.println(a);
		sc.close();
	}
}
