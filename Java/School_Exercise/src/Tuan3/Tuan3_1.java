package Tuan3;

import java.util.Arrays;
import java.util.Scanner;

public class Tuan3_1{
    
    public static int[] deleteZero(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }
        int[] arrNew = Arrays.copyOf(arr, count);
        return arrNew;
    }
    
    public static void sapXep(int[] arr, String chieu) {
        if (chieu.equals("Tang")) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] > arr[j]) {
                        int a = arr[i];
                        arr[i] = arr[j];
                        arr[j] = a;
                    }
                }
            }   
        }
        else if (chieu.equals("Giam")) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] < arr[j]) {
                        int a = arr[i];
                        arr[i] = arr[j];
                        arr[j] = a;
                    }
                }
            } 
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1.1
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        System.out.print("Nhap mang: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();    
        }
        
        // 1.2
        int[] newArr = deleteZero(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        // 1.3
        sapXep(newArr, "Tang");
        for (int i = 0; i < newArr.length; i++) {
            if (arr[i] > 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
        
        // 1.4 
        sapXep(newArr, "Giam");
        for (int i = 0; i < newArr.length; i++) {
            if (arr[i] < 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}