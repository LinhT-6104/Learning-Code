package Thi_Sang_T3;

import java.util.Scanner;

//Họ tên: Trần Đức Linh
//Mã sinh viên: 725105115
public class Cau_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập chuỗi: ");
		String s = sc.next();
		int[] charCount = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			charCount[ch - 'a']++;
		}
		
		for (int i = 0; i < 26; i++) {
			if (charCount[i] > 0) {
				System.out.println("'" + (char)(i + 'a') + "' có " + charCount[i] + " kí tự");
			}
		}
		
		System.out.print("Kết quả: ");
		for (int i = 0; i < 26; i++) {
			if (charCount[i] > 0) {
				if (charCount[i] > 0) {
					System.out.print(charCount[i] + "" + (char)(i + 'a'));
				}
			}
		}
	}
}
