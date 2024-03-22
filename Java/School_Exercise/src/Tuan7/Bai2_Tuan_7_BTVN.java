package Tuan7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Bai2_Tuan_7_BTVN {
	public static void main(String[] args) throws Exception {
		File file = new File("D:\\Learning-Code\\Java\\School_Exercise\\src\\Chuong7\\ListKhachHang.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		ArrayList<KhachHang> kh = new ArrayList<>();
		
		// a) input thong tin khach hang
		kh.add(new KhachHang("1", "A", "001", "01/01/1001", "A@gmail.com", new ArrayList<HoaDon>(Arrays.asList(new HoaDon("hd1", 123.0), new HoaDon("hd2", 234.0))), new ViTien("vt1", 111111.0)));
		kh.add(new KhachHang("2", "B", "002", "02/02/2002", "B@gmail.com", new ArrayList<HoaDon>(Arrays.asList(new HoaDon("hd3", 345.0), new HoaDon("hd4", 456.0))), new ViTien("vt2", 222222.0)));
		kh.add(new KhachHang("3", "C", "003", "03/03/3003", "C@gmail.com", new ArrayList<HoaDon>(Arrays.asList(new HoaDon("hd5", 567.0), new HoaDon("hd6", 678.0))), new ViTien("vt3", 333333.0)));
		kh.add(new KhachHang("4", "D", "004", "04/04/4004", "D@gmail.com", new ArrayList<HoaDon>(Arrays.asList(new HoaDon("hd7", 789.0), new HoaDon("hd8", 890.0))), new ViTien("vt4", 444444.0)));
		
		// b) Nhân đôi số tiền trong ví của tất cả khách hàng
		for (int i = 0; i < kh.size(); i++) {
			kh.get(i).setTongTienVi(kh.get(i).getTongTienVi() * 2);			
		}
		
		// c) Ghi toàn bộ danh sách khách hàng vào file ListKhachHang.txt (Dữ liệu tự clone ra).
		try {
			objectOutputStream.writeObject(kh);
			System.out.println("Ghi danh sách KH vào file " + file.getAbsolutePath() + " thành công!");
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra...");
			e.printStackTrace();
		} finally {
			objectOutputStream.close();
			fileOutputStream.close();
		}
		
		// d)
		// Đọc dữ liệu từ file và hiển thị ra màn hình
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
			ArrayList<KhachHang> kh2 = (ArrayList<KhachHang>) objectInputStream.readObject();
			for (KhachHang khachHang: kh2) {
				System.out.println(khachHang);
			}
		} catch (Exception e) {
			System.err.println("Có lỗi xảy ra...");
			e.printStackTrace();
		} finally {
			objectInputStream.close();
			fileInputStream.close();
		}
	}
}
