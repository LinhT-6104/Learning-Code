package Tuan1_2;

import java.util.Scanner;
import java.lang.Character;

public class Bai9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		boolean check = true;
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isLetter(s.charAt(i))) {
				check = false;
				break;
			}
		}
		if (check) 	System.out.println("TRUE – Chuỗi hợp lệ");
		else System.out.println("FALSE – Chuỗi chứa chữ số hoặc kí tự đặc biệt");
	}
}
