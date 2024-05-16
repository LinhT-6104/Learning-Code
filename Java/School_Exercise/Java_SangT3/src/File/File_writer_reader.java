package File;

import java.awt.color.ProfileDataException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File_writer_reader {
	public static void main(String[] args) throws Exception {
		// Ghi vào file
		File fileIn = new File("D:\\data.out");
		try {
			FileWriter fileWriter = new FileWriter(fileIn);
			String name = "Tran Duc Linh 10";
			fileWriter.write(name);
			System.out.println("Ghi vào file " + fileIn.getAbsolutePath() + " thành công!");
			fileWriter.close();
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra...");
			e.printStackTrace();
		}
		
		// Đọc từ file
		File fileOut = new File("D:\\data.out");
		String data = "";
		int key;
		try {
			FileReader fileReader = new FileReader(fileOut);
			while ((key = fileReader.read()) != -1) {
				data = data + (char)key + "";
			}
			System.out.println("Đọc file " + fileOut.getAbsolutePath() + " thành công!");
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.err.println("Có lỗi xảy ra...");
			e.printStackTrace();
		}
		System.out.println("Name: " + data);
	}
}
