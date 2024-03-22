package Tuan7;

import java.io.File;
import java.util.Scanner;

// Dùng khi muốn đọc 1 file với từng phần tử cách nhau bởi dấu cách
public class ScannerTest {
	public static void main(String[] args) throws Exception {
		File file = new File("D:\\data.text");
		Scanner sc = new Scanner(file);
		int row, column, arr[][];
		row = sc.nextInt();
		column = sc.nextInt();
		arr = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(row + " " + column);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();	
		}
	}
}
