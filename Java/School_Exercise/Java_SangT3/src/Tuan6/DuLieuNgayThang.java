package Tuan6;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DuLieuNgayThang {
	public static void main(String[] args) {
		Date myDate = new Date();
		System.out.println(myDate);
		// Date ==>String
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
		String dateString = dateFormat.format(myDate);
		System.out.println("Bây giờ là: " + dateString);
		
		// String ==> Date
		boolean check = true;
		dateString = "26-09-23";
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			myDate = dateFormat.parse(dateString);
		} catch (Exception e) {
			System.out.println("-----Quy đổi String ==> Date thất bại-----");
			System.out.println("Chuỗi ngày tháng không hợp lệ " + dateString);
			myDate = new Date();
			check = false;
		}
		if (check) System.out.println("-----Quy đổi String ==> Date thành công-----");
		System.out.println("MyDate: " + myDate);
	}
}
