package Thi_Anh;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	int[] charCount = new int[26];
    	
    	for (int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		if (ch >= 'a' && ch <= 'z') {
    			charCount[ch - 'a']++;
    		}
    	}
    	
    	for (int i = 0; i < 26; i++) {
    		if (charCount[i] > 0) {
    			System.out.println((char)(i + 'a') + ": " + charCount[i]);
    		}
    	}
        sc.close();
    }
}

