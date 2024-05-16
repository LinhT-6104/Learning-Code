package Test;

import java.io.IOException;

public class Main_PRG {
	public static void main(String[] args) throws IOException {
		QuanLyKhoHang quanLyKhoHang = new QuanLyKhoHang();
		
		// Câu 1: Nhập dữ liệu
		quanLyKhoHang.nhapDuLieu();
		
		// Câu 2: Đọc dữ liệu
		quanLyKhoHang.docDuLieu();
		
		// Câu 3: Đếm số lượng đồ chơi hình chữ nhật có màu đỏ
		System.out.println("Số lượng đồ chơi hình chữ nhật có màu đỏ là: " + quanLyKhoHang.demSoLuongDoChoiMauDo());
		
		// Câu 4: Tìm hình chữ nhật có chu vi lớn nhất và diện tích nhỏ nhất
		quanLyKhoHang.timHCNChuVi_Max_Min();
		
		// Câu 5: Đếm diện tích hình chữ nhật khác nhau và sắp xếp theo thứ tự không tăng
		quanLyKhoHang.demDienTichHCN();
	}
}
