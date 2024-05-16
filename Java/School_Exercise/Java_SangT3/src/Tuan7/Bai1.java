package Tuan7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Scanner;

// Họ tên: Trần Đức Linh
// Mã sinh viên: 725105115

public class Bai1 {
	public static void main(String[] args) throws Exception {
		String dirPath = "D:\\Learning-Code\\Java\\School_Exercise\\";
		String fileName = "hcn.txt";
		String filePath = dirPath + fileName;
		File file = new File(filePath);
		
		Scanner sc = new Scanner(file);
		int row;
		int col;		
		row = sc.nextInt();
		col = sc.nextInt();
		int[][] a = new int[row][col];
		
		try {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					a[i][j] = sc.nextInt();
				}
			}	
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra..." + e);
		}
		
		// Cau a
		System.out.println("------CÂU A------");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		
		// Cau b
		System.out.println("\n------CÂU B------");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i % 2 == 0 && j % 2 != 0) {
					a[i][j] *= 3;
				}
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		
		// Cau c
		System.out.println("\n------CÂU C------");
		for (int i = 0; i < row; i++) {
			Arrays.sort(a[i]);			
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		
		// Cau d
		System.out.println("\n------Câu D------");
		fileName = "output.txt";
		filePath = dirPath + fileName;
		file = new File(filePath);
		FileOutputStream foStream = new FileOutputStream(file);
		byte[] byteData = null;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {	
				byteData = String.valueOf(a[i][j]).getBytes();
				foStream.write(byteData);
				foStream.write("\t".getBytes());
			}
			foStream.write("\n".getBytes());
		}
		
		foStream.close();
		
		int[][] b = new int[row][col];
		Scanner new_sc = new Scanner(file);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				b[i][j] = new_sc.nextInt();
				System.out.print(b[i][j] + "\t");
			}
			System.out.println();
		}
		new_sc.close();
	}
}
