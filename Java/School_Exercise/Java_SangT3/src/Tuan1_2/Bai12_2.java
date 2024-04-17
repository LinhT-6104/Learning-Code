package Tuan1_2;

import java.util.Random;
import java.util.Scanner;

public class Bai12_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0, count = 2, i = 1;
		while(i <= n) {
			for (int j = 0; j < n; j++) {
				sum += 1;
				i*=2;
				count++;
			}
		}
		System.out.println(count);
	}
}
