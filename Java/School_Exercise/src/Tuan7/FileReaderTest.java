package Tuan7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderTest {
	public static void main(String[] args) throws Exception {
		// Doc tu file
		File file = new File("D:\\data.text");
		FileReader fileReader = null;
		String data = "";
		int key;
		try {
			fileReader = new FileReader(file);
			while ((key = fileReader.read()) != -1) {
				data = data + (char)key + "";
			}
			System.out.println("Doc file \'" + file.getAbsolutePath() + "\' thanh cong!");
		} catch (FileNotFoundException e) {
			System.err.println("Có lỗi xảy ra...");
			e.printStackTrace();
		} finally {
			fileReader.close();
		}
		System.out.println("Name = " + data);
	}
}
