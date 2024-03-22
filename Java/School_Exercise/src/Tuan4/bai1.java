/*
	Xây dựng lớp có tên là khách hàng (Customer) với các thông tin bao gồm các thông tin:
	Họ tên chủ hộ, địa chỉ, số công tơ tháng trước, số công tơ tháng này. Nhập danh sách các
	khách hàng và hiển thị số tiền điện tương ứng của từng khách hàng theo công thức: số điện
	đã dùng *1234.
	Mở rộng:
	- Do thị trường thay đổi nên hệ thống tính toán cũng phải thay đổi. Do đó, xây dựng
	lớp khách hàng mới (NewCustomer) kế thừa khách hàng để tính toán tiền điện theo
	giá mới như sau: Người dùng dưới 100 số thì tính theo định mức giá cũ (1234).
	Ngược lại, trên 100 số sẽ tính theo giá mới là 1650.
	- Ngoài ra, một số khách hàng là doanh nghiệp nên cách tính giá điện cũng sẽ khác.
	Theo đó, nếu khách hàng là doanh nghiệp thì dưới 100 số sẽ là 2000 và trên 100 số
	sẽ là 2500
 */

package Tuan4;

// Lớp cha: Customer 
class Customer {
	private String hoTen;
	private String diaChi;
	private double soCT_TT;
	private double soCT_TN;
	
	public Customer() {
		this.hoTen = this.diaChi = "";
		this.soCT_TT = this.soCT_TN = 0;
	}
	
	public Customer(String hoTen, String diaChi, double soCT_TT, double soCT_TN) {
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soCT_TT = soCT_TT;
		this.soCT_TN = soCT_TN;
	}

	public String getHoTen() {return hoTen;}
	public void setHoTen(String hoTen) {this.hoTen = hoTen;}
	public String getDiaChi() {return diaChi;}
	public void setDiaChi(String diaChi) {this.diaChi = diaChi;}
	public double getSoCT_TT() {return soCT_TT;}
	public void setSoCT_TT(float soCT_TT) {this.soCT_TT = soCT_TT;}
	public double getSoCT_TN() {return soCT_TN;}
	public void setSoCT_TN(float soCT_TN) {this.soCT_TN = soCT_TN;}
	
	public double tienDien() {
		double soDien = soCT_TN - soCT_TT;
		return soDien * 1234;
	}
	
	public void soTienDien() {
		System.out.println("Ten khach hang: " + getHoTen());
		System.out.println("Dia chi: " + getDiaChi());
		System.out.println("So tien: " + tienDien());
	}
}

// Lớp con: NewCustomer
class NewCustomer extends Customer {
	public NewCustomer() {
		super();
	}
	
	public NewCustomer(String hoTen, String diaChi, double soCT_TT, double soCT_TN) {
		super(hoTen, diaChi, soCT_TT, soCT_TN);
	}
	
	@Override
	public double tienDien() {
		double soDien = getSoCT_TN() - getSoCT_TT();
		if (soDien <= 100) {
			return soDien * 1234;	// Định mức giá cũ
		} else {
			return 100 * 1234 + (soDien - 100) * 1650;	// Định mức giá mới
		}
	}
}

// Lớp con: businessCustomer
class businessCustomer extends Customer {
	public businessCustomer() {
		super();
	}

	public businessCustomer(String hoTen, String diaChi, double soCT_TT, double soCT_TN) {
		super(hoTen, diaChi, soCT_TT, soCT_TN);
	}
	
	@Override
	public double tienDien() {
		double soDien = getSoCT_TN() - getSoCT_TT();
		if (soDien <= 100) {
			return soDien * 2000;
		} else {
			return 100 * 2000 + (soDien - 100) * 2500;
		}
	}
}

public class bai1 {
	public static void main(String[] args) {
		// Khách hàng thông thường
		Customer customer1 = new Customer("Linh", "abc", 123, 234);
		customer1.soTienDien();
		
		// Khách hàng mới 
		NewCustomer customer2 = new NewCustomer("Linh", "bcd", 234, 243);
		customer2.soTienDien();
		
		// Khách hàng doanh nghiệp
		businessCustomer customer3 = new businessCustomer("Attech", "cde", 123, 234);
		customer3.soTienDien();
	}
}
