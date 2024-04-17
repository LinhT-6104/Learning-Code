package Tuan6;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Scanner;

public class Bai6_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String stringDate = "";
		Date myDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Nhập vào chuỗi ngày tháng (dd/MM/yyyy): ");
		stringDate = sc.nextLine();
		try {
			myDate = dateFormat.parse(stringDate);
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra: " + e);
		}
		System.out.println("Ngày tháng bạn vừa nhập: " + stringDate);
		dateFormat = new SimpleDateFormat("yyyy");
		System.out.println("Giá trị năm: " + dateFormat.format(myDate));
		System.out.println("Time zone: " + ZoneId.systemDefault());
	}	
}
