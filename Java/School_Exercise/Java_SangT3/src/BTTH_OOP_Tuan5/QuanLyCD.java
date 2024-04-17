package BTTH_OOP_Tuan5;

import java.util.Arrays;
import java.util.Comparator;

public class QuanLyCD {
	private CD[] danhSachCD;
	
	public QuanLyCD () {
		this.danhSachCD = new CD[10];
	}

	public QuanLyCD(CD[] danhSachCD) {
		this.danhSachCD = danhSachCD;
	}
	
	public boolean duplicate_check(int i, int maCD) {
		for (int j = 0; j < i; j++) {
			if (danhSachCD[j].getMaCD() == maCD) return false;
		}
		return true;
	}
	
	public void nhapDanhSachCD() {
		for (int i = 0; i < danhSachCD.length; i++) {
			danhSachCD[i] = new CD();
			danhSachCD[i].nhapCD();
			while (!duplicate_check(i, danhSachCD[i].getMaCD())) {
				System.out.println("Mã CD bị đã tồn tại, vui lòng nhập lại thông"
									+ " tin CD: ");
				danhSachCD[i].nhapCD();
			}
		}
	}
	
	public void inDanhSachCD() {
		System.out.println("------DANH SÁCH CD------");
		for (CD a : danhSachCD) {
			if (a != null) {				
				System.out.println(a);
			}
		}
	}
	
	public int soLuongCD() {
		int count = 0;
		while (danhSachCD[count] != null) {
			count++;
		}
		return count;
	}
	
	public double tongGiaThanh(){
		double tongGiaThanh = 0;
		for (int i = 0; i < soLuongCD(); i++) {
			tongGiaThanh += danhSachCD[i].getGiaThanh();
		}
		return tongGiaThanh;
	}

	public CD[] getDanhSachCD() {
		return danhSachCD;
	}

	public void setDanhSachCD(CD[] danhSachCD) {
		this.danhSachCD = danhSachCD;
	}
	
//	Comparator<CD> GiaThanhComp = new Comparator<CD>() {
//		
//		@Override
//		public int compare(CD o1, CD o2) {
//			o1 = new CD();
//			o2 = new CD();
//			Double gia1 = o1.getGiaThanh();
//			Double gia2 = o2.getGiaThanh();
//			return gia2.compareTo(gia1);
//		}
//	};
	
	Comparator<CD> TuaCDComp = new Comparator<CD>() {
		
		@Override
		public int compare(CD o1, CD o2) {
			o1 = new CD();
			o2 = new CD();
			String tua1 = o1.getTenCD();
			String tua2 = o2.getTenCD();
			if (tua1 == null && tua2 == null) return 0;
			if (tua1 == null) return 1;
			if (tua2 == null) return -1;
			return tua1.compareTo(tua2);
		}
	};
	
	public void sapXepGiaThanh() {
		for (int i = 0; i < danhSachCD.length - 1; i++) {
			for (int j = i + 1; j < danhSachCD.length; j++) {
				if (danhSachCD[i]!= null && danhSachCD[j]!= null &&
					danhSachCD[i].getGiaThanh() < danhSachCD[j].getGiaThanh()){
					CD x = danhSachCD[i];
					danhSachCD[i] = danhSachCD[j];
					danhSachCD[j] = x;
				}
			}
		}
	}
	public void sapXepTuaCD() {
		Arrays.sort(danhSachCD, TuaCDComp);
	}
}
