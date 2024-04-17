package Tuan3;

import java.util.Scanner;

public class Tuan3_2 {
  
    public static void input(int n, int m, int[][] A, Scanner sc) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ;j++) {
                A[i][j] = sc.nextInt();
            }
        }
    }
  
    public static void show(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static int[][] plus(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                C[i][j] = A[i][j] + B[i][j]; 
            }
        }
        return C;
    }
  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    
    int[][] A = new int[n][m];
    int[][] B = new int[n][m];
    input(n, m, A, sc);
    input(n, m, B, sc);
    System.out.println();
    
    show(A);
    show(B);
    
    int[][] C = plus(A, B);
    show(C);
  }
}