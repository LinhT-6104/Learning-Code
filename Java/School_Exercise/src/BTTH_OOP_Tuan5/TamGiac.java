package BTTH_OOP_Tuan5;

import java.util.Arrays;

public class TamGiac extends DaGiac {
	
	public TamGiac() {
		super();
	}

	public TamGiac(int soCanh, int[] ktCanh) {
		super(soCanh, ktCanh);
	}
	
	public void nhapTT() {
		super.nhapTT();
	}

	@Override
	public String toString() {
		return "TamGiac [SoCanh=" + getSoCanh() + ", KtCanh=" + Arrays.toString(getKtCanh()) + "]";
	}

	@Override
	public int tinhChuVi() {
		return super.tinhChuVi();
	}
	
	public double tinhDienTichTamGiac() {
		double a = super.getKtCanh()[0];
		double  b = super.getKtCanh()[1];
		double c = super.getKtCanh()[2];
		double p = tinhChuVi() / 2;
		return Math.sqrt(p * (p-a) * (p-b) * (p-c));
	}
}
