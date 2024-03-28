package BTTH_OOP_Tuan5;

import java.util.ArrayList;
import java.util.Arrays;

public class QuanLyDaGiac {
	private ArrayList<DaGiac> qldg = new ArrayList<DaGiac>();
	
	public QuanLyDaGiac() {
		this.qldg = new ArrayList<DaGiac>();
	}

	public QuanLyDaGiac(ArrayList<DaGiac> qldg) {
		this.qldg = qldg;
	}

	public void inDanhSach() {
		System.out.println("\n------DANH SÁCH TAM GIÁC------");
		for (DaGiac a : qldg) {
			System.out.println(a);
		}
	}
	
	public void canhMaxTamGiac() {
		double dtMax = 0;
		for (DaGiac x : qldg) {
			if (x instanceof TamGiac) {
				TamGiac a = (TamGiac)x;
				if (a.tinhDienTichTamGiac() > dtMax) {
					dtMax = a.tinhDienTichTamGiac();
				}
			}
		}
		
		System.out.println("\n-------TAM GIÁC CÓ DIỆN TÍCH LỚN NHẤT------");
		for (DaGiac x : qldg) {
			if (x instanceof TamGiac && 
					((TamGiac)x).tinhDienTichTamGiac() == dtMax) {
				System.out.println(Arrays.toString(x.getKtCanh()));
			}
		}
	}
	
	public void search(int a) {
		System.out.println("\n------TAM GIÁC Ở VỊ TRÍ " + a + "------");
		System.out.println(qldg.get(a));
	}
	
	public void sapXepDienTich() {
		for (int i = 0; i < qldg.size()-1; i++) {
			for (int j = i+1; j < qldg.size(); j++) {
				TamGiac a = (TamGiac)qldg.get(i);
				TamGiac b = (TamGiac)qldg.get(j);
				if (a.tinhDienTichTamGiac() >= b.tinhDienTichTamGiac()) {
					DaGiac copy = qldg.get(i);
					qldg.set(i, qldg.get(j));
					qldg.set(j, copy);
				}
			}
		}
	}
	
	public ArrayList<DaGiac> getQldg() {
		return qldg;
	}

	public void setQldg(ArrayList<DaGiac> qldg) {
		this.qldg = qldg;
	}
	
	
}
