package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_Input_output_stream {
	public static void main(String[] args) throws Exception{
		// Ghi vào File
		File fileOut = new File("D:\\data.txt");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
			String name = "Tran Duc Linh";
			byte[] byteName = name.getBytes();
			fileOutputStream.write(byteName);
			System.out.println("Ghi du lieu vao file: " + fileOut.getAbsolutePath() + " thanh cong!");
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			System.err.println("Có lỗi xảy ra:....");
			e.printStackTrace();
		} 
		
		// Đọc từ file
		File fileIn = new File("D:\\data.txt");
		String data = "";
		int key;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(fileIn);
			while ((key = fileInputStream.read()) != -1) {
				data = data + (char)key + "";
			}
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra...");
			e.printStackTrace();
		}
		System.out.println("Name = " + data);
	}
}
