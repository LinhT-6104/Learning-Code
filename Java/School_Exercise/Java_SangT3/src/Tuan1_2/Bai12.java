package Tuan1_2;

import java.util.Scanner;

public class Bai12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			boolean check = true;
			for (int j = 0; j < i-1; j++) {
				if (s.charAt(i) == s.charAt(j))	check = false;
			}
			if (check)	result+=s.charAt(i);
		}
		System.out.println(result);
	}
}
