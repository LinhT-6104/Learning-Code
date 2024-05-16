package test;

import java.io.Serializable;

//Họ tên: Trần Đức Linh
//Mã SV: 725105115

public class DiemSo implements Serializable{
	
	private int diemGiuaKi;	
	private int diemCuoiKi;	
	private double diemTB;	
	
	public DiemSo() {
		this.diemGiuaKi = 0;
		this.diemCuoiKi = 0;
		this.diemTB = this.diemGiuaKi*0.4 + this.diemCuoiKi*0.6;
	}

	public DiemSo(int diemGiuaKi, int diemCuoiKi) {
		this.diemGiuaKi = diemGiuaKi;
		this.diemCuoiKi = diemCuoiKi;
		this.diemTB = diemGiuaKi*0.4 + diemCuoiKi*0.6;
	}

	public int getDiemGiuaKi() {
		return diemGiuaKi;
	}

	public void setDiemGiuaKi(int diemGiuaKi) {
		this.diemGiuaKi = diemGiuaKi;
	}

	public int getDiemCuoiKi() {
		return diemCuoiKi;
	}

	public void setDiemCuoiKi(int diemCuoiKi) {
		this.diemCuoiKi = diemCuoiKi;
	}

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}

	@Override
	public String toString() {
		return "DiemSo [diemGiuaKi=" + diemGiuaKi + ", diemCuoiKi=" + diemCuoiKi + ", diemTB=" + diemTB + "]";
	}
	
	
}
