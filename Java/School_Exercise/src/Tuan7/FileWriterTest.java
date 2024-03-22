package Tuan7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
	public static void main(String[] args) throws Exception {
		File file = new File("D:\\data.text");
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			String name = "Tran Duc Linh1";
			fileWriter.write(name);
			System.out.println("Ghi vao file \'" + file.getAbsolutePath() + "\' thanh cong!");
		} catch (IOException e) {
			System.err.println("Co loi xay ra...");
			e.printStackTrace();
		} finally {
			fileWriter.close();
		}
		
	}
}
