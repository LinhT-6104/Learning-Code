package Tuan3;

import java.util.Scanner;
import java.text.NumberFormat;

public class Tuan3_6 {

    public static void main(String[] args) {
        // Khởi tạo một đối tượng Scanner để đọc dữ liệu từ bàn phím
        Scanner sc = new Scanner(System.in);

        // Cho phép nhập vào một chuỗi các chữ số
        System.out.print("Nhập một chuỗi các chữ số: ");
        String chuoi = sc.nextLine();

        // Thêm dấu phân cách hàng nghìn (dấu phẩy) vào cho số đó
        // Sử dụng lớp NumberFormat để định dạng số theo địa phương hiện tại
        NumberFormat nf = NumberFormat.getInstance();
        // Chuyển đổi chuỗi thành số nguyên
        int so = Integer.parseInt(chuoi);
        // Định dạng số với dấu phẩy
        String ketQua = nf.format(so);
        // In kết quả
        System.out.println("Số sau khi thêm dấu phẩy là: " + ketQua);
    }
}
 
