package Tuan3;

import java.util.Scanner;

public class Tuan3_3 {
    public static boolean checkBienXe(String s) {
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || i == 1 || i == 4 || i == 6 || i == 7 || i == 9 || i == 10 || i == 11) && (s.charAt(i) < '1' || s.charAt(i) > '9')) {
                return false;
            }
            if ((i == 3) && (s.charAt(i) < 'A' || s.charAt(i) > 'z')) {
                return false;
            }
            if (i == 2 && s.charAt(i) != '-') {
                return false;
            }
            if (i == 5 && s.charAt(i) != ' ') {
                return false;
            }
            if (i == 8 && s.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkHaNoi(String s) {
        return checkBienXe(s) && (s.startsWith("29") || s.startsWith("30") || s.startsWith("31"));
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (checkBienXe(s)) {
            System.out.println("Bien so xe hop le");
        } else {
            System.out.println("Bien so xe khong hop le");
        }
        
        if (checkHaNoi(s)) {
            System.out.println("Bien so xe Ha Noi");
        } else {
            System.out.println("Khong la bien so xe Ha Noi");
        }
    }
}
