package Tuan1_2;

import java.util.Scanner;

public class Bai11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String hoTen = sc.nextLine();
		int count = 0;
		
		for (char c: hoTen.toCharArray())	if (c == ' ')	count++;
		String[] names = hoTen.split(" ");
		String gmail = names[count];
		for (int i = 0; i < count; i++) {
			names[i] = names[i].toLowerCase();
			gmail += names[i].charAt(0); 
		}
		gmail += "@gmail.com";
		System.out.println(gmail);
		sc.close();
	}
}
