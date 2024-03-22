package Tuan1_2;

import java.util.Scanner;
import java.lang.Character;

public class Bai5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char a = sc.next().charAt(0);
		a = Character.toUpperCase(a);
		System.out.println(a + "-" + (int)(a));
	}
}
