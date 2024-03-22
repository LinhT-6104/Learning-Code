package Tuan7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) throws IOException {
		// Đọc từ file
		File file = new File("D:\\data.text");
		String data = "";
		int key;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			while ((key = fileInputStream.read()) != -1) {
				data = data + (char)key + "";
			}
		} catch (FileNotFoundException e) {
			System.err.println("Có lỗi xảy ra...");
			e.printStackTrace();
		}
		System.out.println(data);
	}
}
