package Tuan1_2;

import java.util.Scanner;
import java.lang.Character;

public class Bai10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String so = sc.next();
		int Answer = 0;
		for (int i = so.length() - 1; i >= 0; i--) {
			int b = Character.digit(so.charAt(i), 10);
			Answer = Answer * 10 + b;
		}
		System.out.print(Answer);
		sc.close();
	}
}
