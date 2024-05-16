package File;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class File_Scanner {
	public static void main(String[] args) throws Exception {
		String dirPath = "D:\\";
		String fileName = "hcn.txt";
		String filePath = dirPath + fileName;
		
		File directory = new File(dirPath);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		
		File file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.err.println("Co loi noi chua file");
				e.printStackTrace();
			}
		}
		
		Scanner sc = new Scanner(file);
		int row, col, arr[][];
		row = sc.nextInt();
		col = sc.nextInt();
		arr = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(row + " " + col);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
