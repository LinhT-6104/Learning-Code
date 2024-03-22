package Tuan7;


import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Bai1_Tuan_7_BTVN {
	public static void display(int arr[][], int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void sortArray(int arr[][], int row) {
		for (int i = 0; i < row; i++) {
			Arrays.sort(arr[i]);
		} 
	}
	
	public static void main(String[] args) throws Exception{
		File file = new File("D:\\Learning-Code\\Java\\School_Exercise\\src\\Chuong7\\input.txt");
		Scanner sc = new Scanner(file);
		FileWriter fileWriter = new FileWriter("D:\\Learning-Code\\Java\\School_Exercise\\src\\Chuong7\\output.txt");
		
		int row, col, arr[][];
		row = sc.nextInt();
		col = sc.nextInt();
		arr = new int [row][col];
		
		// Input
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// a) In ra màn hình mảng 2 chiều đọc được từ file input.txt
		display(arr, row, col);
		
		// b) Nhân 3 lần giá trị của các phần tử ở vị trí hàng chẵn – cột lẻ
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if ((i+1) % 2 == 0 && (j+1) % 2 != 0) {
					arr[i][j] *= 3;
				}
			}
		}
		
		// c) Sắp xếp các dòng trong ma trận theo thứ tự không giảm
		sortArray(arr, row);
		
		// d) Ghi lại giá trị của hàng, cột và ma trận 2 chiều mới (sau khi thực hiện câu b và c) vào file output.txt
		for (int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				fileWriter.write(arr[i][j] + "\t");
			}
			fileWriter.write("\n");
		}
		
		fileWriter.close();
		sc.close();
	}
}
