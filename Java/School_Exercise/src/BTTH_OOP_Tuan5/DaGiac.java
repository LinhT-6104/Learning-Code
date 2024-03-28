package BTTH_OOP_Tuan5;

import java.util.Arrays;
import java.util.Scanner;

public class DaGiac {
	private int soCanh;
	private int[] ktCanh;
	
	public DaGiac() {}

	public DaGiac(int soCanh, int[] ktCanh) {
		this.soCanh = soCanh;
		this.ktCanh = ktCanh;
	}
	
	public void nhapTT() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số cạnh: ");
		this.soCanh = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập kích thước các cạnh: ");
		ktCanh = new int[soCanh];
		for (int i = 0; i < soCanh; i++) {
			this.ktCanh[i] = Integer.parseInt(sc.nextLine());
		}
	}
	
	public int tinhChuVi() {
		int sum = 0;
		for (int x : ktCanh) {
			sum += x;
		}
		return sum;
	}
	
	
	@Override
	public String toString() {
		return "DaGiac [soCanh=" + soCanh + ", ktCanh=" + Arrays.toString(ktCanh) + "]";
	}

	public void inCanh() {
		for (int x: ktCanh) {
			System.out.print(x + " ");
		}
	}

	public int getSoCanh() {
		return soCanh;
	}

	public void setSoCanh(int soCanh) {
		this.soCanh = soCanh;
	}

	public int[] getKtCanh() {
		return ktCanh;
	}

	public void setKtCanh(int[] ktCanh) {
		this.ktCanh = ktCanh;
	}
	
}
