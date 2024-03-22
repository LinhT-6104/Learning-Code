package Tuan7;

import java.io.Serializable;

public class MyPham extends HangHoa implements Serializable {
	private String maMyPham, congDung;

	// Constructor MyPham
	public MyPham() {
		super();
		this.maMyPham = this.congDung = "";
	}

	public MyPham(String ten, String xuatXu, int namSX, Double donGia, String maMyPham, String congDung) {
		super(ten, xuatXu, namSX, donGia);
		this.maMyPham = maMyPham;
		this.congDung = congDung;
	}
	
	// Hiển thị
	@Override
	public String toString() {
		return super.toString() + ", Mã mỹ phẩm = " + maMyPham + ", Công dụng = " + congDung + "]";
	}

	// Getter & Setter MyPham
	public String getMaMyPham() { return maMyPham; }
	public void setMaMyPham(String maMyPham) { this.maMyPham = maMyPham; }
	public String getCongDung() { return congDung; }
	public void setCongDung(String congDung) { this.congDung = congDung; }

}
