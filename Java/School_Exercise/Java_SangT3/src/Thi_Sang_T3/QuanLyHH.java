package Thi_Sang_T3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyHH {
	private ArrayList<HangHoa> listHH;
	
	public QuanLyHH() {
		this.listHH = new ArrayList<HangHoa>();
	}

	public QuanLyHH(ArrayList<HangHoa> listHH) {
		this.listHH = listHH;
	}

	public void nhapDuLieu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số hàng hóa: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n ; i++) {
			System.out.print("\nNhập loại hàng hóa (Oto: o | SmartPhone: sm): ");
			String luaChon = sc.nextLine().toLowerCase().trim();
			if (luaChon.equals("o")) {
				Oto o = new Oto();
				o.nhapDuLieu();
				listHH.add(o);
			} else {
				SmartPhone sm = new SmartPhone();
				sm.nhapDuLieu();
				listHH.add(sm);
			}
		}
		sc.close();
	}
	
	public void hienThiHH() {
		System.out.println("\n------DANH SÁCH HÀNG HÓA------");
		for (int i = 0; i < listHH.size(); i++) {
			System.out.println(listHH.get(i));
		}
	}
	
	public void hienThiDienThoai() {
		System.out.println("\n------DANH SÁCH ĐIỆN THOẠI------");
		for (int i = 0; i < listHH.size(); i++) {
			if (listHH.get(i) instanceof SmartPhone) {
				System.out.println(listHH.get(i));				
			}
		}
	}
	
	public void hienThiOto() {
		System.out.println("\n------DANH SÁCH Ô TÔ------");
		for (int i = 0; i < listHH.size(); i++) {
			if (listHH.get(i) instanceof Oto) {
				System.out.println(listHH.get(i));				
			}
		}
	}
	
	public double tongTienAndroid() {
	    double money = 0;
	    for (HangHoa hh : listHH) {
	        if (hh instanceof SmartPhone) {
	            SmartPhone smp = (SmartPhone) hh;
	            if (smp.getHeDH().equals("Android")
	                && smp.getDungLuongPin() > 40000
	                && checkSNT(smp.getDungLuongPin())) {
	                money += smp.getDonGia() * smp.getSoLuong();                                        
	            }
	        }
	    }
	    return money;
	}

	
	public int demAndroidTM() {
		int count = 0;
		for (int i = 0; i < listHH.size(); i++) {
			if (listHH.get(i) instanceof SmartPhone) {
				SmartPhone smp = (SmartPhone) listHH.get(i);
				if (smp.getHeDH().equals("Android") && smp.isHoTro5G()
					&& smp.getDungLuongPin() > 3000) {
					count++;
				}
			}
		}
		return (int)count;
	}
	
	public void xoaOto() {
		for (int i = 0; i < listHH.size(); i++) {
			if (listHH.get(i) instanceof Oto) {
				Oto o = (Oto) listHH.get(i);
				if (o.getNamSX() <= 2012) {
					listHH.remove(i);
				}
			}
		}
	}
	
	public boolean checkSNT(double pin) {
		if (pin < 2) return false;
		
		for (int i = 2; i <= Math.sqrt((int)pin); i++) {
			if ((int)pin % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public void sapXep() {
		Collections.sort(listHH, sapXepTien);
	}
	
	Comparator<HangHoa> sapXepTien = new Comparator<HangHoa>() {
		
		@Override
		public int compare(HangHoa o1, HangHoa o2) {
			if (o1 instanceof SmartPhone && o2 instanceof SmartPhone) {
				SmartPhone dt1 = (SmartPhone) o1;
				SmartPhone dt2 = (SmartPhone) o2;
				double thanhTien1 = dt1.getDonGia() * dt1.getSoLuong();
				double thanhTien2 = dt2.getDonGia() * dt2.getSoLuong();
				return (int)(thanhTien1 - thanhTien2);
			}
			return 0;
		}
	};
	
	public ArrayList<HangHoa> getlistHH() {
		return listHH;
	}

	public void setlistHH(ArrayList<HangHoa> listHH) {
		this.listHH = listHH;
	}
}
