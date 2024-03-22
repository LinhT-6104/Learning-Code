package Tuan7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	public static void main(String[] args) throws IOException  {
		// Ghi vao file
		File file =  new File("D:\\testChuong7.docx");
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			String name = "Tran Duc Linh";
			byte byteName[] = name.getBytes();
			fileOutputStream.write(byteName);
			System.out.println("Ghi dữ liệu vào file " + file.getAbsolutePath() + " thanh cong!");
		} catch (FileNotFoundException e) {
			System.err.println("Có lỗi xảy ra...");
			e.printStackTrace();
		} finally {
			fileOutputStream.close();
		}
		
	}	
}
