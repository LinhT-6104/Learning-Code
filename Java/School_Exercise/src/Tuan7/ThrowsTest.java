package Tuan7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ThrowsTest {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// Ghi vao file
		File file = new File("D:\\data.text");
		PrintWriter printWriter = new PrintWriter(file);
		String name = "Tran Duc Linh throws";
		printWriter.write(name);
		printWriter.close();
	}
}
